package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class SelectSort {
    /*
     * 选择排序
     */
    private static void selectSort(int[] a) {
        int len = a.length;
        int min = Integer.MAX_VALUE;
        int pos = 0;
        for (int i = 0; i <len - 1; i++) {
            for (int j = i; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    pos = j;
                }
            }
            int t = a[pos];
            a[pos] = a[i];
            a[i] = t;
            min = Integer.MAX_VALUE;
            pos = i;
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        selectSort(a);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
