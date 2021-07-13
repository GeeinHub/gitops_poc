package g.gitops.poc.domain.po.repository;

import g.gitops.poc.domain.po.entity.SplittedPoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SplittedPoItemRepo  extends JpaRepository<SplittedPoItem, String> {
}
