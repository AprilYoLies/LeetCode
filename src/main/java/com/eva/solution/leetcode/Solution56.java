package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2023-04-05 00:31:35
 * @Email g863821569@gmail.com
 */
public class Solution56 {

    @Test
    public void testSolution() {
        int[][] intervals = new int[][]{{1, 3}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int pos = 0;
        int[] newInter = null;
        for (int i = 0; i < intervals.length; i++) {
            if (newInter == null) {
                newInter = intervals[i];
            } else {
                int[] inter = intervals[i];
                int dist = Math.max(newInter[1], inter[1]) - Math.min(newInter[0], inter[0]);
                int total = newInter[1] - newInter[0] + 1 + inter[1] - inter[0] + 1;
                if (dist + 1 < total) {
                    newInter = new int[]{Math.min(newInter[0], inter[0]), Math.max(newInter[1], inter[1])};
                } else {
                    intervals[pos++] = newInter;
                    newInter = inter;
                }
            }
            if (i == intervals.length - 1) {
                intervals[pos++] = newInter;
            }
        }
        return Arrays.copyOfRange(intervals, 0, pos);
    }

    public int[][] merge2(int[][] intervals) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] newInter : intervals) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] inter = queue.poll();
                int dist = Math.max(newInter[1], inter[1]) - Math.min(newInter[0], inter[0]);
                int total = newInter[1] - newInter[0] + 1 + inter[1] - inter[0] + 1;
                if (dist + 1 < total) {
                    newInter = new int[]{Math.min(newInter[0], inter[0]), Math.max(newInter[1], inter[1])};
                } else {
                    queue.offer(inter);
                }
            }
            queue.offer(newInter);
        }
        int[][] ans = new int[queue.size()][2];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public int[][] merge1(int[][] intervals) {
        boolean[] marks = new boolean[(int) Math.pow(10, 4)];
        for (int[] interval : intervals) {
            Arrays.fill(marks, interval[0], interval[1] + 1, true);
        }
        List<int[]> interval = new ArrayList<>();
        boolean flag = false;
        int from = 0;
        int to;
        for (int i = 0; i < marks.length; i++) {
            if (!flag && marks[i]) {
                from = i;
                flag = true;
            }
            if (flag && !marks[i]) {
                to = i - 1;
                interval.add(new int[]{from, to});
                flag = false;
            }
        }
        int[][] ans = new int[interval.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = interval.get(i);
        }
        return ans;
    }
}
