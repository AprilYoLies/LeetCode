package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {

    @Test
    public void testSolution() {
        int[][] ratings = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(findMinArrowShots(ratings));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int min = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= min) {
                min = Math.min(min, points[i][1]);
            } else {
                count++;
                min = points[i][1];
            }
        }
        return count;
    }

    public static int findMinArrowShots1(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int[] pre = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre[1]) {
                count++;
                pre = points[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots1(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
}
