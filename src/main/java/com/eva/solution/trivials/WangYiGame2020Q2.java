package com.eva.solution.trivials;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-21
 * @Email g863821569@gmail.com
 */

/**
 * 2
 * 1 5 7 2
 * 3 5 1 2
 * <p>
 * 2
 * 1 15 4 2
 * 12 19 3 2
 */
public class WangYiGame2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
            arr[i][3] = sc.nextInt();
        }
        loop:
        for (int[] ns : arr) {
            int c = 0;
            outer:
            while (ns[1] > ns[0]) {
                int p = ns[2], q = ns[3];
                if (ns[0] + p * q >= ns[1]) {
                    int l = 1, r = q;
                    while (l < r) {
                        int mid = (l + r) >>> 1;
                        if (ns[0] + p * mid >= ns[1]) r = mid - 1;
                        else if (ns[0] + p * mid == ns[1]) {
                            System.out.println(mid);
                            continue loop;
                        } else {
                            l = mid + 1;
                        }
                    }
                    for (int i = r; i < l + 1; i++) {
                        if (ns[0] + p * i >= ns[1]) {
                            c += i;
                            break outer;
                        }
                    }
                } else {
                    ns[2] *= ns[3];
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
