package org.algos;

public class BTreeNodeDistanceFinder {

	static class Node {
		Node left, right;
		int key;
		public Node(int key) {
			super();
			this.key = key;
		}
		
	}
	
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
		
		System.out.println("Distance between two nodes: " + findDistance(tree, 3, 4));
		System.out.println("Distance between two nodes: " + findDistance(tree, 1, 4));
		System.out.println("Distance between two nodes: " + findDistance(tree, 7, 4));
		System.out.println("Distance between two nodes: " + findDistance(tree, 6, 4));
		System.out.println("Distance between two nodes: " + findDistance(tree, 3, 8));
		System.out.println("Distance between two nodes: " + findDistance(tree, 0, 4));
	}

	// dist = d1 + d2 
	private static int findDistance(Node root, int i, int j) {
		// find LCA (least common ancestor)
		Node lca = LCA(root, i, j);
		// find Level
		int d1 = findLevel(lca, i, 0);
		int d2 = findLevel(lca, j, 0);
		return d1 + d2;
	}

	private static int findLevel(Node lca, int a, int lvl) {
		if(lca == null) {
			return -1;
		}
	    if(lca.key == a) {
	    	return lvl;
	    }
	    
		int left = findLevel(lca.left, a, lvl + 1);
		if(left == -1) {			
			return findLevel(lca.right, a, lvl + 1);
		}
		return left;
	}

	private static Node LCA(Node root, int i, int j) {
		if(root == null) {
			return null;
		}
		
		if(root.key == i || root.key == j) {
			return root;
		}

		Node left = LCA(root.left, i, j);
		Node right = LCA(root.right, i, j);
		
		if(left != null && right != null) {
			return root;
		}
		if(left != null) {
			return  LCA(root.left, i, j);
		}
		return LCA(root.right, i, j);
	}
	
	

}
