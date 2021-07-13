package g.gitops.poc.domain.so.entity;

import g.gitops.poc.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SoItem extends BaseEntity {
    private String splittedPoItemId;

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    private So theSo;
}
