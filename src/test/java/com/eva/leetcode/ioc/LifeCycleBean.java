package com.eva.leetcode.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.*;

import java.beans.PropertyDescriptor;

/**
 * @Author EvaJohnson
 * @Date 2019-08-04
 * @Email g863821569@gmail.com
 */
public class LifeCycleBean extends InstantiationAwareBeanPostProcessorAdapter implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean, BeanPostProcessor, BeanFactoryPostProcessor {

    private String name;

    private BeanFactory beanFactory;

    private String beanName;

    public LifeCycleBean() {
        System.out.println("[构造器]调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[注入属性]注入属性name");
        this.name = name;
    }

    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "name='" + name + '\'' +
                '}';
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[BeanFactoryAware接口]调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String name) {
        System.out.println("[BeanNameAware接口]调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean接口]调用InitializingBean.afterPropertiesSet()");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("[DiposibleBean接口]调用DiposibleBean.destory()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void initMethod() {
        System.out.println("[initMethod-method]调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void destroyMethod() {
        System.out.println("[destroy-method]调用<bean>的destroy-method属性指定的初始化方法");
    }

    // BeanPostProcessor
    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    // BeanPostProcessor
    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }

    // InstantiationAwareBeanPostProcessorAdapter
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        return null;
    }

    // InstantiationAwareBeanPostProcessorAdapter
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        return true;
    }

    // InstantiationAwareBeanPostProcessorAdapter
    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        return pvs;
    }

    // BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法");
    }
}
