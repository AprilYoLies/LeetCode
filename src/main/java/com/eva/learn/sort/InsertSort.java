package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class InsertSort {
    /*
     * 直接插入排序
     */
    private static void insertSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                // 将 a[j] 放到前面的一个合适的位置
                if (a[j] < a[j - 1]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        insertSort(a);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
