package br.ufc.crateus.eda.st;

public interface OrderedST <Key extends Comparable<Key>, Value> extends ST <Key , Value> {

    Key min();

    Key max();

    Key floor(Key e);

    Key ceiling(Key e);

    Key select(int index);

    Iterable<Key> keys(Key lo, Key hi);

    int rank(Key e);

    void deleteMin();

    void deleteMax();

    int size(Key lo, Key hi);

}
