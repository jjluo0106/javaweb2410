package com.azhe.pojo;

import lombok.Data;

@Data
public class MemberPayFiled {

    // 主键
    private String filedMapperId;

    // 支付模板ID
    private String payModelId;

    // API字段名称
    private String apiFiledName;

    // 字段类型(java 类型) 默认为 java.lang.String
    private String filedJavaType = "java.lang.String";

    // 对应实体的名字
    private String modelFiledName;

    // 字段对应顺序
    private String orderNumber;

    // 是否是金额 0:不是 1:是
    private String isAmount;

    // 字段所属类型 1:请求报文 2:响应报文 3:回调报文 4:签名字段 5:回调签名字段 6:前端回传字段映射
    private String filedType;

    // 创建时间
    private String creationTime;

    // 创建人
    private String creationBy;

    // 修改时间
    private String lastUpdatedTime;

    // 最后更新人
    private String lastUpdatedBy;
}
