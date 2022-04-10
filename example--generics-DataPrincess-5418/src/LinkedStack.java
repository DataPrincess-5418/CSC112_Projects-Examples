// Figure 13-5

import java.util.NoSuchElementException;

// LinkedStack inherits from Stack  (it does not inherit much)
public class LinkedStack<T> extends Stack<T>{

    /* private (inner) class used to create linked list */
    private class Cell{
        private T value;        // value stored in Stack
        private Cell link;      // next element

        // constructor to create a new cell in linked list
        Cell(T value, Cell link){
            this.value = value;
            this.link = link;
        }

        public T getValue() { return this.value;}
        public Cell getLink() { return this.link;}
    }

    // reference which is anchor for linked list
    private Cell start;

    // constructor
    public LinkedStack(){
        this.clear();
    }

    // create null linked list
    public void clear(){
        this.start = null;
        super.count = 0;
    }

    public void push(T value){

        // An exception can be thrown here is out of Java
        // heap memory
        //
        // create cell at beginning of list
        Cell cp = new Cell(value,this.start);
        this.start = cp;
        super.count++;
    }

    // pop the stack
    public T pop(){

        // if Stack is empty, this raises an exception.
        if (super.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }

        // get value from top, then link around top cell
        T currentvalue =this.start.getValue();
        this.start = this.start.getLink();

        super.count--;
        return currentvalue;
    }

    // peek at the top but do not remove it
    public T peek(){

        if (super.isEmpty()){
        throw new NoSuchElementException("Stack is empty");
        }

        return this.start.getValue();
    }




}
