package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-03-29 21:55:22
 * @Email g863821569@gmail.com
 */
public class Solution101 {

    @Test
    public void testTopKFrequent() {
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
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        boolean outer = compare(left.left, right.right);
        boolean inner = compare(left.right, right.left);
        return outer && inner;
    }
}
