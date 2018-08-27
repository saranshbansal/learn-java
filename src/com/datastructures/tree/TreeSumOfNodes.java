package com.datastructures.tree;

public class TreeSumOfNodes
{
    static int sum;


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

        System.out.println("Total sum of all nodes: " + countTotalSum(tree));
    }


    private static int countTotalSum(Node tree)
    {
        if (null == tree)
            return 0;
        // trick: remember how tree traversal works
        sum += tree.key;
        countTotalSum(tree.left);
        countTotalSum(tree.right);
        return sum;
    }
}
