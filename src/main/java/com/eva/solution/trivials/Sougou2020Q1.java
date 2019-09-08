package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */
public class Sougou2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> lines = new LinkedList<>();
        if (n == 0) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if ("".equals(line)) break;
                lines.add(line);
            }
            for (String line : lines) {
                System.out.println(line);
            }
            return;
        }
        List<String> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("".equals(line)) break;
            lines.add(line);
        }
        for (String line : lines) {
            String[] kv = line.split(" ");
            Integer oldValue = map.get(kv[0]);
            int newValue = Integer.parseInt(kv[1]);
            if (oldValue == null) {
                if (list.size() < n) {
                    map.put(kv[0], newValue);
                    list.add(kv[0]);
                } else {
                    String key = list.remove(0);
                    Integer val = map.remove(key);
                    System.out.println(key + " " + val);
                    map.put(kv[0], newValue);
                    list.add(kv[0]);
                }
            } else {
                if (oldValue < newValue) {
                    map.put(kv[0], newValue);
                    list.remove(kv[0]);
                    list.add(kv[0]);
                }
            }
        }
    }
}
