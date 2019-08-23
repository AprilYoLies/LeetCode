package com.eva.solution.leetcode;

public class Solution547 {
    private static int n;

    public static int findCircleNum1(int[][] M) {
        n = M.length;
        int circleNum = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private static void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }

    public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int friendsZone = 0;

        for (int i = 0; i < M.length; i++) {
            if (visited[i]) continue;
            friendsZone++;
            findFriends(M, i, visited);
        }
        return friendsZone;
    }

    private static void findFriends(int[][] m, int cur, boolean[] visited) {
        if (visited[cur]) return;
        visited[cur] = true;
        for (int i = 0; i < m.length; i++) {
            if (m[cur][i] == 1)
                findFriends(m, i, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum1(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}
        ));
        System.out.println(findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}
        ));
    }
}
