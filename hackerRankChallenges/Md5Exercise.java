package hackerRankChallenges;

import java.security.MessageDigest;
import java.util.Scanner;

public class Md5Exercise {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes());
            byte[] arr = md5.digest();
            StringBuilder out = new StringBuilder();
            for(int i=0;i<arr.length;i++){
                out.append(String.format("%02x", arr[i]));
            }
            System.out.println(out.toString());

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
