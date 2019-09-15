package com.eva.solution.trivials;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-15
 * @Email g863821569@gmail.com
 */

/**
 * 5
 * 9 15 27 35 50
 */
public class Langchao2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> odds = new LinkedList<>();
        List<Integer> evens = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            if (s % 2 == 0) evens.add(s);
            else odds.add(s);
        }
        Collections.sort(odds);
        Collections.sort(evens);
        if (odds.size() == 0 || evens.size() == 0) {
            if (odds.size() == 0) {
                System.out.println(1 + " " + 50);
            } else {
                System.out.println(2 + " " + 50);
            }
            return;
        }
        int max = 0, pos = 0;
        for (int i = 0; i < evens.size(); i++) {
            if (i == 0) {
                int t = (evens.get(i) - 2) / 2;
                if (t > max) {
                    max = t;
                    pos = 2;
                }
            } else {
                int t = (evens.get(i) - 2 - evens.get(i - 1)) / 2;
                if (t > max) {
                    max = t;
                    pos = evens.get(i - 1) + 2;
                }
            }
        }
        for (int i = 0; i < odds.size(); i++) {
            if (i == 0) {
                int t = (odds.get(i) - 1) / 2;
                if (t > max) {
                    max = t;
                    pos = 1;
                }
            } else {
                int t = (odds.get(i) - 2 - odds.get(i - 1)) / 2;
                if (t > max) {
                    max = t;
                    pos = odds.get(i - 1) + 2;
                }
            }
        }
        Integer evenLast = evens.get(evens.size() - 1);
        int len = (100 - evenLast) / 2;
        if (len > max) {
            max = len;
            pos = evenLast + 2;
        }
        Integer oddLast = odds.get(odds.size() - 1);
        len = (99 - oddLast) / 2;
        if (len > max) {
            max = len;
            pos = oddLast + 2;
        }
        System.out.println(pos + " " + max);
    }
}
