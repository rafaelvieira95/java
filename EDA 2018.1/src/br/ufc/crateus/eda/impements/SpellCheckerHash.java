package br.ufc.crateus.eda.impements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Mini Corretor Ortografico, com tres regras simples e comuns de correcao,
 . adiçao de caracter
 . subtracao de caracter
 . inversao de caracteres adjacente
Build by: Rafael Lima Vieira
 */
    
public class SpellCheckerHash {

	
	private static int M = 18279;
	private static class Node {
		String key;
		Integer value;
		Node next;

		public Node(String key, Integer value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	private Node[] arr;
	private int count;

	public SpellCheckerHash(int m) {
		this.arr = new Node[m];
	  this.M = m;
	}

	public SpellCheckerHash() {
		this(M);
	}

	private int hash(String key) {	
		if(key.length() ==  1) return (key.hashCode()  & 0x7fffffff % M);
		if(key.length() == 2 ) return (key.substring(0, 1).hashCode()  & 0x7fffffff % M);
		else return (key.substring(0, 2).hashCode()  & 0x7fffffff % M);
	}

	public void put(String key, Integer value) {

		if (key == null) return;
		if (value == null) this.delete(key);

		int k = hash(key);

		for (Node p = arr[k]; p != null; p = p.next) 		
			if (key.equals(p.key)) return;			
		
		
		arr[k] = new Node(key, value, arr[k]);

		count++;

		//if(count / M <= 0.5) resize(2*M);

	}

	public Integer get(String key) {

		for (Node p = arr[hash(key)]; p != null; p = p.next)
			if (key.equals(p.key))
				return (Integer) p.value;

		return null;
	}

	private Node delete(Node r, String key) {

		if (r == null)
			return null;

		if (key.equals(r.key)) {
			r = r.next;
			count--;
		} else
			r.next = delete(r.next, key);

		return r;
	}

	public void delete(String key) {
		if (key == null)
			return;
		arr[hash(key)] = delete(arr[hash(key)], key);
	}

	
	private void resize(int m) {

		SpellCheckerHash newArr  = new SpellCheckerHash(m);

		for (int i = 0; i < M; i++) {
			if (arr[i] != null) {
				for (Node p = arr[i]; p != null; p = p.next) {
					newArr.put((String) p.key, (Integer) p.value);
				}
			}

		}

		this.arr = newArr.arr;
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public Iterable<String> Keys() {
		LinkedList<String> list = new LinkedList<String>();
		return listKeys(list, 0);
	}

	private LinkedList<String> listKeys(LinkedList<String> list, int current) {

		if (current >= arr.length)
			return null;
		Node p = arr[current];
		if (p != null) {
			do {
				list.add((String) p.key);
				p = p.next;
			} while (p != null);
		}
		listKeys(list, current + 1);

		return list;
	}

	// Spell Checker
	public void spellChecker(File Dictionary, File DictionaryPersonal) throws IOException {

		FileReader fr = new FileReader(Dictionary);
		FileReader dp = new FileReader(DictionaryPersonal);
		BufferedReader br = new BufferedReader(fr);
		BufferedReader brp = new BufferedReader(dp);
		SpellCheckerHash dictionary = new SpellCheckerHash();
		int acc = 0;
		if (Dictionary.exists() && DictionaryPersonal.exists())
			while (br.ready())
				dictionary.put(br.readLine(), acc++);

		int count = 1;
		while (brp.ready()) {
			String str = brp.readLine();
			boolean x = checkWords(dictionary, str);

			if (!x) {

				List<String> suggestAddChar = probeWordsAddChar(dictionary, str);

				if (suggestAddChar != null) {
					System.out.println("esta palavra nao foi econtrada: " + str + "\n erro na linha: " + count
							+ "\n 1 sugestao de correcao (Add char): " + suggestAddChar.toString());
					System.out.println("-----------------------------------");
				}else {
			
					List<String> suggestSubChar = probeWordsSubChar(dictionary, str);
					
					if (suggestSubChar != null) {
					System.out.println("esta palavra nao foi econtrada: " + str + "\n erro na linha: " + count
							+ "\n 2 sugestao de correcao (Sub Char): " + suggestSubChar.toString());
					System.out.println("-----------------------------------");
				}else {
					
				List<String> suggestInvChar = probeInverseChar(dictionary, str);

				if (suggestInvChar != null) {
					System.out.println("esta palavra nao foi econtrada: " + str + "\n erro na linha: " + count
							+ "\n 3 correcao (Inverse Char): " + suggestInvChar.toString());
					System.out.println("-----------------------------------");

				}

				if (suggestAddChar == null && suggestSubChar == null && suggestInvChar == null) {
					System.out.println("esta palavra nao foi econtrada: " + str + "\n erro na linha: " + count
							+ "\n essa palavra nao possui correçao !! ");
					System.out.println("-----------------------------------");
			    	}
			 	}
			}
			}

			count++;

		}

		br.close();
		brp.close();

	}

	private List<String> probeInverseChar(SpellCheckerHash sp, String words) {
		List<String> list = new ArrayList<String>();

		for (Node p = sp.arr[sp.hash(words)]; p != null; p = p.next) {

			if (p.key.length() == words.length()) {
				if (sp.equalsWords(p.key, words)) {
					list.add(p.key);
				}
			}
		}
		return (!list.isEmpty() ? list : null);
	}

	// essa tecnica resolve somar todos os componentes da String, logo gera o valor
	// total da soma dos caraceteres
	// como a funçao hash joga para a lista que começa com a primeira letra, se os
	// caracteres estiverem invertidos a soma sera igual a da palavra correta
	// portanto a palavra existe e sera corrigida.
	private int hashChar(String x) {
		int hashx = 0;
		for (int i = 0; i < x.length(); i++)
			hashx += x.charAt(i);

		return hashx;
	}

	public boolean equalsWords(String words, String input) {
		return (hashChar(words) == hashChar(input));
	}

	// x é a palavra errada e y a correta
	private boolean myCompareAddChar(String x, String y) {

		int strX = hashChar(x);
		int strY = hashChar(y);

		int acc = 0;
		for (int i = 97; i < 123; i++) {
			acc = strX + i;
			if (acc == strY) {
				if (y.startsWith(x.substring(0, 2)))  return true;
			}
		}
		return false;
	}

	private List<String> probeWordsAddChar(SpellCheckerHash sp, String words) {
		List<String> list = new ArrayList<String>();
		for (Node p = sp.arr[hash(words)]; p != null; p = p.next) {
			if (words.length() == p.key.length() - 1) {
				if (myCompareAddChar(words, p.key))
					list.add(p.key);

			}
		}

		return (!list.isEmpty()) ? list : null;
	}

	private boolean myCompareSubChar(String x, String y) {

		int strX = hashChar(x);
		int strY = hashChar(y);

		int acc = 0;
		for (int i = 97; i < 123; i++) {
			acc = strX - i;
			if (acc == strY) {
				if (y.startsWith(x.substring(0, 2))) 	return true;
			}
		}
		return false;
	}

	private List<String> probeWordsSubChar(SpellCheckerHash sp, String words) {
		List<String> list = new ArrayList<String>();

		for (Node p = sp.arr[sp.hash(words)]; p != null; p = p.next) {
			if (words.length() - 1 == p.key.length())
				if (myCompareSubChar(words, p.key)) list.add(p.key);
		}

		return (!list.isEmpty()) ? list : null;
	}

	private boolean checkWords(SpellCheckerHash sp, String words) {

		for (Node p = sp.arr[hash(words)]; p != null; p = p.next) {
			if (words.equals(p.key))
				return true;
		}

		return false;
	}

}
