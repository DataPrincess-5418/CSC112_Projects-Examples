
    // Figure 13-1 from Roberts
    // with some modifications by
    //
    //  David John
    //  April, 2021

    public class KeyValuePair<K,V>{

        private K key;
        private V value;

        // assumes the existence of a copy constructor
        // by default uses the Object class copy constructor
        public KeyValuePair(K key, V value){
            this.key = key;
            this.value = value;
        }

        // default constructor
        public KeyValuePair(){
            this.key = null;
            this.value = null;
        }

        // getter and setter for Key
        public K getKey(){
            return this.key;
        }
        public void setKey(K key){ this.key = key;}

        // getter and setter for Value
        public V getValue(){ return this.value; }
        public void setValue(V value){this.value = value;}


        public String toString(){
            return "<"+this.key+" -- "+this.value+">";
        }
    }


