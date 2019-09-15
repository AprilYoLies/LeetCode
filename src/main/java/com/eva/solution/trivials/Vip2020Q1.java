package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-15
 * @Email g863821569@gmail.com
 */
public class Vip2020Q1 {
    private static int max = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        System.out.println(calMaxDistance(root));
    }

    /**
     * 入口方法
     *
     * @param root
     * @return
     */
    public static int calMaxDistance(TreeNode root) {
        doCalMaxDistance(root);
        return max;
    }

    /**
     * 进行真正的运算
     *
     * @param root
     */
    public static void doCalMaxDistance(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        int lh = calTreeHeight(root.left);
        int rh = calTreeHeight(root.right);
        int len = lh + rh + 2;
        if (len > max) max = len;
        doCalMaxDistance(root.left);
        doCalMaxDistance(root.right);
    }

    /**
     * 计算树高
     *
     * @param node
     * @return
     */
    private static int calTreeHeight(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return 0;
        return Math.max(calTreeHeight(node.left) + 1, calTreeHeight(node.right) + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
