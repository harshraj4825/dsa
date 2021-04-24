package sorting;

import java.util.Arrays;

/*
	 * Divide and Conquer and recursively solve the problem
	 * Principle: A pivot element chosen from the array. You can 
	 * choose any element from the array as the pivot element
	 * 
	 * element lesser than pivot element are put left and other right
	 */
public class QuickSort {
	/*
	 * Worst case T.C =O(n^2)
	 * Average case T.C =O(n*log(n))
	 * S.C=O(log(n))
	 */
	void quickSort(int[] arr,int low ,int high) {
		if(low>=high)return;
		int pivotIndex=partition(arr,low,high);
		quickSort(arr, low, pivotIndex-1);
		quickSort(arr, pivotIndex+1, high);
	}
	int partition(int arr[],int low,int high) {
		int pivot=arr[high];
		int pivotIndex=low;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<=pivot) {
				//swap(arr, pivotIndex,j)
				int temp=arr[pivotIndex];
				arr[pivotIndex]=arr[j];
				arr[j]=temp;
				pivotIndex++;
			}
		}
		int temp=arr[pivotIndex];
		arr[pivotIndex]=arr[high];
		arr[high]=temp;
		return pivotIndex;
	}

	public static void main(String[] args) {
		int data[]={-2,45,0,11,-9,-8};
		QuickSort qs=new QuickSort();
		qs.quickSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}

}
