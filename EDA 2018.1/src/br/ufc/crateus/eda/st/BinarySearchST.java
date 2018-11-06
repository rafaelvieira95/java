package br.ufc.crateus.eda.st;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchST <Key extends  Comparable <Key>, Value> implements  OrderedST<Key, Value>{

    class Entry<Key,Value>{

        Key key;
        Value value;

        Entry(Key key,Value value){

            this.key = key;
            this.value = value;
        }


        @Override
        public String toString() {
            return "("+this.key+", "+value+")";
        }
    }


    private int current;
    Entry [] array;
    int size;


    BinarySearchST(){
        this(10);
    }

    BinarySearchST(int lenght){

        this.array = new Entry [lenght];
        this.size=0;

    }

    @Override
    public void put(Key key, Value value) {

        if(this.size == array.length - 1){

            resize(array.length * 3 / 2);

        }

        if (value == null) this.delete(key);

        int pos = rank(key);
        Entry elem = new Entry(key, value);

        if (contains(key)) {

            array[pos] = elem;

        } else {

            for(int i = size; i > pos; i--){

                array[i] = array[i - 1];
            }
            array[pos] = elem;
            size++;

        }

    }

    @Override
    public Value get(Key key) {

        for(int i=0; i < this.size(); i++){

            if(key.equals(array[i])) {
                Value v = (Value) array[i];
                return v;

            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {

        int index = rank(key);

        if(key.equals(array[index].key)){

         array[index] = null;

         for(int i = index; i < size; i++){

             array[i] = array[i + 1];
         }
       size--;

        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Key> Keys() {

        return () -> new Iterator() {

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Key next() {

                return (Key) array[current++].key;
            }
        };
    }


    @SuppressWarnings("unchecked")
    public int rank(Key key){

        int lo = 0;
        int hi = this.size() - 1;

        while(lo <= hi) {

            int mid = (lo + hi) / 2;

            int cmp = key.compareTo((Key) array[mid].key);

            if (cmp < 0) {
                hi = mid - 1;
            } else {
                if (cmp > 0) {
                    lo = mid + 1;
                }
                else {

                    return mid;
                }
            }
        }
        return lo;
    }


    @Override
    public Key min() {
        Key key = (Key) array[0].key;
        return key;
    }

    @Override
    public Key max() {
        return (Key) array[size - 1].key;
    }

    @Override
    public Key floor(Key e) {
        int rank = rank(e);
        return (Key) array[rank - 1].key;
    }

    @Override
    public Key ceiling(Key e) {

             int rank = rank(e);

            Key key = null;

            if (array[rank + 1] == null) return null;
            else
                key =  (Key) array[rank + 1].key;

            return (Key) key;
    }

    @Override
    public Key select(int index) {

        if(index > (size - 1)) throw  new NoSuchElementException();
        else
        return (Key) array[index].key;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {

        return () -> new Iterator<Key>() {

            int current = rank(lo);
            int limit = rank(hi);

            @Override
            public boolean hasNext() {
                return current + 1 <= limit;
            }

            @Override
            public Key next() {

                return (Key) array[current++].key;
            }
        };
    }


    @Override
    public void deleteMin() {
        Key key = (Key) array[0].key;
        this.delete(key);
    }

    @Override
    public void deleteMax() {
        Key key = (Key) array[size - 1].key;
        this.delete(key);
    }

    @Override
    public int size(Key lo, Key hi) {
        return rank(hi) - rank(lo);
    }



    private void resize(int newSize){

        array = Arrays.copyOf(array,newSize);

    }

    public String elements(){

        StringBuilder builder = new StringBuilder("[");


        for(int i =0; i < this.size(); i++){

            builder.append("("+array[i].key+", "+array[i].value+")");

            if(i < this.size() - 1) builder.append(", ");
        }

        builder.append("]");
        return builder.toString();
    }


    public void printKeys(){

        for(Key key: Keys()){

            System.out.println(key);
        }

    }


    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
