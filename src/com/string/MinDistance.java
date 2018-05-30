package com.string;

import java.util.HashMap;
import java.util.Map.Entry;

//有一个字符串数组strs,两个字符串str1和str2,求str1和str2在字符串数组中的最小距离
public class MinDistance {
	
	public static void main(String[] args) {
		String[] strs = {"1", "3", "3", "2", "11"};
		String str1 = "1";
		String str2 = "2";
		System.out.println(str1 + "与" + str2 + "最短距离为:" + MinDistance.minDis(strs, str1,str2));
	}
	public static int minDis(String[] strs, String str1, String str2) {
		if (strs == null || str1 == null || str2 == null) {
			return -1;
		}
		
		if(str1.equals(str2)) {
			return 0;
		}
		
//		用last1记录str1最近出现在字符串数组中的位置,用last2记录str2最近出现在字符串数组中的位置
		
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++) {
			if(strs[i].equals(str1)) {
				min = Math.min(min, last2 == -1 ? min : i - last2);
				last1 = i;
			}
			
			if(strs[i].equals(str2)) {
				min = Math.min(min, last1 == -1 ? min : i - last1);
				last2 = i;
			}
		}
		if (last1 == -1 || last2 == -1) {
			return -1;
		}
		return min;
	}

}
//方法二:采用空间换时间的思想,提前记录号字符串数组中每个字符串到其他字符串的最小距离
class Record {
	private HashMap<String, HashMap<String, Integer>> record;
	
	public Record(String[] strArr) {
		record = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		for(int i = 0; i < strArr.length; i++) {
			String curStr = strArr[i];
			update(indexMap, curStr, i);
			indexMap.put(curStr, i);
		}
	}
	
	private void update(HashMap<String, Integer> indexMap, String str, int i) {
		if(!record.containsKey(str)){
			record.put(str, new HashMap<String, Integer>());
		}
		
		HashMap<String, Integer> strMap = record.get(str);
		
		for(Entry<String, Integer> lastEntry : indexMap.entrySet()) {
			String key = lastEntry.getKey();
			int index = lastEntry.getValue();
			if(!key.equals(str)) {
				HashMap<String, Integer> lastMap = record.get(key);
				int curMin = i - index;
				if(strMap.containsKey(key)) {
					int preMin = strMap.get(key);
					if(preMin > curMin) {
						strMap.put(key, curMin);
						lastMap.put(str,  curMin);
					}else {
						strMap.put(key, curMin);
						lastMap.put(str, curMin);
					}
				}
			}
		}
	}
	
	public int minDistance(String str1, String str2) {
		if(str1 == null || str2 == null) {
			return -1;
		}
		
		if(str1.equals(str2)) {
			return 0;
		}
		
		if(record.containsKey(str1) && record.get(str1).containsKey(str2)) {
			return record.get(str1).get(str2);
		}
		return -1;
	}
}
