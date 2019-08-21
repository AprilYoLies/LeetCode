package com.eva.solution.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public static int findMinArrowShots(int[][] points) {
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
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
}
