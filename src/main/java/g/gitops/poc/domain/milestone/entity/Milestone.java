package g.gitops.poc.domain.milestone.entity;

import g.gitops.poc.domain.common.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Milestone extends BaseEntity {
    private String referenceType;
    private String referenceId;
    private String referenceOwner;
    private String milestoneCode;
    private Date expectedDate;
    private Date actualDate;

    public Milestone(){}

    public Milestone(String referenceType, String referenceId, String referenceOwner, String milestoneCode, Date expectedDate){
        this.setReferenceType(referenceType);
        this.setReferenceId(referenceId);
        this.setReferenceOwner(referenceOwner);
        this.setMilestoneCode(milestoneCode);
        this.setExpectedDate(expectedDate);
        this.setCreatedBy("SYSTEMDUMMY");
        this.setCreatedDate(new Date());
        this.setLastModifiedBy("SYSTEMDUMMY");
        this.setLastModifiedDate(new Date());
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceOwner() {
        return referenceOwner;
    }

    public void setReferenceOwner(String referenceOwner) {
        this.referenceOwner = referenceOwner;
    }

    public String getMilestoneCode() {
        return milestoneCode;
    }

    public void setMilestoneCode(String milestoneCode) {
        this.milestoneCode = milestoneCode;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(Date actualDate) {
        this.actualDate = actualDate;
    }
}
