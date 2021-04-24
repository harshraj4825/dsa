package sorting;

import java.util.Arrays;
	/*
	 * Principle: Assume we have already have sorted array, than take
	 * a element and insert into sorted array at right position.
	 */

public class InsertionSort {
	/*
	 * T.C =O(n^2)
	 * S.C =O(1)
	 */
	void insertionSort(int arr[]) {
		int size=arr.length;
		for(int i=1;i<size;i++) {
			for(int j=i-1;j>=0;j--) {
				if(arr[j+1]<arr[j]) {
					arr[j+1]=arr[j+1]^arr[j];
					arr[j]=arr[j+1]^arr[j];
					arr[j+1]=arr[j+1]^arr[j];
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int data[]={-2,45,0,11,-9,-8};
		InsertionSort is=new InsertionSort();
		is.insertionSort(data);
		System.out.println(Arrays.toString(data));
		
	}

}
