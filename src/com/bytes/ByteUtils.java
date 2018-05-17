package com.bytes;

public class ByteUtils {

	public static int bytes2Int(byte[] b, int start, int len) {
		int sum = 0;
		int end = start + len;
		for(int i = start; i < end; i++) {
			int n = ((int)b[i]) & 0xff;
//			System.out.print("  b2int  " + (n <<= (--len) * 8));
			n <<= (--len) * 8;
			sum = n + sum;
		}
		return sum;
	}
	
	public static byte[] int2Bytes(int value, int len) {
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
//			System.out.println((byte)(value >> 8 * i) & 0xff);
			b[len - i - 1] = (byte)((value >> 8 * i)&0xff);
		}
		return b;
	}
	
	public static void main(String[] args) {
		byte[] b = int2Bytes(257, 4);
		System.out.println("binaary string is " + Integer.toBinaryString(257));
		for(int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "  ");
		}
		int a = bytes2Int(b, 0, 4);
		System.out.println(a);
		
	}
}
