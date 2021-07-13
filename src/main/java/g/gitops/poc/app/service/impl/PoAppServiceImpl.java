package g.gitops.poc.app.service.impl;

import g.gitops.poc.app.service.DocumentAppService;
import g.gitops.poc.app.service.PoAppService;
import g.gitops.poc.domain.document.entity.Document;
import g.gitops.poc.domain.document.service.DocumentDomService;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.domain.po.entity.SplittedPoItem;
import g.gitops.poc.domain.po.service.PoDomService;
import g.gitops.poc.infrastructure.common.ActiveMQConfig;
import g.gitops.poc.infrastructure.common.email.EmailService;
import g.gitops.poc.infrastructure.common.event.JmsEventPublisher;
import g.gitops.poc.infrastructure.util.JsonUtil;
import g.gitops.poc.interfaces.event.PoEventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PoAppServiceImpl implements PoAppService {
    @Autowired
    PoDomService poDomService;

//    @Autowired
//    MilestoneAppService milestoneAppService;

    @Autowired
    DocumentDomService documentDomService;

    @Autowired
    EmailService emailService;

    @Autowired
    DocumentAppService documentAppService;

    @Autowired
    JmsEventPublisher jmsEventPublisher;

    @Override
    public Po uploadPo(Document doc) {
        String poXml = this.documentDomService.convertExcelToXml(doc);
        Po po = this.convertPoXmlToPo(poXml);
        return this.createPo(po);
    }

    @Override
    public Po convertPoXmlToPo(String poXml){
        return new Po();
    }

    @Override
    public Po createPo(Po po) {
        Po newPo = poDomService.createPo(po);
        this.jmsEventPublisher.publish(JsonUtil.objectToMap(newPo), PoEventType.CREATE_PO.name(), ActiveMQConfig.TOPIC_PO);
        //this.createVendorBookingMilestone(po);
//        this.createPoNotification(newPo);
        return newPo;
    }

//    public void createVendorBookingMilestone(Po po){
////        String refType = "PO";
////        String refId = po.getPoNum();
////        String refOwner = po.getConsignee();
////        String milestoneCode = MilestoneConstant.VENDOR_BOOKING_CREATED;
//
//        try{
////            SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD");
////            Date baseDate = sf.parse(po.getShipDate());
////            Date expectedDate = milestoneAppService.calculateMilestoneExpectedDate(milestoneCode, po.getPoNum(), baseDate);
////            this.jmsEventPublisher.publish(JsonUtil.objectToMap(po), PoEventType.CREATE_PO.name(), ActiveMQConfig.TOPIC_PO);
////            Milestone milestone = new Milestone(refType, refId, refOwner, milestoneCode, expectedDate);
////            return this.milestoneAppService.createMilestone(milestone);
//        }catch (Exception e){
//            log.error(e.getMessage(),e);
////          return null;
//        }
//    }

    @Override
    public List<Po> findAll() {
        return poDomService.findAll();
    }

    @Override
    public void createPoNotification(Po po){
        String emailFrom = "papp@xxxxlogistics.com";
        String emailTo = "user@demovendor.com";
        String emailCc = "";
        String emailBcc = "";
        String subject = "papp PO Notification";
        String body = "Dear Vendor, <br/><br/>PO# " + po.getPoNum() + " has been created. Please follow-up. <br/><br/>Regards, papp";
        boolean isSuccess = emailService.sendSimpleEmail(emailFrom, emailTo, emailCc, emailBcc, subject, body);
        if(isSuccess){
            log.info("createPoNotification sent");
        }else{
            log.error("createPoNotification cannot be sent");
        }
    }

    @Override
    public Po searchPo(String poNumber) {
        return poDomService.findPoByPoNum(poNumber);
    }

    @Override
    public Po searchPo(String poNumber, String customerCode) {
        return poDomService.findPoByPoNumberAndCustomerCode(poNumber, customerCode);
    }

    @Override
    public Po searchPo(String poNumber, String customerCode, String vendorCode) {
        return poDomService.findPoByPoNumberAndCustomerCodeAndVendorCode(poNumber, customerCode, vendorCode);
    }

    @Override
    public Document uploadPoSuppDocument(Document document){
        return this.documentAppService.uploadDocument(document);
    }

    @Override
    public SplittedPoItem splitPoItem(String poItemId, int quantity){
        PoItem poItem = poDomService.findPoItemById(poItemId);
        if(poItem == null){
            return null;
        }
        SplittedPoItem splittedPoItem = new SplittedPoItem();
        splittedPoItem.setCreatedBy("SYSTEMDUMMY");
        splittedPoItem.setCreatedDate(new Date());
        splittedPoItem.setLastModifiedBy("SYSTEMDUMMY");
        splittedPoItem.setLastModifiedDate(new Date());
        splittedPoItem.setQuantity(quantity);
        splittedPoItem.setThePoItem(poItem);
        return poDomService.createSplittedPoItem(splittedPoItem);
    }

    @Override
    public Po updatePo(Po updatedPo){
        Po existPo = this.searchPo(updatedPo.getPoNum(), updatedPo.getConsignee());
        if(existPo == null){
            return null;
        }
        BeanUtils.copyProperties(updatedPo, existPo);
        return this.poDomService.updatePo(existPo);
    }
}
