package com.temp;

public class MinKNum {

	public static void main(String[] args) {
		int[] arr = {7,3,2,6,5,1,4, -2};
		int[] heap = new MinKNum().getMinKNum(arr,  4);
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + "  ");
		}
	}
	
	public int[] getMinKNum(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k < 0) {
			return null;
		}
		
		
		//先利用前k个数生成大根堆
		int[] heap = new int[k];
		
		for (int i = 0; i < k; i++) {
			heap[i] = arr[i];
		}
		
		for (int i = 0; i < k; i++) {
			//将这几个数变成大根堆
			heapfity(heap, i);
		}
		
		//然后遍历数组 将往后的数跟根进行对比， 如果比根小则替换
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < heap[0]) {
				heap[0] = arr[i];
				xiachen(heap, 0, k);
			}
		}
		return heap;
	}
	
	public void heapfity(int[] arr, int index) {
		int parent = 0;
		while (index != 0) {
			parent = (index - 1 ) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
			}else {
				break;
			}
			index = parent;
			
		}
	}
	
	public void xiachen(int[] arr, int i, int size) {
		int leftChild = 2 * i + 1;
		int rightChild  = 2 * i + 2;
		
		int largest = i;
		while (i < size) {
			if (leftChild < size && arr[leftChild] > arr[i]) {
				largest = leftChild;
			}
			
			if (rightChild < size && arr[rightChild] > arr[largest]) {
				largest = rightChild;
			}
			
			if (largest != i) {
				swap(arr, i, largest);
			}else {
				break;
			}
			i = largest;
			leftChild = 2 * i + 1;
			rightChild = 2 * i + 2;
			
		}
	}
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
