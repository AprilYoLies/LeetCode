package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-11
 * @Email g863821569@gmail.com
 */

/**
 * A={1,3,5},B={2,4,6},R=1
 */
public class Hua2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String aStr = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
        String sub = line.substring(line.indexOf("}") + 1);
        String bStr = sub.substring(sub.indexOf("{") + 1, sub.indexOf("}"));
        int r = Integer.parseInt(line.substring(line.indexOf("R")).split("=")[1]);
        String[] as = aStr.split(",");
        String[] bs = bStr.split(",");
        int[] ans = new int[as.length];
        int[] bns = new int[bs.length];
        for (int i = 0; i < as.length; i++) {
            ans[i] = Integer.parseInt(as[i]);
        }
        for (int i = 0; i < bs.length; i++) {
            bns[i] = Integer.parseInt(bs[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            boolean has = false;
            for (int bn : bns) {
                if (an <= bn && bn - an <= r) {
                    has = true;
                    sb.append("(").append(an).append(",").append(bn).append(")");
                }
                if (bn - an > r) break;
            }
            if (!has) {
                for (int bn : bns) {
                    if (bn >= an) {
                        sb.append("(").append(an).append(",").append(bn).append(")");
                        break;
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
