package g.gitops.poc.app.service.impl;

import g.gitops.poc.app.service.*;
import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import g.gitops.poc.domain.po.entity.SplittedPoItem;
import g.gitops.poc.domain.po.service.PoDomService;
import g.gitops.poc.domain.si.entity.Si;
import g.gitops.poc.domain.si.service.SiDomService;
import g.gitops.poc.domain.so.entity.So;
import g.gitops.poc.domain.so.service.SoDomService;
import g.gitops.poc.infrastructure.common.email.EmailService;
import g.gitops.poc.interfaces.assembler.SiAssember;
import g.gitops.poc.interfaces.assembler.SoAssembler;
import g.gitops.poc.interfaces.dto.SoDto;
import g.gitops.poc.interfaces.dto.SoItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SoAppServiceImpl  implements SoAppService {
    @Autowired
    private SoDomService soDomService;

    @Autowired
    PoDomService poDomService;

    @Autowired
    private MilestoneDomService milestoneDomService;

    @Autowired
    SiDomService siDomService;

    @Autowired
    RuleAppService ruleAppService;

    @Autowired
    EmailService emailService;

    @Autowired
    DocumentAppService documentAppService;

    @Autowired
    CarrierBookingAppService carrierBookingAppService;

    @Autowired
    PoAppService poAppService;

    @Override
    public So createSo(SoDto soDto) {
        if(soDto == null || soDto.getItemDtos() == null){
            return null;
        }

        List<SoItemDto> soItemDtos = soDto.getItemDtos();
        for(SoItemDto soItemDto: soItemDtos){
            SplittedPoItem splittedPoItem = poAppService.splitPoItem(soItemDto.getPoItemId(), soItemDto.getQuantity());
            if(splittedPoItem != null){
                soItemDto.setSplittedPoItemId(splittedPoItem.getId());
            }
        }

        So newSo = soDomService.createSo(SoAssembler.toSoEntity(soDto));
//        List<MileStone> mileStone = mileStoneDomService.getMilestones(so.getId());
//        mileStoneDomService.updateMilestones(mileStone);
        return newSo;
    }

    @Override
    public List<So> findAll() {
        return null;
    }

    @Override
    public So submitDraftSo(So so) {
        so = this.updateSoStatus(so, "PENDING");
        List<Milestone> mileStone = milestoneDomService.getMilestones(so.getId());
        milestoneDomService.updateMilestones(mileStone);
        ruleAppService.checkEdiRule("SO_CSV", "DUMMY_CUSTOMER");
        ruleAppService.matchCsv("DUMMY_OFFICE");
        this.sendSoEdi(so);
        this.notifyCsv(so);
        return so;
    }

    public void sendSoEdi(So so){
        ruleAppService.checkEdiRule("SO_EDI", "DUMMY_CUSTOMER");
        //B2B: Send EDI ---> not implement for POC
    }

    @Override
    public So updateSoStatus(So so, String status) {
        return soDomService.updateSo(so);
    }

    @Override
    public void notifyCsv(So so){
        String emailFrom = "papp@xxxxlogistics.com";
        String emailTo = "csv@xxxxlogistics.com";
        String emailCc = "";
        String emailBcc = "";
        String subject = "papp SO Notification";
        String body = "Dear CSV, SO# " + so.getId() + " has been created. Please followup. Regards, papp";
        boolean isSuccess = emailService.sendSimpleEmail(emailFrom, emailTo, emailCc, emailBcc, subject, body);
        if(isSuccess){
            log.info("createPoNotification sent");
        }else{
            log.error("createPoNotification cannot be sent");
        }
    }

    @Override
    public Document uploadSoSuppDocument(String id, Document document){
        Document uploadDocument = null;
        So so = this.searchSo(id);
        if(so!=null){
            uploadDocument = documentAppService.uploadDocument(document);
            //TODO: update documentId to SO
            soDomService.updateSo(so);
        }else{
            log.error("cannot uploadPoSuppDocument");
        }
        return uploadDocument;
    }

    @Override
    public So searchSo(String id){
        return this.soDomService.findSoById(id);
    }

    @Override
    public Document createSiDocument(So so){
        Si si = this.generateSi(so);
        return this.documentAppService.createPdf("SI", si);
    }

    @Override
    public Si generateSi(So so) {
        return this.siDomService.createSi(SiAssember.convertSoToSi(so));
    }

    @Override
    public So submitSo(So so) {
//      SailingScheduleSystem: searchSaillingSchedule --> not implement for POC
        so = this.updateSoStatus(so, "SUBMITTED");
        return carrierBookingAppService.assignContainer(so);
    }
}
