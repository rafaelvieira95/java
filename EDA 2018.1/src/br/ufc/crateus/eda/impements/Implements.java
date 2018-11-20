package br.ufc.crateus.eda.impements;

import br.ufc.crateus.eda.st.*;

import java.io.*;


public class Implements extends LinearProbingHashST<Object, Object> {

	private int hash(String x) {
		return (x.hashCode() & 0x7fffffff % 31);
	}

	// Questao 02 dos polinomios
	private static LinkedListST<Integer, Integer> multiply(LinkedListST<Integer, Integer> p1,
			LinkedListST<Integer, Integer> p2) {

		LinearProbingHash<Integer, Integer> temp = new LinearProbingHash<Integer, Integer>();
		LinkedListST<Integer, Integer> p3 = new LinkedListST<Integer, Integer>();

		for (Integer x : p1.Keys()) {
			for (Integer y : p2.Keys()) {

				int coef = x * y;
				int expX = p1.get(x);
				int expY = p2.get(y);
				int sumExp = expX + expY;
				temp.put(coef, sumExp);
			}
		}

		for (Integer i : temp.Keys()) {
			for (Integer j : temp.Values()) {
				p3.put(i, j);
			}
		}

		return p3;
	}


	public static void main(String[] args) throws IOException {
		/*
		 * 
		 * LinkedListST <Integer,Integer> p1 = new LinkedListST(); LinkedListST
		 * <Integer,Integer> p2 = new LinkedListST();
		 * 
		 * p1.put(3,1); p1.put(2,2);
		 * 
		 * p2.put(4,7); p2.put(3,1);
		 * 
		 * System.out.println(multiply(p1,p2).elements());
		 * 
		 *
		 * 
		 */
//		 SeparateChainingHash <Integer,Integer> st = new SeparateChainingHash<>();

	//	 st.generateTests();

		File Dictionary = new File("/home/rafael/Documentos/newDic.txt");
		File DictionaryPersonal = new File("/home/rafael/Documentos/DicionarioPessoal2.txt");

		SpellCheckerHash dict = new SpellCheckerHash();
		dict.spellChecker(Dictionary, DictionaryPersonal);

	}

}
