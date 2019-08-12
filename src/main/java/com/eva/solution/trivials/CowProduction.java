package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class CowProduction {
    /**
     * 题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二
     * 年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
     *
     * @param year
     * @return
     */
    public static int cowNumOfYear(int year) {
        List<Integer> cows = new ArrayList<>();
        cows.add(0);
        for (int i = 1; i <= year; i++) {
            List<Integer> newCows = new ArrayList<>();
            for (int j = 0; j < cows.size(); j++) {
                if (cows.get(j) < 4)
                    cows.set(j, cows.get(j) + 1);
                else
                    newCows.add(0);
            }
            cows.addAll(newCows);
        }
        return cows.size();
    }

    public static void main(String[] args) {
        System.out.println(cowNumOfYear(10));
    }
}
