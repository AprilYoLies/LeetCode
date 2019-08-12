package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class Solution64 {
    // sum[m][n] = Math.min(sum[m - 1][n], sum[m][n - 1])
    public static int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(grid);
    }
}
