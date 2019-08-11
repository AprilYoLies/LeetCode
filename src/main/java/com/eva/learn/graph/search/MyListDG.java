package com.eva.learn.graph.search;

public class MyListDG {
	private VNode[] mVexs;

	public MyListDG(char[] vexs, char[][] edges) {
		mVexs = new VNode[vexs.length];
		for (int i = 0; i < vexs.length; i++) {
			VNode node = new VNode();
			node.data = vexs[i];
			node.firstEdge = null;
			mVexs[i] = node;
		}

		for (int i = 0; i < edges.length; i++) {
			char c1 = edges[i][0];
			char c2 = edges[i][1];

			int p1 = getPos(c1);
			int p2 = getPos(c2);

			create(p1, p2);
//			create(p2, p1);
		}
	}

	private void create(int from, int to) {
		ENode enode = new ENode();
		enode.ivex = to;
		enode.nextEdge = null;

		if (mVexs[from].firstEdge == null)
			mVexs[from].firstEdge = enode;
		else {
			linkLast(mVexs[from].firstEdge, enode);
		}
	}

	private void linkLast(ENode node, ENode target) {
		ENode helper = node;
		while (helper.nextEdge != null)
			helper = helper.nextEdge;
		helper.nextEdge = target;
	}

	private int getPos(char c) {
		for (int i = 0; i < mVexs.length; i++) {
			if (mVexs[i].data == c)
				return i;
		}
		return -1;
	}

	private class VNode {
		char data;
		ENode firstEdge;
	}

	private class ENode {
		int ivex;
		ENode nextEdge;
	}

	private void DFS() {
		boolean[] records = new boolean[mVexs.length];
		for (int i = 0; i < mVexs.length; i++)
			records[i] = false;

		System.out.print("DFS:");
		for (int i = 0; i < mVexs.length; i++) {
			if (!records[i]) {
				DFS(i, records);
			}
		}

		System.out.println();
	}

	private void DFS(int i, boolean[] records) {
		System.out.printf("%2c", mVexs[i].data);
		records[i] = true;
		ENode node = mVexs[i].firstEdge;
		while (node != null) {
			if (!records[node.ivex])
				DFS(node.ivex, records);
			node = node.nextEdge;
		}
	}

	private void BFS() {
		boolean[] records = new boolean[mVexs.length];
		for (int i = 0; i < mVexs.length; i++)
			records[i] = false;

		System.out.print("BFS:");
		ENode node = null;
		int[] queue = new int[mVexs.length];
		int head = 0, rear = 0;
		for (int i = 0; i < mVexs.length; i++) {
			if (!records[i]) {
				records[i] = true;
				System.out.printf("%2c", mVexs[i].data);
				queue[rear++] = i;
				while (head < rear) {
					int j = queue[head++];
					node = mVexs[j].firstEdge;
					while (node != null) {
						int k = node.ivex;
						if (!records[k]) {
							records[k] = true;
							System.out.printf("%2c", mVexs[k].data);
							queue[rear++] = k;
						}
						node = node.nextEdge;
					}
				}
			}
		}
		System.out.println();
	}

	public void print() {
		System.out.printf("List Graph:\n");
		for (int i = 0; i < mVexs.length; i++) {
			System.out.printf("%d(%c): ", i, mVexs[i].data);
			ENode node = mVexs[i].firstEdge;
			while (node != null) {
				System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
				node = node.nextEdge;
			}
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[][] edges = new char[][] { { 'A', 'B' }, { 'B', 'C' }, { 'B', 'E' }, { 'B', 'F' }, { 'C', 'E' },
				{ 'D', 'C' }, { 'E', 'B' }, { 'E', 'D' }, { 'F', 'G' } };
		MyListDG pG;

		// 自定义"图"(输入矩阵队列)
		// pG = new ListDG();
		// 采用已有的"图"
		pG = new MyListDG(vexs, edges);

		pG.print(); // 打印图
		pG.DFS(); // 深度优先遍历
		pG.BFS(); // 广度优先遍历
	}

}
