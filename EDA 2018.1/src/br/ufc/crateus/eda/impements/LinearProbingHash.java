package br.ufc.crateus.eda.impements;

import br.ufc.crateus.eda.st.ST;

import java.util.LinkedList;
import java.util.Queue;

public class LinearProbingHash<Key,Value> implements ST< Key,Value> {

    private  int M = 16;

    private Key [] keys;
    private Value [] values;
    private int count;
    private int posDies;

    public LinearProbingHash(){
        this.keys = (Key[]) new Object[M];
        this.values = (Value[]) new Object[M];
    };

    public  LinearProbingHash(int m){
        this.keys = (Key[]) new Object[m];
        this.values = (Value[]) new Object[m];
        M = m;

    }

    private int hash(Key key){  return (key.hashCode() & 0x7fffffff % M); }



    @Override
    public void put(Key key, Value value) {
        if(key == null) return;
        if(value == null) this.delete(key);

        if(count + posDies >= (M/2)) resize(2*M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (key.equals(keys[i])) {

                if (values[i] == null) {
                    posDies--;
                    count++;
                }
                values[i] = value;
                return;
            }
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

        if(key == null) return;
        if(!contains(key)) return;

        //metodo que deleta chave e valor da tabela de simbolos
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1)%M) {
            if (key.equals(keys[i])) {
                keys[i] = null;
                values[i] = null;
                count--;
                break;
            }
        }
        //quando deleta fica um buraco no meio do bloco, essa parte corrige isso
        for(int j = i; keys[j] != null; j = (j + 1)%M){
            Key keyTemp = keys[j];
            Value valueTemp = values[j];
            keys[j] = null;
            values[j] = null;
            this.put(keyTemp,valueTemp);
        }

        if(count > 1 && count <= M/8) resize(M/2);

    }

    @SuppressWarnings("unchecked")
    private void resize(int m){
        this.posDies = 0;

        LinearProbingHash <Key,Value> temp;
        temp = new LinearProbingHash<Key,Value>(m);
        for(int i = 0; i < M; i++) {
            if (keys[i] != null)
                temp.put(keys[i], values[i]);
        }
        this.keys = temp.keys;
        this.values = temp.values;
        this.M = temp.M;
    }

    public void deleteLazy(Key key){

        if(key == null) return;
        if(!contains(key)) return;

        for(int i = hash(key) ; keys[i] != null; i = (i + 1)%M){
            if(key.equals(keys[i])){
                values[i] = null;
                posDies++;
                count--;
                return;
            }
        }

        if(count <= (M/8)) resize(M/2);
    }


    @Override
    public boolean contains(Key key) { return get(key) != null; }

    @Override
    public boolean isEmpty() { return count == 0; }

    @Override
    public int size() { return count; }


    public Iterable<Value> Values(){

        Queue <Value> ll = new LinkedList<Value>();
        for (Value v : values) if(v != null) ll.add(v);
        return ll;

    }

    @Override
    public Iterable<Key> Keys() {
        Queue <Key> ll = new LinkedList<Key>();
        for (Key k : keys) if(k != null) ll.add(k);
        return ll;
    }


}
