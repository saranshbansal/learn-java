package com.datastructures.tree;

public class TreeFindHeight {
	public static void main(String[] args) {
		// Build tree
		TreeNode tree = new TreeNode(0);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(5);
		tree.right.right = new TreeNode(6);
		tree.right.left.left = new TreeNode(7);
		tree.right.left.right = new TreeNode(8);

		System.out.println("Max height of the tree: " + findHeight(tree));
	}


	private static int findHeight(TreeNode tree) {
		if (null == tree)
			return 0;
		if (tree.left == null && tree.right == null)
			return 1;
		else
			return Math.max(findHeight(tree.left), findHeight(tree.right)) + 1;
	}
}
