package com.datastructures.tree;

public class TreeCountNodes {

	public static void main(String[] args) {
		// Build tree
		Node tree = new Node(0);
		tree.left = new Node(1);
		tree.right = new Node(2);
		tree.left.left = new Node(3);
		tree.left.right = new Node(4);
		tree.right.left = new Node(5);
		tree.right.right = new Node(6);
		tree.right.left.left = new Node(7);
		tree.right.left.right = new Node(8);
		tree.left.right.right = new Node(9);
		tree.left.right.right.right = new Node(10);
		tree.left.right.right.right.right = new Node(11);
		tree.left.right.right.right.right.right = new Node(12);
		tree.left.right.right.right.right.right.right = new Node(13);

		System.out.println("Total number of nodes: " + countNodes(tree));
	}


	private static int countNodes(Node tree) {
		if (null == tree)
			return 0;
		if (tree.left == null && tree.right == null)
			return 1;
		else
			return countNodes(tree.left) + countNodes(tree.right) + 1;
	}
}
