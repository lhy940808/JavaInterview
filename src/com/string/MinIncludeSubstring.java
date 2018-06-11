package com.string;

import java.util.HashMap;
import java.util.Map;

//���⣺����һ��str1��str2�������str2����С�Ӵ�
public class MinIncludeSubstring {

	public static void main(String[] args){
		String str = "12345";
		String target = "134";
		System.out.println("min len substring result is " + new MinIncludeSubstring().minSubString(str, target));
		
	}
	
	public int minSubString(String str, String target) {
		if (str == null || target == null || str.length() < target.length()) {
			return 0;
		}
		Map map = new HashMap<Character, Integer>();
		
		char[] chr = str.toCharArray();
		char[] targetCh = target.toCharArray();
//		map��ϣ��������¼strǷtarget���ַ�ͳ��
		for(int i = 0; i < targetCh.length; i++) {
			if(map.containsKey(targetCh[i])) {
				Integer count = (Integer)map.get(targetCh[i]);
				map.put(targetCh, count + 1);
			}else {
				map.put(targetCh[i], 1);
			}
		}
		int minLen = Integer.MAX_VALUE;
		int match = targetCh.length;
		int left = 0;
		for(int i = 0; i < chr.length; i++) {
			if(map.containsKey(chr[i])){
				Integer num = (Integer)map.get(chr[i]);
				if(num - 1 >= 0) {
					match--;
				}
				map.put(chr[i], num - 1);
				
			}else {
				map.put(chr[i], -1);
			}
			if (match == 0) {
				//��ʼ������С��Χ���ҵ���С�ĳ���
				while (left < i) {
					Integer count = (Integer)map.get(chr[left]);
					if(count < 0) {
						map.put(chr[left], count + 1);
					}else if (count == 0){
						break;
					}
					left++;
				}
				minLen = Math.min(minLen, i - left + 1);
				match++;
				map.put(chr[left++], 1);
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
		
		
	}
}
