package br.ufc.crateus.eda.st;

import java.util.Iterator;
import java.util.LinkedList;

public class SeparateChainingHashST<Key,Value> implements ST <Key,Value> {

    private static int M = 17;

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

    public SeparateChainingHashST(int m) {
        this.arr = new Node[m];
    }

    public SeparateChainingHashST() {
        this(M);
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
        arr[k].elems++;
        count++;

        if(arr[k].elems >= 4) resize(2*M);

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

        SeparateChainingHashST newArr = new SeparateChainingHashST(m);

        for(int i = 0; i < M; i++){
            if(arr[i] != null){
                for(Node p = arr[i]; p != null; p = p.next){
                    newArr.put(p.key,p.value);
                }
            }

        }

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
}
