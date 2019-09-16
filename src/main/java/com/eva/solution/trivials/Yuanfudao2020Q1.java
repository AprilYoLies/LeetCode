package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-16
 * @Email g863821569@gmail.com
 */

/**
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class Yuanfudao2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mns = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mns[i][j] = sc.nextInt();
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int fx = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1},};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                assert cur != null;
                sb.append(mns[cur[0]][cur[1]]).append(" ");
                int c = 0;
                while (c < 4) {
                    if (fx > 3) fx = 0;
                    int[] dir = dirs[fx];
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if (ni >= 0 && ni < mns.length && nj >= 0 && nj < mns[0].length && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        queue.offer(new int[]{ni, nj});
                        break;
                    }
                    c++;
                    fx++;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
