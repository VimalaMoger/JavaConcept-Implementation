package inputOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingToFile {
    public static void main(String[] args) throws IOException {
        int i;
        FileOutputStream fOut = null;
        FileInputStream fIn = null;
        //file to read
        try {
            fIn = new FileInputStream(args[0]);
            //file to write
            fOut = new FileOutputStream(args[1]);

            do {
                i = fIn.read();
                if (i != -1)
                    fOut.write(i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument is given");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            fIn.close();
            fOut.close();
        }
    }
}
