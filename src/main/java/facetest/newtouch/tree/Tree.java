package facetest.newtouch.tree;

public class Tree {
	private Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public void preOrder(Node node) {
		if (node == null)
			return;
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

	public void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.getLeft());
		System.out.println(node.getData());
		inOrder(node.getRight());
	}

	public void afterOrder(Node node) {
		if (node == null)
			return;
		afterOrder(node.getLeft());
		afterOrder(node.getRight());
		System.out.println(node.getData());
	}

}
