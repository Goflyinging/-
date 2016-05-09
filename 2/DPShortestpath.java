public class DPShortestpath {
	public static final int MAX= 999999;

	/**
	 * 次算法用于计算特定结构图的最短路径
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] path = new int[16][16];
		for (int i = 0; i < 16; ++i) // 初始化
			for (int j = 0; j < 16; ++j)
				path[i][j] = MAX; 
		path[0][1] = 5;
		path[0][2] = 3;
		path[1][3] = 1;
		path[1][4] = 3;
		path[1][5] = 6;
		path[2][4] = 8;
		path[2][5] = 7;
		path[2][6] = 6;
		path[3][7] = 6;
		path[3][8] = 8;
		path[4][7] = 3;
		path[4][8] = 5;
		path[5][8] = 3;
		path[5][9] = 3;
		path[6][8] = 8;
		path[6][9] = 4;
		path[7][10] = 2;
		path[7][11] = 2;
		path[8][11] = 1;
		path[8][12] = 2;
		path[9][11] = 3;
		path[9][12] = 3;
		path[10][13] = 3;
		path[10][14] = 5;
		path[11][13] = 5;
		path[11][14] = 2;
		path[12][13] = 6;
		path[12][14] = 6;
		path[13][15] = 4;
		path[14][15] = 3;
		int[][] f = { { 0, 0 }, { 1, 2 }, { 3, 6 }, { 7, 9 }, { 10, 12 }, { 13, 14 }, { 15, 15 } }; // 分层情况
		int[] d = new int[16]; // 记录到源点最小路径
		int[] front = new int[16]; // 记录前驱
		d[0] = 0;

		for (int i = 1; i < 16; ++i) { // 初始化俩点直接的路径为无穷
			d[i] =MAX; 
		}
		for (int i = 0; i < 6; ++i)
			for (int j = f[i][0]; j <= f[i][1]; ++j)
				for (int k = f[i + 1][0]; k <= f[i + 1][1]; ++k) {
					if (d[k] > d[j] + path[j][k]) {
						d[k] = d[j] + path[j][k];
						front[k] = j; // 记录最短路径的前驱
					}
				}
		System.out.println("The shortest path from 0 to 15:" + d[15]);
		System.out.print("The paths is:");
		printPath(front, 15);
	}

	public static void printPath(int[] front, int forward) {
		if (forward == 0)
			return;
		int i = front[forward];
		printPath(front, i);
		System.out.print(forward + " ");
	}

}
