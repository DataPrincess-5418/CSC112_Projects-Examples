//  Essentially taken from Roberts, but ..
//
//  David John
//  April 2021
//
//   -- replaced Cell class with KeyValueLink class
//   -- introduce "probes", along with supporting code to count
//      the number of decisions made in findCell()

public class HashStringMap implements StringMap {

    private static final int INITIAL_BUCKET_COUNT = 14;

    private Object[] buckets;  // array of KeyValueLink<String,String> objects
    private int nBuckets;       // physical size of array buckets
    private final String title = "HashStringMap";
    private int probes;


    // constructor, O(1)
    public HashStringMap(){
        nBuckets = INITIAL_BUCKET_COUNT;
        buckets = new Object[nBuckets];  // create array of KeyValueLink<String,String> objects
    }

    public String get(String key){
        int bucket= Math.abs(key.hashCode()) % nBuckets;          // hash key and turn into index
        KeyValueLink<String,String> cp = findCell(bucket,key);    // search for key starting at index
        return (cp == null) ? null : cp.getValue();
    }

    public int getProbes(){return this.probes;}

    public void put(String key, String value){

        int bucket = Math.abs(key.hashCode()) % nBuckets;          // hash key and turn into index
        KeyValueLink<String,String> cp = findCell(bucket,key);     // search for key starting at index

        // new key, insert key cell
        if (cp == null){
            cp=new KeyValueLink<String,String>();
            cp.setKey(key);
            cp.setLink((KeyValueLink<String,String>)buckets[bucket]);
            buckets[bucket] = cp;
        }

        // set value of key-value pair
        cp.setValue(value);
    }

    // starting at bucket, search for key until a match
    // or a null link
    private KeyValueLink<String,String> findCell(int bucket, String key){
        this.probes = 0;
        for(KeyValueLink<String,String> cp = (KeyValueLink<String,String>)buckets[bucket];
                cp != null; cp = cp.getLink()){
            probes++;
            if (cp.getKey().equals(key)) return cp;      // found it and return Cell
        }
        return null;
    }

    public String toString(){return title;}
}
