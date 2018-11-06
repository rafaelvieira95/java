package ufc.crateus.algorithms;

import java.util.Random;

public class Sorting implements AbstractSorting {

	private void merge(int [] v,int p,int q,int r) {
		
		int n1 = (q - p + 1);
		int n2 = (r - q);
		int i,j,k;
		int [] v1 = new int[n1 + 1];
		int [] v2 = new int[n2 + 1];
		
		for(i = 0; i < n1;i++) v1[i] = v[p + i];
		
		for(j =0; j < n2;j++) v2[j] = v[q + j + 1];
		
		v1[n1] = Integer.MAX_VALUE;
		v2[n2] = Integer.MAX_VALUE;
		
		i = j = 0;
		
		for(k = p; k <=  r; k++) {
			if(v1[i] <= v2[j])
			{
				 v[k] = v1[i];
				 i++;
			}else {
				v[k] = v2[j];
				j++;
			}
		}
	}
	
	@Override
	public void mergeSort(int[] array, int start, int end) {
		
		if(start < end) {
			
			int q = (start + end)/2;
			mergeSort(array,start,q);
			mergeSort(array,q + 1,end);
			merge(array,start,q,end);
		}

	}

	
	private void swap(int [] v,int i,int j) {
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}
	
	private int partition(int[] v,int p, int r) {
		int i,x;
		x = v[r];
		i = p - 1;
		for(int j =p; j < r; j++) {
			if(v[j] <= x) {
				i++;
				swap(v,i,j);
			}
		}
		swap(v,i + 1,r);
		return i + 1;
	}
	
	 private int randomizedPartition(int [] v, int p, int r) {
		 Random rand = new Random();
	  int i = p + rand.nextInt(r - p + 1);
		 swap(v,i,r);
		 return partition(v,p,r);
	 }
	
	@Override
	public void quickSort(int[] array, int start, int end) {
	
        if(start < end) {
	  int q = randomizedPartition(array, start, end);
	  
	  quickSort(array, start,q - 1);
	  quickSort(array, q + 1, end);
        	
     }

}

	@Override
	public void insertionSort(int[] array) {
		// TODO Auto-generated method stub

	}

	
	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return (2 * i) + 1;
	}

	private int right(int i) {
		return (2 * i) + 2;
	}

private void heapfy(int [] array,int parent, int heapSize) {

		int l = left(parent);
		int r = right(parent);
		int greatest = parent;

		if (l < heapSize && array[l] > array[greatest])
			greatest = l;
		if (r < heapSize && array[r] > array[greatest])
			greatest = r;
		if (greatest != parent) {
			swap(array,parent, greatest);
			heapfy(array,greatest, heapSize);
		}
	}

	@Override
	public void heapSort(int[] array, int n) {
		// TODO Auto-generated method stub
		for (int i = parent(n); i >= 0; i--)
			heapfy(array,i, n);

		for (int k = n; k >= 1; k--) {
			swap(array,0, k);
			heapfy(array,0, k);
		}
	}

}
