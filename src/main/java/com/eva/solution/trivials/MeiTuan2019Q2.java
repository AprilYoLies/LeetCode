package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * 给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1，现在问最大的可能答案
 * <p>
 * <p>
 * 输入描述:
 * 输入第一行两个整数N,K，表示字符串长度和机会次数
 * <p>
 * 第二行输入N个整数，表示该字符串的元素
 * <p>
 * ( 1 <= N <= 300000
 * , 0 <= K <= N )
 * <p>
 * 输出描述:
 * 输出一行表示答案
 * <p>
 * 输入例子1:
 * 10 2
 * 1 0 0 1 0 1 0 1 0 1
 * <p>
 * 输出例子1:
 * 5
 */
public class MeiTuan2019Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }
        if (k >= n) {
            System.out.println(n);
            return;
        }
        int from = -1, c = 0, to = 0, max = 0, pre = -1;
        for (int i = from + 1; i < n; i++) {
            if (ns[i] == 0) {
                c++;
                if (c == k + 1) {
                    to = i;
                    break;
                }
            }
        }
        if (to == pre) {
            max = n;
        } else {
            while (true) {
                int maybeMax = to - from - 1;
                if (maybeMax > max) max = maybeMax;
                for (int i = from + 1; i < n; i++) {
                    if (ns[i] == 0) {
                        from = i;
                        break;
                    }
                }
                pre = to;
                for (int i = to + 1; i < n; i++) {
                    if (ns[i] == 0) {
                        to = i;
                        break;
                    }
                }
                if (pre == to) {
                    maybeMax = n - from - 1;
                    if (maybeMax > max) max = maybeMax;
                    break;
                }

            }
        }
        System.out.println(max);
    }
}
