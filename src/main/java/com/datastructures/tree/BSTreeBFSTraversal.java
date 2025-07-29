package com.datastructures.tree;

// Recursive Java program for level order traversal of Binary Tree aka BFS
class BSTreeBFSTraversal {
    // Root of the Binary Tree
    TreeNode root;


    public BSTreeBFSTraversal() {
        root = null;
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        BSTreeBFSTraversal tree = new BSTreeBFSTraversal();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.left = new TreeNode(6);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }

    /* function to print level order traversal of tree*/
    void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(TreeNode root) {
        if (null == root)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

    /* Print nodes at the given level */
    void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
