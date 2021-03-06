// Simple recursive MergeSort  which has complexity N*lg(N)
//
// David John
// March 2021



import java.util.ArrayList;
import java.util.Random;


public class Main {

    // class members
    private static long count;      // 64 bit integer for counting steps
    private static Random rand;     // Random object for generating test sets
    private static ArrayList<Double> myNumbers; // doubles to sort

    // utility method to populate myNumbers
    private static void populate(int N){
        for(int i=0; i<N; i++){
            myNumbers.add(rand.nextDouble());
        }
    }

    // driver of program
    public static void main(String[] args) {

        count = 0;
        rand = new Random();

        // create arraylist for testing
	    myNumbers = new ArrayList<Double>();
	    populate(16);

        // call MergeSort
	    ArrayList<Double> Result = MergeSort(myNumbers);

	    // print truncated result
        System.out.println("\nTruncated output\n");
	    for(int i=0; i< Math.min(Result.size(), 16);i++){
	      System.out.println(Result.get(i));
        }

	    System.out.println();
	    System.out.println("Number of steps: "+count);

    }

    // ------------------------

    // Method to merge two sorted (ascending order) lists into one
    // sorted list
    public static ArrayList<Double> Merge(ArrayList<Double> FirstList, ArrayList<Double> SecondList){

        ArrayList<Double> sortedtemp = new ArrayList<Double>();

        // while both are not empty, move smaller of two first
        // elements on sorted list
        while (!FirstList.isEmpty() && !SecondList.isEmpty()){
            count++;
            if (FirstList.get(0) < SecondList.get(0)){
                sortedtemp.add(FirstList.remove(0));
            }
            else{
                sortedtemp.add(SecondList.remove(0));
            }
        }

        // if first is still not empty, move balance
        // of first to sorted list
        if (!FirstList.isEmpty()){
            count+=FirstList.size();
            sortedtemp.addAll(FirstList);
        }

        // if second is still not empty, move balance
        // of second to sorted list
        if (!SecondList.isEmpty()){
            count += SecondList.size();
            sortedtemp.addAll(SecondList);
            }


        // return the sorted list
        return sortedtemp;

    }

    // -----------------------------

    // mergesort method
    public static ArrayList<Double> MergeSort(ArrayList<Double> theList){

        // recursive bit
        if (theList.size() > 1) {

            // find the middle of the list
            int middle = theList.size()/2;

            // create and mergesort two arraylists [start,end)
            // this is a bit sleezy
            // This detail could be pushed under the rug but would be present
            // in one form or another.  Adds to the time & time complexities.
            ArrayList<Double> A = new ArrayList<Double>(theList.subList(0,middle));
            ArrayList<Double> B = new ArrayList<Double>(theList.subList(middle,theList.size()));

            A = MergeSort(A);
            B = MergeSort(B);

            // returned the merged result
            return Merge(A,B);

        }

        return theList;

    }
}
