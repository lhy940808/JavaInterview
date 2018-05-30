package com.string;

import java.util.HashMap;
import java.util.Map.Entry;

//��һ���ַ�������strs,�����ַ���str1��str2,��str1��str2���ַ��������е���С����
public class MinDistance {
	
	public static void main(String[] args) {
		String[] strs = {"1", "3", "3", "2", "11"};
		String str1 = "1";
		String str2 = "2";
		System.out.println(str1 + "��" + str2 + "��̾���Ϊ:" + MinDistance.minDis(strs, str1,str2));
	}
	public static int minDis(String[] strs, String str1, String str2) {
		if (strs == null || str1 == null || str2 == null) {
			return -1;
		}
		
		if(str1.equals(str2)) {
			return 0;
		}
		
//		��last1��¼str1����������ַ��������е�λ��,��last2��¼str2����������ַ��������е�λ��
		
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
//������:���ÿռ任ʱ���˼��,��ǰ��¼���ַ���������ÿ���ַ����������ַ�������С����
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
