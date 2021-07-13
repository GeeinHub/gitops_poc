package g.gitops.poc.interfaces.dto;

public class MilestoneSearchDto {
    private String refId;

    private String refType;

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }
}
