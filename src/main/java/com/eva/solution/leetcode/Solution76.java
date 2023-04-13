package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author EvaJohnson
 * @Date 2023-04-13 22:53:54
 * @Email g863821569@gmail.com
 */
public class Solution76 {

    @Test
    public void testSolution() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char aChar : t.toCharArray()) {
            tMap.compute(aChar, (cChar, nums) -> {
                if (nums == null) return 1;
                return nums + 1;
            });
        }
        int min = Integer.MAX_VALUE;
        int r = 0;
        int l = 0;
        int ansL = 0;
        int ansR = 0;
        while (r < s.length()) {
            char aChar = s.charAt(r++);
            if (!tMap.containsKey(aChar)) continue;
            sMap.compute(aChar, (cChar, nums) -> {
                if (nums == null) return 1;
                return nums + 1;
            });
            boolean findFit = false;
            while (isFit(tMap, sMap)) {
                findFit = true;
                sMap.compute(s.charAt(l++), (c, nums) -> {
                    if (nums == null) return 0;
                    return nums - 1;
                });
            }
            if (findFit) {
                int len = r - l + 1;
                if (len < min) {
                    min = len;
                    ansL = l - 1;
                    ansR = r;
                }
            }
        }
        return s.substring(ansL, ansR);
    }

    private boolean isFit(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> kv : tMap.entrySet()) {
            if (sMap.getOrDefault(kv.getKey(), 0) < kv.getValue()) return false;
        }
        return true;
    }
}
