package com.interview;

public class CodeExecuton {

    int v;
    static int c;
    CodeExecuton(){

        System.out.println("contructor");


    }

    static {

        System.out.println("static block");
    }
    {
        System.out.println("instance block");
    }

    public  void instance(){
        System.out.println("instance method");
    }
    public static void method(){

        System.out.println("static method");
    }

    public static void main(String[] args) {
        CodeExecuton codeExecuton= new
                CodeExecuton();
    }

}
