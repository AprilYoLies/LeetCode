package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */
public class Solution583 {
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                boolean isEquals = word1.charAt(i) == word2.charAt(j);
                if (i == 0 || j == 0) {
                    if (isEquals)
                        dp[i][j] = 1;
                    else {
                        if (i == j)
                            continue;
                        if (i == 0)
                            dp[i][j] = dp[i][j - 1];
                        else
                            dp[i][j] = dp[i - 1][j];
                    }
                } else if (isEquals)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - dp[word1.length() - 1][word2.length() - 1] * 2;
    }

    public static int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("a", "ab"));
        System.out.println(minDistance1("sea", "eat"));
    }
}
