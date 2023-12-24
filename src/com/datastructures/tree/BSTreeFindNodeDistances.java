package com.datastructures.tree;

public class BSTreeFindNodeDistances {

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
	private static int findDistance(Node root, int elm1, int elm2) {
		// find LCA (least common ancestor)
		Node lca = LCA(root, elm1, elm2);
		// find Level
		int d1 = findLevel(lca, elm1, 0);
		int d2 = findLevel(lca, elm2, 0);
		return d1 + d2;
	}


	private static Node LCA(Node root, int i, int j) {
		if (root == null) {
			return null;
		}

		if (root.key == i || root.key == j) {
			return root;
		}

		Node left = LCA(root.left, i, j);
		Node right = LCA(root.right, i, j);

		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return LCA(root.left, i, j);
		}
		return LCA(root.right, i, j);
	}


	private static int findLevel(Node lca, int elmt, int lvl) {
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
