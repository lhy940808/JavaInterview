package com.array;

//����:�������飬Ҫôʹ�����±��Ӧ�Ķ������� Ҫôʪż���±�ȫ��ż��

public class AdjustArray {

	public static void main(String[] args) {
		int[] arr = {1,8,3,2,4,6};
		new AdjustArray().adjust(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		int[] arr1 = {1,8,3,2,4,6};
		new AdjustArray().adjust2(arr1);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}
	
	public void adjust(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length < 2) {
			return;
		}
		
		//ȷ�����������ż������ĸ���
		int oddNumber = (arr.length % 2  == 0) ? arr.length / 2 : arr.length / 2 - 1;
		int evenNuomber = (arr.length % 2 == 0) ? arr.length / 2 : arr.length / 2 + 1;
		
		int odd = 0;
		int even = 0;
		//ͳ��������������ż���ĸ���
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even++;
			}else {
				odd++;
			}
		}
		boolean flag = false;//Ĭ��ż��
		//ȷ���ǽ������±��Ӧ���� ���ǽ�ż���±��Ӧż��
		if (odd > oddNumber) {
			flag = true;
		}
		
		//flag Ϊfalse : ��ż�����꿪ʼ true ���������꿪ʼ
		int begin = 0;//��ʼ����
		if (flag)
			begin = 1;
		int i = begin;
		while (i < arr.length) {
			//�������������򽻻�
//			System.out.println("result " + (arr[i] % 2 == 0));
			if ((arr[i] % 2 == 0) == flag) {
				int j = flag == true ? 0 : 1;
				while (j < arr.length) {
					if ((arr[j] % 2 == 0) != flag) {
						swap(arr, j, i);
						break;
					}
					j += 2;
				}
			}else {
				i += 2;
			}
		}
	}
	
	public void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} 
	
	//���з������ֱ�����������ָ������ߵ�ż���±�������±꣬Ȼ������һ�������������һ������ż���ͺ�ż�����꽻���������ͺ��������꽻��
	public void adjust2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int even = 0;
		int odd = 1;
		int len = arr.length - 1;
		while (even < arr.length && odd < arr.length) {
			if(arr[len] % 2 == 0) {
				swap(arr, even, len);
				even += 2;
			}else {
				swap(arr, odd, len);
				odd += 2;
			}
		} 
	}
}
