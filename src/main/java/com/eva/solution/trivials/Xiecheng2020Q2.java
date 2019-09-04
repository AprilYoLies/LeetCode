package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-04
 * @Email g863821569@gmail.com
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Xiecheng2020Q2 {


    /*请完成下面这个函数，实现题目要求的功能 ((ur)(ft)oi)
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '(') {
                count++;
                map.put(count, sb.length());
            } else if (c == ')') {
                Integer from = map.remove(count);
                if (--count < 0) return "";
                String str = sb.toString();
                sb.delete(0, sb.length());
                sb.append(str, 0, from).append(new StringBuilder(str.substring(from)).reverse());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
