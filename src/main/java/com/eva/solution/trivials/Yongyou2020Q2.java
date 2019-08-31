package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-08-31
 * @Email g863821569@gmail.com
 */
// ABDEFCGH,DBFEAGCH
public class Yongyou2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] pa = line.split(",");
        StringBuilder sb = new StringBuilder();
        calAfterOrder(pa[0], pa[1], sb);
        sb.reverse();
        System.out.println(sb.toString());
    }

    private static void calAfterOrder(String pre, String after, StringBuilder sb) {
        char c = pre.charAt(0);
        sb.append(c);
        int idx = after.indexOf(c);
        String npre = after.substring(0, idx);
        String nafter = after.substring(idx + 1);
        if (nafter.length() > 0)
            calAfterOrder(pre.substring(1 + npre.length()), nafter, sb);
        if (npre.length() > 0)
            calAfterOrder(pre.substring(1, 1 + npre.length()), npre, sb);
    }
}
