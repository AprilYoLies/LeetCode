package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2023-03-28 22:44:46
 * @Email g863821569@gmail.com
 */
public class Solution145 {

    @Test
    public void testTopKFrequent() {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode rl = new TreeNode(3);
        root.right = r;
        r.left = rl;
        List<Integer> ans = postorderTraversal(root);
        System.out.println(ans);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }

    public void postorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, ans);
        postorderTraversal(root.right, ans);
        ans.add(root.val);
    }
}
