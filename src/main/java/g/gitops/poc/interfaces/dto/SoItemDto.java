package g.gitops.poc.interfaces.dto;

import lombok.Data;

@Data
public class SoItemDto extends BaseDto {
    private String poItemId;
    private String splittedPoItemId;
    private String skuNum;
    private String ctns;
    private String ctnUom;
    private String units;
    private String unitsUom;
    private String divisionSku;
    private String handingParty;
    private String netWeight;
    private String forwardStockingLocationFlag;
    private String packing;
    private String unitOrPack;
    private String retailerPoType;
    private String retailerItemNumber;
    private String retailerPurchaseOrder;
    private String shipToNum;
    private String volumeCbm;
    private String weight;
    private String description;
    private String color;
    private String size;
    private String length;
    private String width;
    private String height;
    private String measurement;
    private String poItemStatus;
    private int quantity;
}
