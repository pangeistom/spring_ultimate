package com.ctrip.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OneUser {
    @Value("用户名称")
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public OneUser() {
        System.out.println("开始就创建了");
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        boolean btsm=true;
        if(btsm) {
            System.out.println();
        }
    }
}
