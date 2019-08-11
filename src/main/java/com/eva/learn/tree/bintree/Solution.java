package com.eva.learn.tree.bintree;

import com.eva.learn.tree.bintree.MyBSTree.BSTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final int arr[] = {3, 2, 1, 4, 5, 6,};

    public static void main(String[] args) {
        int i, ilen;
        MyBSTree<Integer> tree = new MyBSTree<Integer>();

        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for (i = 0; i < ilen; i++) {
            System.out.print(arr[i] + " ");
            tree.insert(arr[i]);
        }
        System.out.println();

        int height = height(tree.mRoot);

        int width = width(height);

        System.out.println("========逐层打印========");
        layerPrint(tree.mRoot);

        System.out.println("========格式化打印========");
        print(tree.mRoot, width, height);
    }

    private static int height(BSTreeNode<Integer> tree) {
        if (tree == null)
            return 0;

        int lheight = height(tree.left);
        int rheight = height(tree.right);
        return (lheight > rheight ? lheight : rheight) + 1;
    }

    private static int width(int loops) {
        if (--loops == 0) {
            return 1;
        }

        return width(loops) * 2 + 1;
    }

    private static void print(BSTreeNode<Integer> tree, int width, int height) {
        String[] strs = new String[width];

        for (int m = 0; m < strs.length; m++) {
            strs[m] = "\"\"";
        }

        List<BSTreeNode<Integer>> flist = new LinkedList<>();

        List<BSTreeNode<Integer>> slist = new LinkedList<>();

        List<Integer> fappends = new ArrayList<>();

        List<Integer> sappends = new ArrayList<>();

        flist.add(tree);
        fappends.add(0);
        fappends.add((width + 1) / 2);

        int pos = 0;
        int direction = 0;
        int fpos = 0;
        int level = height;
        BSTreeNode<Integer> current = null;
        String[] dest = new String[strs.length];
        while (!flist.isEmpty()) {
            System.arraycopy(strs, 0, dest, 0, strs.length);
            for (int i = 0; i < flist.size(); i++) {
                current = flist.get(i);
                direction = fappends.get(i);
                fpos = fappends.get(i * 2 + 1);
                pos = getPos(level, direction, fpos);
                dest[pos - 1] = "\"" + current.key + "\"";
                if (current.left != null) {
                    slist.add(current.left);
                    sappends.add(-1);
                    sappends.add(fpos);
                }
                if (current.right != null) {
                    slist.add(current.right);
                    sappends.add(1);
                    sappends.add(fpos);
                }
            }
            level--;
            System.out.println(Arrays.toString(dest));
            flist.clear();
            flist.addAll(slist);
            slist.clear();

            fappends.clear();
            fappends.addAll(sappends);
            sappends.clear();
        }
    }

    private static int getPos(int level, int direction, int fpos) {
        if (direction == 0)
            return fpos;
        else if (direction < 0)
            return fpos - (width(level) + 1) / 2;
        else
            return fpos + (width(level) + 1) / 2;
    }

    private static void layerPrint(BSTreeNode<Integer> tree) {
        if (tree == null)
            return;

        List<BSTreeNode<Integer>> flist = new LinkedList<>();

        List<BSTreeNode<Integer>> slist = new LinkedList<>();

        flist.add(tree);

        while (!flist.isEmpty()) {
            for (int i = 0; i < flist.size(); i++) {
                BSTreeNode<Integer> current = flist.get(i);
                System.out.print(current.key + " ");
                if (current.left != null)
                    slist.add(current.left);
                if (current.right != null)
                    slist.add(current.right);
            }

            flist.clear();
            flist.addAll(slist);
            slist.clear();
            System.out.println();
        }
    }
}
