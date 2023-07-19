package com.interview.binarytree;

public class BinaryTreeMaxValue3 {


    public static  int printMax(TreeNode node){

        if(node==null){
            return Integer.MIN_VALUE;
        }
        int leftMax=printMax(node.lefTreeNode);
        int rightMax=printMax(node.rightTreeNode);
        int max=Math.max(node.value,Math.max(leftMax,rightMax));
        return  max;


    }
    public static void main(String[] args) {
         TreeNode node= new TreeNode(10);
         node.lefTreeNode= new TreeNode(25);
         node.rightTreeNode=new TreeNode(500);
         node.lefTreeNode.rightTreeNode= new TreeNode(520);
         node.rightTreeNode.lefTreeNode= new TreeNode(4569);
        System.out.println(printMax(node));


    }
}
