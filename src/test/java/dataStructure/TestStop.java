package dataStructure;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class TestStop {


    public static void myStop(){

        Set<Object> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        set.forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }


    public static void main(String[] args) {
        myStop();
    }
}
