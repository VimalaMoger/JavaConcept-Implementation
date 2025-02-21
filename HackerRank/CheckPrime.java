package HackerRank;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;


class Prime {
    void checkPrime(int... primes) {
        for (int i = 0; i < primes.length; i++) {
            int n = primes[i];

            if (n <= 1){}
            else if(n==2)
                System.out.print(n+" ");
            else {
                int j = 2;
                while (j < n) {
                    if (n % j == 0)
                        break;
                    j++;
                    if(j==n)
                        System.out.print(n + " ");
                }

            }
        }
        System.out.println();
    }
}


//input 2 1 3 4 5  output 2 2 23 235
public class CheckPrime {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n1=Integer.parseInt(br.readLine());
            int n2=Integer.parseInt(br.readLine());
            int n3=Integer.parseInt(br.readLine());
            int n4=Integer.parseInt(br.readLine());
            int n5=Integer.parseInt(br.readLine());
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}