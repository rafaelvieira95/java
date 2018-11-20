package br.ufc.crateus.eda.heaps;

import java.util.LinkedList;
import java.util.List;

public class DWayHeap <K extends Comparable <K>>{

	private K [] heap;
	private int N = 0;
	private int heapOrder;
	
	@SuppressWarnings("unchecked")
	public DWayHeap(int order,int length) {
		
		this.heap = (K []) new Comparable[length];
		this.heapOrder = order;
		
	}
	
	//por padrão,  a heap assumirá uma heap ternária
	public DWayHeap() { this(3,32); }
	
	public void insert(DWayHeap<K> h, K key) {
		if(h == null) return;
		
		N++;
		h.heap[N] = key;
		swim(N);
		
	}

	
	
	public K extractMin(DWayHeap<K> h) {
		
		if(h.N == 0) return null;
		
		N--;
		K key = h.heap[1];
		swap(h.heap,1,N + 1);
		h.heap[N + 1] = null;
		h.sink(1);
		
		return key;
	}

	
	public void decreaseKey(DWayHeap<K> h, K key, K newKey) {
		int i;
		for(i = 1; i <= h.N; i++)
			if(key.equals(h.heap[i])) break;
		
		
		h.heap[i] = newKey;
		
		if(h.heap[i].compareTo(h.heap[getParent(i)]) < 0) {
			swap(h.heap,getParent(i),i);
			i = getParent(i);
			swim(i);
		}
		
	}



	public boolean isEmpty(DWayHeap<K> h) { return h.N == 0; }

	
	public K findMin(DWayHeap<K> h) {
		return (h != null && N > 0)? heap[1]: null;
	}

	
	public void delete(DWayHeap<K> h, K key) {
	
	   decreaseKey(h, key, h.heap[1]);
	   extractMin(h);	
	}

	
	//Operação de Meld tem custo N + M, ou seja, o total de elementos de h1 + h2, e algumas opeçãoes de Swap que tem custo constante, logo não afeta
	//o custo O(N+M) operações
	public DWayHeap<K> meld(DWayHeap<K> h1, DWayHeap<K> h2) {
	
		DWayHeap<K> h3 = new DWayHeap<K>(h1.heapOrder,h1.N + h2.N + 1);
		int maxHeap = 0;
		int minHeap = 0;
		
		   if(h1.N >= h2.N) {
			   
			maxHeap = h1.N; 
			minHeap = h2.N;
			
	      	  int i;
	      	  int k =1;
				for(i = 1; i <= maxHeap && k <= minHeap; i++) {	
					
					if(h1.heap[i].compareTo(h2.heap[k]) < 0)
						h3.insert(h3, h1.heap[i]);
					else {
						i--;
						h3.insert(h3, h2.heap[k]);
						k++;
					}					
				}
				
		if(k == h2.N + 1) {
				for(int j = i; j <= maxHeap; j++)
					h3.insert(h3, h1.heap[j]);
		}
		
		if(i == h1.N + 1) {
			for(int j = k; j <= minHeap; j++)
			h3.insert(h3, h2.heap[j]);
		}
		
		}else if(h1.N < h2.N) {
	 
			maxHeap = h2.N;
			minHeap = h1.N;
			
			  int i;
	      	  int k =1;
				for(i = 1; i <= maxHeap && k <= minHeap; i++) {	
					
					if(h2.heap[i].compareTo(h1.heap[k]) < 0) 
						h3.insert(h3, h2.heap[i]);
					 else {
						i--;
						h3.insert(h3, h1.heap[k]);
						k++;
					}
					
				}
				
				if(k == h1.N + 1) {
					for(int j = i; j <= maxHeap; j++)
						h3.insert(h3, h2.heap[j]);
			}
			
			if(i == h2.N + 1) {
				for(int j = k; j <= minHeap; j++)
				h3.insert(h3, h1.heap[j]);
			}		
					
		}
			
		return h3;
	}

	//usado para pegar o pai do Nó de indice i
	private int getParent(int i) { return ((i + (heapOrder - 2))/ heapOrder); }
		
	//usado apra pegar o filho de determinado Nó pai
	private int getChildren(int i) { return (i * heapOrder - (heapOrder - 2));} 
	
	 private void swim(int index) {
		 
	        int parentIndex = getParent(index); //obtem o pai do indice inex

	        while (parentIndex >= 1) { // enquanto o incide por maior ou igual ao minimo
	            if (heap[parentIndex].compareTo(heap[index]) > 0) { //se o pai for maior que o indice
	          
	                     swap(heap, parentIndex, index); // precisa realizar a operação de swap com custo constante
	            } else {
	                break; // se a arvoe não tiver nenhuma violação, apenas encerra a iteração.
	            }

	            index = parentIndex;
	            parentIndex = getParent(index);
	        }
	    }
	
	 private void sink(int index) {
		 
	        int childSmallestIndex = getChildren(index); //obtem o primeiro filho de determinando pai, se é o primeiro ele deve ser o menor
	        int childHighestIndex = (index * heapOrder + 1); //obtem o filho com maior valor, ex: quero o indice 1 [_,3 , 4, 5, 7, 9,15]
	        //suponha que seja uma heap ternária o maior filho de 3 será 1 * 3 + 1 = 4, ou seja o valor 7.

	        while (childSmallestIndex <= N) { //enquanto o indice de menor filho por menor que o total de elementos 

	            int selectedChildIndex = childSmallestIndex; //selecina o menor filho 

	          //começa a iteração comparando com o proximo irmao, ou seja, ignora compara-lo consigo mesmo, isso até chegar no irmão de valor maior.  
	         for(int childIndex = childSmallestIndex + 1; childIndex <= childHighestIndex; childIndex++) {
	               if (childIndex <= N && heap[selectedChildIndex].compareTo(heap[childIndex]) > 0)
	               {
	                    selectedChildIndex = childIndex; // se o menor elemento dessa subarvore for maior que algum irmao, se o "menor irmao" for
	                    // maior que algum outro, o menor passa a ser o irmão menor que ele.
	                }
	            }
	         
	            if (heap[selectedChildIndex].compareTo(heap[index]) < 0) { // aqui verifica se esse menor elemento é menor que o pai,
	            	//caso seja, acontece uma troca.
	               
	            	swap(heap, index, selectedChildIndex); // efetivação da troca
	                
	            } else {
	                break; // se a arvore estiver com as propriedades a iteração é interrompida.
	            }
	            
 
	            index = selectedChildIndex; // aqui o indice fica sendo o menor
	            childSmallestIndex = getChildren(index);  // o menor filho fica sendo o filho desse menor filho (hieraquia)
	            childHighestIndex = (index * heapOrder + 1);  // o maior filho fica sendo o ultimo do nó
	            
	        }
	    }
	 
	private void swap(Comparable <K> [] heap, int i, int j) {
		Comparable <K>  h1 =  heap[i];
		heap[i] = heap[j];
		heap[j] = h1;
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
