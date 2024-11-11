package com.azhe.pojo;

import lombok.Data;

/**
 * 盤口平台編碼&回調地址
 */
@Data
public class PayAppType {


    private String app_id; // key
    private String app_code; //'盘口平台编码',
    private String app_name; //'盘口平台名称',
    private String app_call_url; //'盘口支付回调地址',
    private String app_domain; //'盘口平台域名'
}
