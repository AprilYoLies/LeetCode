package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-09-06
 * @Email g863821569@gmail.com
 */
public class BucketSort {
    private static void bucketSort(int[] a, int max) {
        int[] buckets = new int[max];
        for (int i = 0; i < a.length; i++) {
            buckets[a[i]]++;
        }
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i]-- > 0) {
                a[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 30, 20, 12, 101};

        System.out.print("before sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        bucketSort(a, 102);

        System.out.print("after  sort:");
        for (int i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
