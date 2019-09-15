package com.eva.leetcode.common.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //调用自己的类加载器
        Class<?> clazz = new MyClassLoader("target").findClass("com.eva.clsloader.ClassLoaderAttachment");
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
