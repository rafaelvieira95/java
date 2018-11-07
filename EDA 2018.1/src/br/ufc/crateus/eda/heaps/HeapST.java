package br.ufc.crateus.eda.heaps;

public interface HeapST<K extends Comparable<K>> {

	void insert(HeapST<K> h, K key);
	
	K extractMin(HeapST<K> h);
	
	void decreaseKey(HeapST<K> h,K key,K newKey);
	
	boolean isEmpty(HeapST<K> h);
	
	K findMin(HeapST<K> h);
	
	void delete(HeapST<K> h,K key);
	
	HeapST <K> meld(HeapST<K> h1,HeapST<K> h2);
	
	
}
