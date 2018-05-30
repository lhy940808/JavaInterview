package com.string;

//���⣺����һ���ַ����������������ַ���ʹ���Ϊ���Ĵ����ַ�������һ�־���
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
	
//	�ö�̬�滮��˼��ʵ��
//	dp[i][j] ��ʾ�ַ���str��λ��iλ�õ��ַ���λ��jλ��֮����Ҫ�������ַ���
//	���dp�Ŀ�����������
	
	/*1 ���i��j֮�����һ���ַ�����ôdp[i][j] = str[i] == str[j] ? 0 : 1;
	2 ���str[i..j]֮��ֻ��һ���ַ�����ôdp[i][j] = 0
	3 ���str[i][j]֮�����һ���ַ������str[i] = str[j] dp[i][j] = dp[i + 1][j - 1],��������ڣ�
	��dp[i][j] = min(dp[i + 1][j], dp[i, j - 1]) + 1;*/
	public int[][] getDp(String str) {
		if(str == null) {
			throw new RuntimeException("�������Ϸ�");
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
	
//	�������Ǹ���dp�����������ַ��Ĺ���
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

	
//	�������⣺����������ַ���������������У��������
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
			//���ַ������ҵ���lplλ����ȵ��ַ�
			while(chr[sl] != lps[lpl]) {
				sl++;
			} 
			
			while(chr[sr] != lps[lpr]) {
				sr--;
			}
			
			//��ʱresult = [lastl:sl][sr:lastr] +[lpl] ... + [lpr] + [sr:lastr][lastl:sl]
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
