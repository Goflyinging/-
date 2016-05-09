public class MatrixChainProduct {
/**
 * �˷�����������һ���������������С�˷�����  ��������յĳ˷���ʽ
 * @param A �������±�  ��0��ʼ����
 */
	
	public static void matrixChainOrder(int[] A) {
		int n = A.length; //�����±��1��ʼ
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
		System.out.println("��С�˷�����"+m[1][n-1]);
		PrintOptimalParens(s,1,n-1);  //�ݹ�������ռ�����
	}
/**
 * �˷�����������������˷���С�˷����������ռ�����
 * @param s  ����ʱ����ľ��� �±��1 ��ʼ
 * @param i  ��Ҫ����ĳ�ʼλ�� ��1��ʼ
 * @param j ��Ҫ���������λ��  ��n��ʼ
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
