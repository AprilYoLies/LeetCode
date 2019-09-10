package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-10
 * @Email g863821569@gmail.com
 */

// 00002:00140
public class Shunfeng2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] sf = line.split(":");
        int min = 0;
        for (int i = 0; i < sf[0].length(); i++) {
            char c = sf[0].charAt(i);
            int num = toNumber(c);
            if (num > min) min = num;
        }
        for (int i = 0; i < sf[1].length(); i++) {
            char c = sf[1].charAt(i);
            int num = toNumber(c);
            if (num > min) min = num;
        }
        if (min == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = min + 1; i < 36; i++) {
            int count = 0;
            for (int j = 0; j < sf[0].length(); j++) {
                count += toNumber(sf[0].charAt(sf[0].length() - 1 - j)) * Math.pow(i, j);
            }
            if (count > 23) break;
            count = 0;
            for (int j = 0; j < sf[1].length(); j++) {
                count += toNumber(sf[1].charAt(sf[1].length() - 1 - j)) * Math.pow(i, j);
            }
            if (count > 59) break;
            res.add(i);
        }
        StringBuilder sb = new StringBuilder();
        if (res.size() == 0) {
            System.out.println(-1);
            return;
        }
        for (Integer re : res) {
            sb.append(re).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

    private static int toNumber(char c) {
        if (isNumber(c))
            return c - '0';
        else
            return c - 'A' + 10;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
