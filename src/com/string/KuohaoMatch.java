package com.string;

/*
 * 问题1：给定一个字符串，判断是不是整体有效的括号字符串
    问题2:给定一个括号字符串str，返回最长的有效括号子串
*/
public class KuohaoMatch {

	
	public static void main(String[] args) {
		String str = "((()))";
		System.out.println(str + "result is : " + new KuohaoMatch().isVaild(str));
		System.out.println(str+ "vaild length is : " + new KuohaoMatch().getMaxLen(str));
	}
	
//	问题一：
	
	/*思路，从左到有遍历字符串，判断每一个字符串是不是(或者)，如果不是，直接返回false
	遍历到每一个字符时，检查（和）字符的数量，如果）更多，直接返回false
	最后检查（和）的数量，一样多，则返回true，否则false
	*/
	public boolean isVaild(String str) {
		if(str == null || str.length() < 2) {
			return false;
		}
		int left = 0;
		int right = 0;
		char[] chr = str.toCharArray();
		for (int i = 0; i < chr.length; i++) {
			if(chr[i] == '('){
				left++;
			}else if(chr[i] == ')') {
				right++;
				if (right > left) {
					return false;
				}
			}else {
				return false;
			}
		}
		if(right != left) {
			return false;
		}
		return true;
	} 
	
//	问题二：
	
	/*思路：用动态规划的思想求解
	dp[i]表示必须以str[i]结尾的最长有效括号长度
	1 dp[0] = 0
	2 从左到右遍历字符串，如果遍历到str[i]
	3 如果str[i] = '(',则为0，因为没有以（结尾的有效字符串
	4 如果str[i] = ')',则需要考虑dp[i - 1]的有效长度，
	看看str[i] == str[i - dp[i - 1]],同时还要考虑dp[i - dp[i - 1] - 2]的有效长度
	*/
	
	public int getMaxLen(String str) {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		char[] chr = str.toCharArray();
		int[] dp = new int[chr.length];
		int max = 0;
		
		for(int i = 1; i < chr.length; i++) {
			if(chr[i] == ')') {
				if(i - dp[i- 1] - 1 >= 0 && chr[i - dp[i - 1] - 1] == '(') {
					dp[i] = 2 + dp[i - 1];
					if(i - dp[i - 1] - 2 >= 0) {
						dp[i] += dp[i - dp[i - 1] - 2];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
