package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-06
 * @Email g863821569@gmail.com
 */

/**
 * 1(2(3,4(,5)),6(7,))
 */
public class Xiaomi2020Q1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        getMidString(input, sb);
        return sb.toString();
    }

    private static void getMidString(String input, StringBuilder sb) {
        if (input.length() <= 0) return;
        int count = 0;
        String left = "";
        String right = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') count++;
            else if (c == ')') count--;
            else if (c == ',' && count == 1) {
                left = input.substring(2, i);
                right = input.substring(i + 1, input.length() - 1);
            }
        }
        getMidString(left, sb);
        if (isNumber(input.charAt(0)))
            sb.append(input.charAt(0));
        getMidString(right, sb);
    }

    private static boolean isNumber(char c) {
        int i = c - '0';
        return i >= 0 && i <= 9;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
