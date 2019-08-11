package com.eva.learn.tree.bintree;

public class MyBSTreeTest {
	private static final int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };

	public static void main(String[] args) {
		int i, ilen;
		MyBSTree<Integer> tree = new MyBSTree<Integer>();

		System.out.print("== 依次添加: ");
		ilen = arr.length;
		for (i = 0; i < ilen; i++) {
			System.out.print(arr[i] + " ");
			tree.insert(arr[i]);
		}

		System.out.print("\n== 前序遍历: ");
		tree.preOrder();

		System.out.println();

		System.out.println("== 最小值: " + tree.minimum().key);

		System.out.println("== 最大值: " + tree.maximum().key);

		System.out.println("== 树的详细信息: ");
		tree.print();

		int index = 7;
		System.out.print("\n== 删除节点: " + arr[index]);
		tree.remove(arr[index]);

		System.out.println("\n== 树的详细信息: ");
		tree.print();

		tree.clear();
	}
}
