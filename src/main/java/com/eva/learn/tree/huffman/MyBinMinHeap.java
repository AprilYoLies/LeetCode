package com.eva.learn.tree.huffman;

/**
 * 二叉堆(最大堆)
 *
 * @author skywang
 * @date 2014/03/07
 */

import java.util.ArrayList;
import java.util.List;

public class MyBinMinHeap<T extends Comparable<T>> {
	private List<MyHuffmanNode<T>> mHeap;

	public MyBinMinHeap() {
		mHeap = new ArrayList<>();
	}

	private void filterup() {
		int c = mHeap.size() - 1;
		int p = (c - 1) / 2;
		MyHuffmanNode<T> temp = mHeap.get(c);
		int cmp;
		while (c > 0) {
			MyHuffmanNode<T> pele = mHeap.get(p);
			cmp = temp.compareTo(pele.key);
			if (cmp < 0)
				mHeap.set(c, pele);
			else
				break;
			c = p;
			p = (c - 1) / 2;
		}
		mHeap.set(c, temp);
	}

	public void insert(MyHuffmanNode<T> ele) {
		mHeap.add(ele);
		filterup();
	}

	private void filterdown(int index) {
		int c = index;
		int s = c * 2 + 1;
		MyHuffmanNode<T> temp = mHeap.get(c);
		int cmp;
		while (s < mHeap.size()) {
			if (s < mHeap.size() - 1 && mHeap.get(s).compareTo(mHeap.get(s + 1).key) > 0) {
				s++;
			}
			MyHuffmanNode<T> sele = mHeap.get(s);
			cmp = temp.compareTo(sele.key);
			if (cmp > 0)
				mHeap.set(c, sele);
			else
				break;
			c = s;
			s = c * 2 + 1;
		}
		mHeap.set(c, temp);
	}

	public void remove(MyHuffmanNode<T> ele) {
		int index = mHeap.indexOf(ele);

		if (index != -1) {
			if (mHeap.size() == 1 || index == mHeap.size() - 1) {
				mHeap.remove(index);
				return;
			}
			mHeap.set(index, mHeap.remove(mHeap.size() - 1));
			filterdown(index);
		}
	}

	public MyHuffmanNode<T> dumpFromMinimum() {
		int size = mHeap.size();

		if (size == 0)
			return null;

		MyHuffmanNode<T> node = mHeap.get(0).clone();

		mHeap.set(0, mHeap.get(size - 1));

		mHeap.remove(size - 1);

		if ((size = mHeap.size()) != 0)
			filterdown(0);

		return node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mHeap.size(); i++)
			sb.append(mHeap.get(i) + " ");

		return sb.toString();
	}
}
