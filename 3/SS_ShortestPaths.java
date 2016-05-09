public class SS_ShortestPaths {

	static final int INFINITE = 99999;

	public static boolean bellmanFord(int[][] g, int e, int[] d) {
		int n = g[0].length; // 列数
		int m = g.length; // 行数
		d[0] = 0;
		for (int i = 1; i < n; i++) {
			d[i] = INFINITE;
		}
		for (int i = 0; i < e - 1; ++i)
			for (int j = 0; j < n; ++j)
				for (int k = 0; k < m; ++k) {
					if (d[j] > d[k] + g[k][j])
						d[j] = d[k] + g[k][j];
				}

		for (int j = 0; j < n; ++j)
			for (int k = 0; k < m; ++k) {
				if (d[j] > d[k] + g[k][j])
					return false;
			}
		return true;
	}

	public static void main(String[] args) {
		int[][] g = new int[5][5];
		for (int i = 0; i < 5; ++i)
			for (int j = 0; j < 5; ++j)
				g[i][j] = INFINITE;
		g[0][1] = -1;
		g[0][2] = 3;
		g[1][2] = 3;
		g[1][3] = 2;
		g[1][4] = 2;
		g[3][1] = 1;
		g[3][2] = 5;
		g[4][3] = -3;
		int[] shortest = new int[g[0].length];
		if (!bellmanFord(g, 8, shortest)) {
			System.out.println("存在一个从源点可以到达的权重为负值的环路！");
		} else {
			for (int i = 0; i < g[0].length; ++i) {
				System.out.println("0-" + i + ":" + shortest[i]);
			}
		}

	}

}
