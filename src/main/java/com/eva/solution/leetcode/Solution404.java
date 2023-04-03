package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-03 21:18:20
 * @Email g863821569@gmail.com
 */
public class Solution404 {

    /**
     *               1
     *         2           3
     *     4      5     6    7
     *          8   9
     */
    @Test
    public void testSolution() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        TreeNode lrl = new TreeNode(8);
        TreeNode lrr = new TreeNode(9);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        lr.left = lrl;
        lr.right = lrr;
        System.out.println(sumOfLeftLeaves(root));
    }

    private int count;

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves1(root);
        return count;
    }

    public void sumOfLeftLeaves1(TreeNode node) {
        if (node == null) return;
        if (node.left != null && node.left.left == null && node.left.right == null) {
            count += node.left.val;
        }
        sumOfLeftLeaves1(node.left);
        sumOfLeftLeaves1(node.right);
    }
}
