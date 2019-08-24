package com.eva.solution.trivials;

import java.util.Scanner;

public class JD2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }
        int pre = ns[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (ns[i] >= pre) {
                pre = ns[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
