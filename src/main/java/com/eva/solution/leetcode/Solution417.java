package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution417 {
    private int m, n;
    private int[][] matrix;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(new Solution417().pacificAtlantic1(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
        System.out.println(new Solution417().pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }

        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP);
            dfs(m - 1, i, canReachA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    ret.add(pos);
                }
            }
        }
        return ret;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                    || matrix[r][c] > matrix[nextR][nextC]) {

                continue;
            }
            dfs(nextR, nextC, canReach);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return results;
        boolean[][] dn = new boolean[matrix.length][matrix[0].length];
        boolean[][] xb = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            findDn(matrix, dn, matrix.length - 1, i);
            findXb(matrix, xb, 0, i);
        }
        for (int i = 0; i < matrix.length; i++) {
            findDn(matrix, dn, i, matrix[0].length - 1);
            findXb(matrix, xb, i, 0);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dn[i][j] && xb[i][j]) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    results.add(pos);
                }
            }
        }
        return results;
    }

    private void findDn(int[][] matrix, boolean[][] dn, int i, int j) {
        if (dn[i][j]) return;
        dn[i][j] = true;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (notInMap(matrix, ni, nj) || matrix[i][j] > matrix[ni][nj]) continue;
            findDn(matrix, dn, ni, nj);
        }
    }

    private boolean notInMap(int[][] matrix, int ni, int nj) {
        return ni < 0 || ni >= matrix.length || nj < 0 || nj >= matrix[0].length;
    }

    private void findXb(int[][] matrix, boolean[][] xb, int i, int j) {
        if (xb[i][j]) return;
        xb[i][j] = true;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (notInMap(matrix, ni, nj) || matrix[i][j] > matrix[ni][nj]) continue;
            findDn(matrix, xb, ni, nj);
        }
    }
}
