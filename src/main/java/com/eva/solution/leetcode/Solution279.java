package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution279 {

    @Test
    public void testSolution() {
        System.out.println(numSquares(13));
    }

    public int numSquares(int n) {
        List<Integer> powNums = genPowNums(n);
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(n);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer t = queue.poll();
                if (powNums.contains(t)) {
                    return count;
                } else {
                    for (Integer powNum : powNums) {
                        int e = t - powNum;
                        if (e >= 1) {
                            queue.offer(e);
                        }
                    }
                }
            }
        }
        return count;
    }

    private List<Integer> genPowNums(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int t = i * i;
            if (t <= n) {
                list.add(t);
            } else {
                break;
            }
        }
        return list;
    }

    public static int numSquares1(int n) {
        int[] nums = new int[n + 3];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++) {
            int s = (int) Math.sqrt(i);
            if (i - s * s == 0)
                nums[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 2; j <= s; j++) {
                    int maybeMin = nums[i - j * j] + 1;
                    if (maybeMin < min) {
                        min = maybeMin;
                    }
                }
                nums[i] = min;
            }
        }
        return nums[n];
    }

    public int numSquaresSlow(int n) {
        int[] nums = new int[n + 3];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        for (int i = 4; i <= n; i++) {
            int s = (int) Math.sqrt(i);
            if (i - s * s == 0)
                nums[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < i / 2 + 1; j++) {
                    int maybeMin = nums[j] + nums[i - j];
                    if (maybeMin < min)
                        min = maybeMin;
                }
                nums[i] = min;
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares1(13));
    }
}
