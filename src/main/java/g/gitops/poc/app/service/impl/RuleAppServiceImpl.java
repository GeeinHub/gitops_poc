package g.gitops.poc.app.service.impl;

import g.gitops.poc.app.service.RuleAppService;
import g.gitops.poc.domain.milestone.constant.MilestoneConstant;
import org.springframework.stereotype.Service;

@Service
public class RuleAppServiceImpl implements RuleAppService {

    @Override
    public String checkEdiRule(String module, String customerCode) {
        return null;
    }

    @Override
    public String matchCsv(String serviceOffice) {
        return null;
    }

    @Override
    public String checkMilestoneRule(String milestoneCode, String customerCode) {
        if(MilestoneConstant.VENDOR_BOOKING_CREATED.equals(milestoneCode)){
            return "-10";
        }
        return "-5";
    }
}
