package com.azhe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static StarService getProxy(StarService star) {

        return (StarService) Proxy.newProxyInstance(
                star.getClass().getClassLoader(),
                star.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        if (name.equals("dance")) {
                            System.out.println("收錢100萬");
                        } else if (name.equals("sing")) {
                            System.out.println("收錢20萬");
                        }
                        Object invoke = method.invoke(star, args);
                        return invoke;
                    }
                }
        );
    }


    /**
     * 計算方法執行時間
     * @param obj
     * @return
     * @param <T>
     */
    public static <T>T getProxy2(T obj) {

        return (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(), // 類的類載
                obj.getClass().getInterfaces(), // 類的介面
                new InvocationHandler() { // 實作介面
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        long start = System.currentTimeMillis();

                        Object invoke = method.invoke(obj, args);

                        long end = System.currentTimeMillis();

                        System.out.println(method.getName() + " 執行時間: " + (end - start) + "ms");
                        return invoke;
                    }
                }
        );
    }
}
