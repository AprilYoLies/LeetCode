package com.eva.learn.tree.huffman;

/**
 * Huffman树
 *
 * @author skywang
 * @date 2014/03/27
 */

public class MyHuffman {
	MyBinMinHeap<Integer> heap;

	private MyHuffmanNode<Integer> mRoot; // 根结点

	public MyHuffman(int[] a) {
		// 建立数组a对应的最小堆
		heap = new MyBinMinHeap<Integer>();

		MyHuffmanNode<Integer> parent = null;
		for (int i = 0; i < a.length; i++) {
			heap.insert(new MyHuffmanNode<Integer>(a[i], null, null, null));
		}

		for (int i = 0; i < a.length - 1; i++) {
			MyHuffmanNode<Integer> left = heap.dumpFromMinimum(); // 最小节点是左孩子
			MyHuffmanNode<Integer> right = heap.dumpFromMinimum(); // 其次才是右孩子

			// 新建parent节点，左右孩子分别是left/right；
			// parent的大小是左右孩子之和
			parent = new MyHuffmanNode<Integer>(left.key + right.key, left, right, null);
			left.parent = parent;
			right.parent = parent;

			// 将parent节点数据拷贝到"最小堆"中
			heap.insert(parent);
		}

		mRoot = parent;
	}

	/*
	 * 前序遍历"Huffman树"
	 */
	private void preOrder(MyHuffmanNode<Integer> tree) {
		if (tree != null) {
			System.out.print(tree.key + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	public void preOrder() {
		preOrder(mRoot);
	}

	/*
	 * 中序遍历"Huffman树"
	 */
	private void inOrder(MyHuffmanNode<Integer> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.key + " ");
			inOrder(tree.right);
		}
	}

	public void inOrder() {
		inOrder(mRoot);
	}

	/*
	 * 后序遍历"Huffman树"
	 */
	private void postOrder(MyHuffmanNode<Integer> tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key + " ");
		}
	}

	public void postOrder() {
		postOrder(mRoot);
	}

	/*
	 * 打印"Huffman树"
	 *
	 * key -- 节点的键值 direction -- 0，表示该节点是根节点; -1，表示该节点是它的父结点的左孩子; 1，表示该节点是它的父结点的右孩子。
	 */
	private void print(MyHuffmanNode<Integer> tree, int key, int direction) {

		if (tree != null) {

			if (direction == 0) // tree是根节点
				System.out.printf("%2d is root\n", tree.key);
			else // tree是分支节点
				System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");

			print(tree.left, tree.key, -1);
			print(tree.right, tree.key, 1);
		}
	}

	public void print() {
		if (mRoot != null)
			print(mRoot, mRoot.key, 0);
	}
}
