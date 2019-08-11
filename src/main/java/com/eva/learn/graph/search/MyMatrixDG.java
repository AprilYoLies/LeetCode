package com.eva.learn.graph.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Java: 邻接矩阵表示的"无向图(List Undirected Graph)"
 *
 * @author skywang
 * @date 2014/04/19
 */

/**
 * Java: 邻接矩阵表示的"无向图(Matrix Undirected Graph)"
 *
 * @author skywang
 * @date 2014/04/19
 */

public class MyMatrixDG {

	private char[] mVexs; // 顶点集合
	private int[][] mMatrix; // 邻接矩阵

	/*
	 * 创建图(用已提供的矩阵)
	 *
	 * 参数说明： vexs -- 顶点数组 edges -- 边数组
	 */
	public MyMatrixDG(char[] vexs, char[][] edges) {

		// 初始化"顶点数"和"边数"
		int vlen = vexs.length;
		int elen = edges.length;

		// 初始化"顶点"
		mVexs = new char[vlen];
		for (int i = 0; i < mVexs.length; i++)
			mVexs[i] = vexs[i];

		// 初始化"边"
		mMatrix = new int[vlen][vlen];
		for (int i = 0; i < elen; i++) {
			// 读取边的起始顶点和结束顶点
			int p1 = getPosition(edges[i][0]);
			int p2 = getPosition(edges[i][1]);

			mMatrix[p1][p2] = 1;
//			mMatrix[p2][p1] = 1;
		}
	}

	/*
	 * 返回ch位置
	 */
	private int getPosition(char ch) {
		for (int i = 0; i < mVexs.length; i++)
			if (mVexs[i] == ch)
				return i;
		return -1;
	}

	/*
	 * 深度优先搜索遍历图
	 */
	public void BFS() {
		boolean[] records = new boolean[mVexs.length];
		for (int i = 0; i < mVexs.length; i++)
			records[i] = false;
		System.out.print("BFS:");

		List<Integer> pre = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < mVexs.length; i++) {
			pre.add(i);
			while (pre.size() > index) {
				for (int j = index; j < pre.size(); j++) {
					if (!records[pre.get(j)]) {
						System.out.printf("%2c", mVexs[pre.get(j)]);
						records[pre.get(j)] = true;
						for (int m = 0; m < mMatrix[pre.get(j)].length; m++) {
							if (mMatrix[pre.get(j)][m] == 1) {
								pre.add(m);
							}
						}
					}
				}
				index++;
			}
		}

		System.out.println();
	}

	/*
	 * 广度优先搜索（类似于树的层次遍历）
	 */
	public void DFS() {
		boolean[] records = new boolean[mVexs.length];
		for (int i = 0; i < mVexs.length; i++)
			records[i] = false;
		System.out.print("DFS:");
		for (int i = 0; i < mVexs.length; i++) {
			if (!records[i])
				DFS(i, records);
		}
		System.out.println();
	}

	private void DFS(int i, boolean[] records) {
		if (!records[i]) {
			System.out.printf("%2c", mVexs[i]);
			records[i] = true;
			for (int j = 0; j < mMatrix[i].length; j++) {
				if (mMatrix[i][j] == 1)
					DFS(j, records);
			}
		}
	}

	/*
	 * 打印矩阵队列图
	 */
	public void print() {
		System.out.printf("Martix Graph:\n");
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++)
				System.out.printf("%d ", mMatrix[i][j]);
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[][] edges = new char[][] { { 'A', 'B' }, { 'B', 'C' }, { 'B', 'E' }, { 'B', 'F' }, { 'C', 'E' },
				{ 'D', 'C' }, { 'E', 'B' }, { 'E', 'D' }, { 'F', 'G' } };
		MyMatrixDG pG;

		// 自定义"图"(输入矩阵队列)
		// pG = new MatrixDG();
		// 采用已有的"图"
		pG = new MyMatrixDG(vexs, edges);

		pG.print(); // 打印图
		pG.DFS(); // 深度优先遍历
		pG.BFS(); // 广度优先遍历
	}
}
