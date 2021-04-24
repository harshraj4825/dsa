package sorting;

import java.util.Arrays;

/* 
	 * Divide and Conquer Strategy
	 * Principle: Divide array in two part and then sort it then merge both
	 * Two part
	 * 1. main part/ dividing and sorting recursive
	 * 2. merge left and right
	 */
public class MergeSort {
	/*
	 * T.C=n*log(n)+n=O(n*log(n))
	 * S.C=O(n)
	 */
	void mergeSort(int arr[],int low,int high) {
		if(low<high) {
			int mid=low+(high-low)/2;
			mergeSort(arr,low,mid);		//T1=T(n/2)
			mergeSort(arr,mid+1,high);	//T2=T(n/2)
			merge(arr,low,mid,high);	//T3=n
		}
	}
	/*
	 * T.C of merge=O(n);
	 */
	void merge(int arr[],int low,int mid,int high) {
		int nl=mid-low+1;
		int nr=high-mid;
		int L[]=new int[nl];
		int R[]=new int[nr];
		for(int i=0;i<nl;i++) {
			L[i]=arr[low+i];
		}
		for(int i=0;i<nr;i++) {
			R[i]=arr[mid+1+i];
		}
		int i=0,j=0;
		int k=low;
		while(i<nl && j<nr) {
			if(L[i]<=R[j]) {
				arr[k]=L[i];
				i++;
			}
			else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<nl) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<nr) {
			arr[k]=R[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int data[]={-2,45,0,11,-9,-8};
		MergeSort ms=new MergeSort();
		ms.mergeSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}

}
