// Essentially taken from Roberts text book, but ...
//
// David John
// April 2021
//
//     -- replaced Cell with KeyValuePair<String,String>
//     -- modified code to use KeyValuePair<String,String>
//     -- "probes" added, with getter() and associated ++ and initialization to
//         count the number of comparisons in findCell() before a decision is made

import java.util.ArrayList;

public class ArrayStringMap implements StringMap {


    private ArrayList<KeyValuePair<String,String>> bindings;
    private final String title = "ArrayListMap";
    private int probes;     // count comparisons

    // constructor, O(1)
    public ArrayStringMap(){
        bindings = new ArrayList<KeyValuePair<String,String>>();
    }

    // enter a new key value pair or replace the value associated
    // with the key, put() calls findCell(), so the runtime complexity
    // of put() is O(N)
    public void put(String key, String value){
        int index = findCell(key);
        if (index==-1){
            KeyValuePair kvp = new KeyValuePair<String,String>(key,value);
            bindings.add(kvp);
        }
        else {
            bindings.get(index).setValue(value);
        }
    }

    // find a value associated with key or null, get() calls get() hence
    // its runtme complexity is O(N)
    public String get(String key){
        int index = findCell(key);
        return (index==-1)? null : bindings.get(index).getValue();
    }

    public int getProbes() { return this.probes;}

    // this routine does a sequential search of bindings for key
    // if bindings.size() is N then the runtime complexity of
    // this routine is O(N)
    private int findCell(String key){
        this.probes = 0;
        for(int i=0; i<bindings.size(); i++){
            probes++;
            if (bindings.get(i).getKey().equals(key)) return i;
        }
        return -1;
    }

    public String toString(){return title;}
}
