package com.dynamic;

//问题：求两个字符串的最长公共子序列
public class MaxCommonSubseq {

	public static void main(String[] args) {
		String str1 = "1A2C3D4B56";
		String str2 = "B1D23CA45B6A";
		System.out.println("max len common subseq : " + new MaxCommonSubseq().maxSeq(str1, str2));
	}
	
	public String maxSeq(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
			return null;
		}
		
		char[] chr1 = str1.toCharArray();
		char[] chr2 = str2.toCharArray();
		int[][] dp = getDp(chr1, chr2);
		
		System.out.println("max sub sequence length is : " + dp[chr1.length - 1][chr2.length - 1]);
		
		//通过dp数组获取最长公共子序列
		return getSeq(chr1, chr2, dp);
		
	}
	
	public String getSeq(char[] chr1, char[] chr2, int[][] dp) {
		char[] seq = new char[dp[chr1.length - 1][chr2.length - 1]];
		int sIndex = seq.length - 1;
		int i = chr1.length - 1;
		int j = chr2.length - 1;
		while (i >= 0 && j >= 0) {
			//判断当前元素是怎么获取来的 
     			if(chr1[i] == chr2[j]) {
				seq[sIndex--] = chr1[i];
				i--;
				j--;
			}else if (i == 0){
				j--;
			}else if (j == 0) {
				i--;
			}else if (dp[i - 1][j] >= dp[i][j - 1]){
				i--;
			}else {
				j--;
			}
		}
		return new String(seq);
	}
	
	public int[][] getDp(char[] chr1, char[] chr2) {
		int[][] dp = new int[chr1.length][chr2.length];
		//给边界赋值
		boolean flag = false;
		for (int i = 0; i < chr2.length; i++) {
			if (chr1[0] == chr2[i]) {
				flag = true;
			}
			dp[0][i] = flag ? 1 : 0;
		}
		flag = false;
		for (int i = 0; i < chr1.length; i++) {
			if (chr1[i] == chr2[0]) {
				flag = true;
			}
			dp[i][0] = flag ? 1 : 0;
		}
		
		//开始动态规划计算
		for (int i = 1; i < chr1.length; i++)
			for(int j = 1; j < chr2.length; j++) {
				dp[i][j] =  chr1[i] == chr2[j] ? dp[i - 1][j - 1] + 1 : 0;
				int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
				dp[i][j] = Math.max(dp[i][j], max);
			}
		return dp;
		
	}
}
