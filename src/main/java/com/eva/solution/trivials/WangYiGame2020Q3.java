package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-21
 * @Email g863821569@gmail.com
 */

/**
 * 2
 * 5
 * 1 3 9 2 6
 * 5
 * 4 2 9 16 7
 */
public class WangYiGame2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                list1.add(sc.nextInt());
            }
            list.add(list1);
        }
        for (List<Integer> lst : list) {
            int[] arr = new int[lst.size()];
            arr[0] = lst.get(0);
            int pre = 0, len = 1;
            for (int i = 1; i < lst.size(); i++) {
                if (lst.get(i) >= arr[pre]) {
                    len++;
                    arr[i] = arr[pre] + lst.get(i);
                    pre = i;
                }
            }
            System.out.println(len);
        }
    }
}
