package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */
public class Qunar2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mid = sc.nextLine();
        String after = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        appendChar(after, mid, sb);
        System.out.println(sb.toString());
    }

    private static void appendChar(String after, String mid, StringBuilder sb) {
        if (after.length() == 0) return;
        if (after.length() == 1) {
            sb.append(after);
            return;
        }
        char c = after.charAt(after.length() - 1);
        sb.append(c);
        int idx = mid.indexOf(c);
        String leftMid = mid.substring(0, idx);
        String rightMid = mid.substring(idx + 1);
        String leftAfter = after.substring(0, leftMid.length());
        String rightAfter = after.substring(leftMid.length(), after.length() - 1);
        appendChar(leftAfter, leftMid, sb);
        appendChar(rightAfter, rightMid, sb);
    }
}
