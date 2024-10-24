package com.azhe;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class TestsApp {

    @Test
    void abc() {


        String s = "abc";
        StringBuilder sb = new StringBuilder();
        dealS(s, sb);


        System.out.println(s);
        System.out.println(sb);

    }

    public void dealS(String s, StringBuilder sb){
        s = "修改";
        sb.append("修改");
    }

    // 測試hutool的json對象
    @Test
    void testJSON(){
        String jsonStr = "{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 123,\n" +
                "        \"url\": \"https://example.com\"\n" +
                "    }\n" +
                "}";

        JSONObject json = JSONUtil.parseObj(jsonStr);

        JSONObject data = json.getJSONObject("data");

        data.set("obj","物件");

        System.out.println(data.get("obj"));

        Object url = data.get("url");

        System.out.println(url);

    }




    public static String getSign(TreeMap<String,String> queries, TreeMap<String,String> body, String secret){
        String text="";
        if (Objects.nonNull(queries)) {
            String param=queries.entrySet().stream().map(entry->entry.getKey()+"="+entry.getValue()) .collect(Collectors.joining("&"));
            System.out.println("queries param :\n" + param);
            text+=digest(param).toLowerCase();
        }else{
            text+= IntStream.range(0, 32).mapToObj(i->"0").collect(Collectors.joining(""));
        }
        if (Objects.nonNull(body)) {
            String param=writeObject(body);
            System.out.println("body param :" + param);
            text+=digest(param).toLowerCase();
        }else{
            text+=IntStream.range(0, 32).mapToObj(i->"0").collect(Collectors.joining(""));
        }
        text = secret + text + secret;
        return digest(text).toLowerCase();
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String writeObject(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to write object to string", e);
        }
    }

    public static String digest(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(text.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }


}
