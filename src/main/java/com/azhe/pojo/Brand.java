package com.azhe.pojo;

public class Brand {

    private String id; // 唯一ID
    private String brandName; // 品牌名稱
    private String companyName; // 公司名稱
    private String ordered; // 數量
    private String description; // 描述
    private String status; // 狀態


    public Brand() {
    }

    public Brand(String id, String brandName, String companyName, String ordered, String description, String status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取
     * @return ordered
     */
    public String getOrdered() {
        return ordered;
    }

    /**
     * 设置
     * @param ordered
     */
    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        return "Brand\n{id = " + id + ", brandName = " + brandName + ", companyName = " + companyName + ", ordered = " + ordered + ", description = " + description + ", status = " + status + "}\n";
    }
}
