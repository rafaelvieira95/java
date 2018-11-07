package ufc.crateus.algorithms;

public interface AbstractSorting {

	void mergeSort(int [] array,int start,int end);
	
	void quickSort(int [] array,int start, int end);
	
	void heapSort(int [] array,int n);
	
	void insertionSort(int [] array);
	
}
