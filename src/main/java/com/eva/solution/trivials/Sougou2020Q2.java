package com.eva.solution.trivials;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */

/**
 * 1 2
 * 3 0 1 2
 * 2 1 3
 */
public class Sougou2020Q2 {
    private static int last = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nl = sc.nextLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        int h;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String line = sc.nextLine();
            String[] s = line.split(" ");
            int[] son = new int[2];
            Arrays.fill(son, 0, 2, -1);
            if (s.length >= 3) son[0] = Integer.parseInt(s[2]);
            if (s.length == 4) son[1] = Integer.parseInt(s[3]);
            map.put(Integer.parseInt(s[1]), son);
        }
        h = calHeight(0, map);
        if (n == 2) System.out.println(h);
        else {
            if (map.get(last) == null || map.get(last)[0] == -1 || map.get(last)[1] == -1) System.out.println(h);
            else System.out.println(h + 1);
        }
    }

    private static int calHeight(int i, Map<Integer, int[]> map) {
        int[] son = map.get(i);
        if (son == null || son[0] == -1 && son[1] == -1) return 0;
        last = i;
        return Math.max(1 + calHeight(son[0], map), 1 + calHeight(son[1], map));
    }
}
