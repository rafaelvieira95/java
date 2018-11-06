package br.ufc.crateus.eda.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListBag <E> extends  AbstractListBag <E> {

    private class Node{

        E element;
        Node next;

        private Node current = null;

        public Node(E element, Node next) {

            this.element = element;
            this.next = next;
        }

    }


    private  Node list;

    int count;

    @Override
    public void add(E e) {
       list = new Node(e,list);
         count++;
    }



    @Override
    public void remove(E e) {

        Node h = new Node(null,list);

        if(e.equals(list.element)) {
            list = list.next;
            h = list;
            count--;

        }else{

        for(Node p = h; p.next != null; p = p.next) {

            if (e.equals(p.next.element)) {

                p.next = p.next.next;
                count--;
                break;
            }
          }
        }

    }

    @Override
    public boolean isEmpty() {
        return this.list == null;
    }

    @Override
    public int size() {
		
        return this.count;
    }

    @Override
    public boolean contains(E o) {

        for(E e: this){

            if(e.equals(o)){

                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(E o) {

        int index = 0;

        for(E e : this){
        index++;
            if(e.equals(o)){

                return index;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E o) {
        return 0;
    }

    @Override
    public E remove(int index) {

        int count=0;

        for(Node node = this.list; node != null; node = node.next) {
            count++;

            if (count == index) {
                E e = node.element;
                this.remove(e);
                return e;

            }
        }
        return null;
    }

    @Override
    public E set(int index, E element) {

        Node aux = list;
        int acc=1;

        if(index > count || index <= 0) throw  new NoSuchElementException();

        while(aux != null){

            if(acc <= count)
                if(acc == index)
                    aux.element = element;

              aux = aux.next;
                acc++;
        }

        return element;
    }

    @Override
    public AbstractListBag <E> subList(int fromIndex, int toIndex) {

        LinkedListBag <E> subList = new LinkedListBag<>();

        if (count < toIndex) throw new IndexOutOfBoundsException();

        int init = 0, last = 0;
        for (E e : this) {

            init++;
            if (init <= fromIndex) {
                last = init;
            } else {


                if (last <= toIndex + 1)
                    subList.add(e);

            }
               last++;
        }

            return subList;

    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            Node current;
            @Override
            public boolean hasNext() {

                if (current == null && list != null) {

                    return true;

                } else {

                    return current.next != null;
                }
            }

            @Override
            public E next() {

                if (current == null && list != null) {
                    current = list;
                    return current.element;

                } else {

                    if (current != null) {
                            current = current.next;
                            return current.element;

                    }
                }
                throw  new NoSuchElementException();
            }
        };
    }


    public void printer(){

        if(this.list == null) {

            System.out.printf("[]");

        }else {
            for(E e: this){
                System.out.println(e);
            }

        }


        }

}
