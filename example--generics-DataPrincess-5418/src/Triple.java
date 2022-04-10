// Simple generic class to hold a triple of values
//
// David John
// March 2021

public class Triple<T1,T2,T3> {

    private T1 A;
    private T2 B;
    private T3 C;

    // alternate constructor
    public Triple(T1 A, T2 B, T3 C){
        this.A = A;
        this.B = B;
        this.C = C;
    }

    // getters
    public T1 getA(){
        return A;
    }

    public T2 getB(){
        return B;
    }

    public T3 getC(){
        return C;
    }

    // overload of Object toString(), notice
    // that T1 toString(), T2 toString(), and
    // T3 toString() are used
    public String toString(){
        return "< "+A+", "+B+", "+C+">";
    }
}
