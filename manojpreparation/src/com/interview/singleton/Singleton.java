package com.interview.singleton;

public class Singleton {

    private static   Singleton singleton ;


    private  Singleton( ) {

    }

    public static Singleton getSingleton() {
        return singleton;
    }
    static {
        if(singleton==null){


            singleton=new Singleton();
        }


    }

    public static void main(String[] args) {
      Singleton value =  Singleton.getSingleton();
        Singleton value2 =  Singleton.getSingleton();
        System.out.println(value2==value);

    }
}
