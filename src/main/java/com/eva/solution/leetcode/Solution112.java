package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-04-03 21:18:20
 * @Email g863821569@gmail.com
 */
public class Solution112 {

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
        System.out.println(hasPathSum(root, 16));
    }

    private boolean flag;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        hasPathSum(root, targetSum, 0);
        return flag;
    }

    public void hasPathSum(TreeNode root, int targetSum, int count) {
        if (flag || root == null) return;
        count += root.val;
        if (root.left == null && root.right == null) {
            if (count == targetSum) {
                flag = true;
                return;
            }
        }
        if (root.left != null) {
            hasPathSum(root.left, targetSum, count);
        }
        if (root.right != null) {
            hasPathSum(root.right, targetSum, count);
        }
    }
}
