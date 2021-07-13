package g.gitops.poc.interfaces.dto;

import lombok.Data;

@Data
public class DocumentDto extends BaseDto{
    private String referenceType;
    private String referenceId;
    private String referenceOwner;
    private String documentId;
}
