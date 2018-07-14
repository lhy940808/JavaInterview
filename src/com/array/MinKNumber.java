package com.array;

//获取无序数组中的最小的k个数
public class MinKNumber {

	public static void main(String[] args) {
		int[] arr = {5,1,4,3,2};
		int[] kMin = new MinKNumber().getMinKNumberByHeap(arr, 2);
		
		for(int i = 0; i < kMin.length; i++) {
			System.out.print(kMin[i] + "  ");
		}
		
	}
	
	public int[] getMinKNumberByHeap(int[] arr, int k) {
		if (arr == null || k < 1 || k > arr.length ) {
			return null;
		}
		//Y一个大根堆，存储数组的最小的k个数
		int[] kHeap = new int[k];
		
		for(int i = 0; i != k; i++){
			heapInsert(kHeap, i, arr[i]);
		}
		
		for(int i = k; i < arr.length; i++) {
			if (arr[i] < kHeap[0]) {
				kHeap[0] = arr[i];
				//往下调整堆，使之成为大根堆
				heapfity(arr, 0, k);
			}
		}
		return kHeap;
	}
	
	public void heapInsert(int[] arr, int i, int value) {
		arr[i] = value;
		int parent = 0;
		
		while (i != 0) {
			parent = (i - 1) / 2;
			if (arr[i] > arr[parent]) {
				swap(arr, i, parent);
				i = parent;
			}else {
				break;
			}
		}
	}
	
	public void heapfity(int[] arr, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		while (left < size) {
			if (arr[left] > arr[i]) {
				largest = left;
			}
			if(right < size && arr[right] > arr[largest]) {
				largest = right;
			}
			
			if (largest != i) {
				swap(arr, largest, i);
			}else {
				break;
			}
			i = largest;
			left = 2 * i + 1;
			right = 2 * i + 2;
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
