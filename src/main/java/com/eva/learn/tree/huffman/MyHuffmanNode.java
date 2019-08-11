package com.eva.learn.tree.huffman;

/**
 * Huffman节点类(Huffman.java的辅助类)
 *
 * @author skywang
 * @date 2014/03/27
 */

public class MyHuffmanNode<T extends Comparable<T>> implements Comparable<T>, Cloneable {
	protected T key; // 权值
	protected MyHuffmanNode<T> left; // 左孩子
	protected MyHuffmanNode<T> right; // 右孩子
	protected MyHuffmanNode<T> parent; // 父结点

	protected MyHuffmanNode(T key, MyHuffmanNode<T> left, MyHuffmanNode<T> right, MyHuffmanNode<T> parent) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	@SuppressWarnings("unchecked")
	@Override
	public MyHuffmanNode<T> clone() {
		MyHuffmanNode<T> obj = null;

		try {
			obj = (MyHuffmanNode<T>) super.clone();// Object 中的clone()识别出你要复制的是哪一个对象。
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}

		return obj;
	}

	@Override
	public int compareTo(T obj) {
		return key.compareTo(obj);
	}
}