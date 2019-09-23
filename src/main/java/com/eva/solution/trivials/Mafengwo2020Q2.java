package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-23
 * @Email g863821569@gmail.com
 */

/**
 * 1,2,3,4,5,6,7,8,9
 * 1
 */
public class Mafengwo2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] eles = sc.nextLine().split(",");
        int t = Integer.parseInt(sc.nextLine());
        int[] vals = new int[eles.length];
        for (int i = 0; i < eles.length; i++) {
            vals[i] = Integer.parseInt(eles[i]);
        }
        int idx = -1;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == t) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println(-1);
            return;
        }
        int next = idx * 2 + 2;
        if (next >= vals.length) {
            System.out.println(-1);
            return;
        }
        idx = next;
        while (idx * 2 + 1 < vals.length) {
            idx = idx * 2 + 1;
        }
        System.out.println(vals[idx]);
    }
}
