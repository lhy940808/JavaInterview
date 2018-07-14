package com.array;

import java.util.ArrayList;

//问题：输入一个矩阵，顺时针打印矩阵
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
		
//		用来标记已经打印的个数
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
		
		//第一步：从左到右打印一行
		for(int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
		}
		
		//第二步：从上到下打印一行
		if(start < endY) {
			for(int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
			}
		} 
		
		//第三步：从右到左打印一行
		if(start < endX && start < endY) {
			for(int i = endX - 1; i >= start; i-- ) {
				list.add(matrix[endY][i]);
			}
		}
		
		//第四步：从下到上 (至少需要三行两列)
		if(start < endX && start < endY - 1) {
			for( int i = endY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
	}
	
	//方法二：同样的思想，不同的写法
	
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
		//子矩阵只有一行
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				System.out.print(matrix[tR][i] + "  ");
			}
		} else if (tC == dC) {
			//这时情况只有一列
			for (int i = tR; i <= dR; i++) {
				System.out.print(matrix[i][tC]);
			}
		}else {
			//一般情况
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
