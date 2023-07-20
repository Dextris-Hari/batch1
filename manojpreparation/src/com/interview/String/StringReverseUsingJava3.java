package com.interview.String;

public class StringReverseUsingJava3 {


    public static void main(String[] args) {

        String value="manoj";



      String reverse=  value.chars().mapToObj(c->String.valueOf((char) c))
                .reduce("",(arr,str)->str+arr);
        System.out.println(reverse);

        String rev="";

        for(int i=value.length()-1;i>=0;i--){

            rev+=value.charAt(i);
        }
        System.out.println(rev);


    }
}
