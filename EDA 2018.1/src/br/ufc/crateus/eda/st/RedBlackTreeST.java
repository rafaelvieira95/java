package br.ufc.crateus.eda.st;

public class RedBlackTreeST<Key extends  Comparable<Key>, Value> extends BinarySearchTreeST <Key,Value> {


    private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class RBNode extends Node {

	    boolean color;

        		public RBNode(Key key, Value value) {
            			super(key, value);
            			this.color = RED;
            		}
	}

        	private Node put(Node r, Key key, Value value) {
                if (r == null) return new RBNode(key, value);

                int cmp = key.compareTo(r.key);
                if (cmp < 0) r.left = put(r.left, key, value);
                else if (cmp > 0) r.right = put(r.right, key, value);
                else r.value = value;

                if (getColor(r.left) == BLACK && getColor(r.right) == RED) r = rotateLeft(r);
                if (getColor(r.left) == RED && getColor(r.left.left) == RED) r = rotateRight(r);
                if (getColor(r.left) == RED && getColor(r.right) == RED) flipColors(r);
                //r.count = count(r.left) + count(r.right) + 1;
                return r;
            }


                @Override
                public void put (Key key, Value value){
                    this.root = put(root, key, value);
                    setColor(root, BLACK);
                }

                private Node rotateLeft (Node h){
                    Node x = h.right;
                    h.right = x.left;
                    x.left = h;
                    setColor(x, getColor(h));
                    setColor(h, RED);

                    //h.count = count(h.left) + count(h.right) + 1;
                    //x.count = h.count + count(x.right) + 1;
                    return x;
                }

                private Node rotateRight (Node h){
                    Node x = h.left;
                    h.left = x.right;
                    x.right = h;
                    setColor(x, getColor(h));
                    setColor(h, RED);

                    //h.count = count(h.left) + count(h.right) + 1;
                    //x.count = h.count + count(x.right) + 1;
                    return x;
                }

                private void flipColors (Node h){
                    setColor(h, RED);
                    setColor(h.left, BLACK);
                    setColor(h.right, BLACK);
                }

                @SuppressWarnings("unchecked")
                private void setColor (Node n,boolean color){
                    RBNode node = (RBNode) n;
                    node.color = color;
                }

                @SuppressWarnings("unchecked")
                private  boolean getColor (Node n){
                    if (n == null) return BLACK;
                    RBNode node = (RBNode) n;
                    return node.color;
                }

                private int heightBlack(RBNode r){

	              int height=0;
	              if(r == null) return -1;

	                if(r.color == BLACK) {
                        height = 1 + Math.max(heightBlack((RBNode) r.left),heightBlack((RBNode) r.right));
                    }else{
                        height = Math.max(heightBlack((RBNode) r.left),heightBlack((RBNode) r.right));
                    }

	              return height;
                }

                public int getHeightBlack(){

	           return heightBlack((RBNode) root);
                }

                private void elems(Node r){
	           if(r == null){

               }else{

                  RBNode node = (RBNode) r;
                   System.out.print(r.key +"{"+((RBNode) r).color+"}");
                   System.out.print("(");
                   elems(r.left);
                   elems(r.right);
                   System.out.print(") ");
               }

                     }
                     public void elements(){
	                 elems(root);
                     }

            }


