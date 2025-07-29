package com.datastructures.tree;

// Java program for an efficient solution to check if
// a given array can represent Preorder traversal of
// a Binary Search Tree

import java.util.Stack;

class BinarySearchTreeValidator {

    public static void main(String[] args) {
        BinarySearchTreeValidator bst = new BinarySearchTreeValidator();
        int[] arr1 = new int[]{40, 30, 35, 80, 100};
        int n = arr1.length;
        if (bst.canRepresentBST(arr1, n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] arr2 = new int[]{40, 30, 35, 20, 80, 100};
        if (bst.canRepresentBST(arr2, n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    boolean canRepresentBST(int[] arr, int n) {
        // Create an empty stack
        Stack<Integer> stack = new Stack<Integer>();

        // Initialize current root as minimum possible
        // value
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < n; i++) {
            // If we find a node who is on right side
            // and smaller than root, return false
            if (arr[i] < root) {
                return false;
            }

            // If arr[i] is in right subtree of stack top,
            // Keep removing items smaller than arr[i]
            // and make the last removed item as new
            // root.
            while (!stack.empty() && stack.peek() < arr[i]) {
                root = stack.peek();
                stack.pop();
            }

            // At this point either stack is empty or
            // arr[i] is smaller than root, push arr[i]
            stack.push(arr[i]);
        }
        return true;
    }
}
