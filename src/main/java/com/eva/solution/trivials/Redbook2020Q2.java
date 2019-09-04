package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-03
 * @Email g863821569@gmail.com
 */
public class Redbook2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (count == 0) {
                if (c != '(' && c != ')' && c != '<') sb.append(c);
                if (c == '<' && sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
                if (c == '(') count++;
            } else {
                if (c == '(') count++;
                if (c == ')') count--;
            }
        }
        System.out.println(sb.toString());
    }
}
