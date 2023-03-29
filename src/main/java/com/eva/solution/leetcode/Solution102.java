package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2023-03-29 21:55:22
 * @Email g863821569@gmail.com
 */
public class Solution102 {

    @Test
    public void testTopKFrequent() {
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
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }

    /**
     *               1
     *         2           3
     *     4      5     6    7
     *          8   9
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                item.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(item);
        }
        return ans;
    }
}
