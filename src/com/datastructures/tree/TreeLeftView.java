package com.datastructures.tree;

// Java program to print left view of binary tree
public class TreeLeftView {
	private int maxLevel;
	TreeNode root;

	public static void main(String[] args) {
		TreeLeftView tree = new TreeLeftView();
		tree.root = new TreeNode(12);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(25);
		tree.root.right.right = new TreeNode(40);

		tree.leftView();
	}

	// recursive function to print left view
	void printLeftView(TreeNode node, int level) {
		if (node == null)
			return;

		// If this is the first node of its level
		if (maxLevel < level) {
			System.out.print(" " + node.key);
			maxLevel = level;
		}

		// Recursively print left and right subtrees
		printLeftView(node.left, level + 1);
		printLeftView(node.right, level + 1);
	}

	void leftView() {
		maxLevel = 0;
		printLeftView(root, 1);
	}
}
