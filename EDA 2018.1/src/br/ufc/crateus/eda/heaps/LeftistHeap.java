package br.ufc.crateus.eda.heaps;

import java.util.LinkedList;

public class LeftistHeap <K extends Comparable <K>> {

	
	private class Node{
		
		K key;
		Node left;
		Node right;
		
		public Node(K key) {
			this.key = key;
		}
	}
	
	private Node root;
	
   private int CCN(Node r) {
		if(r == null) return 0;
		return 1 + Math.min(CCN(r.left),CCN(r.right));
	}
	
	
	public void insert(LeftistHeap<K> h, K key) {
		if(h == null) return;
		if(key == null) return;
		h.root = merge(h.root, new Node(key));
	}

	public K extractMin(LeftistHeap<K> h) {
	if(h == null) return null;
	
	K key = h.root.key;
	h.root = merge(h.root.left,h.root.right);	
	
		return key;
	}

	
	void decreaseKey(LeftistHeap<K> h,K newKey) {
		
		extractMin(h);
		insert(h, newKey);
	}
	
	void delete(LeftistHeap<K> h) {
		extractMin(h);
	}
	
	public boolean isEmpty(LeftistHeap<K> h) { return root == null; }
	
	public K findMin(LeftistHeap<K> h) {
		return (h.root == null)? null : h.root.key;
	}

	
	public LeftistHeap<K> meld(LeftistHeap<K> h1, LeftistHeap<K> h2) {
		
		LeftistHeap <K> h3 = new LeftistHeap<>();
		h3.root = merge(h1.root,h2.root);
		
		return h3;
	}
	
	private Node merge(Node h1,Node h2) {
		
		if(h1 == null) return h2;
		if(h2 == null) return h1;
		
		Node least,most;
		
		if(h1.key.compareTo(h2.key) < 0) {
			least = h1;
			most = h2;
		}else {
			least = h2;
			most = h1;
		}
		
		least.right = merge(least.right,most);
		
			if(least.left == null) {
				least.left = least.right;
				least.right = null;
				
			}else if(CCN(least.left) < CCN(least.right)) {
           
				 Node t = least.left;
			     least.left = least.right;
		 	     least.right = t;
		}
			
		return least;
	}

	public void Keys() {
		
		keys(root);
	
	}
	
	private void keys(Node r) {
		if(r == null) {
			
		}else {
			
			System.out.print(r.key);
			System.out.print(" (");
			keys(r.left);
			keys(r.right);
			System.out.print(") ");
		}
		
	}
	
}
