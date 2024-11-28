package com.azhe.pojo;

import lombok.Data;

@Data
public class PayChannel {

    private Integer payChannelId;           // 主键
    private Integer payTypeId;              // 支付类型ID
    private Integer payMethodId;            // 支付方式ID
    private Integer payModelId;             // 支付模板ID
    private String payPlatformCode;         // 支付平台编码
    private String payChannelCode;          // 支付通道代码
    private String payChannelName;          // 支付通道名称
    private String payChannelDesc;          // 支付通道描述
    private Integer orderNum;               // 支付通道排序字段
    private String payChannelQuota;         // 支付限额规则
    private String payDefaultAmount;        // 支付默认金额配置
    private String payBankCode;             // 网银支付编码
    private Boolean isRecommend;            // 是否推荐
    private Boolean isEnable;               // 是否启用
    private Boolean isDelete;               // 删除状态
    private Boolean isDisplay;              // 是否展示
    private Integer bankCardId;             // 银行卡ID
    private String receiptAccount;          // 收款账号
    private String opAccountPlace;          // 开户地
    private String receiptName;             // 收款人姓名
    private String payIconUrl;              // 收款二维码
    private String bankDeposit;             // 开户行
    private String voucherTips;             // 凭证提示
    private String remark;                  // 备注
    private Integer totalLoadTimes;         // 累计充值次数
    private String totalLoadAmount;     // 累计充值金额
    private String creationTime;              // 创建时间
    private String creationBy;              // 创建人
    private String lastUpdatedTime;           // 最后更新日期
    private String lastUpdatedBy;           // 最后更新人
    private String discountProportion;  // 优惠比例
    private String maxDiscountAmount;   // 最大优惠金额
    private String handlingProportion;  // 手续费比例
    private String maxHandlingAmount;   // 最大手续费金额
    private Integer successTimes;           // 成功次数
    private String totalSuccessAmount;  // 累计成功金额
    private String discountDamaMultiple; // 优惠打码倍数
    private Boolean enterSelf;              // 是否手动输入金额
    private String usdtType;                // USDT取款类型
    private String usdtAddress;             // USDT钱包地址
}
