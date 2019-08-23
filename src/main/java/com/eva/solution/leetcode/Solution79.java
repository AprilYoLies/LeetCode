package com.eva.solution.leetcode;

public class Solution79 {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char c = board[i][j];
                    board[i][j] = 0;
                    if (dfs(board, word, 1, i, j)) return true;
                    board[i][j] = c;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int cur, int i, int j) {
        if (cur == word.length()) return true;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (!inMap(board, ni, nj) || board[ni][nj] != word.charAt(cur)) continue;
            char c = board[ni][nj];
            board[ni][nj] = 0;
            if (dfs(board, word, cur + 1, ni, nj)) return true;
            board[ni][nj] = c;
        }
        return false;
    }

    private static boolean inMap(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        }, "AAB"));
    }
}
