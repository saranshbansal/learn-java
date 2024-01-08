package com.datastructures.tree;

//Java program to print left view of binary tree
public class TreeLeftView {
	static int max_level = 0;
	TreeNode root;

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		TreeLeftView tree = new TreeLeftView();
		tree.root = new TreeNode(12);
		tree.root.left = new TreeNode(10);
		tree.root.right = new TreeNode(30);
		tree.root.right.left = new TreeNode(25);
		tree.root.right.right = new TreeNode(40);

		tree.leftView();
	}

	// recursive function to print left view
	void leftViewUtil(TreeNode treeNode, int level) {
		// Base Case
		if (treeNode == null)
			return;

		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + treeNode.key);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(treeNode.left, level + 1);
		leftViewUtil(treeNode.right, level + 1);
	}

	// A wrapper over leftViewUtil()
	void leftView() {
		leftViewUtil(root, 1);
	}
}
