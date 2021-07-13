package g.gitops.poc.domain.document.repository;

import g.gitops.poc.domain.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo  extends JpaRepository<Document, String> {
}
