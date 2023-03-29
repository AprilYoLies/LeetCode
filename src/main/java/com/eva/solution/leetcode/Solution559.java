package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2023-03-29 21:55:22
 * @Email g863821569@gmail.com
 */
public class Solution559 {

    /**
     *               1
     *         2           3
     *     4      5     6    7
     *          8   9
     */
    @Test
    public void testSolution() {
        Node root = new Node();
        System.out.println(maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int depth = maxDepth(root.children.get(i));
            max = Math.max(max, depth);
        }
        return max + 1;
    }
}
