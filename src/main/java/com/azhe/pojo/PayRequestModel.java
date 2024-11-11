package com.azhe.pojo;

import lombok.Data;

/**
 * 支付平台对应的支付算法模板
 */
@Data
public class PayRequestModel {


    private String PAY_MODEL_ID                ; // key,
    private String PLATFORM_CODE               ; //'支付平台编码',
    private String PAY_STRATEGY_NAME           ; //'支付策略名称',
    private String PAY_STRATEGY_TYPE           ; //'支付策略 1.WAP 2.网银 3.扫码 (此处编码为字母)',
    private String PAY_REQUEST_STRATEGY        ; //'支付请求策略编码(报文组装策略)',
    private String PAY_REQUEST_API             ; //'请求接口地址',
    private String ORDER_STRATEGY              ; //'订单生成策略',
    private String ENCRYPTION_STRATEGY         ; //'加密策略编码',
    private String SIGN_VALUE                  ; //'签名的格式',
    private String REQUERT_VALUE               ; //'请求报文格式',
    private String REQUEST_ENCRYPTION_STRATEGY ; //'请求报文2次加密 (默认不加密)',
    private String RESPONSE_STRATEGY           ; //'响应报文解析策略',
    private String PAGE_CALLBACK_URL           ; //'成功回调页面跳转地址',
    private String CALLBACK_URL                ; //'回调链接',
    private String CALLBACK_STRATEGY           ; //'回调报文解析策略',
    private String CALLBACK_RETURN_STRATEGY    ; //'回调回传报文策略',
    private String ORDERNO_STATUS              ; //'回调成功标志',
    private String CALLBACK_SIGN_VALUE         ; //'回调签名格式',
    private String ROOT_XML                    ; //'配置XML',
    private String AMOUNT_STRATEGY             ; //'金额处理策略',
    private String QUERY_STRATEGY              ; //'回调订单同步查询策略',
    private String CREATION_TIME               ; //'创建时间',
    private String CREATION_BY                 ; //'创建人',
    private String LAST_UPDATED_TIME           ; //'修改时间',
    private String LAST_UPDATED_BY             ; //'最后更新人'
}//
