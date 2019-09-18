package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-09-18
 * @Email g863821569@gmail.com
 */
public class ChampionSort {
    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101, 103, 77, 49};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

//        mergeSortUp2Down(a, 0, a.length - 1);        // 归并排序(从上往下)
        championSort(a);                    // 归并排序(从下往上)

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }

    // 锦标赛排序的主要逻辑
    private static void championSort(int[] arr) {
        int len = tableSizeFor(arr.length);
        int treeLen = calTreeLen(len);
        TreeNode[] tree = new TreeNode[treeLen];
        createChampionTree(arr, len, treeLen, tree);
        championSort(arr, tree, len);
    }

    // 执行锦标赛排序
    private static void championSort(int[] arr, TreeNode[] tree, int len) {
        int i = 0;
        while (i < arr.length) {
            TreeNode root = tree[0];
            arr[i++] = root.val;
            adjustTree(tree, len);
        }
    }

    // 调整锦标赛树
    private static void adjustTree(TreeNode[] tree, int len) {
        int cur = tree[0].idx + tree.length - len;
        tree[cur] = new TreeNode(Integer.MAX_VALUE, cur);
        while (cur != 0) {
            TreeNode t;
            if (cur % 2 == 0) {
                if (tree[cur].val > tree[cur - 1].val)
                    t = tree[cur - 1];
                else
                    t = tree[cur];
            } else {
                if (tree[cur].val > tree[cur + 1].val)
                    t = tree[cur + 1];
                else
                    t = tree[cur];
            }
            cur = (cur - 1) / 2;
            tree[cur] = t;
        }
    }

    // 创建锦标赛树
    private static void createChampionTree(int[] arr, int len, int treeLen, TreeNode[] tree) {
        for (int i = 0; i < len; i++) {
            if (i < arr.length)
                tree[treeLen - len + i] = new TreeNode(arr[i], i);
            else
                tree[treeLen - len + i] = new TreeNode(Integer.MAX_VALUE, i);

        }
        int t = len;
        while (t != 0) {
            for (int i = t - 1; i < 2 * t - 1; i += 2) {
                int p = (i - 1) / 2;
                if (tree[i].val < tree[i + 1].val)
                    tree[p] = tree[i];
                else tree[p] = tree[i + 1];
            }
            t /= 2;
        }
    }

    // 通过数组存放树的节点，计算树应该的长度
    private static int calTreeLen(int len) {
        int sum = 0;
        int t = len;
        while (t != 0) {
            sum += t;
            t /= 2;
        }
        return sum;
    }

    // 求大于等于 cap 的最小的 2 的幂级数
    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    private static class TreeNode {
        int val;
        int idx;

        public TreeNode(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
