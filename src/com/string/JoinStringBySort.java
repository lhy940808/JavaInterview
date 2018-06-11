package com.string;

import java.util.Arrays;
import java.util.Comparator;



//���⣺����һ���ַ������͵����飬�ҵ�һ��ƴ��˳��ʹ�������ַ���ƴ��������˳�������п������ֵ�˳����С��

//˼�룺�Ƚ��ַ����������������ƴ�ӣ�����ԭ��������ַ���a���ַ���bƴ����һ��a.b < a.b,��a��ǰ�棬����b��ǰ��
public class JoinStringBySort {
	
	public static void main(String[] args) {
//		String[] strs = {"hah", "a", "ab", "c"};
		String[] strs = {"b", "ba"};
		System.out.println("result is : " + new JoinStringBySort().sort(strs));
		
	}
	
	public String sort(String[] strs) {
		if(strs == null || strs.length == 0) {
			return null;
		}
		
		Arrays.sort(strs, new MyComparator()     );
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strs.length; i++) {
			sb.append(strs[i]);
		}
		return sb.toString();
		
	}

}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return (o1 + o2).compareTo(o2 + o1);
	
	}
	
}


