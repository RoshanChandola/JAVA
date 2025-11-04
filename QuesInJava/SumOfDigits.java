package PatternsInJava;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter a number:");
        int n= sc.nextInt(),d,sum=0;
        while(n!=0)
        {
            d=n%10;
            sum+=d;
            n=n/10;
        }
        System.out.println("the sum of digits of given number:"+sum);

    }
}
