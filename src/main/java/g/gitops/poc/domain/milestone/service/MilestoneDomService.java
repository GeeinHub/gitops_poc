package g.gitops.poc.domain.milestone.service;

import g.gitops.poc.domain.milestone.entity.Milestone;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MilestoneDomService {
    Milestone createMilestone(Milestone milestone);
    List<Milestone> updateMilestones(List<Milestone> milestones);
    List<Milestone> getMilestones(String id);
    Optional<Milestone> getMileStone(String id);
    Date calculateMilestoneExpectedDate(String milestoneCode, String customerCode, Date baseDate);
    List<Milestone> findByReferenceIdAndReferenceType(String referenceId,String referenceType);
}
