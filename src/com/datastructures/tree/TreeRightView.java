package com.datastructures.tree;

//class to access maximum level by reference 
class MaxLevel
{

    int maxLevel;
}


//Java program to print right view of binary tree
public class TreeRightView
{
    Node root;
    MaxLevel max = new MaxLevel();


    // Recursive function to print right view of a binary tree. 
    void rightViewUtil(Node node, int level, MaxLevel maxLevel)
    {

        // Base Case 
        if (node == null)
            return;

        // If this is the last Node of its level 
        if (maxLevel.maxLevel < level)
        {
            System.out.print(node.key + " ");
            maxLevel.maxLevel = level;
        }

        // Recur for right subtree first, then left subtree 
        rightViewUtil(node.right, level + 1, maxLevel);
        rightViewUtil(node.left, level + 1, maxLevel);
    }


    void rightView()
    {
        rightView(root);
    }


    // A wrapper over rightViewUtil() 
    void rightView(Node node)
    {

        rightViewUtil(node, 1, max);
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
