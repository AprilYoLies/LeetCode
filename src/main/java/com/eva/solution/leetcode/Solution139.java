package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-16
 * @Email g863821569@gmail.com
 */

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if ("".equals(s))
            return wordDict.contains("");
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (String word : wordDict) {
                int head = i + 1 - word.length();
                if (head == 0 && word.equals(s.substring(0, word.length())))
                    dp[i] = true;
                else if (head > 0 && dp[head - 1] &&
                        s.substring(head).startsWith(word)) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        System.out.println(wordBreak(s, words));
    }
}
