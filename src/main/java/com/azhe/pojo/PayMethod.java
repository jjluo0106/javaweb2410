package com.azhe.pojo;

import lombok.Data;

@Data
public class PayMethod {

    private Integer payMethodId;          // 主键
    private Integer payTypeId;            // 支付类型ID
    private Boolean isOnline;             // 线上线下 1:线上 2:线下
    private String payMethodCode;         // 支付方式代码
    private String payMethodName;         // 支付方式名称
    private String payMethodDesc;         // 支付方式描述
    private Integer orderNum;             // 支付类型排序字段
    private Boolean isRecommend;          // 是否推荐 0:未推荐 1:推荐
    private Boolean isEnable;             // 是否启用 0:未启用 1:已启用
    private String creationTime;            // 创建时间
    private String creationBy;            // 创建人
    private String lastUpdatedTime;         // 最后更新日期
    private String lastUpdatedBy;         // 最后更新人
}
