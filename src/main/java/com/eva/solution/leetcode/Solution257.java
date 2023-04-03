package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {
    public static List<String> binaryTreePaths1(TreeNode root) {
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
        binaryTreePaths1(root);
    }

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
        System.out.println(binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (root == null) return ans;
        binaryTreePaths(root, ans, sb);
        return ans;
    }

    public void binaryTreePaths(TreeNode root, List<String> ans, StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append("->");
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, ans, sb);
            sb.delete(sb.lastIndexOf("->"), sb.length());
        }
        if (root.right != null) {
            binaryTreePaths(root.right, ans, sb);
            sb.delete(sb.lastIndexOf("->"), sb.length());
        }
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
