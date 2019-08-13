package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution62 {
    // sum[m][n] = sum[m - 1][n] + sum[m][n -1]
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
    }
}
