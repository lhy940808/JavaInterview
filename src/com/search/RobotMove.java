package com.search;

//有个m * n 的方格，一个机器人从（0，0）开始移动，每次可以向上下左右移动一格，但不能进入到行和列坐标的数位之和大于k

public class RobotMove {
	
	public static void main(String[] args) {
		int[][] array = {{1,2,4},
						 {2,5,7},
						 {6,8,11}};
		
		System.out.println("step is : " + new RobotMove().countMoving(array, 20));
	}
	public int countMoving(int[][] array, int k) {
		if (array == null || array.length <= 0 || array[0].length <= 0 || k < 0) {
			return 0;
		}
		
		int rows= array.length;
		int cols = array[0].length;
		boolean[][] visited = new boolean[rows][cols];
		return moveCore(array, 0, 0, k, visited);
	}

	private int moveCore(int[][] array, int i, int j, int threshold, boolean[][] visited) {
		// TODO Auto-generated method stub
		int count = 0;
		if(check(array, i, j,threshold, visited)) {
			visited[i][j] = true;
			count = 1 + moveCore(array, i - 1, j, threshold, visited) + moveCore(array, i + 1, j, threshold, visited)
					  + moveCore(array, i, j - 1, threshold, visited) + moveCore(array, i, j + 1, threshold, visited);
		}
		return count;
	}

	private boolean check(int[][] array, int i, int j, int threshold, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(i >= 0 && i < array.length && j >= 0 && j < array[0].length && !visited[i][j] && getDigitSum(i) + getDigitSum(j) <= threshold) {
			return true;
		}
		
		return false;
	}

	private int getDigitSum(int number) {
		// TODO Auto-generated method stub
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

}
