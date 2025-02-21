package HackerRank;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetExample {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(1024);
        bitSet.set(10, true);

        System.out.println(bitSet);
        System.out.println(bitSet.get(10));

        bitSet.clear(10);
        System.out.println(bitSet.get(10));

        //to clear range of bits
        bitSet.clear(5,10);
        for(int i=5; i<= 10; i++){
            bitSet.set(i, true);
            System.out.println(bitSet.get(i));
        }
        System.out.println(bitSet);
        bitSet.clear();
        System.out.println(bitSet);

        //flipping bits
        System.out.println(".........................flip");
        bitSet.set(2);
        System.out.println(bitSet);
        bitSet.flip(2);
        System.out.println(bitSet);

        System.out.println("........................bitset and second set..........................");
        bitSet.set(5,10);
        System.out.println(bitSet);
        BitSet second = new BitSet();
        second.set(7,15);
        System.out.println(second);
        System.out.println(bitSet.get(5)+" "+bitSet.get(6)+" "+bitSet.get(7)+" "+bitSet.get(8)
                +" "+bitSet.get(9)+" "+bitSet.get(10)+" "+bitSet.get(11)+" "+bitSet.get(12)
                +" "+bitSet.get(13)+" "+bitSet.get(14));
        System.out.println(second.get(5)+" "+second.get(6)+" "+second.get(7)+" "+second.get(8)
                +" "+second.get(9)+" "+second.get(10)+" "+second.get(11)+" "+second.get(12)
                +" "+second.get(13)+" "+second.get(14));

        System.out.println(" ...................intersect.........................");
        //System.out.println(bitSet.intersects(second));
        bitSet.intersects(second);
        System.out.println(bitSet.get(5)+" "+bitSet.get(6)+" "+bitSet.get(7)+" "+bitSet.get(8)
                +" "+bitSet.get(9)+" "+bitSet.get(10)+" "+bitSet.get(11)+" "+bitSet.get(12)
                +" "+bitSet.get(13)+" "+bitSet.get(14));
        System.out.println(second.get(5)+" "+second.get(6)+" "+second.get(7)+" "+second.get(8)
                +" "+second.get(9)+" "+second.get(10)+" "+second.get(11)+" "+second.get(12)
                +" "+second.get(13)+" "+second.get(14));
        //logical and
        System.out.println(" ........................and.................................");
        bitSet.and(second);
        System.out.println(bitSet.get(5)+" "+bitSet.get(6)+" "+bitSet.get(7)+" "+bitSet.get(8)
                +" "+bitSet.get(9)+" "+bitSet.get(10)+" "+bitSet.get(11)+" "+bitSet.get(12)
                +" "+bitSet.get(13)+" "+bitSet.get(14));

        System.out.println(second.get(5)+" "+second.get(6)+" "+second.get(7)+" "+second.get(8)
                +" "+second.get(9)+" "+second.get(10)+" "+second.get(11)+" "+second.get(12)
                +" "+second.get(13)+" "+second.get(14));

        //xor operation
        System.out.println(",...........................xor...............................");
        bitSet.xor(second);
        System.out.println(bitSet.get(5)+" "+bitSet.get(6)+" "+bitSet.get(7)+" "+bitSet.get(8)
                +" "+bitSet.get(9)+" "+bitSet.get(10)+" "+bitSet.get(11)+" "+bitSet.get(12)
                +" "+bitSet.get(13)+" "+bitSet.get(14));

        System.out.println(second.get(5)+" "+second.get(6)+" "+second.get(7)+" "+second.get(8)
                +" "+second.get(9)+" "+second.get(10)+" "+second.get(11)+" "+second.get(12)
                +" "+second.get(13)+" "+second.get(14));

        System.out.println(".............................or...............");
        bitSet.or(second);
        System.out.println(bitSet.get(5)+" "+bitSet.get(6)+" "+bitSet.get(7)+" "+bitSet.get(8)
                +" "+bitSet.get(9)+" "+bitSet.get(10)+" "+bitSet.get(11)+" "+bitSet.get(12)
                +" "+bitSet.get(13)+" "+bitSet.get(14));

        System.out.println(second.get(5)+" "+second.get(6)+" "+second.get(7)+" "+second.get(8)
                +" "+second.get(9)+" "+second.get(10)+" "+second.get(11)+" "+second.get(12)
                +" "+second.get(13)+" "+second.get(14));

        System.out.println("..............HackerRank problem...............");
        BitSet b1 = new BitSet(5);
        BitSet b2 = new BitSet(5);
        System.out.println(b1.get(0)+" "+b1.get(1)+" "+b1.get(2)+" "+b1.get(3)+" "+b1.get(4));
        System.out.println(b2.get(0)+" "+b2.get(1)+" "+b2.get(2)+" "+b2.get(3)+" "+b2.get(4));
        System.out.println(b1.cardinality()+ " "+b2.cardinality());
        //and 1 2
        System.out.println("..............and");
        b1.and(b2);
        System.out.println(b1.get(0)+" "+b1.get(1)+" "+b1.get(2)+" "+b1.get(3)+" "+b1.get(4));
        System.out.println(b2.get(0)+" "+b2.get(1)+" "+b2.get(2)+" "+b2.get(3)+" "+b2.get(4));
        System.out.println(b1.cardinality()+ " "+b2.cardinality());
        //set 1 4
        System.out.println("...........................set //4th set to true");
        b1.set(4);
        System.out.println(b1.get(0)+" "+b1.get(1)+" "+b1.get(2)+" "+b1.get(3)+" "+b1.get(4));
        System.out.println(b1.cardinality()+ " "+b2.cardinality());
                //flip 2 2
        System.out.println(" ...........................flip..negate the state -any");
        b2.flip(2);
        System.out.println(b2.get(0)+" "+b2.get(1)+" "+b2.get(2)+" "+b2.get(3)+" "+b2.get(4));
        System.out.println(b1.cardinality()+ " "+b2.cardinality());
        //or 2 1
        System.out.println("...........or");
        b2.or(b1);
        System.out.println(b1.get(0)+" "+b1.get(1)+" "+b1.get(2)+" "+b1.get(3)+" "+b1.get(4));
        System.out.println(b2.get(0)+" "+b2.get(1)+" "+b2.get(2)+" "+b2.get(3)+" "+b2.get(4));
        System.out.println(b2.cardinality()+ " "+b1.cardinality());

        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        System.out.println(str[0]);
        String opType = str[0];
        int n = Integer.valueOf(str[1]);
        int m = Integer.valueOf(str[2]);
        System.out.println(opType +" "+ n+" "+m);
    }/*10 50
AND 1 2
XOR 1 2
XOR 1 2
AND 2 1
XOR 1 2
SET 1 1
SET 1 0
XOR 2 1
OR 1 2
FLIP 2 1
OR 2 1
FLIP 1 4
AND 1 2
OR 1 2
OR 2 1
XOR 1 2
SET 1 3
AND 1 2
SET 2 8{-truncated-}*/

}
