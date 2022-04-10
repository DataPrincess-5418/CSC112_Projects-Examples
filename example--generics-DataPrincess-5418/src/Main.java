import java.util.Random;
import java.util.NoSuchElementException;

public class Main {

    private static Random rand;
    private static Stack<Double> XXX;         // specify XXX as a Queue (interface)

    private static void populate(){
        int howmany = rand.nextInt(16);
        for(int i=0;i<howmany;i++){
            XXX.push(rand.nextDouble());
        }
    }

    public static void main(String[] args) {

        rand = new Random();
        XXX = new Stack<Double>();     // instantiate XXX as a LinkedQueue (implements Queue)

        //Triple<Integer,Integer,Integer> YYY = new Triple<Integer,Integer,Integer>(1,2,3);
        //System.out.println(YYY);

        populate();

        System.out.println(XXX);
        System.out.println();

        int limit = Math.min(XXX.size(),16);
        for(int i=0; i<limit; i++) {

            try {
                System.out.println(i+"  "+XXX.pop());
            } catch (NoSuchElementException e) {
                System.out.println("Whoops!  The stack is empty.  Be more careful!!!");
            }

        }








    }
}
