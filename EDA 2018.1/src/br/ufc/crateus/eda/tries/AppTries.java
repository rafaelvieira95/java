package br.ufc.crateus.eda.tries;

import java.io.File;
import java.io.IOException;

public class AppTries {

    public static void main(String[] args) throws IOException {

        TST <Integer>  st = new TST<>();
        
     //   st.put("Rene", 0);
      //  st.put("Re", 1);
      //  st.put("Algorithms", 2);
      //  st.put("Algo", 3);
      //  st.put("Algor", 4);
       // st.put("Tree", 5);
       // st.put("Trie", 6);
       /// st.put("TST", 7);
       // st.put("Trie123", 8);

       // trie.delete("sells");
        //trie.delete("shore");

        // System.out.println(st.keysWithPrefix("Al"));
        //System.out.println(trie.keysThatMatch("s.."));
        //System.out.println(((RWayTrieST<Integer>) st).ceiling("Tre"));
        //System.out.println(((RWayTrieST<Integer>) st).floor("Trie1"));
        //System.out.println(st.rank("Re"));
    // File file = new File("/home/rafael/Documentos/brazilian");
  //    File newFile = new File("/home/rafael/Documentos/newDic.txt");
   
       // st.createText(file, newFile);
        File file = new File("/home/rafael/Documents/movies.txt");
        st.searchMoviesTST(file,args[0]);
        
        
    }
}
