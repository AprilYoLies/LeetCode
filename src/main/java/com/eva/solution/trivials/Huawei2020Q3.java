package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-07
 * @Email g863821569@gmail.com
 */
// [1234]=[12]+[34]*{50},[12]=[1]+[2]/{2};[1]=10,[2]=20,[34]=50;[1234]
public class Huawei2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(";");
        String[] eles = strs[1].split(",");
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String ele : eles) {
            String[] kv = ele.split("=");
            map.put(kv[0], Integer.parseInt(kv[1]));
        }
        String[] exps = strs[0].split(",");
        Queue<String> queue = new LinkedList<>();
        for (String exp : exps) {
            if (exp.startsWith(strs[2])) {
                for (int i = 0; i < exp.length(); i++) {
                    if (exp.charAt(i) != '{' && exp.charAt(i) != '}')
                        sb.append(exp.charAt(i));
                }
            } else {
                StringBuilder sb1 = new StringBuilder();
                String[] kv = exp.split("=");
                for (int i = 0; i < kv[1].length(); i++) {
                    if (kv[1].charAt(i) != '{' && kv[1].charAt(i) != '}')
                        sb1.append(kv[1].charAt(i));
                }
                Integer val = calValue(sb1.toString(), map);
                if (val == null) queue.offer(kv[1]);
                else map.put(kv[0], val);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String exp = queue.poll();
                Integer val = calValue(exp, map);
                if (val == null) queue.offer(exp);
                else map.put(exp, val);
            }
        }
        System.out.println(calValue(sb.toString().split("=")[1], map));
    }

    private static Integer calValue(String exp, Map<String, Integer> map) {
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '+') {
                return calValue(exp.substring(0, i), map) + calValue(exp.substring(i + 1), map);
            } else if (exp.charAt(i) == '-') {
                return calValue(exp.substring(0, i), map) + calValue(exp.substring(i + 1), map);
            } else if (exp.charAt(i) == '*') {
                return calValue(exp.substring(0, i), map) * calValue(exp.substring(i + 1), map);
            } else if (exp.charAt(i) == '/') {
                return calValue(exp.substring(0, i), map) / calValue(exp.substring(i + 1), map);
            }
        }
        try {
            return Integer.parseInt(exp);
        } catch (Exception e) {
            return map.get(exp);
        }
    }
}
