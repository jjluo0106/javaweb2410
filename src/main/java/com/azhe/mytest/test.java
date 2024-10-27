package com.azhe.mytest;

import com.azhe.pojo.Brand;
import com.azhe.pojo.User;
import com.azhe.util.Day;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class test {

    @Test
    public void tt() {


        User user = new User();

        int i = 1;

        doSomething(user);
        System.out.println(user);

        doI(i);

        System.out.println(i);

        StringBuffer sb = new StringBuffer();
        doSB(sb);


        System.out.println(sb);
    }

    public void doSomething(User user) {
        user.setAge(18);
    }

    public void doI(int i) {
        i = 4;
    }

    public void doSB(StringBuffer sb) {
        sb.append("123");
    }


    @Test
    public void testReflect() throws Exception {
        Brand brand = new Brand();

        Class<? extends Brand> clazz = brand.getClass();


        Constructor<? extends Brand> declaredConstructor = clazz.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);

        Brand brand1 = declaredConstructor.newInstance("abc");


        System.out.println(brand1);


    }

    @Test
    public void testProp() {

        // 創建 Properties 物件
        Properties properties = new Properties();

        // 使用 FileInputStream 來讀取 properties 文件
        try (FileInputStream input = new FileInputStream("src\\main\\java\\com\\azhe\\util\\myprop.properties")) {
            // 加載 .properties 文件
            properties.load(input);

            // 獲取指定鍵的值

            String name = properties.getProperty("className");
            String methodName = properties.getProperty("methodName");

            System.out.println(name);
            System.out.println(methodName);

            Class<?> clazz = Class.forName(name);

            Constructor cons = clazz.getDeclaredConstructor();
            Object myObj = cons.newInstance();

            Method method = clazz.getDeclaredMethod(methodName);



            method.invoke(myObj);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void testEnum(){
        Day myday = Day.FRIDAY;

        System.out.println(myday);
    }

}



