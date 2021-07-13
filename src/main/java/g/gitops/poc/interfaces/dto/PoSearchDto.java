package g.gitops.poc.interfaces.dto;

import lombok.Data;

@Data
public class PoSearchDto {
    private String poNumber;
    private String customerCode;
    private String vendorCode;
}
