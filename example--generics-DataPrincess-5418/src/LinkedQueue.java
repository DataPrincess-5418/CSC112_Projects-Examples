// Figure 13-8

import java.util.NoSuchElementException;

// my LinkedQueue<T> is promising to implement all the
// methods specified in the interface Queue<T>
public class LinkedQueue<T> implements Queue<T> {

    // private (inner) class
    private class Cell{
        T value;
        Cell link;

        Cell(T value, Cell link){
            this.value = value;
            this.link = link;
        }
    }

    private Cell head;
    private Cell tail;
    private int count;

    public LinkedQueue(){
        this.head = this.tail= null;
        this.count = 0;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count==0;
    }

    public void clear(){
        this.head = this.tail = null;
        this.count = 0;
    }

    public void add(T value){
        Cell cp = new Cell(value,null);    // create new cell

        if (this.head==null){
            this.head = cp;
        } else {
            this.tail.link = cp;
        }
        this.tail = cp;
        count++;
    }

    public T remove(){
        if (this.isEmpty()) throw new NoSuchElementException("Queue is empty");
        T currentvalue = this.head.value;
        this.head = this.head.link;
        if (this.head == null) this.tail =null;
        count--;
        return currentvalue;
    }

    public T peek(){
        if (this.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return head.value;
    }

    public String toString(){
        return " Number of elements: "+this.count;
    }

}
