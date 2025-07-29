package com.datastructures.tree;

//Java program to print right view of binary tree
public class TreeRightView {
    static int max_level = 0;
    TreeNode root;

    // Driver program to test the above functions
    public static void main(String[] args) {
        TreeRightView tree = new TreeRightView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left.right = new TreeNode(8);

        tree.rightView();

    }

    // recursive function to print right view
    void rightViewUtil(TreeNode treeNode, int level) {
        // Base Case
        if (treeNode == null)
            return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.print(" " + treeNode.key);
            max_level = level;
        }

        // Recur for left and right subtrees
        rightViewUtil(treeNode.right, level + 1);
        rightViewUtil(treeNode.left, level + 1);
    }

    // A wrapper over rightViewUtil()
    void rightView() {
        rightViewUtil(root, 1);
    }
}
