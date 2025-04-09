package inputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingFromFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fIn = null;
        try {
            fIn = new FileInputStream(args[0]);

            do {
                i = fIn.read();
                if (i != -1)
                    System.out.print((char) i);  //prints "I am trying to read this file."
            } while (i != -1);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No argument is given");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            fIn.close();
        }
    }
}
