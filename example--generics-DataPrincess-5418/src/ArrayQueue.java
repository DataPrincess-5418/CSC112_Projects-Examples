// Figure 13-7

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T>  {

    private int capacity;
    private int head;
    private int tail;
    private GenericArray<T> array;

    private static final int INITIAL_CAPACITY = 16;

    public ArrayQueue(){
        this.capacity = this.INITIAL_CAPACITY;
        this.array = new GenericArray<T>(this.capacity);
        this.head = this.tail = 0;
    }

    public int size(){
        return (this.tail+this.capacity-this.head)%this.capacity;
    }

    public boolean isEmpty(){
        return this.head==this.tail;
    }

    public void clear(){
        this.head = this.tail = 0;
    }

    public void add(T value){
        if (this.size()==this.capacity-1) this.expandCapacity();
        this.array.set(this.tail, value);
        this.tail = (this.tail+1)%this.capacity;

    }

    public T remove(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        T currentvalue = this.array.get(head);
        this.head = (this.head+1)%this.capacity;
        return currentvalue;
    }

    public T peek(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return this.array.get(this.head);
    }

    private void expandCapacity(){
        GenericArray<T> newArray = new GenericArray<T>(2*capacity);
        int count = this.size();
        for(int i=0; i<count;i++){
            newArray.set(i,this.array.get((this.head+i)%this.capacity));
        }
        this.head = 0;
        this.tail = count;
        this.capacity *= this.capacity;
        this.array = newArray;
    }
}
