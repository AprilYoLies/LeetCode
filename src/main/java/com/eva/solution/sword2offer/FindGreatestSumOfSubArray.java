package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-09
 * @Email g863821569@gmail.com
 */
public class FindGreatestSumOfSubArray {
    public static int findGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                long res = 0L;
                for (int k = i; k <= j; k++) {
                    res += array[k];
                }
                if (res > max)
                    max = (int) res;
            }
        }
        return max;
    }

    public static int findGreatestSumOfSubArrayDP(int[] array) {
        if (array.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
            if (res[i] > max)
                max = res[i];
            for (int j = i + 1; j < array.length; j++) {
                if (res[j - 1] < 0)
                    res[j] = array[j];
                else {
                    res[j] = res[j - 1] + array[j];
                }
                if (res[j] > max)
                    max = res[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6};
        int max = findGreatestSumOfSubArrayDP(arr);
        System.out.println(max);
    }
}
