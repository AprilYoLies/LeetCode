package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-04
 * @Email g863821569@gmail.com
 */

import java.util.Scanner;

public class Xiecheng2020Q3 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m, int[] array) {
        int[][] dp = new int[m][array.length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == 0) {
                    if (j == 0) dp[i][j] = array[j];
                    else dp[i][j] = dp[i][j - 1] + array[j];
                } else {
                    for (int k = 0; k < j; k++) {
                        int sum = 0;
                        for (int l = k + 1; l < j; l++) {
                            sum += array[l];
                        }
                        if (sum < dp[i - 1][k]) {
                            dp[i][j] = sum;
                            break;
                        }
                    }
                }
            }
        }
        return dp[m - 1][array.length - 1];
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m, array);
        System.out.println(String.valueOf(res));
    }
}
