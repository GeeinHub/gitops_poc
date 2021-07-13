package g.gitops.poc.domain.milestone.repository;

import g.gitops.poc.domain.milestone.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MileStoneRepo extends JpaRepository<Milestone, String> {
    List<Milestone> findAllById(String id);

    List<Milestone> findByReferenceIdAndReferenceType(String referenceId,String referenceType);
}
