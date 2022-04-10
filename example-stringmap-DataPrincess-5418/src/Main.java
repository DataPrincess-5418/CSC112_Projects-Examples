// Main class used to test and analyze two lists implemented by hashing.
//
//  David John
//  April 2021

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Main {

    // for testing search for these keys
    private static final String[] mykeylist = {"CA", "VA", "NY", "CO","NY", "AK", "TN", "WI", "PR", "CT"};

    // testing routine
    public static void main(String[] args) {

        StringMap ASM = new ArrayStringMap();
        StringMapExample(ASM);

        System.out.println();

        ASM = new HashStringMap();       // think about what this has done
        StringMapExample(ASM);
    }

    // method to create and test StringMap
    public static void StringMapExample(StringMap myStringMap) {

        // create and initialize myStringMap for array based hashing
        //StringMap myStringMap = new ArrayStringMap();
        setup(myStringMap);

        System.out.println();
        System.out.println("****  TEST OF " + myStringMap);
        System.out.println();

        double psum = 0.0;      // set initial number of probes

        // report number of probes for the testing keys
        for (String mykey : mykeylist) {
            System.out.print(mykey + " : ");
            String theValue = myStringMap.get(mykey);
            System.out.printf("%15s", (theValue != null) ? theValue : "null");
            System.out.println(" : " + myStringMap.getProbes());
            psum += myStringMap.getProbes();
        }

        System.out.printf("%nTotal number of probes: %8.0f%n", psum);
        System.out.printf("Average number of probes: %9.2f%n", psum / mykeylist.length);
    }


    // very exciting method to initialize myStringMap
    private static void setup(StringMap myStringMap) {

        Scanner StateData = null;
        try {
            StateData = new Scanner(new FileReader("src/StateInfo.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Illegal input file name");
            System.exit(77);
        }

        // grab data, first line is abbreviation, second is state name
        while (StateData.hasNextLine()) {
            String StateAbbrev= new String();
            String StateName = new String();
            try {
                StateAbbrev = StateData.nextLine();
                StateName = StateData.nextLine();
            } catch (NoSuchElementException e){
                System.out.println("Error in data file -- FIX IT!");
                System.exit(66);
            }

            // remove (possible) spaces around StateAbbrev
            myStringMap.put(StateAbbrev.strip(), StateName);
        }

        StateData.close();


    }

}
