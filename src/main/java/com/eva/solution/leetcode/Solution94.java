package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-03-28 22:44:46
 * @Email g863821569@gmail.com
 */
public class Solution94 {

    @Test
    public void testTopKFrequent() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);
        root.right = r;
        r.left = rl;
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, ans);
        ans.add(root.val);
        inorderTraversal(root.right, ans);
    }
}
