package br.ufc.crateus.eda.st;

public class AppST {

    public static void main(String[] args) {

       // BinarySearchTreeST<Integer, String> list = new BinarySearchTreeST<>();
        AVLTreeST <Integer, String> list = new AVLTreeST<Integer, String>();
      // RedBlackTreeST list = new RedBlackTreeST();
     //  SeparateChainingHashST list = new SeparateChainingHashST();
     // LinearProbingHashST list = new LinearProbingHashST();
        //LinkedListST list = new LinkedListST();
        //BinarySearchST list = new BinarySearchST();

     // LinearProbingHashST list2 = new LinearProbingHashST();

         //for(int i=1; i < 27; i++) list2.put(new Character((char)(i+64)),i);

      //  for(int i =1; i < 27; i++) list.put(new Character((char) (i+64)),i);
   
//(r.nextInt() & 0x7fffffff)
//for(int  i = 1; i <= 16; i++)  list.put(i,"");	   
   
        
        list.put(10,"rafael");
        list.put(15,"joao");
        list.put(7,"carlos");
        list.put(9,"Vanessa");
        list.put(8,"Vagner");
        list.put(13,"Leandro");
        list.put(12,"Benedito");
        list.put(18,"Pedro");
        list.put(5,"Marcelo");
        list.put(17,"joana");
        

  System.out.println(list.Keys());
    
    //System.out.println(list.floor(11));
   // System.out.println(list.floor(6));
        
        //System.out.println(list2.get('A').equals(list.get('A')));
        //System.out.println(list.contains('P'));
        //list.deleteMax();
        //list.deleteMin();

    }

}
