package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */

public class PrintZTree {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        private TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        zigzagLevelOrder(res, nodes, true);
        return res;
    }

    private void zigzagLevelOrder(List<List<Integer>> res, List<TreeNode> nodes, boolean flag) {
        if (nodes.isEmpty())
            return;
        List<TreeNode> nNodes = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        if (flag) {
            for (int i = 0; i < nodes.size(); i++) {
                re.add(nodes.get(i).val);
            }
        } else {
            for (int i = nodes.size() - 1; i >= 0; i--) {
                re.add(nodes.get(i).val);
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null)
                nNodes.add(nodes.get(i).left);
            if (nodes.get(i).right != null)
                nNodes.add(nodes.get(i).right);
        }
        res.add(re);
        zigzagLevelOrder(res, nNodes, !flag);
    }

    public static void main(String[] args) {
        PrintZTree zTree = new PrintZTree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode left1 = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        TreeNode right1 = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = left1;
        right.right = right1;
        zTree.zigzagLevelOrder(root);
    }
}