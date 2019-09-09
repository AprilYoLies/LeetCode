package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */
public class ByteDance2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        int target = Integer.parseInt(strs[strs.length - 1]);
        int max = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            int key = Integer.parseInt(strs[i]);
            if (key == target) {
                System.out.println(1);
                return;
            }
            max += key;
            map.put(key, 1);
        }
        boolean hasMore = true;
        while (hasMore) {
            hasMore = false;
            List<Integer> list = new ArrayList<>(map.keySet());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                for (int j = i; j < size; j++) {
                    Integer a = map.get(list.get(i));
                    Integer b = map.get(list.get(j));
                    Integer a1 = list.get(i);
                    Integer b1 = list.get(j);
                    int add = a1 + b1;
                    int sub = Math.abs(a1 - b1);
                    if (add <= max && map.get(add) == null) {
                        hasMore = true;
                        map.put(add, Math.max(a, b) + 1);
                        if (add == target) {
                            System.out.println(map.get(add));
                            return;
                        }
                    }
                    if (sub <= max && sub > 0 && map.get(sub) == null) {
                        hasMore = true;
                        map.put(sub, Math.max(a, b) + 1);
                        if (sub == target) {
                            System.out.println(map.get(sub));
                            return;
                        }
                    }
                }
            }
        }
    }
}
