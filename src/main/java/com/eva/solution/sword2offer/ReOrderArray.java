package com.eva.solution.sword2offer;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class ReOrderArray {
    // 1 2 3 4 5 6 7 8 9
    // 1 2 3 4 5 6 7 8 9 10
    public static void reOrderArray(int[] array) {
        int len = array.length - 1;
        for (int i = len; i >= 0; i--) {
            if (isEven(array[i]))
                continue;
            int count = 1;
            while (--i >= 0 && isOdd(array[i])) {
                count++;
            }
            if (i < 0)
                return;
            int temp = array[i];
            for (int j = 0; j < count; j++) {
                array[i + j] = array[i + j + 1];
            }
            array[i + count] = temp;
            i = i + count;
        }
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 3, 5, 6, 7};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
