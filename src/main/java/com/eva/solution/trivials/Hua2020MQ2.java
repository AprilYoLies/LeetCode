package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-19
 * @Email g863821569@gmail.com
 */

/**
 * 4 5
 * 3 0
 * 0 4
 * 4
 * 1 0
 * 1 1
 * 1 2
 * 2 4
 */
public class Hua2020MQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int si = sc.nextInt();
        int sj = sc.nextInt();
        int ei = sc.nextInt();
        int ej = sc.nextInt();
        int[][] map = new int[m][n];
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ei, ej});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                assert pos != null;
                map[pos[0]][pos[1]] = 2;
                int li = pos[0], lj = pos[1] - 1, bi = pos[0] + 1, bj = pos[1];
                if (lj >= 0 && lj < n && map[li][lj] != 1) queue.offer(new int[]{li, lj});
                if (bi >= 0 && bi < m && map[bi][bj] != 1) queue.offer(new int[]{bi, bj});
            }
        }
        int bc = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) bc++;
            }
        }
        queue.offer(new int[]{si, sj});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                assert pos != null;
                map[pos[0]][pos[1]] = 3;
                int ri = pos[0], rj = pos[1] + 1, ui = pos[0] - 1, uj = pos[1];
                if (rj >= 0 && rj < n && map[ri][rj] != 1) queue.offer(new int[]{ri, rj});
                if (ui >= 0 && ui < m && map[ui][uj] != 1) queue.offer(new int[]{ui, uj});
            }
        }
        int ac = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1 && map[i][j] != 3) ac++;
            }
        }
        System.out.println(ac + " " + bc);
    }
}
