package com.eva.solution.trivials;

import java.util.*;

// wrt wrf er ett rftt
public class Meituan2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = line.split(" ");
        Set<Character> characters = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (String word : words) {
            if (word.length() > max)
                max = word.length();
            if (sb.indexOf(String.valueOf(word.charAt(0))) == -1)
                sb.append(word.charAt(0));
            else {
                System.out.println("invalid");
                return;
            }
            for (int i = 0; i < word.length(); i++) {
                characters.add(word.charAt(i));
            }
        }
        List<String> orderStrs = new ArrayList<>();
        orderStrs.add(sb.toString());
        int len = characters.size();
        int cur = 1;
        while (true) {
            if (cur > max) break;
            String pre = "";
            String preWord = "";
            StringBuilder order = new StringBuilder();
            for (String word : words) {
                if (word.length() < cur) continue;
                if ("".equals(pre)) {
                    pre = word.substring(0, cur);
                    preWord = word;
                    if (preWord.length() > cur)
                        order.append(preWord.charAt(cur));
                } else {
                    if (pre.equals(word.substring(0, cur))) {
                        if (preWord.charAt(cur) == word.charAt(cur)) {
                            // empty
                        } else {
                            order.append(word.charAt(cur));
                        }
                    } else {
                        if (order.length() > 1)
                            orderStrs.add(order.toString());
                        order.delete(0, order.length());

                        pre = word.substring(0, cur);
                        preWord = word;
                        if (preWord.length() > cur)
                            order.append(preWord.charAt(cur));
                    }
                }
            }
            cur++;
        }
        StringBuilder orders = new StringBuilder(orderStrs.remove(0));
        int c = orderStrs.size();
        while (orders.length() != len && c-- >= 0) {
            int t = -1;
            for (int i = 0; i < orderStrs.size(); i++) {
                if (orderStrs.get(i).charAt(0) == orders.charAt(orders.length() - 1)) {
                    t = i;
                    break;
                }
            }
            if (t != -1) {
                String s = orderStrs.remove(t);
                String next = s.substring(1);
                for (int i = 0; i < next.length(); i++) {
                    if (orders.indexOf(String.valueOf(next.charAt(i))) != -1) {
                        System.out.println("invalid");
                        return;
                    }
                }
                orders.append(next);
            }
            t = -1;
            for (int i = 0; i < orderStrs.size(); i++) {
                if (orderStrs.get(i).charAt(orderStrs.get(i).length() - 1) == orders.charAt(0)) {
                    t = i;
                    break;
                }
            }
            if (t != -1) {
                String s = orderStrs.remove(t);
                String next = s.substring(0, s.length() - 1);
                for (int i = 0; i < next.length(); i++) {
                    if (orders.indexOf(String.valueOf(next.charAt(i))) != -1) {
                        System.out.println("invalid");
                        return;
                    }
                }
                next = next + orders.toString();
                orders.delete(0, orders.length());
                orders.append(next);
            }
        }
        System.out.println(orders.toString());
    }
}
