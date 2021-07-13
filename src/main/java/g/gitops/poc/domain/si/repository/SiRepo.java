package g.gitops.poc.domain.si.repository;

import g.gitops.poc.domain.si.entity.Si;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiRepo extends JpaRepository<Si, String> {
}
