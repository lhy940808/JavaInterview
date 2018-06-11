package com.string;
//���⣺��һ���ַ����и��һ�����ַ�����ʹ��ÿ���ַ������ǻ����ַ���

public class CutHuiwenStr {

	public static void main(String[] args) {
		String str = "acaba";
		System.out.println("min cut times is : " + new CutHuiwenStr().minCut(str));
	}
	
	public int minCut(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		char[] chr = str.toCharArray();
//		dp[i]����˼�Ǵ�i..len-1������С�и���
		int[] dp = new int[chr.length + 1];
		
		dp[chr.length] = -1;
		
		//������ʶstr[i..j]�Ƿ�Ϊ�����ַ���
		boolean[][] p = new boolean[chr.length][chr.length];
		
		for (int i = chr.length - 1; i > -1; i--) {
			dp[i] = Integer.MAX_VALUE;
			for(int j = i; j <= chr.length - 1; j++){
				if(chr[i]== chr[j] && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1]) + 1;
				}
			}
		}
		
		return dp[0];
	}
}
