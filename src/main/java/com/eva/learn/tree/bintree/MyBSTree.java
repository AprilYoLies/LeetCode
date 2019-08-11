package com.eva.learn.tree.bintree;

public class MyBSTree<T extends Comparable<T>> {
	BSTreeNode<T> mRoot;

	static class BSTreeNode<E extends Comparable<E>> {
		E key;

		BSTreeNode<E> left;

		BSTreeNode<E> right;

		BSTreeNode<E> father;

		int height;

		public BSTreeNode(BSTreeNode<E> father, BSTreeNode<E> left, BSTreeNode<E> right, E key) {
			this.father = father;

			this.left = left;

			this.right = right;

			this.key = key;

			this.height = 1;
		}
	}

	private void destroy(BSTreeNode<T> tree) {
		if (tree != null) {
			destroy(tree.left);
			destroy(tree.right);
			tree = null;
		}
	}

	public void clear() {
		destroy(mRoot);
	}

	private void preOrder(BSTreeNode<T> tree) {
		if (tree != null) {
			System.out.print(tree.key + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}

	public void preOrder() {
		preOrder(mRoot);
	}

	private BSTreeNode<T> insert(BSTreeNode<T> tree, T key) {
		if (tree == null)
			return new BSTreeNode<>(null, null, null, key);

		int cmp;
		BSTreeNode<T> father;
		while (tree != null) {
			father = tree;
			cmp = key.compareTo(tree.key);
			if (cmp < 0) {
				tree = tree.left;
				if (tree == null) {
					father.left = new BSTreeNode<T>(father, null, null, key);
				}
			} else if (cmp > 0) {
				tree = tree.right;
				if (tree == null) {
					father.right = new BSTreeNode<T>(father, null, null, key);
				}
			} else {
				System.out.println("不允许，添加重复的数据...");
			}

		}
		return mRoot;
	}

	public void insert(T key) {
		mRoot = insert(mRoot, key);
	}

	private BSTreeNode<T> minimum(BSTreeNode<T> tree) {
		if (tree == null)
			throw new IllegalArgumentException();
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}

	public BSTreeNode<T> minimum() {
		return minimum(mRoot);
	}

	private BSTreeNode<T> maximum(BSTreeNode<T> tree) {
		if (tree == null)
			throw new IllegalArgumentException();
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}

	public BSTreeNode<T> maximum() {
		return maximum(mRoot);
	}

	private BSTreeNode<T> search(BSTreeNode<T> tree, T key) {
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
		return tree;
	}

	public BSTreeNode<T> search(T key) {
		return search(mRoot, key);
	}

	private void remove(BSTreeNode<T> tree, BSTreeNode<T> target) {
		if (target.left == null || target.right == null) {
			BSTreeNode<T> son = target.left == null ? target.right : target.left;

			BSTreeNode<T> father = target.father;

			if (son != null)
				son.father = father;

			if (father == null) {
				mRoot = son;
				return;
			}

			if (target == father.left)
				father.left = son;
			else
				father.right = son;

//			if (target.father == null) {
//				mRoot = target.left == null ? target.right : target.left;
//				return;
//			}
//			if (target == target.father.left) {
//				target.father.left = target.left == null ? target.right : target.left;
//			} else {
//				target.father.right = target.left == null ? target.right : target.left;
//			}
//			if (target.left != null)
//				target.left.father = target.father;
//			if (target.right != null)
//				target.right.father = target.father;
		} else {
			target.key = maximum(target.left).key;
			remove(target.left, maximum(target.left));
		}
	}

	public void remove(T key) {
		BSTreeNode<T> target = search(key);
		if (target != null)
			remove(mRoot, target);
	}

	private void print(BSTreeNode<T> father, BSTreeNode<T> son, int direction) {
		if (son != null) {
			if (direction == 0)
				System.out.printf("%2d is root and his father is %2d\n", son.key,
						son.father != null ? son.father.key : -1);
			else
				System.out.printf("%2d is %2d's %6s child and his father is %2d \n", son.key, father.key,
						direction == -1 ? "left" : "right", son.father != null ? son.father.key : -1);
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
