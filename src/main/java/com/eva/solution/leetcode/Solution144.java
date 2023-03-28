package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-03-28 22:44:46
 * @Email g863821569@gmail.com
 */
public class Solution144 {

    @Test
    public void testTopKFrequent() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);
        root.right = r;
        r.left = rl;
        List<Integer> ans = preorderTraversal(root);
        System.out.println(ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    public void preorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }
}
