package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-15
 * @Email g863821569@gmail.com
 */

import java.util.Scanner;

/**
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * <p>
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 * <p>
 * 输入
 * 3 10
 * 1 2 4
 * <p>
 * 输出
 * 8
 */
public class NiuNiuBackpackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int space = Integer.parseInt(sc.nextLine().split(" ")[1]);
        String[] sVols = sc.nextLine().split(" ");
        int[] vols = new int[sVols.length];
        long total = 0;
        for (int i = 0; i < sVols.length; i++) {
            vols[i] = Integer.parseInt(sVols[i]);
            total += vols[i];
        }

        if (total <= space) {
            System.out.println((int) Math.pow(2, vols.length));
            return;
        }

        int methods = calPutMethodsRecursive(vols.length, space, vols);
        System.out.println(methods);

        System.out.println(calPutMethods(0, 0, vols, space) + 1);

        System.out.println(niuNiuBackpackRecursive(0, space, vols));
    }

    private static int niuNiuBackpackRecursive(int cur, int space, int[] vols) {
        if (space <= 0)
            return 0;
        if (cur == vols.length - 1) {
            if (vols[cur] <= space)
                return 2;
            else
                return 1;
        }
        return niuNiuBackpackRecursive(cur + 1, space, vols) + niuNiuBackpackRecursive(cur + 1, space - vols[cur], vols);
    }

    private static int calPutMethodsRecursive(int length, int space, int[] vols) {
        if (space <= 0)
            return 0;
        if (length == 1) {
            if (vols[length - 1] <= space) {
                return 2;
            } else {
                return 1;
            }
        }
        return calPutMethodsRecursive(length - 1, space, vols) +
                calPutMethodsRecursive(length - 1, space - vols[length - 1], vols);
    }

    private static int calPutMethods(long sum, int cur, int[] vols, int space) {
        int count = 0;
        if (sum > space || cur >= vols.length) {
            return 0;
        }
        count += calPutMethods(sum, cur + 1, vols, space);
        if (sum + vols[cur] <= space) {
            count++;
            count += calPutMethods(sum + vols[cur], cur + 1, vols, space);
        }
        return count;
    }

}
