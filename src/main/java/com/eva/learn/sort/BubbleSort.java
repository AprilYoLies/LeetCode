package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class BubbleSort {
    /*
     * 冒泡排序
     */
    public static void bubbleSort1(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                // 若不满足递增顺序，交换相邻数据
                if (a[j] > a[j + 1]) {
                    int t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                }
            }
        }
    }

    /*
     * 冒泡排序(改进版)
     */
    private static void bubbleSort2(int[] a) {
        int len = a.length; // 标记
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                // 若不满足递增顺序，交换相邻数据
                if (a[j] > a[j + 1]) {
                    int t = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = t;
                    flag = true;
                }
            }
            if (!flag) break;
            flag = false;
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        bubbleSort2(a);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
