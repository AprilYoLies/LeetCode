package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : -(a[0] - b[0])));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    }
}
