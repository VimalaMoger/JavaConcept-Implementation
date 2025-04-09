package inputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLinefromInput {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[100];
        System.out.println("Enter lines of text or 'stop' to quit");
        int i = 0;
        while(i<100){
            try {
                str[i] = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(str[i]);
            if(str[i].equals("stop"))
                break;
            i++;
        }

    }
}
