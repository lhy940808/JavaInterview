package com.string;

import java.util.Arrays;
import java.util.Comparator;



//问题：给定一个字符串类型的数组，找到一种拼接顺序，使得所有字符串拼接起来的顺序是所有可能中字典顺序最小的

//思想：先将字符串数组进行排序，再拼接，排序原则是如果字符串a和字符串b拼接在一起即a.b < a.b,则a在前面，否则b在前面
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


