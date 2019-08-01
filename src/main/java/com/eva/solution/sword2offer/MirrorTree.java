package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class MirrorTree {
    public void mirrorTree(TreeNode root) {
        exchangeSon(root);
    }

    public void exchangeSon(TreeNode node) {
        if (node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                exchangeSon(node.left);
            }
            if (node.right != null) {
                exchangeSon(node.right);
            }
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        MirrorTree.TreeNode root1 = new MirrorTree.TreeNode(8);
        root1.left = new MirrorTree.TreeNode(8);
        root1.right = new MirrorTree.TreeNode(7);
        root1.left.left = new MirrorTree.TreeNode(9);
        root1.left.right = new MirrorTree.TreeNode(2);
        root1.left.right.left = new MirrorTree.TreeNode(4);
        root1.left.right.right = new MirrorTree.TreeNode(7);
        new MirrorTree().exchangeSon(root1);
        System.out.println(root1);
    }
}
