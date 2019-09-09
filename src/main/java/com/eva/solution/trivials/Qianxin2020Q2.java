package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */

/**
 * 4
 * 9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
 * 37 20
 */
public class Qianxin2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        String[] nodes = sc.nextLine().split(" ");
        String[] ab = sc.nextLine().split(" ");
        List<String> aps = new LinkedList<>();
        List<String> bps = new LinkedList<>();
        int ia = 0, ib = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals(ab[0])) ia = i;
            if (nodes[i].equals(ab[1])) ib = i;
        }
        while (ia > 0) {
            int pia = (ia - 1) / 2;
            aps.add(nodes[pia]);
            if (pia == 0) break;
            ia = pia;
        }
        while (ib > 0) {
            int pib = (ib - 1) / 2;
            bps.add(nodes[pib]);
            if (pib == 0) break;
            ib = pib;
        }
        loop:
        for (String ap : aps) {
            for (String bp : bps) {
                if (ap.equals(bp)) {
                    System.out.println(ap);
                    break loop;
                }
            }
        }
    }
}
