package com.heap;

public class HeapSort {

	public static void main(String[] args) {
		String str = "BCEADFHG";
		char[] chr = str.toCharArray();
		System.out.println("before sort -----------");
		HeapSort hs = new HeapSort();
		hs.print(chr);
		hs.heapSort(chr);
		System.out.println("\nafter sort ---------------");
		hs.print(chr);
		
	}
	public void heapSort(char[] chas) {
		for(int i = 0; i < chas.length; i++ ) {
			heapInsert(chas, i);
		}
		for(int i = chas.length - 1; i > 0; i--) {
			swap(chas, 0, i);
			heapify(chas, 0, i);
		}
		
	}
	
	public void heapInsert(char[] chas, int i){
		int parent = 0;
		while (i != 0) {
			parent = (i -1) / 2;
			if(chas[parent] < chas[i]) {
				swap(chas, parent, i);
				i = parent;
			}else {
				break;
			}
		}
	}
	
	public void heapify(char[] chas, int i, int size) {
		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int largest = i;
		while(left < size) {
			if(chas[left] > chas[i]) {
				largest = left;
			}
			if(right < size && chas[right] > chas[largest]) {
				largest = right;
			}
			if(largest != i) {
				swap(chas, i, largest);
			}else {
				break;
			}
			i = largest;
			left = 2 * i + 1;
			right = 2 * i + 2;
		}
	}
	
	public void print(char[] chas) {
		for(int i = 0; i < chas.length; i++) {
			System.out.print(chas[i] + "  ");
		}
	}
	public void swap(char[] chas, int i, int j) {
		char temp = chas[i];
		chas[i] = chas[j];
		chas[j] = temp;
	}
}
