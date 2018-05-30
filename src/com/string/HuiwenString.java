package com.string;

//问题：给定一个字符串，求出添加最少字符，使其成为回文串的字符，给出一种就行
public class HuiwenString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABA";
		char[] chr = str.toCharArray();
		new HuiwenString().getDP(chr);
		String test = "ABC";
		System.out.println(test + "result is : " + new HuiwenString().getPalindromel(test));
		String str1 = "A1BC22DE1F";
		String lps = "1221";
		System.out.println(str1 + "result is :" + new HuiwenString().getPalindromel2(str1, lps));

	}
	
	public int[][] getDP(char[] str) {
		int[][] dp = new int[str.length][str.length];
		
		for(int j = 1; j < str.length; j++) {  
			dp[j -1][j] = str[j - 1] == str[j] ? 0 : 1;
			for(int i = j - 2; i > -1; i--) {
				if(str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp;

	}
	
//	用动态规划的思想实现
//	dp[i][j] 表示字符串str中位于i位置的字符和位于j位置之间需要的最少字符数
//	求解dp的可能有是三种
	
	/*1 如果i与j之间相隔一个字符，那么dp[i][j] = str[i] == str[j] ? 0 : 1;
	2 如果str[i..j]之间只有一个字符，那么dp[i][j] = 0
	3 如果str[i][j]之间多于一个字符，如果str[i] = str[j] dp[i][j] = dp[i + 1][j - 1],如果不等于，
	则，dp[i][j] = min(dp[i + 1][j], dp[i, j - 1]) + 1;*/
	public int[][] getDp(String str) {
		if(str == null) {
			throw new RuntimeException("参数不合法");
		}
		
		int[][] dp = new int[str.length()][str.length()];
		char[] chr = str.toCharArray();
		for(int j = 1; j < str.length(); j++) {
			dp[j - 1][j] = chr[j - 1] == chr[j] ? 0 : 1;
			for(int i = j - 2; i > -1; i--) {
				if(chr[i] == chr[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				}else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp;
		
	}
	
//	接下来是根据dp矩阵求出添加字符的过程
	public String getPalindromel(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		char[] chr = str.toCharArray();
		int[][] dp = getDp(str);
		char[] result = new char[str.length() + dp[0][str.length() - 1]];
		int i = 0;
		int j = chr.length - 1;
		int rLeft = 0;
		int rRight = result.length - 1;
		while(i <= j) {
			if(chr[i] == chr[j]){
				result[rLeft++] = chr[i++];
				result[rRight--] = chr[j--];
			} else if (dp[i + 1][j] > dp[i][j - 1]) {
				result[rLeft++] = chr[j];
				result[rRight--] = chr[j--];
			}else {
				result[rLeft++] = chr[i];
				result[rRight--] = chr[i++];
			};
		}
		
		return String.valueOf(result);
	}

	
//	进阶问题：如果给定了字符串的最长回文子序列，该如何求
	public String getPalindromel2(String str,String strlps) {
		if(str == null || strlps.equals("")) {
			return "";
		}
		char[] chr = str.toCharArray();
		char[] lps = strlps.toCharArray();
		char[] result = new char[2 * chr.length - lps.length];
		int sl = 0;
		int sr = chr.length - 1;
		int lpl = 0;
		int lpr = lps.length - 1;
		int resl = 0;
		int lastl = 0;
		int lastr = sr;
		int resr = result.length - 1;
		while(lpl <= lpr) {
			lastl = sl;
			lastr = sr;
			//在字符串中找到跟lpl位置相等的字符
			while(chr[sl] != lps[lpl]) {
				sl++;
			} 
			
			while(chr[sr] != lps[lpr]) {
				sr--;
			}
			
			//这时result = [lastl:sl][sr:lastr] +[lpl] ... + [lpr] + [sr:lastr][lastl:sl]
			set(result, resl, resr, chr, lastl, sl, sr, lastr);
			resl += sl - lastl + lastr - sr;
			resr -= sl - lastl + lastr - sr;
			result[resl++] = chr[sl++];
			result[resr--] = chr[sr--];
			lpl++;
			lpr--;
		}
		
		return String.valueOf(result);
	}

     private void set(char[] result, int resl, int resr, char[] chr, int lastl,
		int sl, int sr, int lastr) {
	 // TODO Auto-generated method stub
    	 for(int i = lastl; i < sl; i++) {
    		 result[resl++] = chr[i];
    		 result[resr--] = chr[i];
    	 }
    	 for(int i = lastr; i > sr; i--) {
    		 result[resl++] = chr[i];
    		 result[resr--] = chr[i];
    	 }
	
    }
}
