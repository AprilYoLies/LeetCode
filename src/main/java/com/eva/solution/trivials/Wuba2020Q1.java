package com.eva.solution.trivials;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author EvaJohnson
 * @Date 2019-09-12
 * @Email g863821569@gmail.com
 */
public class Wuba2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        String[] strs = sc.nextLine().split(",");
        for (String str : strs) {
            set.add(str);
        }
        System.out.println(set.size());
    }
}
