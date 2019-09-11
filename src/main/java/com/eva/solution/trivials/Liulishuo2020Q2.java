package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-11
 * @Email g863821569@gmail.com
 */
public class Liulishuo2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> lines = new LinkedList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("".equals(line.trim())) break;
            String[] nodes = line.split(" ");
            lines.add(nodes);
        }
        int[][] map = new int[lines.size()][lines.get(0).length];
        int mi = 0, mj = 0, si = 0, sj = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int n = Integer.parseInt(lines.get(i)[j]);
                if (n == 2) {
                    mi = i;
                    mj = j;
                } else if (n == 3) {
                    si = i;
                    sj = j;
                }
                map[i][j] = n;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{mi, mj});
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int len = 0;
        map[mi][mj] = 1;
        loop:
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curs = queue.poll();
                assert curs != null;
                map[curs[0]][curs[1]] = 1;
                for (int[] dir : dirs) {
                    int ni = curs[0] + dir[0];
                    int nj = curs[1] + dir[1];
                    if (ni < 0 || ni >= map.length || nj < 0 || nj >= map[0].length) continue;
                    if (map[ni][nj] == 3) break loop;
                    if (map[ni][nj] == 1) continue;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
        System.out.println(len);
    }
}
