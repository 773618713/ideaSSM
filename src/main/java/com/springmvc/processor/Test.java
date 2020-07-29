package com.springmvc.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 中前置、后置处理器的使用案例
 *
 * 参考：
 * https://blog.csdn.net/weixin_40834464/article/details/82832173
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext_processor.xml");
        Animal a = (Animal) ac.getBean("dog");
        System.out.println(a.getClass().getName());
        a.eat();
    }
}
