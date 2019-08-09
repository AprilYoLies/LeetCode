package com.eva.solution.sword2offer;

import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-09
 * @Email g863821569@gmail.com
 */
public class MoreThanHalfNumSolution {
    public static int moreThanHalfNumSolution(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        Arrays.sort(array);
        int pre = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == pre) {
                count++;
                if (count > array.length / 2)
                    return pre;
            } else {
                count = 1;
            }
            pre = array[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        moreThanHalfNumSolution(array);
    }
}
