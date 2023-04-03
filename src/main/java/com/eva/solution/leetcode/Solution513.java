package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author EvaJohnson
 * @Date 2023-04-03 21:18:20
 * @Email g863821569@gmail.com
 */
public class Solution513 {

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
        System.out.println(findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }
}
