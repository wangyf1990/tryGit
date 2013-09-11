package app;

public class SelectionSort {
	public static void selectionSort(int[] a) {
		for(int i=2 ; i<a.length ; i++) {
			int key = a[i];
			int j = i - 1;			
			while((j >= 0) && (a[j] > key)) {
				a[i] = a[j--];				
			}
			a[j + 1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,5,2,4};
		selectionSort(a);
		for(int i=0 ; i<a.length ; i++) {
			System.out.println(a[i]);
		}

	}

}
