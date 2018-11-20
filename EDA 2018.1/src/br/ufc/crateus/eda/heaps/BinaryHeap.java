package br.ufc.crateus.eda.heaps;

import java.util.LinkedList;
import java.util.List;

public class BinaryHeap<K extends Comparable<K>>{

	
	private int N=0;
	private K [] heap;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap(int h) {
		this.heap = (K [])new Comparable[h];
	
	}
	
	 public BinaryHeap() {
		this(32);
	}
	
	 //no pai
	 private int parent(int i) { return (i- 1)/2; }
	 //filho direito
	 private int right(int i) {return (2*i + 2);}
	 //filho esquerdo
	 private int left(int i) {return (2*i + 1);}
	 
	public void insert(BinaryHeap<K> h, K key) {
		if(h == null) return;
	    if(N == h.heap.length - 1) return;
	  
	  N++;
	  int i = N - 1;
	  h.heap[i] = key;
	  
	  swim(i);
	
	}

	
	public K extractMin(BinaryHeap<K> h) {
		

	    if (N <= 0) return null;
	    if (N == 1)
	    {
	        N--;
	        return h.heap[0];
	    }
 
	    K root = h.heap[0];
	    h.heap[0] = h.heap[N - 1];
	    N--;
	    sink(0);

		return root;
	}

	
	public void decreaseKey(BinaryHeap<K> h, K key, K newKey) {
		if(h == null || h.N == 0) return;
		int i;
		for(i = 0;i < N; i++)
			if(key.equals(h.heap[i])) break;
	
	    h.heap[i] = newKey;
	    
	    swim(i);

	}

	public boolean isEmpty(BinaryHeap<K> h) { return N == 0; }

	public K findMin(BinaryHeap<K> h) { return (N > 0)? h.heap[0]: null; }
	
	public void delete(BinaryHeap<K> h, K key) {
		
   decreaseKey(h, key, h.heap[0]);		
   extractMin(h);	    
   
	}


	public BinaryHeap <K> meld(BinaryHeap<K> h1, BinaryHeap<K> h2) {
	 	
		BinaryHeap<K> h3 = new BinaryHeap<K>(h1.N + h2.N + 1);
		int maxHeap = 0;
		int minHeap = 0;
	
		
		   if(h1.N >= h2.N) {
			   
			maxHeap = h1.N; 
			minHeap = h2.N;
			
	      	  int i;
	      	  int k =0;
				for(i = 0; i < maxHeap && k < minHeap; i++) {	
					
					if(h1.heap[i].compareTo(h2.heap[k]) < 0)
						h3.insert(h3, h1.heap[i]);
					else {
						i--;
						h3.insert(h3, h2.heap[k]);
						k++;
					}					
				}
			
			
		if(k == h2.N) {
				for(int j = i; j < maxHeap; j++)
					h3.insert(h3, h1.heap[j]);
		}
		
		if(i == h1.N) {
			for(int j = k; j < minHeap; j++)
			h3.insert(h3, h2.heap[j]);
		}
		
		}else if(h1.N < h2.N) {
	 
			maxHeap = h2.N;
			minHeap = h1.N;
			
			  int i;
	      	  int k =0;
				for(i = 0; i < maxHeap && k < minHeap; i++) {	
					
					if(h2.heap[i].compareTo(h1.heap[k]) < 0) 
						h3.insert(h3, h2.heap[i]);
					 else {
						i--;
						h3.insert(h3, h1.heap[k]);
						k++;
					}
					
				}
				
				if(k == h1.N) {
					for(int j = i; j < maxHeap; j++)
						h3.insert(h3, h2.heap[j]);
			}
			
			if(i == h2.N) {
				for(int j = k; j < minHeap; j++)
				h3.insert(h3, h1.heap[j]);
			}		
		
		} 
		
		   return h3;
	}

	private void sink(int i) {
		
		    int l = left(i);
		    int r = right(i);
		    int smallest = i;
		    if (l < N && heap[l].compareTo(heap[i]) < 0)
		        smallest = l;
		    if (r < N && heap[r].compareTo(heap[smallest]) < 0)
		        smallest = r;
		    if (smallest != i)
		    {
		        swap(i, smallest);
		        sink(smallest);
		    }
	}
		
	
	private void swim(int i) {
		
		  while(i != 0 && heap[parent(i)].compareTo(heap[i]) > 0) {
	
			  swap(i,parent(i));
			  i = parent(i);
		  }
	}
	
	private void swap(int i,int j) {
		K key = heap[i];
		heap[i] = heap[j];
		heap[j] = key;
	}

		
	public void Keys() {
		if(N==0) return;
		List <K> ll = new LinkedList<K>();
		for(K key : heap) {
			   if(key != null)
				ll.add(key);
		}
	System.out.println(ll.toString());
	}
	
}
