package com.eva.solution.sword2offer;

import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-08-15
 * @Email g863821569@gmail.com
 */

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9ae56e5bdf4f480387df781671db5172
 * 来源：牛客网
 * <p>
 * 我们有两个字符串m和n，如果它们的子串a和b内容相同，则称a和b是m和n的公共子序列。子串中的字符不一定在原字符串中连续。
 * 例如字符串“abcfbc”和“abfcab”，其中“abc”同时出现在两个字符串中，因此“abc”是它们的公共子序列。此外，“ab”、“af”等都是它们的字串。
 * 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最长公共子序列的长度。
 */
public class LongestCommonSubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] ab = line.split(" ");
            int len = longestCommonSubStr(ab[0], ab[1]);
            System.out.println(len);
        }
    }

    private static int longestCommonSubStr(String s1, String s2) {
        int[][] res = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                boolean equals = s1.charAt(i - 1) == s2.charAt(j - 1);
                if (equals)
                    res[i][j] = res[i - 1][j - 1] + 1;
                else
                    res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
            }
        }
        return res[s1.length()][s2.length()];
    }
}
