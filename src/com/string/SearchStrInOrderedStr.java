package com.string;

//�и�һ���ַ������飬������null���飬����Ϊnull��λ���ϣ��ַ����ǰ����ֵ�˳���С����һ�ʳ��ֵģ� ����һ���ַ���������str���ַ������������λ��
public class SearchStrInOrderedStr {

	public static void main(String[] args) {
		String[] strs = {null, "a", null, "b", null, "c"};
		String target = "a";
		System.out.println("index is " + new SearchStrInOrderedStr().getIndex(strs, target));
	}
	public int getIndex(String[] strs, String target) {
		if (strs == null || strs.length < 1) {
			throw new RuntimeException("invaild parameter!!!");
		}
		
		if(target == null) {
			return -1;
		}
		
		int left = 0;
		int right = strs.length - 1;
		int mid;
		int res = -1;
		while(left <= right) {
			mid = (left + right) / 2;
			if(strs[mid] == target) {
				right = mid - 1;
			}else if(strs[mid] != null) {
				if(strs[mid].compareTo(target) > 0) {
					res = mid;
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				int cur = mid;
				while(strs[cur] == null && --cur >= left);
				if(cur < left || strs[cur].compareTo(target) < 0) {
					left = mid + 1;
				}else {
					res = strs[cur].equals(target) ? cur : res;
					right = cur - 1;
				}
			}
		}
		return res;
		
	}
}
