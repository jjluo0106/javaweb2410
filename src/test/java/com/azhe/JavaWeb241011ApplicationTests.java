package com.azhe;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
class JavaWeb241011ApplicationTests {

    @Test
    void contextLoads() {

        TreeMap<String, String> tm = new TreeMap<>();

        tm.put("1","11");
        tm.put("2","11");
        tm.put("3","11");
        tm.put("4","11");

        String sign = getSign(tm, tm, "6666");

        System.out.println(sign);
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
