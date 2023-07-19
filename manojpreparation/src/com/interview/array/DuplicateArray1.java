package com.interview.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateArray1 {
    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 1, 5, 4, 6, 7, 8, 5};


        for (int i = 0; i < array.length; i++) {
          for(int j=i+1;j<array.length;j++){

              if(array[i]==array[j]){
                  System.out.println(array[j]);
              }
          }

        }
        // using hasset

        Set set= new HashSet();
        for(int num:array){
            if(set.contains(num)){
                System.out.println(num);
            }
            set.add(num);


        }
    }
}
