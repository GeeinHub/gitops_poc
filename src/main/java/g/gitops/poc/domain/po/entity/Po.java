package g.gitops.poc.domain.po.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import g.gitops.poc.domain.common.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

//@Data
@Entity
public class Po extends BaseEntity {
    private String consignee;
    private String poNum;
    private String poVendor;
    private String buyer;
    private String billTo;
    private String shipToName;
    private String shipToAddress;
    private String cargoOrigin;
    private String cargoDest;
    private String disneyOrigin;
    private String dept;
    private String paymentTerms;
    @JsonIgnore
    private Boolean domestic;
    private String shipVia;
    @JsonIgnore
    private String freightPayment;
    private String tradingTerms;
    private String priority;
    private String handingParty;
    @JsonIgnore
    private String specialConsigneeNames;
    private String originalConsigneeNames;
    private String consigneeNameIdentifier;
    private String actualReceiver;
    private String retailerPoType;
    private String retailerPurchaseOrder;
    private String shipToNum;
    private String sellingCurrency;
    private String buyingCurrency;
    private String remarks;
    private String poDate;
    private String cancelDate;
    private String shipDate;
    private String latestShipDate;
    private String demandDate;
    private String inWhseDate;
    private String forwardStockingLocationFlag;
    private String poStatus;

    private String poType;

    @OneToMany(mappedBy="thePo", targetEntity = PoItem.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PoItem> poItems = new ArrayList<>();

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    public String getPoVendor() {
        return poVendor;
    }

    public void setPoVendor(String poVendor) {
        this.poVendor = poVendor;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public String getCargoOrigin() {
        return cargoOrigin;
    }

    public void setCargoOrigin(String cargoOrigin) {
        this.cargoOrigin = cargoOrigin;
    }

    public String getCargoDest() {
        return cargoDest;
    }

    public void setCargoDest(String cargoDest) {
        this.cargoDest = cargoDest;
    }

    public String getDisneyOrigin() {
        return disneyOrigin;
    }

    public void setDisneyOrigin(String disneyOrigin) {
        this.disneyOrigin = disneyOrigin;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Boolean getDomestic() {
        return domestic;
    }

    public void setDomestic(Boolean domestic) {
        this.domestic = domestic;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getFreightPayment() {
        return freightPayment;
    }

    public void setFreightPayment(String freightPayment) {
        this.freightPayment = freightPayment;
    }

    public String getTradingTerms() {
        return tradingTerms;
    }

    public void setTradingTerms(String tradingTerms) {
        this.tradingTerms = tradingTerms;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getHandingParty() {
        return handingParty;
    }

    public void setHandingParty(String handingParty) {
        this.handingParty = handingParty;
    }

    public String getSpecialConsigneeNames() {
        return specialConsigneeNames;
    }

    public void setSpecialConsigneeNames(String specialConsigneeNames) {
        this.specialConsigneeNames = specialConsigneeNames;
    }

    public String getOriginalConsigneeNames() {
        return originalConsigneeNames;
    }

    public void setOriginalConsigneeNames(String originalConsigneeNames) {
        this.originalConsigneeNames = originalConsigneeNames;
    }

    public String getConsigneeNameIdentifier() {
        return consigneeNameIdentifier;
    }

    public void setConsigneeNameIdentifier(String consigneeNameIdentifier) {
        this.consigneeNameIdentifier = consigneeNameIdentifier;
    }

    public String getActualReceiver() {
        return actualReceiver;
    }

    public void setActualReceiver(String actualReceiver) {
        this.actualReceiver = actualReceiver;
    }

    public String getRetailerPoType() {
        return retailerPoType;
    }

    public void setRetailerPoType(String retailerPoType) {
        this.retailerPoType = retailerPoType;
    }

    public String getRetailerPurchaseOrder() {
        return retailerPurchaseOrder;
    }

    public void setRetailerPurchaseOrder(String retailerPurchaseOrder) {
        this.retailerPurchaseOrder = retailerPurchaseOrder;
    }

    public String getShipToNum() {
        return shipToNum;
    }

    public void setShipToNum(String shipToNum) {
        this.shipToNum = shipToNum;
    }

    public String getSellingCurrency() {
        return sellingCurrency;
    }

    public void setSellingCurrency(String sellingCurrency) {
        this.sellingCurrency = sellingCurrency;
    }

    public String getBuyingCurrency() {
        return buyingCurrency;
    }

    public void setBuyingCurrency(String buyingCurrency) {
        this.buyingCurrency = buyingCurrency;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPoDate() {
        return poDate;
    }

    public void setPoDate(String poDate) {
        this.poDate = poDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getLatestShipDate() {
        return latestShipDate;
    }

    public void setLatestShipDate(String latestShipDate) {
        this.latestShipDate = latestShipDate;
    }

    public String getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(String demandDate) {
        this.demandDate = demandDate;
    }

    public String getInWhseDate() {
        return inWhseDate;
    }

    public void setInWhseDate(String inWhseDate) {
        this.inWhseDate = inWhseDate;
    }

    public String getForwardStockingLocationFlag() {
        return forwardStockingLocationFlag;
    }

    public void setForwardStockingLocationFlag(String forwardStockingLocationFlag) {
        this.forwardStockingLocationFlag = forwardStockingLocationFlag;
    }

    public String getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(String poStatus) {
        this.poStatus = poStatus;
    }

    public String getPoType() {
        return poType;
    }

    public void setPoType(String poType) {
        this.poType = poType;
    }

    public List<PoItem> getPoItems() {
        return poItems;
    }

    public void setPoItems(List<PoItem> poItems) {
        this.poItems = poItems;
    }
}
