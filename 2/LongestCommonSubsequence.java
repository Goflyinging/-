public class LongestCommonSubsequence {
	public static final int UP = 0;  //��
	public static final int UPLEFT = 1;//б��
	public static final int LEFT = 2;//��
	/**
	 * ���㷨�������������ַ��������Ĺ���������
	 * @param X  �ַ���A
	 * @param Y  �ַ���B
	 */
	public static void LCS(String X, String Y) {
		int m = X.length() + 1;
		int n = Y.length() + 1;
		int[][] b = new int[m][n];
		int[][] c = new int[m][n];

		for (int i = 0; i < m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = UPLEFT;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = UP;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = LEFT;
				}
			}
		}
		PrintLCS(b, X, m - 1, n - 1);
	}
/**
 * �η���������ӡ��� �����ַ��������Ĺ���������
 * @param b �������ָ�������
 * @param X �ַ���A
 * @param i �ַ���A�ĳ���
 * @param j �ַ���B�ĳ���
 */
	public static void PrintLCS(int[][] b, String X, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (b[i][j] == UPLEFT) {
			PrintLCS(b, X, i - 1, j - 1);
			System.out.print(X.charAt(i - 1));
		} else if (b[i][j] == UP)
			PrintLCS(b, X, i - 1, j);
		else
			PrintLCS(b, X, i, j - 1);

	}

	public static void main(String[] args) {
		String A = "xzyzzyx";
		String B = "zxyyzxz";
		LCS(A, B);
		System.out.println();
		A = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
		B = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
		LCS(A, B);
	}

}
