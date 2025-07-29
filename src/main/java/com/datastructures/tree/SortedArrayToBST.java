package com.datastructures.tree;

public class SortedArrayToBST {

    /**
     * Given an array where elements are sorted in ascending order, convert it
     * to a height balanced BST.
     *
     * @param nums sorted array
     * @return BST
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return toBstRec(nums, 0, nums.length - 1);
    }

    /**
     * Recursive method to transform sorted array to BST.
     *
     * @param nums sorted array
     * @param l    left index
     * @param h    right index
     * @return partial BST
     */
    private static TreeNode toBstRec(int[] nums, int l, int h) {
        if (l > h) return null;
        int mid = (l + h) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBstRec(nums, l, mid - 1);
        node.right = toBstRec(nums, mid + 1, h);
        return node;
    }

    private static void printView(TreeNode tree) {
        if (tree != null) {
            printView(tree.left);
            System.out.print(tree.key + " ");
            printView(tree.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9}; // Input array

        TreeNode bstTree = sortedArrayToBST(nums); // Transform array to BST
        printView(bstTree); // Print the sorted array
    }
}
