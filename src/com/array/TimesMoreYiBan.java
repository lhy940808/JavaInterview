package com.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//打印数组中出现次数大于一半的数
public class TimesMoreYiBan {

	public static void main(String[] args) {
		int[] arr = {1,2,3,2,2,2,3,2};
		new TimesMoreYiBan().print(arr);
		new TimesMoreYiBan().printHalfMajor(arr);
		new TimesMoreYiBan().getHalfNumber(arr);
	}
	
	public void print (int[] arr) {
		if (arr == null) {
			return;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				int value = map.get(arr[i]);
				map.put(arr[i], value + 1);
			}else {
				map.put(arr[i], 1);
			}
		}
		boolean flag = false;
		for (Integer key : map.keySet()) {
			if (map.get(key) >= arr.length / 2) {
				System.out.print(key + "  ");
				flag = true;
			}
		}
		
		if (!flag) {
			System.out.println("no number !!!!");
		}
	}
	
	//方法二：思想是一次在数组中删除掉k个不同的数，不停地删除，直到剩下的数的种类不足k就停止删除
	
	public void printHalfMajor(int[] arr) {
		if (arr == null) {
			return;
		}
		
		// 删除数
		
		int cand = 0;// 表示候选数
		int times = 0;//表示候选的次数
		
		for (int i = 0; i < arr.length; i++) {
			if (times == 0){ //表示没有候选数
				cand = arr[i];
				times = 1;
			}else if (arr[i] == cand) { //这时候是候选的点数又加一
				times++;
			}else { //找到了另外一个候选
				times--;
				
			}
		}
		
		//这个是为了确保留下的数确实是大于一半的
		times = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == cand) {
				times++;
			}
		}
		if (times > arr.length / 2) {
			System.out.println("the number is " + cand);
		}else {
			System.out.println("no number ");
		}
	}
	
	//问题进阶：找出数组中出现次数大于n/K的数
	//思想：跟上述方法一样
	public void printKMajor(int[] arr, int k) {
		if (arr == null || k < 2 || k > arr.length) {
			return;
		}
		
		//表示k个候选人和相应的次数
		HashMap<Integer, Integer> candTimes = new HashMap<Integer, Integer>();
		
		//开始删除
		for (int i = 0; i < arr.length; i++) {
			if (candTimes.size() == 0) { //此时候选为空
				candTimes.put(arr[i], 1);
			}else if(!candTimes.containsKey(arr[i])){
				if (candTimes.size() == k - 1) {
					reduce(candTimes);//刚好够k个 全部删除，遇到删完为0的 直接删除
				}else {
					candTimes.put(arr[i], 1);
				}
			}else {
				int value = candTimes.get(arr[i]);
				candTimes.put(arr[i], value + 1);
			}
		}
		boolean hasPrint = false;
		//开始验证每个数是否真的出现次数大于n/k
		HashMap<Integer, Integer> numberCount = getReals(arr, candTimes);
		for (Entry<Integer, Integer> set: numberCount.entrySet()) {
			Integer key = set.getKey();
			if (numberCount.get(key) > arr.length /k) {
				hasPrint = true;
				System.out.println(key + "  ");
			}
		}
		System.out.println(hasPrint ? "" : "no such number");      
	}
	
	public void reduce(HashMap<Integer, Integer> map) {
		List<Integer> removeList = new LinkedList<Integer>();
		for(Entry<Integer, Integer> set : map.entrySet()) {
			Integer key = set.getKey();
			Integer value = set.getValue();
			if (value == 1) {
				removeList.add(key);
			}
			map.put(key, value - 1);

		}
		
		for (Integer key : removeList) {
				map.remove(key);
		}
	} 
	
	public HashMap<Integer, Integer> getReals(int[] arr, Map<Integer, Integer> candTimes) {
		HashMap<Integer,Integer> reals = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (candTimes.containsKey(arr[i])) {
				if (reals.containsKey(arr[i])) {
					reals.put(arr[i], reals.get(arr[i]) + 1);
				}else {
					reals.put(arr[i], 1);
				}
			}
		}
		return reals;
	}
	
	
	//计算超过一半的数的第三种解法
	public int getHalfNumber(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		//思想：排好序的数组如果有出现了超过一半的数，那么一定是在数组的中间
		//然后利用快速排休的思想，如果每次归位的这个数刚好在n/2处 那么则可以通过计算这个数出现的次数，从而确定这个数的次数是否超过了一般那
		
		int mid = arr.length / 2;
		int left = 0;
		int right  = arr.length - 1;
		int index  = partition(arr, left, right);
		
		while (index != mid) {
			if (index < mid) {
				//中位数一定在index的右面
				left = index + 1;
				index = partition(arr, index + 1, right);
			}else if (index > mid) {
				right = index - 1;
				index = partition(arr, left, index - 1);
			}
		}
		
		return checkMoreThanHalf(arr, index) ? arr[index] : Integer.MAX_VALUE;
	}
	
	public int partition(int[] arr, int left, int right) {
		int temp = arr[left];
		int i = left;
		int j = right; 
		
		while (i != j) {
			while (arr[j] >= temp && j != i) {
				j--;
			}
			while (arr[i] <= temp && j != i) {
				i++;
			}
			if (i != j) {
				swap(arr, i, i);
			}
		}
		arr[i] = temp;
		return i;
	}
	
	public boolean checkMoreThanHalf(int[] arr, int index) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[index]) {
				count++;
			}
		}
		return count >= arr.length / 2 ? true : false;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
} 
