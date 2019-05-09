package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
