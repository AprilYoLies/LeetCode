package com.eva.solution.trivials;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ByteDance1 {

    @Test
    public void testSolution() {
        int[][] times = new int[][]{{6, 12}, {1, 15}, {8, 30}, {20, 50}, {25, 32}};
//        int[][] times = new int[][]{{1, 3}, {2, 5}, {4, 6}, {7, 10}, {8, 11}, {9, 12}};
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
        int max = Integer.MIN_VALUE;
        List<int[]> ans = new ArrayList<>();
        ans.add(times[0]);
        for (int i = 1; i < times.length; i++) {
            int count = 1;
            int left = times[i][0];
            int right = times[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (left < times[j][1]) {
                    count++;
                    right = Math.min(times[j][1], right);
                }
            }
            if (count == max) {
                ans.add(new int[]{left, right});
            } else if (count > max) {
                ans.clear();
                max = count;
                int[] span = new int[2];
                span[0] = left;
                span[1] = right;
                ans.add(span);
            }
        }
        System.out.println(max);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }
}
