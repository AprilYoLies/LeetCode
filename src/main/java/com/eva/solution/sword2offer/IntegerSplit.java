package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-14
 * @Email g863821569@gmail.com
 */

import java.util.Scanner;

/**
 * 一个整数总可以拆分为2的幂的和，例如： 7=1+2+4 7=1+2+2+2 7=1+1+1+4 7=1+1+1+2+2 7=1+1+1+1+1+2 7=1+1+1+1+1+1+1 总共有六种不同
 * 的拆分方式。 再比如：4可以拆分成：4 = 4，4 = 1 + 1 + 1 + 1，4 = 2 + 2，4=1+1+2。 用f(n)表示n的不同拆分的种数，例如f(7)=6. 要求
 * 编写程序，读入n(不超过1000000)，输出f(n)%1000000000。
 */
public class IntegerSplit {
    // f(2n + 1) = f(2n)
    // f(2n) = f(2n - 1) + f(n)
    public static long integerSplit(int n) {
        long[] res = new long[n + 1];
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0)
                res[i] = (res[i - 1] + res[i / 2]) % 1000000000;
            else
                res[i] = res[i - 1] % 1000000000;
        }
        return res[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(integerSplit(Integer.parseInt(s)));
    }
}
