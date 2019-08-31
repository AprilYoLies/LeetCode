package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-08-31
 * @Email g863821569@gmail.com
 */

// 3, 3.1, 4.3.5.4, 2.10.3, 2.4
public class Sina2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] versions = line.split(", ");
        System.out.println(getMinVersion(versions));
    }

    public static String getMinVersion(String[] list) {
        // 在这里编写代码
        String min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (!isSmallerThan(min, list[i])) {
                min = list[i];
            }
        }
        return min;
    }

    private static boolean isSmallerThan(String min, String target) {
        String[] mins = min.split("\\.");
        String[] targets = target.split("\\.");
        for (int i = 0; i < Math.min(mins.length, targets.length); i++) {
            if (Integer.parseInt(mins[i]) < Integer.parseInt(targets[i])) {
                return true;
            } else if (Integer.parseInt(mins[i]) > Integer.parseInt(targets[i])) {
                return false;
            }
        }
        return mins.length < targets.length;
    }
}
