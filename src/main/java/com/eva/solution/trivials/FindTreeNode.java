package com.eva.solution.trivials;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class FindTreeNode {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        midOrder(root, res, k1, k2);
        return res;
    }

    private void midOrder(TreeNode node, List<Integer> res, int left, int right) {
        if (node.left != null && node.left.val >= left)
            midOrder(node.left, res, left, right);
        if (node.val >= left)
            res.add(node.val);
        if (node.right != null)
            midOrder(node.right, res, left, right);
    }

    public static void main(String[] args) {
        FindTreeNode findTreeNode = new FindTreeNode();
        TreeNode root = new TreeNode(20);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(40);
        TreeNode l2 = new TreeNode(35);
        root.left = l1;
        root.right = r1;
        r1.left = l2;
        findTreeNode.searchRange(root, 17, 37);
    }
}
