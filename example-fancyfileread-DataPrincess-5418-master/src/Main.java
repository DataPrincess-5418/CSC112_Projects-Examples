// Example program to illustrate formatted input from Buffered Reader using Scanner
// Reads a file where each line consists of integers
// Outputs the average of the integers on each line
//
// The input file is opened through a (pop up) "open file"
// window.
//
//  David John
//  September 3, 2020
//  February, 2021

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Main {

    // class member (variable) for formatted inputs
    // one from keyboard and the other from a file
    private static Scanner myInput;
    private static Scanner keyboard;

    public static void main(String[] args) {



        // open external input file for reading and associated with
        // Scanner class.  Any exception will halt this program, but look for
        // file open problem first.
        try {

            myInput = new Scanner(openBufferedReaderUsingDialog());

        // catch the exception
        } catch(IOException e){
            System.out.println("File open problem");
            System.exit(2);
        } catch(NullPointerException e) {
            System.out.println("No file selected");
            System.exit(11);
        }catch (Exception e){
            System.out.println("Something weird happened:"+e);
            System.exit(3);
        }

        // as long as the next token in the input is an int, read it
        // and then display it
        while (myInput.hasNextLine()){

            // read the line and instantiate Scanner myData on that (String) data
            Scanner myData = new Scanner(myInput.nextLine());

            // initialize variables for summing and averagingxyz
            double sum = 0.0;
            int count = 0;

            // read the integers and update sum and count
            while(myData.hasNextInt()){
                sum += myData.nextInt();
                count++;
            }

            // if there were ints on the line then compute
            // and print (formatted) their average
            if (count >0) {
                sum = sum / count;
                System.out.printf("The average of %3d entries on this line is %7.2f%n",count, sum);
            }
        }

        // close file
        myInput.close();

    }

    /*
     * Opens a buffered reader using the JFileChooser method
     * Eric Roberts, Figure 4-11, 2017
     * David John, 2021 (modified)
     */

    // Open a file from a (pop up) open file window.  This routine can throw
    // an IOException
    private static BufferedReader openBufferedReaderUsingDialog() throws IOException {

        // pop up an "open file" chooser window on the path names
        // based on the current working directory (cwd)
        File dir = new File(System.getProperty("user.dir"));
        JFileChooser chooser = new JFileChooser(dir);
        int result = chooser.showOpenDialog(null);

        // if action chooses a file, open and return
        // the file as a BufferedReader
        if (result == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            return new BufferedReader(new FileReader(file));
        }

        // if anything else, return null
        return null;
    }
}
