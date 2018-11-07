package br.ufc.crateus.eda.bag;

import java.util.Arrays;
import java.util.Iterator;


public class ArrayListBag <E> extends AbstractListBag <E> {

    private  class Array{

        E [] array;
        int initialCapacity;

        private int current=0;

        public Array(){

            this(10);
        }

        public Array(int initialCapacity){

            this.initialCapacity = initialCapacity;
            this.array = (E[]) new Object[initialCapacity];
        }
    }

    private Array arr = new Array();
    private int count;


    @Override
    public int indexOf(E o) {
        int index=0;
            for(E e: this){
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

        if(index > arr.array.length - 1){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            E x = (E) arr.array[index];
            arr.array[index] = null;
            count--;
            equalizeArray();
            return x;
        }


    }

    @Override
    public E set(int index, E element) {

        if(index >= arr.initialCapacity) throw  new IndexOutOfBoundsException();

        arr.array[index] = element;

        return (E) arr.array[index];
    }

    @Override
    public AbstractListBag<E> subList(int fromIndex, int toIndex) {

       if(count >= toIndex) {

           ArrayListBag subList = new ArrayListBag();
           subList.arr = new Array((toIndex + 1) - fromIndex);


           for (int i = fromIndex; i < toIndex + 1; i++) subList.add(arr.array[i]);

           return subList;
       } else

           throw  new IndexOutOfBoundsException();
    }

    @Override
    public void add(E e) {

        if (this.count == arr.array.length) {
            resize((arr.array.length * 3) / 2 + 1);
            arr.array[count++] = e;
        } else {
            arr.array[count] = e;
            count++;
        }
    }


       private void resize (int newSize){

           this.arr.array = Arrays.copyOf(this.arr.array,newSize);
           this.arr.initialCapacity = newSize;
       }



    @Override
    public boolean contains(E o) {

        for (E e : arr.array) {

            if (e.equals(o)) {
                return true;

            }

            }
        return false;
        }


    @Override
    public boolean isEmpty() {
        if(this.size() == 0) return true;

        return false;
    }


    private Iterator it = this.iterator();

    @Override
    public void remove(E e) {

        int i=0;
        for(E ob: this){

            if (e == ob) {
                arr.array[i] =null;
                count--;
                break;
            }
            i++;
        }
            equalizeArray();
        }



    @Override
    public int size() {
        return count;
    }


    public String printer(){

        StringBuilder builder = new StringBuilder("[");

        for(E e: this){

            if(e != null){
                builder.append(e);
                builder.append(", ");
            }

        }
        builder.append("]");


        return builder.toString();
    }


    private void equalizeArray(){

        Array temp = new Array(arr.array.length);
        int i=0;

        for (E e : this) {

            if(e != null){
                temp.array[i] = e;

            }
            i++;
        }

        this.arr = temp;

    }


    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int current;
            @Override
            public boolean hasNext() {
                return current < arr.initialCapacity;
            }

            @Override
            public E next() {
                return arr.array[current++];
            }

        };


    }


}
