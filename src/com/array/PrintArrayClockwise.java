package com.array;

import java.util.ArrayList;

//���⣺����һ������˳ʱ���ӡ����
public class PrintArrayClockwise {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},
					   {5,6,7,8},
					   {9,10,11,12},
					   {13,14,15,16},
					   {17,18,19,20}};
		
//		printClockwise(arr);
		ArrayList<Integer> list = printMatrix(arr);
		for(Integer ele : list) {
			System.out.print(ele + "  ");
		}
		System.out.println();
		new PrintArrayClockwise().sprialOrderPrint(arr);
	}
	public static void printClockwise(int[][] arr) {
		if(arr == null ) {
			return;
		}
		
//		��������Ѿ���ӡ�ĸ���
		int count = 0;
		
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		int total = arr.length * arr[0].length;
		int i = 0;
		int j = 0;
		int flag = 0;
		while (count <= total) {
			while(i >= 0 && i < arr.length && j >=0 && j < arr[0].length && !visited[i][j]) {
				count++;
				visited[i][j] = true;
				System.out.print(arr[i][j] + "  ");
				switch (flag % 4) {
				case 0:
					j++;
					break;
				case 1:
					i++;
					break;
				case 2:
					j--;
					break;
				case 3:
					i--;
					break;
				}
			}
			     
			switch (flag % 4) {
			case 0:
				i++;
				break;
			case 1:
				j--;
				break;
			case 2:
				i--;
				break;
			case 3:
				j++;
				break;
			}
			
			flag++;
			if (i == arr.length) {
				i = arr.length - 1;
			}
			if (j == arr[0].length) {
				j = arr[0].length - 1;
			}
			if (i == - 1){
				i = 0;
			}
			if( j == -1) {
				j = 0;
			}
			
		}
		
	}
	
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return null;
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int start = 0;
		while (rows > start * 2 && cols > start *2) {
			printMatrixInCircle(matrix, cols, rows, start, list);
			start++;
		}
		return list;
	}
	
	public static void printMatrixInCircle(int[][] matrix, int cols, int rows, int start, ArrayList<Integer> list) {
		int endX = cols - 1 - start;
		int endY = rows - 1 - start;
		
		//��һ���������Ҵ�ӡһ��
		for(int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}
		
		//�ڶ��������ϵ��´�ӡһ��
		if(start < endY) {
			for(int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
			}
		} 
		
		//�����������ҵ����ӡһ��
		if(start < endX && start < endY) {
			for(int i = endX - 1; i >= start; i-- ) {
				list.add(matrix[endY][i]);
			}
		}
		
		//���Ĳ������µ��� (������Ҫ��������)
		if(start < endX && start < endY - 1) {
			for( int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
	}
	
	//��������ͬ����˼�룬��ͬ��д��
	
	public void sprialOrderPrint(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		
		while (tR <= dR && tC <= dC) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
		
	}
	
	public void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
		//�Ӿ���ֻ��һ��
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				System.out.print(matrix[tR][i] + "  ");
			}
		} else if (tC == dC) {
			//��ʱ���ֻ��һ��
			for (int i = tR; i <= dR; i++) {
				System.out.print(matrix[i][tC]);
			}
		}else {
			//һ�����
			int curC = tC;
			int curR = tR;
			
			while (curC != dC) {
				System.out.print(matrix[tR][curC] + "  ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(matrix[curR++][dC] + "  ");;
			}
			while (curC != tC) {
				System.out.print(matrix[curR][curC--] + "  ");
			}
			while (curR != tR) {
				System.out.print(matrix[curR--][tC] + "  ");
			}
			
			
		}
	}
}
