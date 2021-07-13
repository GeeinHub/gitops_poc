package g.gitops.poc.domain.so.repository;

import g.gitops.poc.domain.so.entity.So;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoRepo extends JpaRepository<So, String> {
    So findSoById(String id);
}
