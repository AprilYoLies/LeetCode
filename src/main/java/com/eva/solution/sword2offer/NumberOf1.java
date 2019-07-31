package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class NumberOf1 {
    public static int numberOf1(int n) {
        int a = 0x01;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int b = (n >> i) & a;
            if (b != 0) {
                count++;
            }
        }
        if (n < 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOf1(-0x0f);
        System.out.println(i);
    }
}
