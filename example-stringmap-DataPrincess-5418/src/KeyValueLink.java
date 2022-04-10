// key-value-link class, which extends KeyValuePair
//
// OK, a bit showy
//
//  David John
//  April 2021


public class KeyValueLink<K,V> extends KeyValuePair<K,V> {

    // link forward
    private KeyValueLink<K,V> link;

    // default constructor
    public KeyValueLink(){
        super();
        this.link = null;
    };

    // alternate constructor
    public KeyValueLink(K key, V value){
        super(key, value);
        this.link = null;
    }

    // getter and setter for link
    public void setLink(KeyValueLink<K,V> link){ this.link = link;}
    public KeyValueLink<K,V> getLink(){ return this.link;}

    // tostring
    public String toString() { return super.toString() + " <<"+ this.link + ">>";}
}
