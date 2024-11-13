package com.azhe.pojo;

import lombok.Data;

/**
 * 支付平台对应的支付算法模板
 */
@Data
public class PayRequestModel {

    private String payModelId;
    private String platformCode;
    private String payStrategyName;
    private String payStrategyType;
    private String payRequestStrategy;
    private String payRequestApi;
    private String orderStrategy;
    private String encryptionStrategy;
    private String signValue;
    private String requestValue;
    private String requestEncryptionStrategy;
    private String responseStrategy;
    private String pageCallbackUrl;
    private String callbackUrl;
    private String callbackStrategy;
    private String callbackReturnStrategy;
    private String orderNoStatus;
    private String callbackSignValue;
    private String rootXml;
    private String amountStrategy;
    private String queryStrategy;
    private String creationTime;
    private String creationBy;
    private String lastUpdatedTime;
    private String lastUpdatedBy;
}
