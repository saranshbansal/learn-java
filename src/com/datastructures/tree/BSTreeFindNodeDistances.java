package com.datastructures.tree;

public class BSTreeFindNodeDistances {

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

		System.out.println("Distance between two nodes (3,4): " + findDistance(tree, 3, 4));
		System.out.println("Distance between two nodes (1,4): " + findDistance(tree, 1, 4));
		System.out.println("Distance between two nodes (7,4): " + findDistance(tree, 7, 4));
		System.out.println("Distance between two nodes (6,4): " + findDistance(tree, 6, 4));
		System.out.println("Distance between two nodes (3,8): " + findDistance(tree, 3, 8));
		System.out.println("Distance between two nodes (0,4): " + findDistance(tree, 0, 4));
	}


	// dist = d1 + d2

	/**
	 * @param root
	 * @param elm1
	 * @param elm2
	 * @return
	 */
	private static int findDistance(TreeNode root, int elm1, int elm2) {
		// find LCA (least common ancestor)
		TreeNode lca = LCA(root, elm1, elm2);
		// find Level
		int d1 = findLevel(lca, elm1, 0);
		int d2 = findLevel(lca, elm2, 0);
		return d1 + d2;
	}


	private static TreeNode LCA(TreeNode root, int i, int j) {
		if (root == null) {
			return null;
		}

		if (root.key == i || root.key == j) {
			return root;
		}

		TreeNode left = LCA(root.left, i, j);
		TreeNode right = LCA(root.right, i, j);

		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return LCA(root.left, i, j);
		}
		return LCA(root.right, i, j);
	}


	private static int findLevel(TreeNode lca, int elmt, int lvl) {
		if (lca == null) {
			return -1;
		}
		if (lca.key == elmt) {
			return lvl;
		}

		int left = findLevel(lca.left, elmt, lvl + 1);
		if (left == -1) {
			return findLevel(lca.right, elmt, lvl + 1);
		}
		return left;
	}

}
