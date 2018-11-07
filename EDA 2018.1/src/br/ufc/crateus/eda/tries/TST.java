package br.ufc.crateus.eda.tries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class TST<Value> implements StringST<Value> {

	private Node root;
	private int count;

	private class Node {

		Value value;
		char ch;
		Node left, mid, right;
		int size;

		public Node(char ch) {
			this.ch = ch;
		}

	}

	private Node put(Node r, String key, Value value, int i) {
		char ch = key.charAt(i);
		
		if (r == null) r = new Node(ch);
		
		r.size = 1 + size(r.left) + size(r.mid) + size(r.right);

		if (ch < r.ch) r.left = put(r.left, key, value, i);
		else if (ch > r.ch) r.right = put(r.right, key, value, i);
		else if (i == key.length() - 1) r.value = value;
		 else  r.mid = put(r.mid, key, value, i + 1);
		return r;
	}

	@Override
	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}

	private Node get(Node r, String key, int i) {
		if (r == null)
			return null;
		char ch = key.charAt(i);
		if (ch < r.ch)
			return get(r.left, key, i);
		if (ch > r.ch)
			return get(r.right, key, i);
		if (i == key.length() - 1)
			return r;
		return get(r.mid, key, i + 1);
	}

	@Override
	public Value get(String key) {
		Node r = get(root, key, 0);
		return (r != null) ? r.value : null;
	}

	private Node delete(Node r, String key, int i) {
		if (r == null)
			return null;

		if (i == key.length() - 1) {
			if (r.value != null)
				r.value = null;
		} else {

			char ch = key.charAt(i);
			if (ch < r.ch)
				r.left = delete(r.left, key, i);
			else if (ch > r.ch)
				r.right = delete(r.right, key, i);
			else
				r.mid = delete(r.mid, key, i + 1);
		}

		if (count == 0) {
			if (r.left == null && r.right == null)
				return null;
			if (r.left == null)
				return r.right;
			if (r.right == null)
				return r.left;
			else {
				Node aux = r;
				r = max(aux.left);
				r.left = deleteMax(aux.left);
				r.right = aux.right;
			}
		}

		return r;
	}

	private Node max(Node r) {
		if (r.right == null)
			return r;
		return max(r.right);
	}

	private Node deleteMax(Node r) {
		if (r.right == null)
			return r.left;
		r.right = deleteMax(r.right);
		return r;
	}

	@Override
	public void delete(String key) {
		root = delete(root, key, 0);
	}

	@Override
	public boolean contains(String key) {
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
	public Iterable<String> Keys() {
		LinkedList<String> list = new LinkedList<>();
		collect(root, new StringBuilder(), list);
		return list;
	}

	// funçao para o passeio em ordem, varre a L R R
	private void collect(Node r, StringBuilder prefix, LinkedList<String> ll) {
		if (r == null)
			return;
		collect(r.left, prefix, ll);
		if (r.value != null)
			ll.add(prefix.toString() + r.ch);

		collect(r.mid, prefix.append(r.ch), ll);
		prefix.deleteCharAt(prefix.length() - 1);
		collect(r.right, prefix, ll);
	}

	@Override
	public String longestPrefixOf(String key) {
		if (key == null) return null;
		int len = search(root, key, 0, 0);
		
		return key.substring(0, len);
	}

	private int search(Node r, String key, int i, int length) {
		if (r == null) return length;

		if (r.value != null)  length = i + 1;

		char ch = key.charAt(i);

		if (ch < r.ch)
			return search(r.left, key, i, length);
		else if (ch > r.ch)
			return search(r.right, key, i, length);
		else if (i < key.length() - 1) {
			return search(r.mid, key, i + 1, length);
		} else {
			return length;
		}
	}

	@Override
	public Iterable<String> keysWithPrefix(String key) {
		if (key == null)
			return null;

		Node r = get(root, key, 0);
		LinkedList<String> list = new LinkedList<>();

		if (r == null)  return list;
		if (r.value != null) list.add(key);

		collect(r.mid, new StringBuilder(key), list);

		return list;
	}

	@Override
	public Iterable<String> keysThatMatch(String key) {
		if (key == null) return null;

		LinkedList<String> list = new LinkedList<>();
		collect(root, new StringBuilder(), key, list);

		return list;
	}

	// collect para coletar as String com o caracter coringa
	private void collect(Node r, StringBuilder prefix, String key, LinkedList<String> ll) {
		if (r == null)
			return;

		int i = prefix.length(); // inicia o i com 0, tamanho atual do stringBuilder
		char ch = key.charAt(i); // inicia pelo caractere da posiçao 0, ou seja, diferente de '0/'

		if (ch == '.' || ch < r.ch) { // se ch for um ponto ou ch < o caracter da raiz chama a collect para a esquerda
			collect(r.left, prefix, key, ll); // varre toda a sub- arvore que casou com o padrao do ponto ou menor que o
												// caractere
		}

		if (ch == '.' || ch == r.ch) { // verifica se ch tem ponto, ou seja "s.." sea , she por exemplo, neste caso um
										// dos dois sera verdade.
			if (i == key.length() - 1 && r.value != null) { // aqui verifica se o prefix do stringBuilder tem o tamanho
															// da key e se o valor associado
				// nao e nulo
				ll.add(prefix.toString() + r.ch); // aqui ele adiciona a String que casou com o padrao
			} else if (i < key.length() - 1) { // se o tamanho do prefixo for menor que o tamanho de key, a busca ira
												// para o meio
				collect(r.mid, prefix.append(r.ch), key, ll); // o proximo caractere esta no proximo nivel da arvore,
																// por isso desce em mid
				prefix.deleteCharAt(prefix.length() - 1); // deleta o ultimo prefixo do stringBuilder de tamanho
															// length() - 1, pois como ele ja
				// computou o valor, ele elimina para nao ter replicas
			}
		}

		if (ch == '.' || ch > r.ch)
			collect(r.right, prefix, key, ll); // aqui basicamente chama a busca do padrao para direita, se ch for igual
												// ao ponto ou
		// se o caractere de key e maior que o da raiz
	}

	private String replaceString(String word) throws IOException {

		String setr = "";
		int i = 0;
		for (int j = 0; j < word.length(); j++) {
			i = word.charAt(j);
			if ((0 <= i && i <= 47) && (32 != i && i != 46))
				setr += "?";
			else if (58 <= i && i <= 64)
				setr += "?";
			else if (65 <= i && i <= 90)
				setr += word.charAt(j);
			else if (91 <= i && i <= 96)
				setr += "?";
			else if (123 <= i && i <= 191)
				setr += "?";
			else if (i > 266)
				setr += "?";
			else
				setr += word.charAt(j);

		}

		setr = setr.replaceAll("[ã,â,à,á,ä]", "a").replaceAll("[ê,è,é,ë]", "e").replaceAll("[î,ì,í,ï]", "i")
				.replaceAll("[õ,ô,ò,ó,ö]", "o").replaceAll("[û,ú,ù,ü]", "u").replaceAll("Ã,Â,À,Á,Ä", "A")
				.replaceAll("[Ê,È,É,Ë]", "E").replaceAll("Î,Ì,Í,Ï", "I").replaceAll("Õ,Ô,Ò,Ó,Ö", "O")
				.replaceAll("[Û,Ù,Ú,Ü]", "U").replace('ç', 'c').replace('Ç', 'C').replace('ñ', 'n').replace('Ñ', 'n');

		setr = setr.toLowerCase();

		return setr;

	}

	public void createText(File input, File output) throws IOException {

		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));

		FileWriter fw = new FileWriter(output);
		PrintWriter pw = new PrintWriter(fw);

		while (br.ready()) {
			String x = replaceString(br.readLine());
			pw.println(x);
		}

		fr.close();
		br.close();
		fw.close();
		pw.close();
	}

	public void searchMoviesTST(File input, String str) throws IOException {

		StringST<Integer> st = new TST<Integer>();

		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		
		while (br.ready()) {
			String x = br.readLine();
			int i = x.indexOf(" (");
			st.put(replaceString(x.substring(0, i)), i);
		}

			System.out.println("Filmes com o Prexixo:  " + str);
			System.out.println(st.keysWithPrefix(str));

			System.out.println("Filme com prefixo mais longo:  " + str);
			System.out.println(st.longestPrefixOf(str));

			System.out.println("Filme que casa com caractere Coringa (caso for usado na consulta):" + str);
			System.out.println(st.keysThatMatch(str));

		br.close();
		
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
	public String floor(String e) {
		return null;
	}

	@Override
	public String ceiling(String e) {
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
		return (e != null) ? rank(root, e, 0, 0) : 0;
	}

	private int rank(Node r, String key, int i, int length) {
		if (r == null)
			return length;

		char ch = key.charAt(i);

		if (ch < r.ch)
			return rank(r.left, key, i, length);
		else if (ch > r.ch) {
			if (r.value != null)
				length++;
			return size(r.left) + size(r.mid) + rank(r.right, key, i, length);

		} else if (i < key.length() - 1) {

			if (i < key.length() - 1 && r.value != null)
				length++;

			return size(r.left) + rank(r.mid, key, i + 1, length);
		} else {
			return size(r.left) + length;
		}

	}

	private int size(Node r) {
		if (r == null)
			return 0;
		return r.size;
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
