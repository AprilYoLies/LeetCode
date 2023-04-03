package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author EvaJohnson
 * @Date 2023-04-03 21:18:20
 * @Email g863821569@gmail.com
 */
public class Solution106 {

    @Test
    public void testSolution() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        System.out.println(buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight, Map<Integer, Integer> map) {
        if (inLeft > inRight) return null;
        TreeNode node = new TreeNode(postorder[postRight]);
        Integer index = map.get(postorder[postRight]);
        int leftNum = index - inLeft;
        node.left = buildTree(inorder, postorder, inLeft, inLeft + leftNum - 1, postLeft, postLeft + leftNum - 1, map);
        node.right = buildTree(inorder, postorder, index + 1, inRight, postLeft + leftNum, postRight - 1, map);
        return node;
    }
}
