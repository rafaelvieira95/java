package br.ufc.crateus.eda.tries;
import br.ufc.crateus.eda.st.ST;

import java.util.LinkedList;

public class RWayTrieST <Value> implements StringST<Value> {

    private static final int R = 256;

    private static class Node{

        Object value;
        Node [] next = new Node[R];
        int size;

    }

    private Node root = new Node();


    @Override
    public void put(String s, Value value) {
         root = put(root,s,value,0);
    }

    private Node put(Node r,String key, Value v, int i){

        if(r == null) r = new Node();
        if(i == key.length()){
            r.value = v;
            return r;
        }

        r.size = r.size + 1;

        int ch = key.charAt(i);
        r.next[ch] = put(r.next[ch],key,v,i + 1);

        return r;
    }


    private int size(Node r){
        return  (r == null)? 0 : r.size;
    }

    @Override
    public Value get(String key) {
        Node r = get(root,key,0);
        return (r != null)? (Value) r.value : null;
    }

    private Node get(Node r,String key,int i){
        if(r == null) return null;
        if(i == key.length()) return r;
        int ch = key.charAt(i);
        return get(r.next[ch],key,i + 1);

    }

    @Override
    public void delete(String key) {
        if(key == null) return;
        root = delete(root,key,0);

    }


    private Node delete(Node r,String key,int i){

        if(r == null) return null;

        if(i == key.length()) r.value = null;
     else {

            int ch = key.charAt(i);
            r.next[ch] = delete(r.next[ch], key, i + 1);
        }

        if(r.value != null) return r;
        for(Node n : r.next) if(n != null) return r;

        return null;
    }



    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


    @Override
    public String longestPrefixOf(String str) {
        return null;
    }

    @Override
    public Iterable<String> keysWithPrefix(String str) {
        LinkedList<String> ll = new LinkedList<>();
        Node r = get(root,str,0);
        collect(r,new StringBuilder(str),ll);
        return ll;
    }

      //colect para prefixo
    private  void collect(Node r,StringBuilder prefix,LinkedList <String> ll){
        if(r == null) return;

        if(r.value != null) ll.add(prefix.toString());

        for(char ch = 0; ch < R; ch++){
                prefix.append(ch);

                collect(r.next[ch],prefix,ll);

                prefix.deleteCharAt(prefix.length() - 1);
            }

        }



    @Override
    public Iterable<String> keysThatMatch(String key) {
        LinkedList <String> ll = new LinkedList<>();
        collect(root,new StringBuilder(),key,ll);
        return ll;
    }

    //metodo do keysThatMatch para Rway - trie
    private void collect(Node r,StringBuilder prefix,String key  ,LinkedList<String> ll){
        if(r == null) return;

        int i = prefix.length(); // nesse passo o i sera o valor que ira passear nos indices do padrao passado (StringBuiler vai sendo preenchido
         // a cada iteracao com um novo caractere),  no caso e key sera o padrao

        //se o valor i for igual ao tamanho da string,e o valor encontrado por diferente de null ele adiciona na lista
        if(i == key.length() && r.value != null) ll.add(prefix.toString());
        if(i == key.length()) return; //se i for igual ao tamanho de key encerra a chamada recursiva atual

        char ch = key.charAt(i); //pega o caracetere de posicao i na string key

        for(char j = 0; j < R; j++){
            if(ch == '.' || ch == j){ //aqui ele vai entrar no if quando j for o caractere coringa ou se ele acha a correspondencia com o caracter de ch
                prefix.append(j); // joga no construtor de stringo caratere j
                collect(r.next[j],prefix,key,ll); // chama a funçao recursivamente para a posicao j na arvore
                prefix.deleteCharAt(prefix.length() - 1); // eliminina o buffer da ultima string construida
            }

        }

    }

    @Override
    public Iterable <String> Keys()
    {   LinkedList <String> ll = new LinkedList<>();
    collect(root,"",ll);
        return ll;
    }

    //collect apenas para listar todas as chaves da arvore
    private void collect(Node r, String key, LinkedList<String> ll){
        if(r == null) return;
        if(r.value != null) ll.add(key);
        for(char ch = 0; ch < R; ch++)
            collect(r.next[ch],key + ch,ll);
    }


    @Override
    public String min() {
        return null;
    }

    @Override
    public String max() {
        return null;
    }

    @Override
    public String floor(String key) {
        return (key != null)?floor(root,key,0,new StringBuilder(),null) : null;
    }

    private String floor(Node r, String key, int digit, StringBuilder prefix, String lastKey) {
        if (r == null) return null;

        if (prefix.toString().compareTo(key) > 0) return lastKey;

        if(r.value != null) lastKey = prefix.toString();

        char ch;

        if (digit < key.length()) ch = key.charAt(digit);
        else ch = R - 1;

        boolean flag = true;

        for (char nextChar = ch; flag; nextChar--) {
            if (r.next[nextChar] != null) {
                if (nextChar < ch) flag = false;

                lastKey = floor(r.next[nextChar], key, digit + 1, prefix.append(nextChar), lastKey);

                if (lastKey != null) return lastKey;

                prefix.deleteCharAt(prefix.length() - 1);
            }

            if (nextChar == 0) break;

        }

        return lastKey;
    }

    @Override
    public String ceiling(String e) {
        return (e != null) ?ceiling(root,e,0,new StringBuilder()) : null;
    }

    private String ceiling(Node r,String key, int i,StringBuilder prefix){

        if(r == null) return null;

        if(r.value != null && prefix.toString().compareTo(key) >= 0) return prefix.toString();

        char ch;
        boolean flag = true;

        if(flag  && i < key.length()){
            ch = key.charAt(i);
        }else{
            ch = 0;
        }

        for(char j = ch; j < R; j++){

            if(r.next[j] != null){
                if(j > ch)  flag = false;
            }

            String lastKey = ceiling(r.next[j],key,i + 1,prefix.append(j));

            if(lastKey != null) return lastKey;

            prefix.deleteCharAt(prefix.length() - 1);
        }

        return null;
    }

    @Override
    public String select(int index) {
        return null;
    }

    @Override
    public Iterable<String> keys(String lo, String hi) {
        return null;
    }

    @Override
    public int rank(String e) {
        return (e != null)? rank(root,e,0,0): 0;
    }

    private int rank(Node r,String key,int i,int size){
        if(r == null || i == key.length()) return size;

        if(r.value != null){
          if(i < key.length()) size++;
           else return size;
        }

        char ch  = key.charAt(i);

        for(char j = 0; j < ch; j++)
            size+= size(r.next[j]);


     return rank(r.next[ch],key,i + 1,size);

    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(String lo, String hi) {
        return 0;
    }



}
