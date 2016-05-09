public class LongestCommonSubstring {

	/**
	 * 此方法用来计算俩个字符串中最大的公共子串
	 * @param X 字符串A
	 * @param Y 字符串B
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
				if (X.charAt(i - 1) == Y.charAt(j - 1)) { //-1 是因为数组的下标比i，j小1
					c[i][j] = c[i - 1][j - 1] + 1;			
				} else {
					c[i][j] = 0;
				}
			}
		}
		PrintLCSubstring(c, X, m-1, n-1);
	}
	/**
	 * 次方法用来输出 俩个字符串中的最大公共子串
	 * @param c 在LCSubstring方法中记录的数组c
	 * @param X	字符串A
	 * @param m 字符串A的长度
	 * @param n 字符串B的长度
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
