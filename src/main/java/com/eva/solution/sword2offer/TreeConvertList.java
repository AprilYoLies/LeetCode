package com.eva.solution.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-02
 * @Email g863821569@gmail.com
 */
public class TreeConvertList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        List<TreeNode> midOrder = new ArrayList<>();
        midOrder(pRootOfTree, midOrder);
        for (int i = 1; i < midOrder.size(); i++) {
            midOrder.get(i - 1).right = midOrder.get(i);
            midOrder.get(i).left = midOrder.get(i - 1);
        }
        return midOrder.get(0);
    }

    private void midOrder(TreeNode node, List<TreeNode> midOrder) {
        if (node == null) return;
        if (node.left != null) {
            midOrder(node.left, midOrder);
        }
        midOrder.add(node);
        if (node.right != null) {
            midOrder(node.right, midOrder);
        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
