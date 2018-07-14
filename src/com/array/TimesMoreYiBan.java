package com.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//��ӡ�����г��ִ�������һ�����
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
	
	//��������˼����һ����������ɾ����k����ͬ��������ͣ��ɾ����ֱ��ʣ�µ��������಻��k��ֹͣɾ��
	
	public void printHalfMajor(int[] arr) {
		if (arr == null) {
			return;
		}
		
		// ɾ����
		
		int cand = 0;// ��ʾ��ѡ��
		int times = 0;//��ʾ��ѡ�Ĵ���
		
		for (int i = 0; i < arr.length; i++) {
			if (times == 0){ //��ʾû�к�ѡ��
				cand = arr[i];
				times = 1;
			}else if (arr[i] == cand) { //��ʱ���Ǻ�ѡ�ĵ����ּ�һ
				times++;
			}else { //�ҵ�������һ����ѡ
				times--;
				
			}
		}
		
		//�����Ϊ��ȷ�����µ���ȷʵ�Ǵ���һ���
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
	
	//������ף��ҳ������г��ִ�������n/K����
	//˼�룺����������һ��
	public void printKMajor(int[] arr, int k) {
		if (arr == null || k < 2 || k > arr.length) {
			return;
		}
		
		//��ʾk����ѡ�˺���Ӧ�Ĵ���
		HashMap<Integer, Integer> candTimes = new HashMap<Integer, Integer>();
		
		//��ʼɾ��
		for (int i = 0; i < arr.length; i++) {
			if (candTimes.size() == 0) { //��ʱ��ѡΪ��
				candTimes.put(arr[i], 1);
			}else if(!candTimes.containsKey(arr[i])){
				if (candTimes.size() == k - 1) {
					reduce(candTimes);//�պù�k�� ȫ��ɾ��������ɾ��Ϊ0�� ֱ��ɾ��
				}else {
					candTimes.put(arr[i], 1);
				}
			}else {
				int value = candTimes.get(arr[i]);
				candTimes.put(arr[i], value + 1);
			}
		}
		boolean hasPrint = false;
		//��ʼ��֤ÿ�����Ƿ���ĳ��ִ�������n/k
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
	
	
	//���㳬��һ������ĵ����ֽⷨ
	public int getHalfNumber(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MAX_VALUE;
		}
		
		//˼�룺�ź������������г����˳���һ���������ôһ������������м�
		//Ȼ�����ÿ������ݵ�˼�룬���ÿ�ι�λ��������պ���n/2�� ��ô�����ͨ��������������ֵĴ������Ӷ�ȷ��������Ĵ����Ƿ񳬹���һ����
		
		int mid = arr.length / 2;
		int left = 0;
		int right  = arr.length - 1;
		int index  = partition(arr, left, right);
		
		while (index != mid) {
			if (index < mid) {
				//��λ��һ����index������
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
