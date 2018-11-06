package br.ufc.crateus.eda.bag;


public abstract  class AbstractListBag <E> implements  Bag <E> {


    public abstract int indexOf(E o);
    public abstract int lastIndexOf(E o);
    public abstract E remove (int index);
    public abstract E set(int index,E element);
    public abstract AbstractListBag <E> subList(int formIndex, int toIndex);


    @Override
    public void addAll(Bag <? extends E> bag) {

        for(E e : bag){

            add(e);
        }
    }


    public void clear(){

     this.removeAll(this);

      }


    @Override
    public boolean containsAll(Bag<E> bag) {

        for(E e : bag){

            if(!this.contains(e))
                return false;

        }

        return true;
    }

    @Override
    public void removeAll(Bag<E> bag) {

        for(E e : bag){

                this.remove(e);

        }

    }

    @Override
    public void retainAll(Bag<E> bag) {

        for(E e : this){

            if(!bag.contains(e)){
                this.remove(e);
            }

        }

    }

}
