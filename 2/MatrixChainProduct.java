public class MatrixChainProduct {
/**
 * 此方法用来计算一个矩阵链相乘中最小乘法次数  并输出最终的乘法方式
 * @param A 矩阵链下标  从0开始据算
 */
	
	public static void matrixChainOrder(int[] A) {
		int n = A.length; //数组下标从1开始
		int[][] m = new int[n][n];  
		int[][] s = new int[n][n];

		for (int i = 1; i < n; i++) { 
			m[i][i] = 0;
		}
		for (int l = 2; l < n; l++) {
			for (int i = 1; i < n - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		System.out.println("最小乘法次数"+m[1][n-1]);
		PrintOptimalParens(s,1,n-1);  //递归输出最终计算结果
	}
/**
 * 此方法用于输出矩阵链乘法最小乘法次数中最终计算结果
 * @param s  计算时保存的矩阵 下标从1 开始
 * @param i  需要计算的初始位置 从1开始
 * @param j 需要计算的最终位置  从n开始
 */

	public static void PrintOptimalParens(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A"+i);
		} else {
			System.out.print("(");
			PrintOptimalParens(s,i,s[i][j]);
			PrintOptimalParens(s,s[i][j]+1,j);
			System.out.print(")");
		}

	}

	
	
	public static void main(String[] args) {
		int[] A = {3,5,2,1,10};
		int[] B = {2,7,3,6,10};
		int[] C = {10, 3, 15, 12, 7, 2};
		int[] D = {7, 2, 4, 15, 20, 5};
		matrixChainOrder(A);
		System.out.println();
		matrixChainOrder(B);
		System.out.println();
		matrixChainOrder(C);
		System.out.println();
		matrixChainOrder(D);
		System.out.println();

	}

}
