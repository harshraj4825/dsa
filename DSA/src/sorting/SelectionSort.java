package sorting;

import java.util.Arrays;

/*
	 * Principle: find the minimum/maximum element and swap with
	 * right position
	 */
public class SelectionSort {
	//ascending order
	/*
	 * T.C= O(n^2)
	 * S.C= O(1)
	 */
	void selectionSort(int arr[]) {
		int size=arr.length;
		int min;
		int tempIndex;
		for(int i=0;i<size;i++) {
			tempIndex=i;
			min=Integer.MAX_VALUE;
			for(int j=i;j<size;j++) {
				if(min>arr[j]) {
					min=arr[j];
					tempIndex=j;
				}
			}
			if(i!=tempIndex) {
				arr[i]=arr[i]^arr[tempIndex];
				arr[tempIndex]=arr[i]^arr[tempIndex];
				arr[i]=arr[i]^arr[tempIndex];
			}
		}
	}
	public static void main(String[] args) {
		int data[]= {-2,45,0,11,-9};
		SelectionSort ss=new SelectionSort();
		ss.selectionSort(data);
		System.out.println(Arrays.toString(data));
	}

}
