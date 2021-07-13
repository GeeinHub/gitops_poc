package g.gitops.poc.app.service.impl;

import g.gitops.poc.app.service.MilestoneAppService;
import g.gitops.poc.domain.milestone.entity.Milestone;
import g.gitops.poc.domain.milestone.service.MilestoneDomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MilestoneAppServiceImpl implements MilestoneAppService {

    @Autowired
    MilestoneDomService milestoneDomService;

//    @Autowired
//    RuleAppService ruleAppService;

    public Milestone createMilestone(Milestone milestone){
        return milestoneDomService.createMilestone(milestone);
    }

//    public Date calculateMilestoneExpectedDate(String milestoneCode, String customerCode, Date baseDate){
//        if(StringUtils.isEmpty(milestoneCode) || StringUtils.isEmpty(customerCode) || baseDate == null){
//            return baseDate;
//        }
//        String ruleValue = ruleAppService.checkMilestoneRule(milestoneCode, customerCode);
//
//        Calendar c = Calendar.getInstance();
//        c.setTime(baseDate);
//        c.add(Calendar.DATE, Integer.parseInt(ruleValue));
//        return c.getTime();
//    }

    public Milestone createMilestoneViaMsg(Milestone msInfo, Date baseDate){
        Milestone milestone = new Milestone();
        Date expectedDate = milestoneDomService.calculateMilestoneExpectedDate(msInfo.getMilestoneCode(),msInfo.getReferenceOwner(),baseDate);
        BeanUtils.copyProperties(msInfo,milestone);
        milestone.setExpectedDate(expectedDate);
        return milestoneDomService.createMilestone(milestone);
    }

    @Override
    public List<Milestone> searchMilestone(String refId, String refType) {
        return milestoneDomService.findByReferenceIdAndReferenceType(refId,refType);
    }


}
