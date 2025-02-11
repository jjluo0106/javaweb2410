package com.azhe;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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
        Star star = new Star("張三豐");

        StarService proxy = ProxyUtil.getProxy2(star);

        proxy.dance("太極拳");
        System.out.println(proxy.sing());
    }
}
