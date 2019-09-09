package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-09
 * @Email g863821569@gmail.com
 */

/**
 * 3 1 5 21 10
 * 0 3 3 1 5
 * 3
 * <p>
 * 3 1 5 21 10
 * 0 3 3 1 5
 * 5
 */
public class Qianxin2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pidStrs = sc.nextLine().split(" ");
        int[] pids = new int[pidStrs.length];
        for (int i = 0; i < pidStrs.length; i++) {
            pids[i] = Integer.parseInt(pidStrs[i]);
        }
        String[] ppidStrs = sc.nextLine().split(" ");
        int[] ppids = new int[ppidStrs.length];
        for (int i = 0; i < ppidStrs.length; i++) {
            ppids[i] = Integer.parseInt(ppidStrs[i]);
        }
        int n = Integer.parseInt(sc.nextLine());
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                count++;
                Integer ppid = queue.poll();
                for (int j = 0; j < ppids.length; j++) {
                    if (ppids[j] == ppid) {
                        queue.offer(pids[j]);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
