package com.interview.binarytree;

public class BinaryTreeMaxValue12 {


    public static int findMax(TreeNode node) {


        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lestMax = findMax(node.lefTreeNode);
        int rightMax = findMax(node.rightTreeNode);
        int max = Math.max(node.value, Math.max(rightMax, lestMax));
        return max;
    }


    public static void main(String[] args) {

        TreeNode node = new TreeNode(8);
        node.lefTreeNode = new TreeNode(24);

        System.out.println(findMax(node)
        );
    }
}
