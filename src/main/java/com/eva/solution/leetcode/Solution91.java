package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution91 {
    public static int numDecodings(String s) {
        if (s == null || s.trim().equals("") || s.startsWith("0"))
            return 0;
        int[] methods = new int[s.length()];
        methods[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                if (methods[i - 1] == 0)
                    methods[i] = 1;
                else
                    methods[i] = methods[i - 1];
            }
            int ns = Integer.parseInt(s.substring(i - 1, i + 1));
            if (ns <= 26 && ns >= 10)
                if (i - 2 >= 0 && methods[i - 2] != 0)
                    methods[i] += methods[i - 2];
                else
                    methods[i] += 1;
            else if (s.charAt(i) == '0')
                return 0;
        }
        return methods[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
