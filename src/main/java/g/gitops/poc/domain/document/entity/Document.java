package g.gitops.poc.domain.document.entity;

import g.gitops.poc.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Document extends BaseEntity{
    private String referenceType;
    private String referenceId;
    private String referenceOwner;
    private String documentId;
}
