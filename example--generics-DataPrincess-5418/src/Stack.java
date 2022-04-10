// based on Figure 13-4 from Roberts text

import java.util.NoSuchElementException;

public class Stack<T> {             // Remember T inherits from Object

    private GenericArray<T> array;
    private int capacity;           // max number of elements in Stack
    protected int count;            // current number of elements in Stack

    private static final int INITIAL_CAPACITY = 16;

    // set up empty Stack with max capacity INITIAL_CAPACITY
    public Stack(){
        this.capacity = this.INITIAL_CAPACITY;
        this.array = new GenericArray<T>(capacity);
        this.count = 0;
    }

    // number of element currently in Stack
    public int size(){
        return this.count;
    }

    // Stack logically empty?
    public boolean isEmpty(){
        return this.count == 0;
    }

    // make Stack logically empty
    public void clear(){
        this.count = 0;
    }

    // value is pushed onto Stack, Stack is resized if
    // necessary
    public void push(T value){

        // if there is no capacity, then rebuilt stack
        if (this.count==this.capacity){
            this.array.expandCapacity();   // may take some steps
            this.capacity = this.array.size();
        }
        array.set(this.count++,value);
    }

    // pop the Stack
    public T pop(){

        // if the stack is empty, raise an exception
        if (this.count==0){
            throw new NoSuchElementException("Stack is empty");
        }

        return this.array.get(--this.count);
        }

    // return what is on top, but do not pop
    public T peek() {

        // if the stack is empty, raise an exception
        if (this.count == 0) {
            throw new NoSuchElementException("Stack is empty");
        }

        return this.array.get(this.count - 1);
    }

    public String toString(){
        return " Stack (count/capacity): "+this.size()+"/"+this.capacity;
    }

}
