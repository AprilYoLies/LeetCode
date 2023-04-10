package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-10 22:50:27
 * @Email g863821569@gmail.com
 */
public class Solution860 {

    @Test
    public void testSolution() {
        int[] ratings = new int[]{5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(ratings));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            if (bill == 10) {
                ten++;
                five--;
            }
            if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
            }
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}
