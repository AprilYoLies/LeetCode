package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */
public class Qunar2020Q1 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 10000; i++) {
            if (i % 3 != 0 && i % 7 != 0 && i % 11 != 0) count++;
        }
        System.out.println(count);
    }
}
