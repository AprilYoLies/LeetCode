package com.eva.solution.sword2offer;

import java.util.ArrayList;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        ArrayList<TreeNode> toPrint = new ArrayList<>();
        if (root == null)
            return nodes;
        toPrint.add(root);
        printTreeNode(toPrint, nodes);
        return nodes;
    }

    private void printTreeNode(ArrayList<TreeNode> toPrint, ArrayList<Integer> nodes) {
        ArrayList<TreeNode> toPrints = new ArrayList<>();
        for (TreeNode treeNode : toPrint) {
            nodes.add(treeNode.val);
            if (treeNode.left != null) {
                toPrints.add(treeNode.left);
            }
            if (treeNode.right != null) {
                toPrints.add(treeNode.right);
            }
        }
        if (toPrints.size() > 0) {
            printTreeNode(toPrints, nodes);
        }
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
