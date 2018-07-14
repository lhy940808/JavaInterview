package com.array;


//问题：将一个矩阵顺时针旋转
public class RotateClockwise {

	
	public static void main(String[] args) {
		int[][] arr = {{1,2,3,4},
					   {5,6,7,8},
					   {9,10,11,12},
					   {13,14,15,16}};
		arr = new RotateClockwise().rotate(arr);
		
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}  
			System.out.println();
		}
		
		new RotateClockwise().rotate2(arr);
		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public int[][] rotate(int[][] arr) {
		if (arr == null || arr.length == 0 || arr[0].length == 0 ) {
			return null;
		}
		int row = arr.length;
		int col = arr[0].length;
		
		int[][] res = new int[row][col];
		
		int colIndex = col;
		
		for (int i = 0; i < row; i++){
			colIndex--;
			for(int j = 0; j < col; j++){
				res[j][colIndex] = arr[i][j];
			}
		}
		return res;		
	}
	
	public void rotate2(int[][] arr) {
		if (arr == null) {
			return;
		}
		int bR = 0;
		int bC = 0;
		int eR = arr.length - 1;
		int eC = arr[0].length - 1;
		
		while (bR < eR) {
			rotateEdge(arr, bR++, bC++, eR--, eC--);
		}
	}
	
	public void rotateEdge(int[][] arr, int bR, int bC, int eR, int eC) {
		int times = eC - bC;
		
		for(int i = 0; i < times; i++) {
			int tmp = arr[bR][bC + i];
			arr[bR][bC + i] = arr[eR - i][bC];
			arr[eR - i][bC] = arr[eR][eC - i];
			arr[eR][eC - i] = arr[bR + i][eC];
			arr[bR + i][eC] = tmp;
		}
	}
}
