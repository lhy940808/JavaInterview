package com.string;

//��ת�ַ���������һ���ַ����͵�����chas���ڵ��ʼ������������ֻҪ��������˳�����򼴿ɣ��Կո��λ��û���ر�Ҫ��

//�� dog loves pig => pig loves dog    I'm a student. => student. a I'm

public class TurnString {
	
	/*public boolean turn(char[] chas) {
		if(chas == null || chas.length == 0) {
			return "";
		}
		
		// 1 ���Ƚ��ַ�������
		char[] reverseStr = reverse(chas, 0, chas.length - 1);
		int start = 0;
		int end = 0;
		boolean isSpace = false;
		boolean isCount = false;
		for(int i = 0; i < chas.length; i++) {
			if(chas[i] != ' ' && !isSpace) {
//				flag = true;
				start = i; 
			}
//			if(chas[i] && cha)
		}
		return false;
		
	}*/
	

	public static void main(String[] args) {
		String str = "dog loves pig.";
		char[] chr = str.toCharArray();
		new TurnString().rotateWord(chr);
		System.out.println("result is : " + String.valueOf(chr));
		int size = 4;
		new TurnString().adjustString(chr, size);
		System.out.println("adjust result is : " + String.valueOf(chr));
		String str1 = "ABCDE1234";
		int len = 5;
		char[] chr1 = str1.toCharArray();
		new TurnString().adjustString2(chr1, len);
		System.out.println("adjust result (method 2) : " + String.valueOf(chr1));
	}
	
	
//	˼�룺�Ƚ��ַ������巴ת��Ȼ���ٽ�ÿ����������
	public void rotateWord(char[] chr) {
		if(chr == null || chr.length == 0) {
			return;
		}
		
//		���Ƚ��ַ�������
		reverse(chr, 0, chr.length - 1);
		
//		Ȼ��ÿ�����ʣ�Ҳ�����ÿո�������ַ���������������ѵ������ҳ�ÿ�����ʵĿ�ʼ�ͽ�������
		int start = -1;
		int end = -1;
		
		for(int i = 0; i < chr.length; i++) {
			if(chr[i] != ' ') {
				start = i == 0 || chr[i - 1] == ' ' ? i : start;
				end = i == chr.length - 1 || chr[i + 1] == ' ' ? i : end;
			}
			
			if(start != -1 && end != -1) {
				reverse(chr, start, end);
				start = 1;
				end = -1;
			}
		}
		
		
	}
	private void reverse(char[] chr, int start, int end) {
		// TODO Auto-generated method stub
		char temp = 0;
		while (start < end) {
			temp = chr[start];
			chr[start] = chr[end];
			chr[end] = temp;
			start++;
			end--;
		}
		
	}
	
	
//	������һ:����һ���ַ����͵�����chas��һ������size����Ѵ�СΪsize������������Ƶ��Ұ������Ұ��������Ƶ����
//	������ABCDE size = 3 ��Ϊ�� DEABC
	
//	�������һ���Ƚ���������Ȼ����벿�֣�len -size�� ���ұ߲��֣�size���ֱ�����
//	��������ABCDE size = 3 ,��������EDCBA ,�������DECBA �ұ�����DEABC
	
	public void adjustString(char[] chr, int size) {
		if(chr == null || chr.length == 0 || size <= 0 || size > chr.length) {
			return;
		}
		
//		1 ���Ƚ���������
		reverse(chr, 0, chr.length - 1);
		
//		2 �������
		reverse(chr, 0, chr.length - size - 1);
		
//		�ұ�����
		reverse(chr, chr.length -size, chr.length - 1);
	}
	
	
//	������˼·һ��������˼·��
	public void adjustString2(char[] chr, int size) {
		if(chr == null || chr.length == 0 || size <= 0 || size > chr.length) {
			return;
		}
		
		int lStart = 0;
		int rEnd = chr.length - 1;
		
		int lLen = size;
		int rLen = chr.length -size;
		int mLen = Math.min(lLen, rLen);
		
//		���Ҳ��ֳ��Ȳ�
		int deta = lLen - rLen;
		while (true) {
//			�������Ҳ�������
			exchange(chr, lStart, rEnd, mLen);
			
			if(deta == 0) {
				break;
			}else if(deta > 0) {
//				��߳��ȳ�
				lStart += mLen;
				lLen = deta;
			}else {
//				�ұ߳��ȳ�
				rEnd -= mLen;
				rLen = -deta;
			}
			mLen = Math.min(lLen, rLen);
			deta = lLen - rLen;
		}
		
		
	}


	private void exchange(char[] chr, int lStart, int rEnd, int mLen) {
		// TODO Auto-generated method stub
		int rStart = rEnd - mLen + 1;
		while(mLen-- > 0) {
			char temp = chr[lStart];
			chr[lStart] = chr[rStart];
			chr[rStart] = temp;
			lStart++;
			rStart++;
		}
		
	}
}
