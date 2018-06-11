package com.string;

//���⣺����һ���ַ������ҵ����ַ���������ظ��ַ��Ӵ�
public class FindMaxLengthSubstring {
	
	public static void main(String[] args) {
		String str = "aabcb";
//		System.out.println("max length substring : " + new FindMaxLengthSubstring().maxLenSubstring(str));
		System.out.println("max len is : " + new FindMaxLengthSubstring().maxLen(str));
		System.out.println("max len is by method2 : " + new FindMaxLengthSubstring().maxLenSubstring2(str));
	}
	
	public int maxLenSubstring(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		char[] chr = str.toCharArray();
		int[][] dp = new int[str.length()][str.length()];
		dp[0][0] = 1;
		for(int j = 1; j < str.length(); j++) {
			dp[j][j] = 1;
			dp[j - 1][j] = chr[j- 1] == chr[j] ? 1 : 2;
			for(int i = j - 2; i > -1; i--) {
				if(contains(chr, i, j - 1, j) && contains(chr, i + 1, j, i)) {
					dp[i][j] = dp[i + 1][j - 1];
				}
			
				int value1 = contains(chr, i, j - 1, j) ? dp[i][j - 1] : dp[i][j - 1] + 1;
				int value2 = contains(chr, i + 1, j, i) ? dp[i + 1][j] : dp[i + 1][j] + 1;
				int max = Math.max(value1, value2);
				dp[i][j] = Math.max(max, dp[i][j]);
			}
		}
		return dp[0][str.length() - 1];
	}

//	���������ö�̬�滮��˼�룬dp[i]��ʾ����������i��β������ظ��Ӵ�
	public int maxLen(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		int[] dp = new int[str.length()];
		char[] chr = str.toCharArray();
		
		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < chr.length; i++) {
			int index = indexOf(chr, i - dp[i - 1], i - 1, i);
			dp[i] = index != -1 ? i - index : dp[i - 1] + 1 ;
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public int indexOf(char[] chr, int start, int end, int index) {
		for(int i = start; i <= end; i++) {
			if(chr[i] == chr[index]) {
				return i;
			}
		}
		return -1;
	}
	private boolean contains(char[] chr, int start, int end, int index) {
		// TODO Auto-generated method stub
		for(int i = start; i <= end; i++) {
			if (chr[i] == chr[index]) {
				return true;
			}
		}
		return false;
	}
	
	//��������һ�㷽��
	public int maxLenSubstring2(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		//map�����洢���ַ�������ֵ�λ��
		int[] map = new int[256];
		for(int i = 0; i < map.length; i++) {
			map[i] = -1;
		}
		//��ʾ�Ա���i��β������ظ��Ӵ���ǰһ��λ��
		int pre = -1;
		//��ʾǰi��λ�õ�����ظ��Ӵ��ĳ���
		int len = 0;
		char[] chr = str.toCharArray();
		for(int i = 0; i < chr.length; i++) {
			pre = Math.max(pre, map[chr[i]]);
			int cur = i - pre;
			len = Math.max(len, cur);
			map[chr[i]] = i;
		}
		return len;
	}

}
