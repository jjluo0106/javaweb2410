package leetcode.practicing;

import cn.hutool.crypto.digest.DigestUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class A217 {


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set=  new HashSet<>();

        for(int i=0; i<nums.length; i++){
            while(set.contains(nums[i])) return true;
            set.add(nums[i]);

        }
        return false;
    }



    @Test
    public void ttt(){

        String data = "member_id=5&order_no=T100202510081953310652548390&out_order_amount=2.00&out_order_attach=k8rY&out_order_no=20251009190012974KEz&payment_finish_time=1759924457&payment_refund_time=0&payment_status=1&key=e787b6635061e6f718f14d97d1a88db4";

        System.out.println("MD5加密前字串 : " + data);
        System.out.println("加密后 : " + DigestUtil.md5Hex(data));


        System.out.println(System.currentTimeMillis());
    }



    @Test
    public  void tttttt() throws JSONException {
        String json = "{\"requestType\": 3,\"requestStr\": \"member_id=商户号&biz_content={\\\"out_order_no\\\":\\\"订单号\\\"}&timestamp=时间戳&sign_type=MD5&sign=签名\",\"encryptionStr\": \"biz_content={\\\"out_order_no\\\":\\\"订单号\\\"}&member_id=商户号&timestamp=时间戳&key=密钥\",\"autoSort\":\"off\",\"signType\": \"MD5\",\"stateKey\": \"code\",\"stateValue\": \"0\"}";
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("✅ JSON 格式正確");
    }
}
