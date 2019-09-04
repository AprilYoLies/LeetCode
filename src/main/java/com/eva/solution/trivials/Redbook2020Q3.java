package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-03
 * @Email g863821569@gmail.com
 */

/**
 * 1
 * E#S#.
 * .##..
 * #ES##
 * .#...
 * .....
 */
public class Redbook2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        char[][] maps = new char[n][line.length()];
        maps[0] = line.toCharArray();
        for (int i = 1; i < n; i++) {
            line = sc.nextLine();
            maps[i] = line.toCharArray();
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (maps[i][j] == 'S') {
                    queue.offer(new int[]{i, j});
                    maps[i][j] = 'T';
                }
            }
        }
        int distance = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean can = false;
        loop:
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                assert pos != null;
                for (int[] direction : directions) {
                    int r = pos[0] + direction[0];
                    int c = pos[1] + direction[1];
                    if (r == -1) r = maps.length - 1;
                    if (r == maps.length) r = 0;
                    if (c == -1) c = maps[0].length;
                    if (c == maps[0].length) c = 0;
                    if (maps[r][c] == 'E') {
                        can = true;
                        break loop;
                    } else {
                        if (maps[r][c] == 'T') continue;
                        if (maps[r][c] == '#') continue;
                        if (maps[r][c] == '.') {
                            maps[r][c] = 'T';
                            queue.offer(new int[]{r, c});
                        }
                    }
                }
            }
        }
        if (can) System.out.println(distance);
        else System.out.println(-1);
    }
}
