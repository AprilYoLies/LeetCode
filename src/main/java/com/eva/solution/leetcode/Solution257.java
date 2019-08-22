package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) return results;
        findResults(results, root, new StringBuilder());
        return results;
    }

    private static void findResults(List<String> results, TreeNode cur, StringBuilder pre) {
        if (cur.left == null && cur.right == null) {
            if (pre.length() != 0) pre.append("->");
            pre.append(cur.val);
            results.add(pre.toString());
            int idx = pre.lastIndexOf("->");
            if (idx != -1) pre.delete(idx, pre.length());
            return;
        }
        if (pre.length() != 0) pre.append("->");
        pre.append(cur.val);
        if (cur.left != null) {
            findResults(results, cur.left, pre);
        }
        if (cur.right != null) {
            findResults(results, cur.right, pre);
        }
        int idx = pre.lastIndexOf("->");
        if (idx != -1) pre.delete(idx, pre.length());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        root.left = left;
        root.right = right;
        right.left = left1;
        right.right = right1;
        binaryTreePaths(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
