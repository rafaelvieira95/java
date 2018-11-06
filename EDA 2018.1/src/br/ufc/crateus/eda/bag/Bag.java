package br.ufc.crateus.eda.bag;

import java.util.Iterator;

public interface Bag <E> extends Iterable <E> {

    void add(E e);

    void addAll(Bag <? extends E> c);

    void clear();

    boolean contains(E o);

    boolean containsAll (Bag <E> c);

    boolean isEmpty();

    void remove(E e);

    void removeAll(Bag<E> c);

    void retainAll(Bag <E> c);

    int size();

    @Override
    Iterator <E> iterator();
}
