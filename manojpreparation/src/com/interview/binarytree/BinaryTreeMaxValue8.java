package com.interview.binarytree;

import sun.reflect.generics.tree.Tree;

public class BinaryTreeMaxValue8 {


    public  static  int findMax(TreeNode node){

if(node == null){

    return Integer.MIN_VALUE;

}


int leftMax=findMax(node.lefTreeNode);
int rightMax= findMax(node.rightTreeNode);
int max= Math.max(node.value,Math.max(leftMax,rightMax));
return max;


    }


    public static void main(String[] args) {

        TreeNode node= new TreeNode(52);
        node.rightTreeNode=new TreeNode(522);
        node.lefTreeNode=  new TreeNode(520);
        System.out.println(findMax(node));

    }
}
