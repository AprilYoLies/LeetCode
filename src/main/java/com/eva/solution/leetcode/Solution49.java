package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2023-04-05 00:31:35
 * @Email g863821569@gmail.com
 */
public class Solution49 {

    @Test
    public void testSolution() {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.compute(Arrays.toString(chars), (s, eles) -> {
                if (eles == null) {
                    eles = new ArrayList<>();
                }
                eles.add(str);
                return eles;
            });
        }
        return new ArrayList<>(map.values());
    }
}
