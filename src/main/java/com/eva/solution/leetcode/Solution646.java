package com.eva.solution.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author EvaJohnson
 * @Date 2019-08-15
 * @Email g863821569@gmail.com
 */

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 *
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution646 {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] pre = pairs[0];
        int len = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] <= pre[1] && pairs[i][1] < pre[1])
                pre = pairs[i];
            else {
                if (pairs[i][0] > pre[1]) {
                    len++;
                    pre = pairs[i];
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        findLongestChain(new int[][]{{1, 4}, {1, 2}, {1, 3}, {1, 5}, {2, 4}, {2, 3}, {2, 5}, {3, 3}, {3, 5}, {3, 6}});
    }
}
