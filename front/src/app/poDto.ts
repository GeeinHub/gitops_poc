import {PoItemDto} from './poItemDto';

export class PoDto {
  /**
   * 承销人
   */
  consignee: string;

  /**
   * PO#
   */
  poNum: string;

  /**
   * Po 供应商
   */
  poVendor: string;

  /**
   * 买主
   */
  buyer: string;

  /**
   * 收票人/单位
   */
  billTo: string;

  /**
   *
   */
  shipToName: string;

  /**
   * 运输地址
   */
  shipToAddress: string;

  /**
   * 货物来源
   */
  cargoOrigin: string;

  /**
   * 货物目的地
   */
  cargoDest: string;

  /**
   * 迪士尼来源
   */
  disneyOrigin: string;

  /**
   * 部门
   */
  dept: string;

  /**
   * 支付条款
   */
  paymentTerms: string;

  /**
   * 是否国内的
   */
  domestic: boolean;

  /**
   * 装船路由
   */
  shipVia: string;

  /**
   * 运费支付
   */
  freightPayment: string;

  /**
   * 贸易条件
   */
  tradingTerms: string;

  /**
   * 优先级
   */
  priority: string;

  /**
   * 管理方
   */
  handingParty: string;

  /**
   * 特殊承销人
   */
  specialConsigneeNames: string;

  /**
   * 起始承销人
   */
  originalConsigneeNames: string;

  /**
   * 承销人名字标识
   */
  consigneeNameIdentifier: string;

  /**
   * 实际收货人
   */
  actualReceiver: string;

  /**
   * 零售商订单类型
   */
  retailerPoType: string;

  /**
   * 零售商采购订单
   */
  retailerPurchaseOrder: string;

  /**
   *
   */
  shipToNum: string;

  /**
   * 销售货币
   */
  sellingCurrency: string;

  /**
   * 购买货币
   */
  buyingCurrency: string;

  /**
   * 附注
   */
  remarks: string;

  /**
   * po日期
   */
  poDate: string;

  /**
   * 取消日期
   */
  cancelDate: string;

  /**
   * 船期
   */
  shipDate: string;

  /**
   * 最新船期
   */
  latestShipDate: string;

  /**
   * 要求日期
   */
  demandDate: string;

  /**
   *
   */
  inWhseDate: string;

  /**
   * 正向存储位置标志
   */
  forwardStockingLocationFlag: string;

  /**
   * po状态
   */
  poStatus: string;

  /**
   * po类型
   */
  poType: string;

  poItemDtos: PoItemDto[];
}
