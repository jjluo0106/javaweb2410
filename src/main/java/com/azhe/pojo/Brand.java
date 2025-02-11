package com.azhe.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand{

    private String id; // 唯一ID
    private String brandName; // 品牌名稱
    private String companyName; // 公司名稱
    private String ordered; // 數量
    private String description; // 描述
    private String status; // 狀態

//    @Override
//    public int compareTo(Brand o2) {
//        if (o2 == null) {
//            throw new NullPointerException("The Brand object to compare with cannot be null");
//        }
//
//        // 检查 this.brandName 和 o2.brandName 是否为 null
//        if (this.brandName == null && o2.brandName == null) {
//            return 0;
//        } else if (this.brandName == null) {
//            return -1; // 或者根据业务逻辑返回其他值
//        } else if (o2.brandName == null) {
//            return 1; // 或者根据业务逻辑返回其他值
//        } else {
//            return o2.brandName.compareTo(this.brandName);
//        }
//    }

    @Override
    public String toString(){
        return "Brand{" +
                "id='" + id + '\'' +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                "}\n";
    }

}
