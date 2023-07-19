package com.interview.singleton;

public class DoubledCheckedSingleton {

    private static volatile DoubledCheckedSingleton doubledCheckedSingleton;


    private DoubledCheckedSingleton() {


    }

    public static DoubledCheckedSingleton getDoubledCheckedSingleton() {
        return doubledCheckedSingleton;
    }

    static {
        if (doubledCheckedSingleton == null) {


            synchronized (DoubledCheckedSingleton.class) {
                if (doubledCheckedSingleton == null) {


                    doubledCheckedSingleton = new DoubledCheckedSingleton();
                }

            }
        }


    }

    public static void main(String[] args) {
       DoubledCheckedSingleton doubledCheckedSingleton1= getDoubledCheckedSingleton();
       DoubledCheckedSingleton doubledCheckedSingleton2= getDoubledCheckedSingleton();
        System.out.println(doubledCheckedSingleton2==doubledCheckedSingleton1);
    }
}
