package arithmetic.tree;

public class Tree {
	private Node root;

	public Node find(int key) {
		Node current = root;
		while (current.getiData() != key) { // not find
			if (key < current.getiData()) // go left
				current = current.getLeft();
			else
				current = current.getRight(); // go right
			if (current == null)
				return null;
		}
		return current; // find;
	}

	public void insert(int id, int iData) {
		Node node = new Node();
		node.setId(id);
		node.setiData(iData);
		if (root == null) {
			root = node;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (iData < current.getiData()) { // go left find null and insert!
					current = current.getLeft();
					if (current == null) {
						parent.setLeft(node);
						return;
					}
				} else { // go right
					current = current.getRight();
					if (current == null) {
						parent.setRight(node);
						return;
					}
				}
			}
		}

	}

	public boolean delete(int key) {
		Node current = root;
		Node parrent = root;
		boolean isLeft = false; // 判断自己和父节点的关系：左侧还是右侧

		while (current.getiData() != key) { // 查找key 值
			parrent = current; // 要做操作了，将当前节点给父节点。
			if (key < current.getiData()) { // go left
				isLeft = true;
				current = current.getLeft();
			} else {
				isLeft = false;
				current = current.getRight();
			}
			if (current == null) //not find;
				return false;
		}
		// if no child,simple
		if (current.getLeft() == null && current.getRight() == null) { // 1.find2.nochild3.not root
			if (current == root) // if root,set tree empty
				root = null;
			else if (isLeft)
				parrent.setLeft(null);
			else
				parrent.setRight(null);
		}
		// if no right child,replace with left subtree
		else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeft) { // 判断删除节点和父节点 左右关系
				parrent.setLeft(current.getLeft());
			} else {
				parrent.setRight(current.getLeft());
			}
		}
		// if no left child,replace with right subtree;
		else if (current.getLeft() == null) {
			if (current == root)
				root = current.getRight();
			else if (!isLeft)
				parrent.setRight(current.getRight());
			else {
				parrent.setLeft(current.getRight());
			}
		}
		// 2 child inorder successor
		else {
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeft) {
				parrent.setLeft(successor); // 替换后连接父节点
			} else {
				parrent.setRight(successor);
			}
			successor.setLeft(current.getLeft()); // 替换后连接左子节点
		}
		return true;
	}

	private Node getSuccessor(Node delNode) { // 删除节点的 后继节点
		Node successorParent = delNode; // 中值节点 父节点
		Node successor = delNode; // 中值节点
		Node current = delNode.getRight(); // go to right child;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeft(); // 一直往左查找 直到null
		}
		if (successor != delNode.getRight()) {
			successorParent.setLeft(successor.getRight()); // 将后继节点的右子节点
															// 给后继节点的父左节点。
			successor.setRight(delNode.getRight());
		}
		return successor;
	}

	/**
	 * 中序遍历 左子序-根-右子序
	 */
	public void inOrder(Node node) {
		String prefix = " ";
		if (node != null) {
			inOrder(node.getLeft());
			prefix += " ";
			System.out.println(prefix + node.getiData());
			inOrder(node.getRight());
		}
	}

	/**
	 * 前序遍历 根-左子序-右子序
	 */
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(" " + node.getiData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	/**
	 * 后序遍历 左子序-右子序-根
	 */
	public void afterOrder(Node node) {
		if (node != null) {
			afterOrder(node.getLeft());
			afterOrder(node.getRight());
			System.out.println(" " + node.getiData());
		}
	}

	public Node min() {
		Node current, last = null;
		current = root;
		while (current != null) {
			last = current;
			current = current.getLeft();
		}
		return last;
	}

	public Node max() {
		Node current, last = null;
		current = root;
		while (current != null) {
			last = current;
			current = current.getRight();
		}
		return last;
	}
}
