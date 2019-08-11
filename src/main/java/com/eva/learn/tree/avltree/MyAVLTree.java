package com.eva.learn.tree.avltree;

public class MyAVLTree<T extends Comparable<T>> {
	private AVLTreeNode<T> mRoot;

	class AVLTreeNode<E extends Comparable<E>> {
		E key;

		AVLTreeNode<E> left;

		AVLTreeNode<E> right;

		int height;

		public AVLTreeNode(E key, AVLTreeNode<E> left, AVLTreeNode<E> right) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
	}

	public MyAVLTree() {
		mRoot = null;
	}

	private int height(AVLTreeNode<T> tree) {
		if (tree != null)
			return tree.height;
		return 0;
	}

	public int height() {
		return height(mRoot);
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

	private void preOrder(AVLTreeNode<T> tree) {
		if (tree != null) {
			System.out.print(tree.key + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	public void preOrder() {
		preOrder(mRoot);
	}

	private void inOrder(AVLTreeNode<T> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.key + " ");
			inOrder(tree.right);
		}
	}

	public void inOrder() {
		inOrder(mRoot);
	}

	private void postOrder(AVLTreeNode<T> tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.key + " ");
		}
	}

	public void postOrder() {
		postOrder(mRoot);
	}

	private AVLTreeNode<T> search(AVLTreeNode<T> tree, T key) {
		if (tree == null || key == null)
			return null;

		int cmp = key.compareTo(tree.key);
		if (cmp < 0) {
			return search(tree.left, key);
		} else if (cmp > 0) {
			return search(tree.right, key);
		} else
			return tree;
	}

	public AVLTreeNode<T> search(T key) {
		return search(mRoot, key);
	}

	private AVLTreeNode<T> iterativeSearch(AVLTreeNode<T> tree, T key) {
		if (tree == null || key == null)
			return null;

		int cmp;
		while (tree != null) {
			cmp = key.compareTo(tree.key);
			if (cmp < 0) {
				tree = tree.left;
			} else if (cmp > 0) {
				tree = tree.right;
			} else {
				return tree;
			}
		}
		return null;
	}

	public AVLTreeNode<T> iterativeSearch(T key) {
		return iterativeSearch(mRoot, key);
	}

	private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
		if (tree.left != null)
			return minimum(tree.left);
		else
			return tree;
	}

	public AVLTreeNode<T> minimum() {
		return minimum(mRoot);
	}

	private AVLTreeNode<T> iterativeMinimum(AVLTreeNode<T> tree) {
		while (tree != null) {
			tree = tree.left;
		}
		return tree;
	}

	public AVLTreeNode<T> iterativeMinimum() {
		return iterativeMinimum(mRoot);
	}

	private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
		if (tree.right != null)
			return maximum(tree.right);
		else
			return tree;
	}

	public AVLTreeNode<T> maximum() {
		return maximum(mRoot);
	}

	private AVLTreeNode<T> iterativeMaximum(AVLTreeNode<T> tree) {
		while (tree != null) {
			tree = tree.right;
		}
		return tree;
	}

	public AVLTreeNode<T> iterativeMaximum() {
		return iterativeMaximum(mRoot);
	}

	private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> node) {
		AVLTreeNode<T> replacer = node.left;
		node.left = replacer.right;
		replacer.right = node;

		node.height = max(height(node.left), height(node.right)) + 1;
		replacer.height = max(height(node.left), height(node.right)) + 1;
		return replacer;
	}

	private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> node) {
		AVLTreeNode<T> replacer = node.right;
		node.right = replacer.left;
		replacer.left = node;

		node.height = max(height(node.left), height(node.right)) + 1;
		replacer.height = max(height(node.left), height(node.right)) + 1;
		return replacer;
	}

	private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> node) {
		node.left = rightRightRotation(node.left);
		return leftLeftRotation(node);
	}

	private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> node) {
		node.right = leftLeftRotation(node.right);
		return rightRightRotation(node);
	}

	private AVLTreeNode<T> insert(AVLTreeNode<T> tree, T key) {
		if (tree == null) {
			return new AVLTreeNode<>(key, null, null);
		}

		int cmp = key.compareTo(tree.key);
		if (cmp < 0) {
			tree.left = insert(tree.left, key);
			if ((height(tree.left) - height(tree.right)) == 2) {
				AVLTreeNode<T> rep = tree.left;
				if (height(rep.left) > height(rep.right)) {
					tree = leftLeftRotation(tree);
				} else {
					tree = leftRightRotation(tree);
				}
			}
		} else if (cmp > 0) {
			tree.right = insert(tree.right, key);
			if ((height(tree.right) - height(tree.left)) == 2) {
				AVLTreeNode<T> rep = tree.right;
				if (height(rep.left) > height(rep.right)) {
					tree = rightLeftRotation(tree);
				} else {
					tree = rightRightRotation(tree);
				}
			}
		} else {
			System.out.println("被忽视的操作，不允许插入相同节点....");
		}

		tree.height = max(height(tree.left), height(tree.right)) + 1;
		return tree;
	}

	public void insert(T key) {
		mRoot = insert(mRoot, key);
	}

	private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> target) {
		int cmp = target.key.compareTo(tree.key);
		if (cmp < 0) {
			tree.left = remove(tree.left, target);
			if ((height(tree.right) - height(tree.left)) == 2) {
				AVLTreeNode<T> rep = tree.right;
				if (height(rep.left) > height(rep.right)) {
					tree = rightLeftRotation(tree);
				} else {
					tree = rightRightRotation(tree);
				}
			}
		} else if (cmp > 0) {
			tree.right = remove(tree.right, target);
			if ((height(tree.left) - height(tree.right)) == 2) {
				AVLTreeNode<T> rep = tree.left;
				if (height(rep.left) > height(rep.right)) {
					tree = leftLeftRotation(tree);
				} else {
					tree = leftRightRotation(tree);
				}
			}
		} else {
			if (tree.left == null || tree.right == null) {
				return tree.left == null ? tree.right : tree.left;
			} else {
				if (height(tree.left) > height(tree.right)) {
					AVLTreeNode<T> max = maximum(tree.left);
					tree.key = max.key;
					tree.left = remove(tree.left, max);
				} else {
					AVLTreeNode<T> min = minimum(tree.right);
					tree.key = min.key;
					tree.right = remove(tree.right, min);
				}
			}
		}
		return tree;
	}

	public void remove(T key) {
		AVLTreeNode<T> target = search(key);
		if (target != null)
			remove(mRoot, target);
	}

	private void destroy(AVLTreeNode<T> tree) {
		if (tree != null) {
			destroy(tree.left);
			destroy(tree.right);
			tree = null;
		}

	}

	public void destroy() {
		destroy(mRoot);
	}

	private void print(AVLTreeNode<T> father, AVLTreeNode<T> son, int direction) {
		if (son != null) {
			if (direction == 0)
				System.out.printf("%2d is root\n", son.key);
			else
				System.out.printf("%2d is %2d's %6s child\n", son.key, father.key, direction == -1 ? "left" : "right");
			print(son, son.left, -1);
			print(son, son.right, 1);
		}
	}

	public void print() {
		if (mRoot != null) {
			print(null, mRoot, 0);
		}
	}
}
