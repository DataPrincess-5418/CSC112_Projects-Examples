// Figure 13-1 from text

public class KeyValuePair<K,V>{

    private K key;
    private V value;

    // assumes the existence of a copy constructor
    // by default uses the Object class copy constructor
    public KeyValuePair(K key, V value){
        this.key = key;
        this.value = value;
    }


    public K getKey(){
        return this.key;
    }

    public V getValue(){
        return this.value;
    }


    public String toString(){
        return "<"+this.key+" -- "+this.value+">";
    }
}
