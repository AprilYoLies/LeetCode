package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */
public class Solution241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> aResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> bResults = diffWaysToCompute(input.substring(i + 1));
                for (Integer aResult : aResults) {
                    for (Integer bResult : bResults) {
                        if (c == '+')
                            results.add(aResult + bResult);
                        else if (c == '-')
                            results.add(aResult - bResult);
                        else
                            results.add(aResult * bResult);
                    }
                }
            }
        }
        if (results.size() == 0)
            results.add(Integer.parseInt(input));
        return results;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5").size());
    }
}
