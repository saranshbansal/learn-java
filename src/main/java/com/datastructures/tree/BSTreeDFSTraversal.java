package com.datastructures.tree;

/**
 * @author sbansal
 * <p>
 * Java program to demonstrate DFS traversal operations in binary search tree
 */

public class BSTreeDFSTraversal {

	// Root of BST
	TreeNode root;


	// Constructor
	BSTreeDFSTraversal() {
		root = null;
	}

	public static void main(String[] args) {
		BSTreeDFSTraversal tree = new BSTreeDFSTraversal();

        /* Let us create following BST
                   50
                /     \
               30      70
              /  \    /  \
            20   40  60   80
            /
           10
        */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(10);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// print preorder traversal of the BST
		System.out.println("PreOrder(DLR) Traversal :: ");
		tree.preorder();
		// print inorder traversal of the BST
		System.out.println("Inorder(LDR) Traversal :: ");
		tree.inorder();
		// print inorder traversal of the BST
		System.out.println("PostOrder Traversal(LRD) :: ");
		tree.postorder();
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	TreeNode insertRec(TreeNode root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	// This method mainly calls inorderRec()
	void inorder() {
		inorderRec(root);
	}

	// This method mainly calls preorderRec()
	void preorder() {
		preorderRec(root);
	}

	// This method mainly calls postorderRec()
	void postorder() {
		postorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}
	}

	// A utility function to do preorder traversal of BST
	void preorderRec(TreeNode root) {
		if (root != null) {
			System.out.println(root.key);
			inorderRec(root.left);
			inorderRec(root.right);
		}
	}

	// A utility function to do postorder traversal of BST
	void postorderRec(TreeNode root) {
		if (root != null) {
			inorderRec(root.left);
			inorderRec(root.right);
			System.out.println(root.key);
		}
	}
}
