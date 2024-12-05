package com.azhe.pojo;

import lombok.Data;

@Data // 自動生成getter setter
public class PayPlatform {

    private String payPlatformId;    // 主鍵
    private String platformCode;     // 平台編碼
    private String platformName;     // 平台名稱
    private String merchantCode;     // 商戶號
    private String secretKey;        // 商戶秘鑰
    private String rsaKey;           // RSA 秘鑰
    private String publicKey;        // 公鑰
    private String isQuery;          // 是否啟用回調訂單同步查詢接口 (0: 關閉, 1: 啟用)
    private String queryUrl;         // 查詢訂單回調接口 URL
    private String ip;               // 回調伺服器白名單 IP
    private String isEnable;         // 是否啟用 (0: 未啟用, 1: 已啟用)
    private String versionNo;        // 版本號
    private String successUrl;       // 支付成功回傳地址
    private String creationTime;     // 創建時間
    private String creationBy;       // 創建人
    private String lastUpdatedTime;  // 最後更新時間
    private String lastUpdatedBy;    // 最後更新人
    private String payVoucher;       // 商戶秘鑰


    private String myPlatformCode;
    private String myPlatformName;
    private String myMerchantCode;
    private String mySecretCode;
    private String myIP;
    private String mySuccessfulURL;
    private String myQueryURL;
    private String myChannelCode;
}

