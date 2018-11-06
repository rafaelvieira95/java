package br.ufc.crateus.eda.impements;

import br.ufc.crateus.eda.st.ST;

import java.util.LinkedList;
import java.util.Random;

public class SeparateChainingHash <Key,Value> implements ST<Key,Value> {

    private int M = 97;

    private static class Node {
        Object key;
        Object value;
        Node next;
        int elems;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.elems = 1;
        }

    }

    private Node[] arr;
    private int count;

    public SeparateChainingHash(int m) {
        this.arr = new Node[m];
        this.M = m;
        this.M = m;
    }

    public SeparateChainingHash() {
        this(97);
    }

    private int hash(Key key) { return (key.hashCode() & 0x7fffffff % M); }


    @Override
    public void put(Key key, Value value) {

        if (key == null) return;
        if (value == null) this.delete(key);

        int k = hash(key);
        for (Node p = arr[k]; p != null; p = p.next) {

            if (key.equals(p.key)) {
                p.value = value;
                return;
            }

        }
        arr[k] = new Node(key, value, arr[k]);
        if(arr[k].next != null) arr[k].elems = arr[k].next.elems + 1;
        count++;

       //if(arr[k].elems >= 8) resize(2*M);

    }

    public int getMin(){
        int min =0;

        for(int i =0; i < M; i++) {
            if(arr[i]!= null){
                min = arr[i].elems;
                break;
            }
        }

        for(int i =0; i < M; i++){
            if(arr[i] != null){
                if(arr[i].elems < min) min = arr[i].elems;
            }

        }

       return min;
    }

    public int getMax(){
        int max =0;

        for(int i =0; i < M; i++) {
            if(arr[i]!= null){
                max = arr[i].elems;
                break;
            }
        }

        for(int i =0; i < M; i++){
            if(arr[i] != null){
                if(arr[i].elems > max) max = arr[i].elems;
            }

        }

        return max;
    }
    @Override
    public Value get(Key key) {

        for (Node p = arr[hash(key)]; p != null; p = p.next) {
            if (key.equals(p.key)) {
                return (Value) p.value;
            }
        }
        return null;
    }

    private Node delete(Node r, Key key) {

        if (r == null) return null;

        if (key.equals(r.key)) {
            r = r.next;
            count--;
        } else r.next = delete(r.next, key);

        return r;
    }

    @Override
    public void delete(Key key) {
        if (key == null) return;
        arr[hash(key)] = delete(arr[hash(key)], key);
    }



    private void resize(int m){

        SeparateChainingHash newArr = new SeparateChainingHash(m);

        for(int i = 0; i < M; i++){
            if(arr[i] != null){
                for(Node p = arr[i]; p != null; p = p.next){
                    newArr.put(p.key,p.value);
                }
            }

        }

        this.M = newArr.M;
        this.arr = newArr.arr;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterable<Key> Keys() {
        LinkedList<Key> list = new LinkedList<Key>();
        return listKeys(list,0);
    }

    public LinkedList<Key> listKeys(LinkedList<Key> list,int current){

        if(current >= arr.length) return null;
        Node p = arr[current];
        if(p != null){
            do{
                list.add((Key) p.key);
                p = p.next;
            }while(p != null);
        }
        listKeys(list,current + 1);

        return list;
    }


    public void generateTests(){

        int [] arr = {1000,10000,100000,1000000};

        for(int i = 0; i < arr.length; i++){

            int N = arr[i];
            SeparateChainingHash<Integer, Integer> st = new SeparateChainingHash<>(N / 100);
            Random r = new Random();
            for(int j = 0; j < arr[i]; j++) {
                st.put(r.nextInt(),j);
            }
            System.out.println("Number Elements: "+arr[i]);
            System.out.println("List small length: "+st.getMin());
            System.out.println("List big length: "+st.getMax());
        }

    }

    /* teste realizados sem o uso do resize


    para N = 10^3 = menor lista ~= 106 elementos
            "  "                 = maior lista ~= 143 elementos

   para N = 10^4 = menor lista ~= 277 elementos
             " " = maior lista ~= 367 elementos

  para N = 10^5 = menor lista ~= 3008 elementos
           " "                  = maior lista ~= 3211 elementos

  para N = 10^6 = menor lista ~= 1850 elementos
          "  "  	              = maior lista ~= 2058 elementos

    */


}
