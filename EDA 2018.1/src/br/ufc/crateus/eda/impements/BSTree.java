package br.ufc.crateus.eda.impements;



public class BSTree{

    protected class Node {

        int key;
        Node left;
        Node right;


        public Node(int key) {
            this.key = key;
        }

    }


    Node root;


    public Node insert(Node r,int [] keys,int lo,int hi){


        if(lo > hi) return r;

        int mid = (lo + hi)/ 2;

        r = new Node(keys[mid]);

            r.left = insert(r.left,keys,lo,mid - 1);
            r.right = insert(r.right,keys,mid + 1,hi);

        return r;
    }

    private void print(Node r){

        if(r == null){

        }else {

            System.out.print(r.key);
            System.out.print(" (");
            print(r.left);
            print(r.right);
            System.out.print(") ");
        }
    }

    public  void elems(){
        print(root);
    }

    public void insert (int [] arr){

        root = insert(root,arr,0,arr.length - 1);
    }

    public static void main(String[] args) {

     BSTree t = new BSTree();

     int [] arr = {2,3,5,6,8,9,10,17,20,21};

     t.insert(arr);

     t.elems();

    }



}
