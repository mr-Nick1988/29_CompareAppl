package telran.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareAppl {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of args, must be two...");
            return;
        }
        System.out.println("File1 " + args[0]);
        System.out.println("File2 " + args[1]);

        try (FileInputStream file1 = new FileInputStream(args[0]);
             FileInputStream file2 = new FileInputStream(args[1])) {
            int byte1;
            int byte2;
            long position = 0;
            boolean identical = true;

            while ((byte1 = file1.read()) != -1 && (byte2 = file2.read()) != -1) {
                if (byte1 != byte2)
                    System.out.println("Difference at position : " + position + ": " + byte1 + " != " + byte2);
                identical = false;
            }
            position++;

        if (file1.read() != -1 || file2.read() != -1) {
            System.out.println("File have different length at position " + position);
            identical = false;
        }
        if (identical) {
            System.out.println("Files identical");
        }
        } catch(FileNotFoundException e){
            System.out.println("File no found");
        } catch(IOException e){
            System.out.println("IO Error!");
        }
     }
}
