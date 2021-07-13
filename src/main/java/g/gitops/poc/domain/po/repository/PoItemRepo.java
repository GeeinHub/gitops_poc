package g.gitops.poc.domain.po.repository;

import g.gitops.poc.domain.po.entity.PoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoItemRepo extends JpaRepository<PoItem, String> {
    PoItem findPoItemById(String id);
}
