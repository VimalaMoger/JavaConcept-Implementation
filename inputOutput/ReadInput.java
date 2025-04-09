package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {
    public static void main(String[] args){
        char c;
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Enter characters, 'q' to quit. ");
        do{
            try {
               c = (char) br.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.print(c);
        }while(c != 'q');
    }
}
