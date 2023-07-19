package com.interview.binarytree;

public class BinaryTreeMaxValue1 {


    public static void main(String[] args) {
        TreeNode node=new TreeNode(2);
        node.lefTreeNode=new TreeNode(20);
        node.rightTreeNode= new TreeNode(25);
        node.lefTreeNode.lefTreeNode= new TreeNode(500);
        node.lefTreeNode.rightTreeNode= new TreeNode(750);
        node.rightTreeNode.lefTreeNode= new TreeNode(6542);

        System.out.println(findMax(node));
    }

    private static int findMax(TreeNode node) {
        if(node==null)
            return Integer.MIN_VALUE;
        int leftMax=findMax(node.lefTreeNode);
        int rightMax=findMax(node.rightTreeNode);
        int max=Math.max(node.value,Math.max(leftMax,rightMax));
        return max;
    }
}
