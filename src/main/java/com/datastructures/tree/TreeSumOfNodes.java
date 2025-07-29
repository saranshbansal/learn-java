package com.datastructures.tree;

public class TreeSumOfNodes {
    static int sum;


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

        System.out.println("Total sum of all nodes: " + countTotalSum(tree));
    }


    private static int countTotalSum(TreeNode tree) {
        if (null == tree)
            return 0;
        // trick: remember how tree traversal works
        return tree.key
                + countTotalSum(tree.left) +
                countTotalSum(tree.right);
    }
}
