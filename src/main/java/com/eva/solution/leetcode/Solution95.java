package com.eva.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-20
 * @Email g863821569@gmail.com
 */
public class Solution95 {
    public static void main(String[] args) {
        System.out.println(generateTrees(1).size());
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> trees = new ArrayList<>(r - l + 1);
        if (l > r) {
            trees.add(null);
            return trees;
        }
        if (l == r) {
            trees.add(new TreeNode(l));
            return trees;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lTrees = generateTrees(l, i - 1);
            List<TreeNode> rTrees = generateTrees(i + 1, r);
            for (TreeNode lTree : lTrees) {
                for (TreeNode rTree : rTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = lTree;
                    root.right = rTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
