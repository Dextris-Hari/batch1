package com.interview.binarytree;

public class BinaryTreeMaxValue {

 public  int findMax(TreeNode root){
     if(root==null){
         return Integer.MIN_VALUE;
     }
     int leftMax=findMax(root.lefTreeNode);
     int rightMax=findMax(root.rightTreeNode);
     int max=Math.max(root.value, Math.max(leftMax,rightMax));

     return max;


 }

    public static void main(String[] args) {

     TreeNode node = new TreeNode(8);
     node.lefTreeNode=new TreeNode(15);
     node.rightTreeNode= new TreeNode(25);
     node.lefTreeNode.lefTreeNode=new TreeNode(80);
     BinaryTreeMaxValue binaryTreeMaxValue= new BinaryTreeMaxValue();
     int max= binaryTreeMaxValue.findMax(node);
        System.out.println(max);

    }

}
