package inputOutput;

import java.io.PrintWriter;

public class PrintWriterDemo{
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);  //print to output stream, with true to autoflush a new line
        //otherwise it will store the previous value(line)
        pw.println("This is a string ");
        int i = -7;
        pw.println(i);
        double d = 4.5e-7;
        pw.println(d);

    }
}
