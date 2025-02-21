package HackerRank;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetExample2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int length = Integer.valueOf(str[0]);
        int n = Integer.valueOf(str[1]);
        BitSet B1 = new BitSet(length);
        BitSet B2 = new BitSet(length);
        while(n > 0){
            String[] in = scanner.nextLine().split(" ");
            String opType = in[0];
            int a = Integer.valueOf(in[1]);
            int b = Integer.valueOf(in[2]);
            switch(opType){
                case "AND": {
                    if(a ==1 && b==2)
                        B1.and(B2);
                    else
                        B2.and(B1);
                    System.out.println(B1.cardinality() + " " + B2.cardinality());
                    break;}
                case "SET": {
                    if(a ==1)
                        B1.set(b);
                    else
                        B2.set(b);
                    System.out.println(B1.cardinality()+ " "+B2.cardinality());
                    break;}
                case "FLIP": {
                    if(a ==1)
                        B1.flip(b);
                    else
                        B2.flip(b);
                    System.out.println(B1.cardinality()+ " "+B2.cardinality());
                    break;}
                case "OR": {
                    if(a ==1 && b==2)
                        B1.or(B2);
                    else
                        B2.or(B1);
                    System.out.println(B1.cardinality()+ " "+B2.cardinality());
                    break;}
                case "XOR": {
                    if(a ==1 && b==2)
                        B1.xor(B2);
                    else
                        B2.xor(B1);
                    System.out.println(B1.cardinality()+ " "+B2.cardinality());
                    break;}
            }
            n--;

        }

    }
}
