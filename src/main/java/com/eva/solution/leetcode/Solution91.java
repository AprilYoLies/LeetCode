package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class Solution91 {
    public static int numDecodings(String s) {
        if (s == null || s.trim().equals(""))
            return 0;
        int[] methods = new int[s.length() + 1];
        methods[0] = 1;
        methods[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            methods[i] = methods[i - 1];
            int j = i - 1;
            if (Integer.parseInt(s.substring(j - 1, j + 1)) <= 26)
                methods[i] += methods[i - 2];
        }
        return methods[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }
}
