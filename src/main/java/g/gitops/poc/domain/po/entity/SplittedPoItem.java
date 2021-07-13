package g.gitops.poc.domain.po.entity;

import g.gitops.poc.domain.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

//@Data
@Entity
public class SplittedPoItem extends BaseEntity {
    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    private PoItem thePoItem;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PoItem getThePoItem() {
        return thePoItem;
    }

    public void setThePoItem(PoItem thePoItem) {
        this.thePoItem = thePoItem;
    }
}
