package com.interview.Math;

public class DivisionWithoutOperator1 {
    public static void main(String[] args) {
        int divider=3;
        int divident=10;

        System.out.println(divide(divident,divider));

    }
    public static int divide(int divident, int divider){

      if(divider==0){
          throw  new IllegalArgumentException("cont divided by :" +divider);
      }

      int quetient=0;
      while(divident>=divider){

          divident-=divider;
          quetient++;
        }
      return  quetient;

    }
}
