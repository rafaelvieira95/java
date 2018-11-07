package ufc.crateus.algorithms;

public class AppSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Sorting sort = new Sorting();
   int [] arr = {10,3,4,2,1,17,12,98,55,43,21};
   sort.mergeSort(arr, 0, arr.length - 1);
   //sort.quickSort(arr, 0, arr.length - 1);
  // sort.heapSort(arr, arr.length - 1);
   for(int i: arr) System.out.print(i+", ");
   
	}

}
