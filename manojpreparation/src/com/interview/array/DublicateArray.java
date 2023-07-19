package com.interview.array;

import java.util.HashSet;
import java.util.Set;

public class DublicateArray {


    public static void main(String[] args) {
        int [] arrayValue= {1,2,3,5,8,7,4,2,1,3};
        //using loop

        for(int i=0;i<arrayValue.length;i++){


            for(int j=i+1;j<arrayValue.length;j++){
                if(arrayValue[i]==arrayValue[j])
                    System.out.println(arrayValue[i]);

            }
        }
        // using hashset

         Set set= new HashSet();

        for(int i=0; i<arrayValue.length;i++){

            if(set.contains(arrayValue[i])){
                System.out.println(arrayValue[i]);
            }
            set.add(arrayValue[i]);
        }

    }
}
