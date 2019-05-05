package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class HeapSort {
    private static int[] heapSort(int[] a) {
        int[] maxHeap = arrToMaxHeap(a);
        return sortHeap(maxHeap);
    }

    private static int[] sortHeap(int[] maxHeap) {
        return new int[0];
    }

    private static int[] arrToMaxHeap(int[] a) {
        int len = a.length;
        int[] maxHeap = new int[len];
        for (int i = 0; i < len; i++) {

        }
        return new int[0];
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        a = heapSort(a);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
