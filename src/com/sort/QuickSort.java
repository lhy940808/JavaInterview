package com.sort;

import java.io.InputStreamReader;

public class QuickSort {

	
	/*public int Partition(int[] data, int start, int end) {
		if(data == null || data.length <= 0 || start < 0 || end == data.length) {
			throw new RuntimeException("Invaild Parameters");
		}
		int index =randomInRange(start, end);
		swap(data, index, end);
		
		int small = start - 1;
		for(index = start; index < end; index++) {
			if(data[index] < data[end]) {
				++small;
				if(small != index) {
					swap(data, index, small);
				}
			}
		}
		++small;
		swap(data, small, end);
		return small;            
	}*/
	
	public static void main(String[] args){
		int[] data = {5,3,1,8,2,4};
		new QuickSort().sort(data, 0, data.length - 1);
		for(int i = 0; i < data.length; i++) {
			System.out.print(data[i] + "  ");
		}
	}
	public void sort(int[] data, int left, int right) {
		if(data == null || data.length == 0) {
			return;
		}
		if(left > right) {
			return;
		}
		int base = data[left];
		int i = left;
		int j = right;
		while(i != j) {
			while(data[j] >= base && j > i) {
				j--;
			}
			while(data[i] <= base && i < j) {
				i++;
			}
			if(i != j) {
				swap(data, i, j);
			}
			
		}
		
		swap(data, i, left);
		sort(data, left, i - 1);
		sort(data, i + 1, right);
	}
	
	public void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
