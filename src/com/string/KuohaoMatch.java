package com.string;

/*
 * ����1������һ���ַ������ж��ǲ���������Ч�������ַ���
    ����2:����һ�������ַ���str�����������Ч�����Ӵ�
*/
public class KuohaoMatch {

	
	public static void main(String[] args) {
		String str = "((()))";
		System.out.println(str + "result is : " + new KuohaoMatch().isVaild(str));
		System.out.println(str+ "vaild length is : " + new KuohaoMatch().getMaxLen(str));
	}
	
//	����һ��
	
	/*˼·�������б����ַ������ж�ÿһ���ַ����ǲ���(����)��������ǣ�ֱ�ӷ���false
	������ÿһ���ַ�ʱ����飨�ͣ��ַ�����������������ֱ࣬�ӷ���false
	����飨�ͣ���������һ���࣬�򷵻�true������false
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
	
//	�������
	
	/*˼·���ö�̬�滮��˼�����
	dp[i]��ʾ������str[i]��β�����Ч���ų���
	1 dp[0] = 0
	2 �����ұ����ַ��������������str[i]
	3 ���str[i] = '(',��Ϊ0����Ϊû���ԣ���β����Ч�ַ���
	4 ���str[i] = ')',����Ҫ����dp[i - 1]����Ч���ȣ�
	����str[i] == str[i - dp[i - 1]],ͬʱ��Ҫ����dp[i - dp[i - 1] - 2]����Ч����
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
