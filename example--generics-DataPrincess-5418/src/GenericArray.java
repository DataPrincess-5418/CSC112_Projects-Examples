// Figure 13-2 from text with expandCapacity() added

public class GenericArray<T> {

    //  private T [] array;    NOT ALLOWED
    private Object [] array;  // every Java class ISA Object

    public GenericArray(int n){
        this.array = new Object[n];    // instantiate as an array of Objects
    }

    public int size() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    public T get(int k){
        return (T) this.array[k];    // look up the kth Object and then force it to be a T object
    }

    public void set(int k, T value){
        this.array[k] = value;   // Object copy constructor
    }

    // expandCapacity() borrowed from Figure 13-4
    public void expandCapacity(){
        int capacity = 2*this.array.length;
        Object [] newArray = new Object[capacity];
        for(int i=0; i<this.array.length; i++){
            newArray[i] = (T) this.array[i];
        }
        this.array = newArray;

    }
}
