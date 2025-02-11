package com.azhe.pojo;

import lombok.Data;

@Data // 自動生成getter setter
public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Integer dept_id;


    public User() {
    }

    public User(Integer id, String name, String password, Integer age, Integer dept_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.dept_id = dept_id;
    }

    public User(String name){this.name = name;}


    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return dept_id
     */
    public Integer getDept_id() {
        return dept_id;
    }

    /**
     * 设置
     * @param dept_id
     */
    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String toString() {
        return "\nUser{id = " + id + ", name = " + name + ", password = " + password + ", age = " + age + ", dept_id = " + dept_id + "}\n";
    }

    private void playGame(){
        System.out.println(name + "打游戏");
    }
}
