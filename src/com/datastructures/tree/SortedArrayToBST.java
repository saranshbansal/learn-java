package com.datastructures.tree;

public class SortedArrayToBST {

	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode tree = null;
		for (int num : nums) {
			tree = insertRec(tree, num);
		}

		printView(tree);
		return tree;
	}

	public static TreeNode insertRec(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
		}

		if (val > root.key) {
			root.right = insertRec(root.right, val);
		}

		if (val < root.key) {
			root.left = insertRec(root.left, val);
		}

		return root;
	}

	private static void printView(TreeNode tree) {
		if (tree != null) {
			printView(tree.left);
			System.out.print(tree.key + " ");
			printView(tree.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-10,-3,0,5,9}; // Input array

		sortedArrayToBST(nums);
	}
}
