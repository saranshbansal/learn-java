package com.datastructures.tree;

//Java program to print right view of binary tree
public class TreeRightView
{
    Node root;
    static int max_level = 0;


    // recursive function to print right view 
    void rightViewUtil(Node node, int level)
    {
        // Base Case 
        if (node == null)
            return;

        // If this is the first node of its level 
        if (max_level < level)
        {
            System.out.print(" " + node.key);
            max_level = level;
        }

        // Recur for left and right subtrees 
        rightViewUtil(node.right, level + 1);
        rightViewUtil(node.left, level + 1);
    }


    // A wrapper over rightViewUtil() 
    void rightView()
    {
        rightViewUtil(root, 1);
    }


    // Driver program to test the above functions 
    public static void main(String args[])
    {
        TreeRightView tree = new TreeRightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        tree.rightView();

    }
}
