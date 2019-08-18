package com.eva.learn.tree.bintree;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */
public class EasyBSTree {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = insertNode(null, 8);
        insertNode(tree, 5);
        insertNode(tree, 12);
        insertNode(tree, 3);
        insertNode(tree, 6);
        insertNode(tree, 9);
        insertNode(tree, 14);
        preOrder(tree);
    }

    private static void preOrder(TreeNode tree) {
        System.out.println(tree.val);
        if (tree.left != null)
            preOrder(tree.left);
        if (tree.right != null)
            preOrder(tree.right);
    }

    private static TreeNode insertNode(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left != null)
                    cur = cur.left;
                else {
                    cur.left = node;
                    return root;
                }
            } else if (val > cur.val) {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = node;
                    return root;
                }
            }
        }
    }
}
