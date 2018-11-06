package br.ufc.crateus.eda.st;

import java.util.*;


public class LinearProbingHashST <Key,Value> implements ST <Key,Value> {

    private  int M = 16;

    private Key [] keys;
    private Value [] values;
    private int count;

    public LinearProbingHashST(){
        this.keys = (Key[]) new Object[M];
        this.values = (Value[]) new Object[M];
    };

    public  LinearProbingHashST(int m){
        this.keys = (Key[]) new Object[m];
        this.values = (Value[]) new Object[m];
        M = m;

    }

    private int hash(Key key){  return (key.hashCode() & 0x7fffffff % M); }

    @Override
    public void put(Key key, Value value) {

       if(count >= (M/2)) resize(2*M);

        if(key == null) return;
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
             if (key.equals(keys[i])){ values[i] = value;
             return;
            }

            keys[i] = key;
            values[i] = value;
            count++;

    }

    @Override
    public Value get(Key key) {

        for(int i = hash(key); keys[i] != null; i = (i + 1)%M)
            if(key.equals(keys[i])) return values[i];

        return null;
    }

    @Override
    public void delete(Key key) {
        if(!contains(key)) return;

       for(int i = hash(key); keys[i] != null; i = (i + 1)%M) {
           if (key.equals(keys[i])) {
               values[i] = null;
               count--;
               return;
           }
       }

       if(count == (M/8)) resize(M/2);

    }

    @SuppressWarnings("unchecked")
    private void resize(int m){

        LinearProbingHashST <Key,Value> temp;
        temp = new LinearProbingHashST<Key,Value>(m);

        for(int i = 0; i < M; i++)
            if(keys[i] != null)
                temp.put(keys[i],values[i]);

        keys = temp.keys;
        values = temp.values;
        this.M = temp.M;
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
        Queue<Key> ll = new LinkedList<>();
        for (Key k : keys) if(k != null) ll.add(k);
        return (Iterable<Key>) ll;
        }
    }

