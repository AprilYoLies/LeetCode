package com.eva.learn.graph.search;

/**
 * Java: 无回路有向图(Directed Acyclic Graph)的拓扑排序
 *       该DAG图是通过邻接表实现的。  
 *
 * @author skywang
 * @date 2014/04/22
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyTopoMatrixSort {
	// 邻接表中表对应的链表的顶点
	private class ENode {
		int ivex; // 该边所指向的顶点的位置
		ENode nextEdge; // 指向下一条弧的指针
	}

	// 邻接表中表的顶点
	private class VNode {
		char data; // 顶点信息
		ENode firstEdge; // 指向第一条依附该顶点的弧
	};

	private List<VNode> mVexs; // 顶点数组

	/*
	 * 创建图(用已提供的矩阵)
	 *
	 * 参数说明： vexs -- 顶点数组 edges -- 边数组
	 */
	public MyTopoMatrixSort(char[] vexs, char[][] edges) {

		// 初始化"顶点数"和"边数"
		int vlen = vexs.length;
		int elen = edges.length;

		// 初始化"顶点"
		mVexs = new ArrayList<VNode>();
		for (int i = 0; i < vlen; i++) {
			// 新建VNode
			VNode vnode = new VNode();
			vnode.data = vexs[i];
			vnode.firstEdge = null;
			// 将vnode添加到数组mVexs中
			mVexs.add(vnode);
		}

		// 初始化"边"
		for (int i = 0; i < elen; i++) {
			// 读取边的起始顶点和结束顶点
			// 读取边的起始顶点和结束顶点
			int p1 = getPosition(edges[i][0]);
			int p2 = getPosition(edges[i][1]);

			// 初始化node1
			ENode node1 = new ENode();
			node1.ivex = p2;
			// 将node1链接到"p1所在链表的末尾"
			if (mVexs.get(p1).firstEdge == null)
				mVexs.get(p1).firstEdge = node1;
			else
				linkLast(mVexs.get(p1).firstEdge, node1);
		}
	}

	/*
	 * 将node节点链接到list的最后
	 */
	private void linkLast(ENode list, ENode node) {
		ENode p = list;

		while (p.nextEdge != null)
			p = p.nextEdge;
		p.nextEdge = node;
	}

	/*
	 * 返回ch位置
	 */
	private int getPosition(char ch) {
		for (int i = 0; i < mVexs.size(); i++)
			if (mVexs.get(i).data == ch)
				return i;
		return -1;
	}

	/*
	 * 打印矩阵队列图
	 */
	public void print() {
		System.out.printf("== List Graph:\n");
		for (int i = 0; i < mVexs.size(); i++) {
			System.out.printf("%d(%c): ", i, mVexs.get(i).data);
			ENode node = mVexs.get(i).firstEdge;
			while (node != null) {
				System.out.printf("%d(%c) ", node.ivex, mVexs.get(node.ivex).data);
				node = node.nextEdge;
			}
			System.out.printf("\n");
		}
	}

	/*
	 * 拓扑排序
	 *
	 * 返回值： -1 -- 失败(由于内存不足等原因导致) 0 -- 成功排序，并输入结果 1 -- 失败(该有向图是有环的)
	 */
	public int topologicalSort() {
		int length = mVexs.size();
//		char[] result = new char[length];
		List<Character> result = new LinkedList<>();
		List<Integer> helper = new LinkedList<>();
		int[] ins = new int[length];

		for (int i = 0; i < length; i++) {
			ENode node = mVexs.get(i).firstEdge;
			while (node != null) {
				ins[node.ivex]++;
				node = node.nextEdge;
			}
		}

		for (int i = 0; i < length; i++) {
			if (ins[i] == 0)
				helper.add(i);
		}

		for (int i = 0; i < helper.size(); i++) {
			result.add(mVexs.get(helper.get(i)).data);
			ENode node = mVexs.get(helper.get(i)).firstEdge;
			while (node != null) {
				ins[node.ivex]--;
				if (ins[node.ivex] == 0) {
					helper.add(node.ivex);
				}
				node = node.nextEdge;
			}
		}

		if (result.size() != length) {
			System.out.println("非有向无环图...");
			return 1;
		}

		// 打印拓扑排序结果
		System.out.println(result.toString());
		return 0;
	}

	public static void main(String[] args) {
		char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[][] edges = new char[][] { { 'A', 'G' }, { 'B', 'A' }, { 'B', 'D' }, { 'C', 'F' }, { 'C', 'G' },
				{ 'D', 'E' }, { 'D', 'F' } };
		MyTopoMatrixSort pG;

		// 自定义"图"(输入矩阵队列)
		// pG = new ListDG();
		// 采用已有的"图"
		pG = new MyTopoMatrixSort(vexs, edges);

		pG.print(); // 打印图
		// pG.DFS(); // 深度优先遍历
		// pG.BFS(); // 广度优先遍历
		pG.topologicalSort(); // 拓扑排序
	}
}
