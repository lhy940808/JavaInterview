package com.array;

//问题：按照“之”打印矩阵

public class ZigZag {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12}};
//		new ZigZag().printMatrixZigZag(matrix);
		printMatrixZigZag2(matrix);
	}
	
	public void printMatrixZigZag(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = 0;
		int dC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		
		while (tR != endR + 1) {
			printLevel(matrix, tR, tC, dR, dC, fromUp);
			tR = tC == endC ? tR + 1 : tR;
			tC = tC == endC ? tC : tC + 1;
			dR = dR == endR ? dR : dR + 1;
			dC = dR == endR ? dC + 1 : dC;
			fromUp = !fromUp;
		}
		
		System.out.println();
	}
	
	public void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
		if (fromUp) {
			while(tR != dR + 1) {
				System.out.println(matrix[tR++][tC--] + "  ");
			}
		}else {
			while(dR != tR - 1) {
				System.out.println(matrix[dR--][dC++] + "  ");
			}
		}
	}
	
	public static void printMatrixZigZag2(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel2(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel2(int[][] m, int tR, int tC, int dR, int dC,
            boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

}
