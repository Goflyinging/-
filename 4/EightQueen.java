public class EightQueen {

	static int index = 0;
	public static void nQueen(int n) {
		int[] X = new int[n]; // 用于将Q放在具体的位置
		X[0] = 0;
		int k = 0; // 角标
		while (k >= 0) {
			X[k]++;
			
			while (X[k] <= n && !place(k, X)) {
				X[k]++;
			}
			if (X[k] <= n) {
				if (k == n - 1) {
					print(X);
				} else {
					k++;
					X[k] = 0;
				}
			} 
			else {
				k--;
			}
		}
	}

	private static void print(int[] X) {
		System.out.println(++index+"solution:");
		int [][] output = new int[X.length + 1][X.length + 1];
		for (int i = 0; i < X.length; ++i)
			for (int j = 0; j < X.length; ++j)
				output[i][j] = 0;
		for (int i = 0; i < X.length; ++i) {
			output[i][X[i] - 1] = 1;
		}
		for (int i = 0; i < X.length; ++i) {
			for (int j = 0; j < X.length; ++j)
				System.out.print(output[i][j] + " ");
			System.out.println();
		}

	}

	private static boolean place(int k, int[] X) {
		int i = 0;
		while (i < k) {
			if (X[i] == X[k] || Math.abs(X[i] - X[k]) == Math.abs(i - k))
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		nQueen(8);

	}

}
