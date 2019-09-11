package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2019-09-11
 * @Email g863821569@gmail.com
 */

/**
 * I am an 20-years  out--standing @ * -stu- dent
 */
public class Hua2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> before = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (isCharNum(c)) sb.append(c);
            else if (c == '-') {
                if ((i - 1 >= 0 && isCharNum(line.charAt(i - 1))) && (i + 1 < line.length() && isCharNum(line.charAt(i + 1))))
                    sb.append('-');
                else {
                    sb.append(" ");
                }
            } else {
                sb.append(" ");
            }
        }
        String[] strs = sb.toString().split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (!"".equals(str) && !" ".equals(str)) {
                stack.push(str);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb1.append(stack.pop()).append(" ");
        }
        sb1.deleteCharAt(sb1.length() - 1);
        System.out.println(sb1.toString());
    }

    private static boolean isCharNum(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
