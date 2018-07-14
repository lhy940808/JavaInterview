package com.array;

import java.util.HashMap;

//����һ����������arr�� ����Ԫ�ؿ��� �ɸ� ��0������һ������k����arr�����е��������ۼӺ�Ϊk��������鳤��
public class UnSortedArrayMaxLen {
	public static void main(String[] args) {
		int[] arr = {22, 0, 2, -2, 13};
		int k = 2;
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLen(arr, 0));
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLenLessK(arr, k));
		System.out.println("max len is : " + new UnSortedArrayMaxLen().maxLenLessK2(arr, k));
	}
	
	//˼�룺��s(i)��ʾ��i��β���ۼӺͣ���ô������ҵ�s(j)= s(i) -k ,��ôs(i) - s(j) = k
	//���ʱ(j+1....i)���ۼӺ�Ϊk
	
	public int maxLen(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int sum = 0;//��ʾ��ǰ�����ۼӺͣ�Ҳ����s(i)
		//����Ҫ����һ����ϣ�����洢�ۼӺ�������ֵ�λ��
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = 0;
		map.put(0, -1);//��ʾʲô�����ӣ��ۼӺ�Ϊ0
		
		for (int i = 0; i <arr.length; i++) {
			sum += arr[i];
			
			//�ж�sum-k�Ƿ����
			if (map.containsKey(sum - k)) {
				len = Math.max(len, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		return len;
		
	}
	
	//����2�������������Ϊ�ۼӺ�С�ڻ��ߵ��ڸ���ֵ��������鳤��
	
	public int maxLenLessK(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		//˼·������һ���ۼӺ͵����飬��һ����¼�������
		int[] sum = new int[arr.length + 1];
		int[] help = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			sum[i + 1] = sum[i] + arr[i];
		}
		
		int max = 0;
		for (int i = 1; i < sum.length; i++) {
			if (max < sum[i]) {
				max = sum[i];
			}
			help[i] = max;
		}
		int low = 0;
		int high = 0;
		int mid = 0;
		
		int len = 0;
		//����������������Ϳ��Լ���������鳤����
		//ԭ���ۼӺ�С��k��������鳤�ȣ�������� ������ִ���sum-k������
		for (int i = 0; i < arr.length; i++) {
			int restSum = sum[i + 1] - k;
			//��help���ҵ��������restSum��ֵ
			low = 0;
			high = i;
			while (low <= high) {
				mid = (low + high) / 2;
				if (help[mid] >= restSum) {
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			//�ҵ���
			if (low <= i) {
				len = Math.max(len, i - low + 1);
			} 
		}
		return len;
	}
	//���е�����
	public int maxLenLessK2(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(h[i], sum);
		}
		
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i -pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}
	
	public int getLessIndex(int[] arr, int sum) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while(low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= sum) {
				res = mid;
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
        return res;		
	}
}
