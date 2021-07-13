package g.gitops.poc.domain.so.entity;

import g.gitops.poc.domain.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class So extends BaseEntity {
    private String soNumber;
    private String status;

    @OneToMany(mappedBy="theSo", targetEntity = SoItem.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SoItem> soItems = new ArrayList<>();
}
