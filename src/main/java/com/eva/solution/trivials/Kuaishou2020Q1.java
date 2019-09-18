package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-16
 * @Email g863821569@gmail.com
 */
public class Kuaishou2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int idx = line.indexOf(".");
        if (idx < 0) {
            idx = line.indexOf(":");
            if (idx < 0) {
                System.out.println("Neither");
            } else {
                String[] segs = line.split(":");
                if (segs.length != 8) {
                    System.out.println("Neither");
                    return;
                }
                for (int i = 0; i < segs.length; i++) {
                    if ("".equals(segs[i])) {
                        System.out.println("Neither");
                        return;
                    } else {
                        if (i == 0 && segs[i].charAt(0) == '0') {
                            System.out.println("Neither");
                            return;
                        }
                    }
                }
                System.out.println("IPv6");
            }
        } else {
            String[] segs = line.split("\\.");
            if (segs.length != 4) {
                System.out.println("Neither");
                return;
            }
            for (int i = 0; i < segs.length; i++) {
                if ("".equals(segs[i])) {
                    System.out.println("Neither");
                    return;
                } else {
                    if (segs[i].length() > 1 && segs[i].charAt(0) == '0') {
                        System.out.println("Neither");
                        return;
                    } else {
                        int n = Integer.parseInt(segs[i]);
                        if (n < 0 || n > 255) {
                            System.out.println("Neither");
                            return;
                        }
                    }
                }
            }
            System.out.println("IPv4");
        }
    }
}
