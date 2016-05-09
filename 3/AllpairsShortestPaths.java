public class AllpairsShortestPaths {
	static final int INFINITE = 99999;

	public static void floydWarshall(int[][] graph) {
		int n = graph.length; // 行
		int[][] path = new int[n][n];
		int[][][] dist = new int[n+1][n][n];
		int i, j, k;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++) {
				dist[0][i][j] = graph[i][j];
				path[i][j] = 0;
			}
		for (k = 0; k < n; k++){
			for (i = 0; i < n; i++){
				for (j = 0; j < n; j++){
					
					if (!((dist[k][i][k]==INFINITE||dist[k][k][j]==INFINITE)&&dist[k][i][j]==INFINITE)&&dist[k][i][k] + dist[k][k][j] < dist[k][i][j]) {
						dist[k+1][i][j] = dist[k][i][k] + dist[k][k][j];
						path[i][j] = k;
					}
					else
					{
						dist[k+1][i][j]=dist[k][i][j];
					}
				}
			}
		}
		System.out.println("------------------D(5)-----------------");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(dist[5][i][j]+"\t" );
			}
			System.out.println();
		}
		System.out.println("----------------path(用于递归输出路径)-------------------");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print( path[i][j]+"\t" );
			}
			System.out.println();
		}
		System.out.println("----------------0-4：的路径-------------------");
		System.out.print(0 + " ");
		 output(0, 4, path,dist[5]);
		
	}

	public static void output(int i, int j, int[][] path,int dist[][]) {
		if(dist[i][j]==INFINITE){
			System.out.println("路径不可达");
			return;
		}
		if (i == j)
			return;
		if (path[i][j] == 0)
			System.out.print(j + " ");
		else {
			output(i, path[i][j], path,dist);
			output(path[i][j], j, path,dist);
		}
	}

	public static void main(String[] args) {

		int[][] graph = new int[5][5];
		for (int i = 0; i < 5; ++i)
			for (int j = 0; j < 5; ++j) {
				if (i == j)
					graph[i][j] = 0;
				else
					graph[i][j] = INFINITE;
			}
		graph[0][1] = -1;
		graph[0][2] = 3;
		graph[1][2] = 3;
		graph[1][3] = 2;
		graph[1][4] = 2;
		graph[3][1] = 1;
		graph[3][2] = 5;
		graph[4][3] = -3;
		AllpairsShortestPaths.floydWarshall(graph);

	}

}
