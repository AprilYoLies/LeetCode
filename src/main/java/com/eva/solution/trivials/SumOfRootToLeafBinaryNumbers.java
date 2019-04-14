package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-04-12
 * @Email g863821569@gmail.com
 * @Url https://leetcode-cn.com/contest/weekly-contest-131/problems/sum-of-root-to-leaf-binary-numbers/
 */

public class SumOfRootToLeafBinaryNumbers {
    // 最终结果对10 * 9 + 7进行取模
    private static int M = (int) (Math.pow(10, 9) + 7);

    public int sumRootToLeaf(TreeNode root) {
        List<String> strs = new LinkedList<>();
        track("", root, strs);
        long ans = 0;
        for (String str : strs) {
            try {
                ans += Long.valueOf(str, 2);
            } catch (Throwable t) {
                ans += Long.valueOf(str.substring(0, 32), 2);
            }
        }
        return (int) (ans % M);
    }

    /**
     * 跟踪全部根节点到叶子节点的路径，通过strs进行保存
     *
     * @param pre  目前已经走过的路径
     * @param node 当前节点
     * @param strs 所有路径保存在此链表中
     */
    public void track(String pre, TreeNode node, List<String> strs) {
        if (node.left == null && node.right == null) {
            strs.add(pre + node.val);
            return;
        }
        if (node.left != null)
            track(pre + node.val, node.left, strs);
        if (node.right != null)
            track(pre + node.val, node.right, strs);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
