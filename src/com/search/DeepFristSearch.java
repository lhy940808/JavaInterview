package com.search;

//有个矩阵，判断一个矩阵中是否存在一条包含某字符串的所有字符的路径路径可以从矩阵中的任意一格开始，每一步
//可以在矩阵中的上下左右移动一格
public class DeepFristSearch {

	public static void main(String[] args) {
		char[][] target = {{'a', 'b', 't', 'g'},
						   {'c', 'f', 'c', 's'},
						   {'j', 'd', 'e', 'h'}};
		String str = "bfce";
		System.out.println("include path " + str + "  " +new DeepFristSearch().includeStrPath(target, str));
	}
	public boolean includeStrPath(char[][] target, String str) {
		if(target == null || target.length < 1 || target[0].length < 1 || str == null) {
			return false;
		}
		char[] chr = str.toCharArray();
		boolean[][] visited = new boolean[target.length][target[0].length];
		for(int i = 0; i < target.length; i++)
			for(int j = 0; j < target[0].length; j++) {
				if(hasPath(target, i, j, chr, 0, visited)){
					return true;
				}
			}
		return false;
		
	}

	private boolean hasPath(char[][] target, int i, int j, char[] chr, int index, boolean[][] visited) {
		// TODO Auto-generated method stub
		if(index == chr.length) {
			return true;
		}
		boolean finalResult = false;
		if(i >= 0 && i < target.length && j >=0 && j < target[0].length && target[i][j] == chr[index] && !visited[i][j]) {
			visited[i][j] = true;
			index++;
			finalResult = hasPath(target, i - 1, j, chr, index,visited) || hasPath(target, i + 1, j, chr, index, visited)
					|| hasPath(target, i, j - 1, chr, index, visited) || hasPath(target, i, j + 1, chr, index, visited);
			if(!finalResult) {
				index--;
				visited[i][j] = false;
			}
		}
		return finalResult;
	}
}
