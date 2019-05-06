package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class FastSort {
    /*
     * 快速排序
     */
    private static void quickSort(int[] a, int l, int r) {
        int ll = l;
        int rr = r;
        // 参考点
        int mid = a[l];
        // 将整个数组分成大于和小于 mid 的两个部分，其中 mid 可以任取 l 到 r 区间中的一个值
        while (l < r) {
            while (a[r] >= mid && r > l) r--;
            if (r > l) a[l] = a[r];
            while (a[l] <= mid && r > l) l++;
            if (r > l) a[r] = a[l];
        }
        a[l] = mid;
        // 终止条件判断
        if (ll < l - 1) quickSort(a,ll,l - 1);
        if (l + 1 < rr) quickSort(a,l + 1,rr);
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        quickSort(a, 0, a.length - 1);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
