package HackerRank;

import java.util.Scanner;

public class OddEvenPrimePalindrome {

    static boolean isOdd(int n){
        return n % 2 != 0;
    }

    static boolean isPrime(int n){
        if(n<=1)
            return false;
        int i = 2;
        while(i < n){
            if(n%i==0)
                return false;
            i++;
        }
        return true;
    }
    static boolean isPalindrome(int n){
        String s = String.valueOf(n);
        int index=0;
        for(int i= s.length()-1; i>=0; i--){
            if(s.charAt(index++) != s.charAt(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-- >= 0){
            String[] in = scan.nextLine().split(" ");
            switch (in[0]){
                case "1": {
                    if(isOdd(Integer.valueOf(in[1])))
                        System.out.println("ODD");
                    else
                        System.out.println("EVEN");
                    break;
                }
                case "2":{
                    if(isPrime(Integer.valueOf(in[1])))
                        System.out.println("PRIME");
                    else
                        System.out.println("COMPOSITE");
                    break;
                }
                case "3":{
                    if(isPalindrome(Integer.valueOf(in[1])))
                        System.out.println("PALINDROME");
                    else
                        System.out.println("NOT PALINDROME");
                    break;
                }
            }
        }
    }
}
/*
input
1 2 odd/even
1 5  odd/even
2 5  is Prime/Composite
2 3  is Prime/Composite
3 898 is Palindrome/ Not palindrome */