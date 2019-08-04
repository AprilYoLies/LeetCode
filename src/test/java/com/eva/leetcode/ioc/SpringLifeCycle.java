package com.eva.leetcode.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author EvaJohnson
 * @Date 2019-08-04
 * @Email g863821569@gmail.com
 */
public class SpringLifeCycle {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        context.start();
        Object lifeCycleBean = context.getBean("lifeCycleBean");
        System.out.println(lifeCycleBean);
        context.registerShutdownHook();
    }
}
