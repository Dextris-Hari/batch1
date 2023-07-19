package com.interview.binarytree;

public class BinaryTreeMaxValue6 {

    public  static int  findMax(TreeNode node) {

        if (node == null) {

            return Integer.MIN_VALUE;

        }


        int leftMax = findMax(node.lefTreeNode);
        int RightMax = findMax(node.rightTreeNode);
        int max = Math.max(node.value, Math.max(leftMax, RightMax));


        return max;


    }

    public static void main(String[] args) {

        TreeNode node= new TreeNode(120);
        node.rightTreeNode= new TreeNode(1542);
        node.rightTreeNode.lefTreeNode= new TreeNode(125463);
        node.rightTreeNode.rightTreeNode= new TreeNode(14524);
        node.lefTreeNode= new TreeNode(1542);
        node.lefTreeNode.rightTreeNode= new TreeNode(18820);
        node.lefTreeNode.lefTreeNode= new TreeNode(558214);
        int max=findMax(node);
        System.out.println(max);

    }
}
