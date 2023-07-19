package com.interview.String;

public class PrintConsecutiveCharactorInString {
    static void print(String str1)
    {
        char str[] = str1.toCharArray();
        System.out.print(str[0]);

        for (int i = 1; i < str.length; i++) {
//            System.out.print(str[i] == str[i - 1] + 1);

/*            System.out.println(str[i]+" =========");
            System.out.println(str[i-1]+"9999999999999999999");
            System.out.println(str[i-1]+1+"-----------------");
            System.out.println(str[i-1]-1+"00000000000");*/
            if ((str[i] == str[i - 1] + 1)
                    || (str[i] == str[i - 1] - 1)) {
                System.out.print(str[i]);
            }
            else {
                System.out.print("\n" + str[i]);
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "ABCXYZACCD";
        print(str);
    }


}
