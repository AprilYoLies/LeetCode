package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class Power {
    public static double power(double base, int exponent) {
        if (exponent < 0) {
            return 1.0 / power(base, -exponent);
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == 2) {
            return base * base;
        }
        double result = base * base;
        int count = 2;
        while (count < exponent) {
            count *= 2;
            if (count < exponent) {
                result *= result;
            }
        }
        return result * power(base, exponent - count / 2);
    }

    public static void main(String[] args) {
        System.out.println(power(2.0, -1));
    }
}
