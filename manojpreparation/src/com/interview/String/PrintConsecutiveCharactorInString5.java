package com.interview.String;

public class PrintConsecutiveCharactorInString5 {


    public static void main(String[] args) {


        String value="ABCFGHXYZ";
        print(value);
    }

    private static void print(String value) {
     char[] chars= value.toCharArray();
        System.out.print(chars[0]);

        for(int i=1;i<chars.length;i++){

            if((chars[i]==chars[i-1]+1||(chars[i]==chars[i-1]-1))){

                System.out.print(chars[i]);


            }
            else {
                System.out.print("\n"+chars[i]);

            }
        }


    }
}
