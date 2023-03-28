package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author EvaJohnson
 * @Date 2023-03-27 22:36:07
 * @Email g863821569@gmail.com
 */
public class Solution239 {

    @Test
    public void testMaxSlidingWindow() {
        int[] height = new int[]{2, 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(height, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = k; i < nums.length; i++) {
            int toRemove = nums[i - k];
            if (toRemove == queue.peek()) {
                queue.poll();
            }
            int toAdd = nums[i];
            while (!queue.isEmpty() && queue.peekLast() < toAdd) {
                queue.pollLast();
            }
            queue.offerLast(toAdd);
            result[i - k + 1] = queue.peek();
        }
        return result;
    }
}
