package br.ufc.crateus.eda.st;

public class AVLTreeST<Key extends  Comparable<Key>, Value> extends BinarySearchTreeST <Key,Value>  {


     private class AVLNode extends Node{

         int height;

         public AVLNode(Key key,Value value){
             super(key,value);
             height = 0;

         }

     }

     private Node insert(Node r, Key key, Value value){
         if(r == null) return new AVLNode(key, value);

         int cmp = key.compareTo(r.key);

         if(cmp < 0) r.left = insert(r.left,key,value);
         else if (cmp > 0) r.right = insert(r.right,key,value);
         else r.value = value;

    
         ((AVLNode)r).height = 1 + Math.max(getHeight(r.left),getHeight(r.right));
         r.size = size(r.left) + size(r.right) + 1;

         return balanceAVL(r);
     }


    @Override
    public void put(Key key, Value value) {
    	if(value == null) this.delete(key);
    	this.root = insert(this.root,key,value);
    }


    private Node delete(Node r,Key key){

         if(r == null) return null;

         int cmp = key.compareTo(r.key);

         if(cmp < 0) r.left = delete(r.left,key);
         else if(cmp > 0) r.right = delete(r.right,key);
         else{

             if(r.left == null) return r.right;
             if(r.right == null) return r.left;

             Node t = r;
             r = getMax(r.left);
             r.left = deleteMax(t.left);
             r.right = t.right;
         }

         ((AVLNode) r).height = Math.max(getHeight(r.left),getHeight(r.right)) + 1;
        r.size = size(r.left) + size(r.right) + 1;

         return balanceAVL(r);
    }

    @Override
    public void delete(Key key) { root = delete(root,key); }

    private int balanceFactor(Node r){
         Node node = (AVLNode) r;
    return (r == null)? 0 : getHeight(r.left) - getHeight(r.right);
    }


    private Node balanceAVL(Node r){

  if(balanceFactor(r) < -1){ //caso em que key > r.key // caso 4

      if(balanceFactor(r.right) > 0) r.right = rotateRight(r.right);//caso 2 // verifica se o fator da de balanceamento da
      //  subarvore a direita esta em forma de zig-zag, se o fator for maior que zero quer dizer que a altura da esquerda e maior que a da direita e vai ser preciso
      //uma dupla rotaçao, primeiro uma rotaçao a direita nessa subarvore direita, e depois um rotateLeft na raiz r

            r = rotateLeft(r); // caso em que o fator de balanceamento e < - 1.
       }
             if(balanceFactor(r) > 1){ //caso em que key < r.key // caso 1
               if(balanceFactor(r.left) < 0) r.left = rotateLeft(r.left); //caso 3 // verifica se o fator da de balanceamento da
                 //  subarvore a esquerda esta em forma de zig-zag, se o fator for menor que zero quer dizer que a altura da direita e maior que a da esquerda e vai ser preciso
                 //uma dupla rotaçao, primeiro uma rotaçao a esquerda nessa subarvore esquerda, e depois um rotateRight na raiz r

                 r = rotateRight(r); // caso em que o fator de balancemanto e > 1
              }
        ((AVLNode)r).height = 1 + Math.max(getHeight(r.left),getHeight(r.right));//atualiza a altura da arvore
       r.size = size(r.left) + size(r.right) + 1;
       
       
         return r;
    }

    private int getHeight(Node r){

         return (r != null)?((AVLNode) r).height : - 1;
    }

    private int size(Node r){
         return (r == null)? 0 : r.size;
    }


    @SuppressWarnings("unchecked")
	private Node rotateLeft(Node h){

        Node x = h.right;
        h.right = x.left;
        x.left = h;

        ((AVLNode)x).height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        ((AVLNode)h).height = Math.max(getHeight(h.left),getHeight(h.right)) + 1;
        
        x.size = size(x.left) + size(x.right) + 1;
        h.size = size(h.left) + size(h.right) + 1;

        return x;
    }

    @SuppressWarnings("unchecked")
    private Node rotateRight(Node h){

        Node x = h.left;
        h.left = x.right;
        x.right = h;

        ((AVLNode)x).height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
       ((AVLNode)h).height = Math.max(getHeight(h.left),getHeight(h.right)) + 1;

       x.size = size(x.left) + size(x.right) + 1;
       h.size = size(h.left) + size(h.right) + 1;
       
        return x;
    }

    protected Node deleteMax(Node r){

        if(r == null) return null;

        if(r.right == null) return r.left;
        r.right = deleteMax(r.right);

        return balanceAVL(r);
    }

    @Override
    public void deleteMax() { this.root = deleteMax(this.root); }

    @Override
    protected Node deleteMin(Node r) {

        if(r == null) return null;

        if(r.left == null) return r.right;
        r.left = deleteMin(r.left);

        return balanceAVL(r);
    }

    @Override
    public void deleteMin(){ this.root= deleteMin(this.root);}


    @Override
    public Key select(int index) {
        return super.select(index);
    }

    @Override
    public Key ceiling(Key e) {
        return super.ceiling(e);
    }

    @Override
    public Key floor(Key e) {
        return super.floor(e);
    }

    @Override
    public Key max() {
        return super.max();
    }

    @Override
    public Key min() {
        return super.min();
    }


    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Key key) {
        return super.contains(key);
    }

    @Override
    public Value get(Key key) {
        return super.get(key);
    }


    private int minHeightAVL(int h){

         if(h == 0) return 1;
         if(h == 1) return 2;

         return minHeightAVL(h -1) + minHeightAVL(h - 2) + 1;
    }


    private  boolean isHeightValid(Node r){//questao da lista

        if (r == null) return true;

        int minH = minHeightAVL(((AVLNode) r).height);

        if(r.size < minH) return false;

     return isHeightValid(r.left) && isHeightValid(r.right);
    }

    private boolean balanceRules(Node r){ //questao da lista

         if(r == null) return true;

         int balance=0;
         balance = balanceFactor(r);

         if(balance < -1 || balance > 1) return false;

         return balanceRules(r.left) && balanceRules(r.right);
    }


    public boolean isAVLTree(){
         return balanceRules(root) && isHeightValid(root);
    } // questao da lista

}
