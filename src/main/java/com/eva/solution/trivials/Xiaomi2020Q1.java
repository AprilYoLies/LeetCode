package com.eva.solution.trivials;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2019-09-06
 * @Email g863821569@gmail.com
 */
public class Xiaomi2020Q1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (isNumber(input.charAt(i))) stack.push(input.charAt(i));
            else if (input.charAt(i) == ',') {
                if (input.charAt(i - 1) == ')' || isNumber(input.charAt(i - 1))) {
                    sb.append(stack.pop()).append(stack.pop());
                } else {
                    sb.append(stack.pop());
                }
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
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
