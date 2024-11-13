package com.azhe.pojo;

import lombok.Data;

/**
 * 盤口平台編碼&回調地址
 */
@Data
public class PayAppType {


    private String appId; // key
    private String appCode; //'盘口平台编码',
    private String appName; //'盘口平台名称',
    private String appCallUrl; //'盘口支付回调地址',
    private String appDomain; //'盘口平台域名'
}
