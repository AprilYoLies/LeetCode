package com.eva.solution.trivials;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */
public class ByteDance2020Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        if (msg.charAt(0) == '0') return;
        Set<String> set = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        decodeMsg(msg, set, sb, 0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void decodeMsg(String msg, Set<String> set, StringBuilder sb, int cur) {
        if (cur >= msg.length()) {
            set.add(sb.toString());
            return;
        }
        char cChar = msg.charAt(cur);
        if (cChar > '2') {
            sb.append((char) (cChar - '1' + 'A'));
            decodeMsg(msg, set, sb, cur + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (cChar == '0') {
                decodeMsg(msg, set, sb, cur + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                char c = (char) (cChar + 'A' - '1');
                if (cur < msg.length() - 1 && msg.charAt(cur + 1) == '0') {
                    int num = Integer.parseInt(msg.substring(cur, cur + 2));
                    if (cur <= msg.length() - 2) {
                        if (num > 0 && num <= 26) {
                            c = (char) ('A' + num - 1);
                            sb.append(c);
                            decodeMsg(msg, set, sb, cur + 2);
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                } else {
                    sb.append(c);
                    decodeMsg(msg, set, sb, cur + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    if (cur <= msg.length() - 2) {
                        int num = Integer.parseInt(msg.substring(cur, cur + 2));
                        if (num > 0 && num <= 26) {
                            c = (char) ('A' + num - 1);
                            sb.append(c);
                            decodeMsg(msg, set, sb, cur + 2);
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                }
            }
        }
    }
}
