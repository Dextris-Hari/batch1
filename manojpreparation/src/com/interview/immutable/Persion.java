package com.interview.immutable;

public final class Persion {
    private final String name;


    public Persion(String name){

        this.name=name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
      Persion persion=  new Persion("manoj");

    }
}
