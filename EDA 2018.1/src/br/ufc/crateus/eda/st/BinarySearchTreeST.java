package br.ufc.crateus.eda.st;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeST<Key extends  Comparable <Key>, Value> implements  OrderedST<Key,Value> {

    protected class Node {

        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        protected Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }

    }

    protected  Node root;
    int size;

    private Key getMinKey() {

        if (root == null) return null;
        Node r = root;
        while (r.left != null) r = r.left;

        return r.key;
    }


    private int height(Node r){

        if(r == null) return -1;

        int left = height(r.left) + 1;
        int right = height(r.right) + 1;
        return (left > right)? left : right;
    }

    public int height(){
        return height(root);
    }

    @Override
    public Key min() {
        return getMinKey() != null ? getMinKey() : null;
    }


    private Key getMaxKey() {

        if (root == null) return null;
        Node r = root;
        while (r.right != null) r = r.right;

        return r.key;
    }

    @Override
    public Key max() {
        return getMaxKey() != null ? getMaxKey() : null;
    }

    private Key floor(Node r, Key key) {

        if (r == null) return null;

        int cmp = key.compareTo(r.key);

        if (cmp < 0) return floor(r.left, key);
        if (cmp > 0) {

            Key f = floor(r.right, key);

            return (f != null) ? f : r.key;

        }
        return r.key;
    }

    @Override
    public Key floor(Key e) {
        return floor(root, e);
    }

    private Key ceiling(Node r, Key key) {

        if (r == null) return null;

        int cmp = key.compareTo(r.key);

        if (cmp > 0) return ceiling(r.right, key);
        if (cmp < 0) {
            Key c = ceiling(r.left, key);

            return (c != null) ? c : r.key;

        }
        return r.key;
    }

    @Override
    public Key ceiling(Key e) {

        return ceiling(root, e);
    }


    private Node select(Node r, int index) {

        if (r == null) return null;

        int t = size(r.left);

        if (t > index) return select(r.left, index);
        else if (t < index) return select(r.right, index - t - 1);


            return r;
    }

    @Override
    public Key select(int index) {

        Node t = select(root, index);

        return (t != null) ? t.key : null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public int rank(Key e) {
        return rank(root,e);
    }

    private int rank(Node r,Key key) {
    	if(r == null) return 0;
    	
    	int cmp = key.compareTo(r.key);   	
    	
    	if(cmp < 0) return  rank(r.left,key ) ;
    	else if(cmp > 0) return size(r.left) + 1 +  rank(r.right,key);
    	else return size(r.left);
    	
    }

    protected Node deleteMin(Node r) {

        if (r == null) return null;

        if (r.left == null) return r.right;
        r.left = deleteMin(r.left);

        r.size = size(r.left) + size(r.right) + 1;

        return r;
    }

    @Override
    public void deleteMin() {

        root = deleteMin(root);
    }

    protected Node deleteMax(Node r) {

        if (r == null) return null;

        if (r.right == null) return r.left;
        r.right = deleteMax(r.right);

        r.size = size(r.left) + size(r.right) + 1;
        return r;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    private Node insert(Node tree, Key key, Value value) {

        if (tree == null) return new Node(key, value);

        int cmp = key.compareTo(tree.key);

        if (cmp < 0) tree.left = insert(tree.left, key, value);
        else if (cmp > 0) tree.right = insert(tree.right, key, value);
        else tree.value = value;


        root.size = size(root.left) + size(root.right) + 1;

        return tree;
    }

    @Override
    public void put(Key key, Value value) {
        if (value == null) this.delete(key);
        if(key == null) return;    
        root = insert(root, key, value);

    }

    private Node getNode(Node tree, Key key) {

        if (tree == null) return null;

        int cmp = key.compareTo(tree.key);

        if (cmp < 0) return getNode(tree.left, key);
        if (cmp > 0) return getNode(tree.right, key);
        return tree;
    }

    @Override
    public Value get(Key key) {
        Node node = getNode(root, key);
        return (node != null) ? node.value : null;
    }


    private Node deleteNode(Node r, Key key) {

        if (r == null) return null;

        int cmp = key.compareTo(r.key);

        if (cmp < 0) r.left = deleteNode(r.left, key);
        else if (cmp > 0) r.right = deleteNode(r.right, key);
        else {

            if (r.left == null) return r.right;
            if (r.right == null) return r.left;

            Node t = r;
            r = getMax(r.left);
            r.left = deleteMax(t.left);
            r.right = t.right;
        }

        r.size = size(r.left) + size(r.right) + 1;

        return r;
    }


    protected Node getMin(Node r) {

        if (r == null) return null;
        while (r.left != null) r = r.left;
        return r;
    }

    protected Node getMax(Node r) {

        if (r == null) return null;
        while (r.right != null) r = r.right;
        return r;
    }

    @Override
    public void delete(Key key) {

        root = deleteNode(root, key);

    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {   return (root == null)? true : false; }

    private int size(Node r) {   return (r ==  null)? 0 : r.size; }

    @Override
    public int size() {
        return (root != null) ? root.size : 0;
    }

    private int level(Node r, Key key) {

        int acc = 0;
        if (r == null) return -1;

        int cmp = key.compareTo(r.key);
        if (cmp < 0) acc = level(r.left, key) + 1;
        else if (cmp > 0) acc = level(r.right, key) + 1;
        else return acc;

        return acc;
    }



    public int level(Key k){

        return level(root,k);
    }

    @Override
    public Iterable<Key> Keys() {
List <Key> ll  = new LinkedList<>();
preOrderWalk(root, ll);
  return ll;
     }
    
    
    private  void preOrderWalk(Node r,List<Key> ll) {
    	if(r == null) return;
    	
    	ll.add(r.key);
    	preOrderWalk(r.left, ll);
    	preOrderWalk(r.right, ll);
    	
    }
    
}
