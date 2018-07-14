package com.bit;
//���⣺����һ���������飬��һ������1������k����֪������ֻ��һ����������һ����������������k�Σ��뷵�������

public class OnceNum {

	public static void main(String[] args) {
		int[] arr = {7,3,3,2,2};
		int k = 2;
		System.out.println("once num is :" + new OnceNum().getNum(arr, k));
		System.out.println("-2 �Ĳ����ǣ�" );
		int[] res = new OnceNum().getKSysNumFromNum(-2, 2);
		for(int e : res) {
			System.out.print(e + " ");
		}
	}
	
//	˼�룺k��k���Ƶ��������޽�λ��ӵõ��Ľ��һ����0
//	��a[i] + b[i]��% kΪÿһλ�ϵ���ӽ��
	public int getNum(int[] arr, int k) {
		if (arr == null) {
			return -1;
		}
		
		//�������飬������ת��Ϊk���������������ۼ�
		int[] e0 = new int[32];
		for(int i = 0; i < arr.length; i++) {
			setExclusiveOr(e0, arr[i], k);
		}
		
		int res = getNumFromSysNum(e0, k);
		return res;
	}
	
	public void setExclusiveOr(int[] e0, int value, int k) {
		//������ת����k����
		int[] curKSysNum = getKSysNumFromNum(value, k);
		
//		��e0�����޽�λ���
		for(int i = 0; i < e0.length; i++) {
			e0[i] = (e0[i] + curKSysNum[i]) % k;
		}
	}
	
	public int[] getKSysNumFromNum(int value, int k) {
		int[] res = new int[32];
		int index = 0;
		while (value != 0) {
			res[index++] = value % k;
			value /= k;
		}
		return res;
	}
	
	///��k������ת��Ϊ10������
	public int getNumFromSysNum(int[] e0, int k) {
		int res = 0;
		for(int i = e0.length - 1; i >= 0; i--) {
			res = res * k + e0[i];
		}
		return res;
	}
}
