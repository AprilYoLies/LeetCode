package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        StringBuilder sb = new StringBuilder();
        if (num > 3) {
            for (int i = list.size() - 1; i > 0; i--) {
                int mod = num / list.get(i);
                if (mod > 0) {
                    do {
                        sb.append(map.get(list.get(i)));
                    } while (--mod > 0);
                } else
                    continue;
                num = num % list.get(i);
            }
        }
        while (num-- > 0) {
            sb.append(map.get(1));
        }
        return sb.toString();
    }
}
