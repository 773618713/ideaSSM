package com.springmvc.processor;


public class Dog implements Animal {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void eat(){
        System.out.println("正在吃饭...");
    }
}
