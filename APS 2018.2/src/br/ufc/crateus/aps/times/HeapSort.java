package br.ufc.crateus.aps.times;

public class HeapSort {

	int[] array;
	int N;

	public HeapSort(int length) {
		this.array = new int[length + 1];
		this.N = 0;
	}

	private int parent(int i) {
		return i / 2;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	void heapfy(int parent, int heapSize) {

		int l = left(parent);
		int r = right(parent);
		int greatest = parent;

		if (l < heapSize && array[l] > array[greatest])
			greatest = l;
		if (r < heapSize && array[r] > array[greatest])
			greatest = r;
		if (greatest != parent) {
			swap(parent, greatest);
			heapfy(greatest, heapSize);
		}
	}

	public void put(int value) {
		if (array == null) return;
		if (N > array.length) return;
		
		N++;
		array[N] = value;
	}

	public void heapSort() {

		for (int i = parent(N); i >= 1; i--)
			heapfy(i, N);

		for (int k = N; k >= 2; k--) {
			swap(1, k);
			heapfy(1, k);
		}
	}

	void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void array() {
		for (int i = 1; i <= N; i++)
			System.out.print(array[i] + ", ");
	}

}
