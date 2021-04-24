package sorting;

import java.util.Arrays;

	/*Principle for ascending:- compare first and second elements. if e1>e2 than swap. Apply loop
	 * then you will get last element 
	 */
public class BubbleSort {
	/*
	 * T.C =O(n^2)
	 * SC  =O(1)
	 */
	void bubblesort(int arr[]) {
		int size=arr.length;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					arr[j]=arr[j]^arr[j+1];
					arr[j+1]=arr[j]^arr[j+1];
					arr[j]=arr[j]^arr[j+1];
				}
			}
		}
	}
	public static void main(String[] args) {
		int data[]= {-2,45,0,11,-9};
		BubbleSort bs=new BubbleSort();
		bs.bubblesort(data);
		System.out.println(Arrays.toString(data));
		
	}

}
