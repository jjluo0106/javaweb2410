package com.azhe;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star implements StarService{

    private String name;

    private final static String ending = "表演結束!";

    @Override
    public String dance(String name) {
        System.out.println(this.name + " 跳 " + name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ending;
    }

    @Override
    public String sing() {
        System.out.println(name + " 唱歌");

        return ending;
    }
}
