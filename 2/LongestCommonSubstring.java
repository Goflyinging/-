public class LongestCommonSubstring {

	/**
	 * �˷����������������ַ��������Ĺ����Ӵ�
	 * @param X �ַ���A
	 * @param Y �ַ���B
	 */
	public static void LCSubstring(String X, String Y) {
		int m = X.length() + 1;
		int n = Y.length() + 1;
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++) {
			c[i][0] = 0;
		}
		for (int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) { //-1 ����Ϊ������±��i��jС1
					c[i][j] = c[i - 1][j - 1] + 1;			
				} else {
					c[i][j] = 0;
				}
			}
		}
		PrintLCSubstring(c, X, m-1, n-1);
	}
	/**
	 * �η���������� �����ַ����е���󹫹��Ӵ�
	 * @param c ��LCSubstring�����м�¼������c
	 * @param X	�ַ���A
	 * @param m �ַ���A�ĳ���
	 * @param n �ַ���B�ĳ���
	 */

	public static void PrintLCSubstring(int[][] c, String X, int m, int n) {
		int max = 0;
		int indexi = 0;
		int indexj = 0;
		for(int i=1; i<=m; ++i)
			for(int j=1; j<=n; ++j)
				if(c[i][j]>max)
				{
					max = c[i][j];
					indexi = i;
					indexj = j;
				}
		for(int i=0; i<c[indexi][indexj]; ++i)
		{
			System.out.print(X.charAt(indexi-c[indexi][indexj]+i));
		}
		
			

	}

	public static void main(String[] args) {
		String A = "xzyzzyx";
		String B = "zxyyzxz";
		LCSubstring(A, B);
		System.out.println();
		A = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";               
		B = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
		LCSubstring(A, B);
	}

}
