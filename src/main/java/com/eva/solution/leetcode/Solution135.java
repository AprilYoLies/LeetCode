package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-10 22:48:00
 * @Email g863821569@gmail.com
 */
public class Solution135 {

    @Test
    public void testSolution() {
        int[] ratings = new int[]{2, 3, 1, 1, 4};
        System.out.println(candy(ratings));
    }

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int count = 0;
        for (int candy : candies) {
            count += candy;
        }
        return count;
    }
}
