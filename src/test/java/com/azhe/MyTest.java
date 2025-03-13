package com.azhe;

import cn.hutool.jwt.JWT;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MyTest {


    @Test
    public void test1() {
        Star star = new Star("張三豐");

        StarService proxy = ProxyUtil.getProxy(star);

        proxy.dance("太極拳");
        System.out.println(proxy.sing());
    }

    @Test
    public void test2() {
        StringBuffer buffer = new StringBuffer("abcd");

        buffer.replace(1, 2, "**");

        System.out.println(buffer);

    }
}
