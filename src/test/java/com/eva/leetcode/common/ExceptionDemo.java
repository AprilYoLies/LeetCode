package com.eva.leetcode.common;

import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            func1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void func1() {
        try {
            System.out.println("processing in func1");
            func2();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("RuntimeException in func1");
        }
    }

    public static void func2() {
        System.out.println("processing in func2");
        try {
            func3();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("RuntimeException in func3");
        }
    }

    public static void func3() throws IOException {
        System.out.println("processing in func3");
        throw new IOException("IOException in func3");
    }
}
