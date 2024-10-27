package com.azhe.pojo;

import lombok.Data;

@Data // 自動生成getter setter
public class PayPlatform {

    private String PAY_PLATFORM_ID   ;//int auto_increment comment '主键' primary key,
    private String PLATFORM_CODE     ;//varchar(30)          null comment '平台编码',
    private String PLATFORM_NAME     ;//varchar(100)         null comment '平台名称',
    private String MERCHANT_CODE     ;//varchar(200)         null comment '商户号',
    private String SECRET_KEY        ;//varchar(5000)        null comment '商户秘钥',
    private String RSA_KEY           ;//varchar(3000)        null comment '登录IP',
    private String PUBLIC_KEY        ;//varchar(2000)        null comment '公钥',
    private String IS_QUERY          ;//tinyint(1) default 0 null comment '是否启用回调订单同步查询接口 0:关闭 1:启用',
    private String QUERY_URL         ;//varchar(200)         null comment '查询订单回调接口URL',
    private String ip                ;//varchar(500)         null comment '回调服务器白名单IP',
    private String IS_ENABLE         ;//tinyint(1)           null comment '是否启用 0:未启用1:已启用',
    private String VERSION_NO        ;//varchar(100)         null comment '版本号',
    private String SUCCESS_URL       ;//varchar(200)         null comment '支付成功回传地址',
    private String CREATION_TIME     ;//datetime             null comment '创建时间',
    private String CREATION_BY       ;//varchar(30)          null comment '创建人',
    private String LAST_UPDATED_TIME ;//datetime             null comment '最后更新时间',
    private String LAST_UPDATED_BY   ;//varchar(30)          null comment '最后更新人',
    private String pay_Voucher       ;//varchar(3500)        null comment '商户秘钥'

}
