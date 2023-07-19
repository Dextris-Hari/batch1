package com.interview.binarytree;

public class BinaryTreeMaxValue7 {

    public static int findMax(TreeNode node) {


        if (node == null) {

            return Integer.MIN_VALUE;
        }
        int lesfMax = findMax(node.lefTreeNode);
        int rightMax = findMax(node.rightTreeNode);
        int sum = Math.max(node.value, Math.max(lesfMax, rightMax));
        return sum;

    }


    public static void main(String[] args) {


        TreeNode node = new TreeNode(10);
        node.lefTreeNode = new TreeNode(45);
        node.rightTreeNode = new TreeNode(2451);
        System.out.println(findMax(node));

    }
}
