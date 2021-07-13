package g.gitops.poc.app.service;

import g.gitops.poc.domain.milestone.entity.Milestone;

import java.util.Date;
import java.util.List;

public interface MilestoneAppService {
    Milestone createMilestone(Milestone milestone);
//    Date calculateMilestoneExpectedDate(String milestoneCode, String customerCode, Date baseDate);

    Milestone createMilestoneViaMsg(Milestone msInfo,Date baseDate);

    List<Milestone> searchMilestone(String refId,String refType);
}
