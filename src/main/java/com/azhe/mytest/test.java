package com.azhe.mytest;

import com.azhe.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class test {

@Test
    public void tt(){


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

public void doSomething(User user){
    user.setAge(18);
}

public void doI(int i){
    i = 4;
}

public void doSB(StringBuffer sb){
    sb.append("123");
}
}
