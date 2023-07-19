package com.interview.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DublicateArray2 {
    public static void main(String[] args) {



        int[] array={1,2,3,5,1,2,3,4};

      //  printDuplicates(array);
        usingHashSet(array);
    }

    private static void usingHashSet(int[] array) {


        Set set= new HashSet();

        for(int i=0;i<array.length;i++){

            if(set.contains(array[i]))
                System.out.println(array[i]);

            set.add(array[i]);
        }
    }

    private static void printDuplicates(int[] array) {

        for(int i=0;i<array.length;i++){


            for(int j=i+1;j<array.length;j++){

                if(array[i]==array[j]){
                    System.out.println(array[i]);
                }
            }
        }
    }
}
