package g.gitops.poc.interfaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class PoDto extends  BaseDto{
    /**
     * 承销人
     */
    private String consignee;

    /**
     * PO#
     */
    private String poNum;

    /**
     * Po 供应商
     */
    private String poVendor;

    /**
     * 买主
     */
    private String buyer;

    /**
     * 收票人/单位
     */
    private String billTo;

    /**
     *
     */
    private String shipToName;

    /**
     * 运输地址
     */
    private String shipToAddress;

    /**
     * 货物来源
     */
    private String cargoOrigin;

    /**
     * 货物目的地
     */
    private String cargoDest;

    /**
     * 迪士尼来源
     */
    private String disneyOrigin;

    /**
     * 部门
     */
    private String dept;

    /**
     * 支付条款
     */
    private String paymentTerms;

    /**
     * 是否国内的
     */
    private Boolean domestic;

    /**
     * 装船路由
     */
    private String shipVia;

    /**
     * 运费支付
     */
    private String freightPayment;

    /**
     *
     */
    private String tradingTerms;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 管理方
     */
    private String handingParty;

    /**
     * 特殊承销人
     */
    private String specialConsigneeNames;

    /**
     * 起始承销人
     */
    private String originalConsigneeNames;

    /**
     * 承销人名字标识
     */
    private String consigneeNameIdentifier;

    /**
     * 实际收货人
     */
    private String actualReceiver;

    /**
     * 零售商订单类型
     */
    private String retailerPoType;

    /**
     * 零售商采购订单
     */
    private String retailerPurchaseOrder;

    /**
     *
     */
    private String shipToNum;

    /**
     * 销售货币
     */
    private String sellingCurrency;

    /**
     * 购买货币
     */
    private String buyingCurrency;

    /**
     * 附注
     */
    private String remarks;

    /**
     * po日期
     */
    private String poDate;

    /**
     * 取消日期
     */
    private String cancelDate;

    /**
     * 船期
     */
    private String shipDate;

    /**
     * 最新船期
     */
    private String latestShipDate;

    /**
     * 要求日期
     */
    private String demandDate;

    /**
     *
     */
    private String inWhseDate;

    /**
     * 正向存储位置标志
     */
    private String forwardStockingLocationFlag;

    /**
     * po状态
     */
    private String poStatus;

    /**
     * po类型
     */
    private String poType;

    private List<PoItemDto> poItemDtos;
}
