package com.datastructures.tree;

public class TreeFindHeight
{
    public static void main(String[] args)
    {
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

        System.out.println("Max height of the tree: " + findHeight(tree));
    }


    private static int findHeight(Node tree)
    {
        if (null == tree)
            return 0;
        if (tree.left == null && tree.right == null)
            return 1;
        else
            return Math.max(findHeight(tree.left), findHeight(tree.right)) + 1;
    }
}
