package com.interview.binarytree;

public class BinaryTreeMaxValue5 {


    public static void main(String[] args) {

        TreeNode node= new TreeNode(100);
        node.lefTreeNode= new TreeNode(2450);
        node.rightTreeNode= new TreeNode(2587456);
        System.out.println(findMax(node));

    }
    public static  int  findMax(TreeNode node){
        if(node==null){
            return  Integer.MIN_VALUE;

        }
        int leftMax=findMax(node.lefTreeNode);
        int rightMax= findMax(node.rightTreeNode);
        int max=Math.max(node.value,Math.max(leftMax,rightMax));
        return  max;


    }
}
