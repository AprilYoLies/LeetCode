package com.eva.solution.sword2offer;

import java.util.ArrayList;

/**
 * @Author EvaJohnson
 * @Date 2019-08-02
 * @Email g863821569@gmail.com
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;
        ArrayList<ArrayList<TreeNode>> toSearch = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        toSearch.add(list);
        search(results, toSearch, target);
        results.sort((o1, o2) -> -(o1.size() - o2.size()));
        return results;
    }

    private void search(ArrayList<ArrayList<Integer>> results, ArrayList<ArrayList<TreeNode>> toSearch, int target) {
        ArrayList<ArrayList<TreeNode>> reSearch = new ArrayList<>();
        for (ArrayList<TreeNode> ele : toSearch) {
            TreeNode treeNode = ele.get(ele.size() - 1);
            if (treeNode.left == null && treeNode.right == null) {
                int count = 0;
                ArrayList<Integer> result = new ArrayList<>(ele.size());
                for (TreeNode search : ele) {
                    result.add(search.val);
                    count += search.val;
                }
                if (target == count)
                    results.add(result);
            }
            if (treeNode.left != null) {
                ArrayList<TreeNode> list = new ArrayList<>(ele.size() + 1);
                list.addAll(ele);
                list.add(treeNode.left);
                reSearch.add(list);
            }
            if (treeNode.right != null) {
                ArrayList<TreeNode> list = new ArrayList<>(ele.size() + 1);
                list.addAll(ele);
                list.add(treeNode.right);
                reSearch.add(list);
            }
        }
        if (reSearch.size() > 0)
            search(results, reSearch, target);
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
        FindPath.TreeNode root1 = new FindPath.TreeNode(10);
        root1.left = new FindPath.TreeNode(5);
        root1.right = new FindPath.TreeNode(12);
        root1.left.left = new FindPath.TreeNode(4);
        root1.left.right = new FindPath.TreeNode(7);

        FindPath findPath = new FindPath();
        findPath.findPath(root1, 22);
    }
}
