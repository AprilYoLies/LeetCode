package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class MergeSort {
    /**
     * 递归调用归并排序函数
     *
     * @param a 原数组
     * @param l 左边界
     * @param r 右边界
     * @return l 到 r 区间归并排序的结果，返回的是一个新数组
     */
    private static int[] mergeSort(int[] a, int l, int r) {
        int len = r - l + 1;
        // 终止条件
        if (len == 1) return new int[]{a[l]};
        if (len == 2) return a[l] > a[r] ? new int[]{a[r], a[l]} : new int[]{a[l], a[r]};
        // 否则递归调用归并函数
        int[] pre = mergeSort(a, l, l + len / 2 - 1);
        int[] post = mergeSort(a, l + len / 2, r);
        // 合并排序的结果
        return merge(pre, post);
    }

    // 两个排序数组的合并
    private static int[] merge(int[] pre, int[] post) {
        int prl = pre.length, pol = post.length;
        int poi = 0, pri = 0;
        int[] res = new int[prl + pol];
        for (int i = 0; i < prl + pol; i++) {
//            此处限制条件比较多
//            1. 保证 pre 数组的下标 pri 不会越界
//            2. post 数组的值已经全部进入 res 数组
//            3. pre 数组当前值小于 post 数组的当前值
            if (pri != prl && (poi == pol || pre[pri] < post[poi])) res[i] = pre[pri++];
            else res[i] = post[poi++];
        }
        return res;
    }

    private static int[] mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        int step = 2, t = 1;
        while (true) {
            int[] from, to;
            if (t % 2 == 1) {
                from = arr;
                to = temp;
            } else {
                from = temp;
                to = arr;
            }
            int c = 0;
            while (true) {
                int l = step * c;
                int r = step / 2 + step * c;
                int tl = step * c;
                for (int i = 0; i < step; i++) {
                    int min;
                    if (tl >= arr.length) break;
                    if (l < step / 2 + step * c) {
                        if (r < step + step * c && r < arr.length) {
                            if (from[l] < from[r]) min = from[l++];
                            else min = from[r++];
                        } else {
                            min = from[l++];
                        }
                    } else {
                        min = from[r++];
                    }
                    to[tl++] = min;
                }
                if (l >= arr.length || r >= arr.length) break;
                c++;
            }
            if (step >= arr.length) {
                return to;
            }
            step *= 2;
            t++;
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101, 103, 77, 49};
        int[] b = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101, 103, 77, 49};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

//        mergeSortUp2Down(a, 0, a.length - 1);        // 归并排序(从上往下)
        a = mergeSort(a, 0, a.length - 1);                    // 归并排序(从下往上)

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        b = mergeSort(b);                    // 归并排序(从下往上)

        System.out.print("after  sort:");
        for (i = 0; i < b.length; i++)
            System.out.printf("%d ", b[i]);
        System.out.print("\n");
    }
}
