package g.gitops.poc.domain.po.entity;

import g.gitops.poc.domain.common.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity
public class PoItem extends BaseEntity {
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

    @OneToMany(mappedBy="thePoItem", targetEntity = SplittedPoItem.class)
    private List<SplittedPoItem> splittedPoItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
    private Po thePo;

    public String getSkuNum() {
        return skuNum;
    }

    public void setSkuNum(String skuNum) {
        this.skuNum = skuNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getCtns() {
        return ctns;
    }

    public void setCtns(String ctns) {
        this.ctns = ctns;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getEstUnitCost() {
        return estUnitCost;
    }

    public void setEstUnitCost(String estUnitCost) {
        this.estUnitCost = estUnitCost;
    }

    public String getVendorUpc() {
        return vendorUpc;
    }

    public void setVendorUpc(String vendorUpc) {
        this.vendorUpc = vendorUpc;
    }

    public String getUnitRetail() {
        return unitRetail;
    }

    public void setUnitRetail(String unitRetail) {
        this.unitRetail = unitRetail;
    }

    public String getHtsNum() {
        return htsNum;
    }

    public void setHtsNum(String htsNum) {
        this.htsNum = htsNum;
    }

    public String getLongItemNumber() {
        return longItemNumber;
    }

    public void setLongItemNumber(String longItemNumber) {
        this.longItemNumber = longItemNumber;
    }

    public String getSkuServiceLevel() {
        return skuServiceLevel;
    }

    public void setSkuServiceLevel(String skuServiceLevel) {
        this.skuServiceLevel = skuServiceLevel;
    }

    public String getRetailerItemNumber() {
        return retailerItemNumber;
    }

    public void setRetailerItemNumber(String retailerItemNumber) {
        this.retailerItemNumber = retailerItemNumber;
    }

    public List<SplittedPoItem> getSplittedPoItems() {
        return splittedPoItems;
    }

    public void setSplittedPoItems(List<SplittedPoItem> splittedPoItems) {
        this.splittedPoItems = splittedPoItems;
    }

    public Po getThePo() {
        return thePo;
    }

    public void setThePo(Po thePo) {
        this.thePo = thePo;
    }
}
