package g.gitops.poc.dataloader;

import g.gitops.poc.domain.milestone.constant.MilestoneConstant;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.repository.MileStoneRepo;
import g.gitops.poc.domain.po.entity.Po;
import g.gitops.poc.domain.po.entity.PoItem;
import g.gitops.poc.domain.po.repository.PoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Profile({"dev"})
@Configuration
public class DummyDataLoader {

    @Bean
    public CommandLineRunner dataLoader(PoRepo poRepo, MileStoneRepo mileStoneRepo) {
        createDummyPos(poRepo, mileStoneRepo);
        return null;
    }

    private void createDummyPos(PoRepo poRepo,MileStoneRepo mileStoneRepo){
        log.info("****** DataLoader --- createDummyPos start ******");
        List<Po> dummyPos = new ArrayList<>();
        List<Milestone> dummyMilestones = new ArrayList<>();
        for(int i=0; i<10; i++){
            Po po = this.createDummyPo(i);
            dummyPos.add(po);
            dummyMilestones.add(this.createDummyMilestone(po));
        }
        poRepo.saveAll(dummyPos);
        mileStoneRepo.saveAll(dummyMilestones);
        log.info("****** DataLoader --- createDummyPos end ******");
    }

    private Milestone createDummyMilestone(Po po){
        Milestone ms = new Milestone();
        ms.setReferenceType("PO");
        ms.setMilestoneCode(MilestoneConstant.VENDOR_BOOKING_CREATED);
        ms.setReferenceId(po.getPoNum());
        ms.setExpectedDate(new Date());
        return ms;
    }

    private Po createDummyPo(int index){
        Po po = new Po();
        po.setPoNum("TESTPO" + index);
        po.setConsignee("Disney Theme Park Merchandise-CA");
        po.setPoVendor("Disney PO Vendor " + index);

        for(int i=0; i<3; i++){
            PoItem poItem = new PoItem();
            poItem.setSkuNum("SKU " + i);
            poItem.setColor("Color " + i);
            poItem.setSize("Size " + i);
            poItem.setThePo(po);
            po.getPoItems().add(poItem);
        }

        return po;
    }
}
