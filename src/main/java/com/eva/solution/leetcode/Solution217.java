package com.eva.solution.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author EvaJohnson
 * @Date 2019-08-20
 * @Email g863821569@gmail.com
 */
public class Solution217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }

    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{0}));
    }
}
