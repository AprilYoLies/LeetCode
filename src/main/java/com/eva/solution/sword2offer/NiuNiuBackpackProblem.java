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
    private static int count = 0;

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
//        int methods = calPutMethods(space, vols);
//        System.out.println(methods);
        dfs(0, 0, vols.length, vols, space);
        System.out.println(count + 1);
    }

    // method[i][s] = method[i - 1][s] + method[i - 1][s - v[i]]
    private static int calPutMethods(int space, int[] vols) {
        int[][] methods = new int[vols.length + 1][space + 1];
        for (int i = 1; i < space + 1; i++) {
            methods[1][i] = 1;
        }
        for (int i = 1; i < vols.length + 1; i++) {
            methods[i][1] = vols[i - 1] <= 1 ? 1 : 0;
        }
        for (int i = 2; i < vols.length + 1; i++) {
            for (int j = 2; j < space + 1; j++) {
                if (j - vols[i - 1] >= 1)
                    methods[i][j] = methods[i - 1][j] + methods[i - 1][j - vols[i - 1]];
                else
                    methods[i][j] = methods[i - 1][j];
            }
        }
        return methods[vols.length][space];
    }

    private static void dfs(long sum, int cur, int n, int[] nums, int total) {
        if (cur < n) {
            if (sum > total) {
                return;
            }
            // 不添加这件零食
            dfs(sum, cur + 1, n, nums, total);
            // 当前这种添加方式合理,添加这件零食
            if (sum + nums[cur] <= total) {
                count++;
                dfs(sum + nums[cur], cur + 1, n, nums, total);
            }
        }
    }

}
