package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-14
 * @Email g863821569@gmail.com
 */

/**
 * 扔 n 个骰子，向上面的数字之和为 S。给定 n，请列出所有可能的 S 值及其相应的概率。
 */
public class ShaiZi {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        int min = n, max = 6 * n;
        List<Map.Entry<Integer, Double>> res = new ArrayList<>(max - min + 1);
        long[][] counts = new long[n + 1][max + 1];
        Arrays.fill(counts[1], 1, 7, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0)
                        counts[i][j] += counts[i - 1][j - k];
                }
            }
        }
        for (int i = min; i <= max; i++) {
            double p = Math.pow(1.0 / 6, n);
            AbstractMap.SimpleEntry<Integer, Double> entry = new AbstractMap.SimpleEntry<>(i, p * counts[n][i]);
            res.add(entry);
        }
        return res;
    }

    public static void main(String[] args) {
        dicesSum(1);
    }
}
