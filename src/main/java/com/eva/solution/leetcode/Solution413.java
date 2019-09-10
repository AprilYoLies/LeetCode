package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-09-10
 * @Email g863821569@gmail.com
 */
public class Solution413 {
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0) return 0;
        int[] count = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            count[i] = count[i - 1] + calArrayNums(A, i);
        }
        return count[A.length - 1];
    }

    private static int calArrayNums(int[] a, int r) {
        int count = 0, t = a[r];
        int diff = t - a[r - 1], pre = a[r - 1];
        int j = r - 2;
        while (j >= 0) {
            if (pre - a[j] == diff) {
                count++;
                pre = a[j];
            } else break;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
