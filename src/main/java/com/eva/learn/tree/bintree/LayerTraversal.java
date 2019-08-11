package com.eva.learn.tree.bintree;

import java.util.*;

class BinTree {
	// 表示二叉树的字符串数组
	private String[] str;
	// 表示二叉树的List集合
	private List<Node> list;

	// 构造函数
	// 传入字符串数组
	BinTree(String[] str) {
		this.str = str;
	}

	// 二叉树节点内部类
	class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;

			this.left = null;
			this.right = null;
		}
	}

	// 创建二叉树
	public void createBinTree() {
		list = new LinkedList<Node>();

		// 遍历字符串数组，将字符串转成相应的节点
		for (String s : str) {
			// 如果s是#，那么对应null
			if ("#".equals(s)) {
				list.add(null);
			}
			// 否则对应有值的节点
			else {
				list.add(new Node(Integer.parseInt(s)));
			}
		}

		// 构建二叉树父子节点直接的关系
		for (int index = 0; index < str.length / 2 - 1; index++) {
			// 如果节点不是null的，需要加上其左右儿子节点
			if (list.get(index) != null) {
				list.get(index).left = list.get(index * 2 + 1);
				list.get(index).right = list.get(index * 2 + 2);
			}
		}

		// 单独处理最后一个节点
		int lastIndex = str.length / 2 - 1;
		// 添加左儿子
		list.get(lastIndex).left = list.get(lastIndex * 2 + 1);

		// 如果数组长度是奇数，说明有右儿子
		if (str.length % 2 != 0) {
			list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
		}
	}

	// 获取二叉树根
	public Node getRoot() {
		if (list != null) {
			return list.get(0);
		}

		System.out.println("请先创建二叉树");
		return null;
	}

	// 获取二叉树的深度，即最大深度
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}

		// 将深度初始化为1
		int depth = 1;

		// 求左儿子的最大深度
		int leftMaxDepth = maxDepth(root.left);
		// 求右儿子的最大深度
		int rightMaxDepth = maxDepth(root.right);

		return Math.max(leftMaxDepth, rightMaxDepth) + depth;
	}

	// 获取二叉树的最小深度
	public int minDepth(Node root) {
		if (root == null) {
			return 0;
		}

		// 深度初始化为1
		int depth = 1;

		// 求左儿子的最小深度
		int leftMinDepth = minDepth(root.left);
		// 求右儿子的最小深度
		int rightMinDepth = minDepth(root.right);

		// 如果左儿子树或者右儿子树最小深度是0，那么就返回另一个长度
		if (leftMinDepth == 0) {
			return rightMinDepth + depth;
		}
		if (rightMinDepth == 0) {
			return leftMinDepth + depth;
		}

		return Math.min(leftMinDepth, rightMinDepth) + depth;
	}
}

public class LayerTraversal {
	// 需求一
	// 思路一
	public static void layerPrint1(BinTree.Node root) {
		if (root == null) {
			throw new IllegalArgumentException("invalid parameters");
		}

		// 创建队列，存储二叉树节点
		Queue<BinTree.Node> queue = new ArrayDeque<BinTree.Node>();
		// 把根结点加到队列尾
		queue.offer(root);

		// 当前层待遍历个数
		int toBeVisit = 1;
		// 下一层节点个数
		int nextLevel = 0;

		while (!queue.isEmpty()) {
			BinTree.Node temp = queue.poll();// 移除头结点
			System.out.print(temp.val + " ");

			// 添加移除的节点的左儿子节点
			if (temp.left != null) {
				nextLevel++;
				queue.offer(temp.left);
			}
			// 添加移除的节点的右儿子节点
			if (temp.right != null) {
				nextLevel++;
				queue.offer(temp.right);
			}

			// 当前层待遍历节点个数减一
			toBeVisit--;

			// 如果=0，代表当前层已经遍历完
			if (toBeVisit == 0) {
				System.out.println();// 换行

				toBeVisit = nextLevel;
				nextLevel = 0;
			}
		}
	}

	// 需求一
	// 思路二
	public static void layerPrint2(BinTree.Node root) {
		if (root == null) {
			throw new IllegalArgumentException("invalid parameters");
		}

		// 创建队列，存储二叉树节点
		Queue<BinTree.Node> queue = new ArrayDeque<BinTree.Node>();
		// 把根节点存到队列尾
		queue.offer(root);

		// 当队列不是空的时候，将队列头移除，将其儿子节点加入队列
		while (!queue.isEmpty()) {
			int size = queue.size();// 记录当前层节点的个数

			BinTree.Node temp;

			// 遍历size次
			for (int i = 0; i < size; i++) {
				temp = queue.poll();
				System.out.print(temp.val + " ");

				// 添加儿子节点到队列中
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

			System.out.println();// 换行
		}
	}

	// 需求二
	// 思路一
	public static List<List<Integer>> getList1(BinTree.Node root) {
		if (root == null) {
			throw new IllegalArgumentException("invalid parameters");
		}

		// 创建队列，存储二叉树节点
		Queue<BinTree.Node> queue = new ArrayDeque<BinTree.Node>();
		// 把根节点存到队列尾
		queue.offer(root);

		// 当前层待遍历节点个数
		int toBeVisit = 1;
		// 下一层节点个数
		int nextLevel = 0;

		// 创建结果集合
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// 创建集合，存储每一行的节点值
		List<Integer> list = new LinkedList<Integer>();

		while (!queue.isEmpty()) {
			BinTree.Node temp = queue.poll();
			list.add(temp.val);

			if (temp.left != null) {
				nextLevel++;
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				nextLevel++;
				queue.offer(temp.right);
			}

			// 待遍历节点数减一
			toBeVisit--;

			// 当待遍历节点数为0，代表当前行已经遍历完
			if (toBeVisit == 0) {
				// 把当前list集合中的元素存到result中，注意不能直接result.add(list)，因为后面要清空list集合，result也会受到影响
				// 所以可以创建新的集合，存储list集合元素，然后添加到result中
				List<Integer> l = new LinkedList<Integer>();
				l.addAll(list);

				result.add(l);

				toBeVisit = nextLevel;
				nextLevel = 0;
				list.clear();// 清空共有的List集合
			}
		}

		return result;
	}

	// 需求二
	// 思路二
	public static List<List<Integer>> getList2(BinTree.Node root) {
		if (root == null) {
			throw new IllegalArgumentException("invalid parameters");
		}

		// 创建结果集合
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// 创建队列，存储二叉树节点
		Queue<BinTree.Node> queue = new ArrayDeque<BinTree.Node>();
		// 把根节添加到队列尾
		queue.offer(root);

		// 当队列中不为空
		while (!queue.isEmpty()) {
			// 创建List集合存储当前层节点值
			List<Integer> list = new LinkedList<Integer>();

			// 记录当前层的节点个数
			int size = queue.size();
			BinTree.Node temp;

			for (int i = 0; i < size; i++) {
				temp = queue.poll();
				list.add(temp.val);

				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}

			result.add(list);
		}

		return result;
	}

	public static void main(String[] args) {
		String[] str = { "20", "10", "50", "5", "15", "25", "75" };

		// 构建二叉树
		BinTree bt = new BinTree(str);
		bt.createBinTree();

		// 层次遍历
//		System.out.println("逐层打印：");
//		layerPrint1(bt.getRoot());

		System.out.println("逐层打印2：");
		layerPrint2(bt.getRoot());

		// System.out.println("二叉树分层集合：");
//		System.out.println(getList1(bt.getRoot()));
//		System.out.println("二叉树分层集合：");
//		System.out.println(getList2(bt.getRoot()));
	}
}