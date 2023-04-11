package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-04-12 00:18:37
 * @Email g863821569@gmail.com
 */
public class Solution51 {

    @Test
    public void testSolution() {
        int n = 4;
        System.out.println(solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();
        boolean[] visited = new boolean[n];
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
        solveNQueens(n, 0, grid, ans, visited);
        return ans;
    }

    public void solveNQueens(int n, int row, char[][] grid, List<List<String>> ans, boolean[] visited) {
        if (row == n) {
            List<String> item = new ArrayList<>();
            for (char[] chars : grid) {
                item.add(new String(chars));
            }
            ans.add(item);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (!isValid(row, i, grid)) continue;
            visited[i] = true;
            grid[row][i] = 'Q';
            solveNQueens(n, row + 1, grid, ans, visited);
            visited[i] = false;
            grid[row][i] = '.';
        }
    }

    private boolean isValid(int row, int col, char[][] grid) {
        int x = row;
        int y = col;
        while (x >= 0 && y < grid.length) {
            if (grid[x--][y++] == 'Q') return false;
        }
        x = row;
        y = col;
        while (x >= 0 && y >= 0) {
            if (grid[x--][y--] == 'Q') return false;
        }
        return true;
    }
}
