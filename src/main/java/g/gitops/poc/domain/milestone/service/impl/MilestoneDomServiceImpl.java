package g.gitops.poc.domain.milestone.service.impl;

import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.repository.MileStoneRepo;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MilestoneDomServiceImpl implements MilestoneDomService {

    @Autowired
    MileStoneRepo mileStoneRepo;

    @Override
    public Milestone createMilestone(Milestone milestone) {
        milestone.setCreatedDate(new Date());
        return mileStoneRepo.save(milestone);
    }

    @Override
    public List<Milestone> updateMilestones(List<Milestone> milestones) {
        return mileStoneRepo.saveAll(milestones);
    }

    @Override
    public List<Milestone> getMilestones(String id) {
        return mileStoneRepo.findAllById(id);
    }


    @Override
    public Optional<Milestone> getMileStone(String id) {
        return mileStoneRepo.findById(id);
    }

    public Date calculateMilestoneExpectedDate(String milestoneCode, String customerCode, Date baseDate){
        if(StringUtils.isEmpty(milestoneCode) || StringUtils.isEmpty(customerCode) || baseDate == null){
            return baseDate;
        }

        //suggest to store such rule in centralized server cache, e.g. redis
        String ruleValue = "-10";//ruleAppService.checkMilestoneRule(milestoneCode, customerCode);

        Calendar c = Calendar.getInstance();
        c.setTime(baseDate);
        c.add(Calendar.DATE, Integer.parseInt(ruleValue));
        return c.getTime();
    }
    
    public List<Milestone> findByReferenceIdAndReferenceType(String referenceId,String referenceType){
        return mileStoneRepo.findByReferenceIdAndReferenceType(referenceId,referenceType);
    }

}
