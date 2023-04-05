package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author EvaJohnson
 * @Date 2023-04-05 17:27:19
 * @Email g863821569@gmail.com
 */
public class Solution1091 {

    @Test
    public void testSolution() {
        int[][] map = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(map));
    }

    private final int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    /**
     * {0, 0, 0}
     * {1, 1, 0}
     * {1, 1, 0}
     *
     * @param grid
     * @return 最短路径
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int dist = 0;
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                if (pos[0] == grid.length - 1 && pos[1] == grid[0].length - 1) {
                    return dist;
                }
                for (int[] direction : directions) {
                    int x = pos[0] + direction[0];
                    int y = pos[1] + direction[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
