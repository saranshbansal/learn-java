package com.datastructures.tree;

public class TreeCountNodes {

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
		tree.left.right.right = new TreeNode(9);
		tree.left.right.right.right = new TreeNode(10);
		tree.left.right.right.right.right = new TreeNode(11);
		tree.left.right.right.right.right.right = new TreeNode(12);
		tree.left.right.right.right.right.right.right = new TreeNode(13);

		System.out.println("Total number of nodes: " + countNodes(tree));
	}


	private static int countNodes(TreeNode node) {
		if (null == node)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return countNodes(node.left) + countNodes(node.right) + 1;
	}
}
