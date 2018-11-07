package br.ufc.crateus.eda.st;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListST <Key,Value> implements ST <Key,Value> {

    private class Node{

        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {

            this.key = key;
            this.value = value;
            this.next = next;
        }

    }


    Node list;
    int count;

    @Override
    public void put(Key key, Value value) {

        if (value == null) {
            delete(key);
            return;
        }

        if (key == null) return;

        if (checkIntegrityKeys(key, value)) {

        } else {

            list = new Node(key, value, list);
            count++;
        }

    }


    private boolean checkIntegrityKeys(Key key, Value value) {

        for (Node ll = list; ll != null; ll = ll.next) {

            if (key.equals(ll.key)) {

                ll.key = key;
                ll.value = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public Value get(Key key) {

        for (Node ll = list; ll != null; ll = ll.next) {

            if (ll.key.equals(key)) {
                Value value = (Value) ll.value;
                return value;
            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {

       Node prev = new Node(null, null, list);

        for (Node p = prev; p.next != null; p = p.next) {

            if (key.equals(p.next.key)) {

                    p.next = p.next.next;
                    count--;
                    break;
            }

        }
      // list = prev;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }


    @Override
    public boolean isEmpty() {
        return list != null;
    }

    @Override
    public int size() {
        return count;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable <Key> Keys() {

        return () -> new Iterator() {
            Node aux;
            @Override
            public boolean hasNext() {

                if (aux == null && list != null) {
                    return true;

                } else {

                    return aux.next != null;
                }
            }

            @Override
            public Key next() {

                if (aux == null && list != null) {
                    aux = list;
                    return aux.key;
                } else {
                    if (aux != null) {

                        if (aux.next != null) {
                            aux = aux.next;
                            return aux.key;
                        }
                    }
                }
                throw new NoSuchElementException();
            }

        };
    }



    public void printKeys(){

  for(Key key : Keys()){

      System.out.println(key);
  }

    }

    public String elements(){

        if(list == null) return "is empty []";

        StringBuilder builder = new StringBuilder("[");

        for(Node ll =list; ll != null; ll = ll.next){

            builder.append("("+ll.key+", "+ll.value+")");
            if(ll.next != null) builder.append(", ");
        }
        builder.append("]");

        return builder.toString();
    }
}
