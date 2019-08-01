package com.eva.solution.sword2offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class HasSubtree {
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        List<TreeNode> list1 = new LinkedList<>();
        List<TreeNode> list2 = new LinkedList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        if (list1.size() > list2.size())
            return compare(list1, list2);
        else
            return compare(list2, list1);
    }

    private static void preOrder(TreeNode node, List<TreeNode> list) {
        list.add(node);
        if (node.left != null)
            preOrder(node.left, list);
        if (node.right != null)
            preOrder(node.right, list);
    }

    private static boolean compare(List<TreeNode> longer, List<TreeNode> shorter) {
        int l = longer.size();
        int s = shorter.size();
        next:
        for (int i = 0; i <= l - s; i++) {
            for (int j = 0; j < shorter.size(); j++) {
                if (shorter.get(j).val != longer.get(i + j).val)
                    continue next;
            }
            return true;
        }
        return false;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        boolean hasSubtree = hasSubtree(root1, root2);
        System.out.println(hasSubtree);
    }
}
