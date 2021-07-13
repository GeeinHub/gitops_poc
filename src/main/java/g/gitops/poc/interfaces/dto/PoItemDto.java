package g.gitops.poc.interfaces.dto;

import lombok.Data;

@Data
public class PoItemDto extends BaseDto {
    private String skuNum;
    private String color;
    private String size;
    private String description;
    private String division;
    private String unitCost;
    private String units;
    private String ctns;
    private String volume;
    private String estUnitCost;
    private String vendorUpc;
    private String unitRetail;
    private String htsNum;
    private String longItemNumber;
    private String skuServiceLevel;
    private String retailerItemNumber;
}
