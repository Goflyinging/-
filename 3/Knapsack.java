import java.util.Arrays;

public class Knapsack {
	/**
	 * 
	 * @author lxing
	 *
	 */
	class Goods implements Comparable {
		int num;
		int values;
		int weight;

		public Goods(int num, int values, int weight) {
			this.num = num;
			this.values = values;
			this.weight = weight;
		}

		@Override
		public int compareTo(Object o) { // 降序
			double vdw1 = (double) this.values / this.weight;
			double vdw2 = (double) ((Goods) o).values / ((Goods) o).weight;
			if (vdw1 > vdw2)
				return -1;
			else if (vdw1 == vdw2)
				return 0;
			else
				return 1;
		}
	}

	/**
	 * 此方法用于解决0-1背包为整数情况下的问题
	 * 
	 * @param goods
	 *            物品
	 * @param bag
	 *            背包容量/10
	 * @return 保存价值的 m[][] 数组
	 */

	public static int[][] oneZeroKnapsack(Goods[] goods, int bag) {
		int n = goods.length;
		int[][] m = new int[n + 1][bag + 1];
		for (int j = 0; j <= bag; j++)
			m[0][j] = 0;
		for (int i = 1; i <= n; i++) {
			m[i][0] = 0;
			for (int j = 1; j <= bag; j++) {
				m[i][j] = m[i - 1][j];
				if (goods[i - 1].weight / 10 <= j
						&& goods[i - 1].values + m[i - 1][j - goods[i - 1].weight / 10] > m[i - 1][j]) {
					m[i][j] = goods[i - 1].values + m[i - 1][j - goods[i - 1].weight / 10];
				}
			}
		}
		return m;
	}

	/**
	 * 此方法用于构建0-1背包问题的解决方案
	 * 
	 * @param m
	 *            计算0-1问题时保存的数组
	 * @param goods
	 *            物品
	 * @param bag
	 *            背包的容量/10
	 * @return 一维数组 1表示选择了第i个物品，0表示没有选择
	 */
	public int[] buildSolution(int[][] m, Goods[] goods, int bag) {
		int n = goods.length;
		int j = bag;
		int[] x = new int[n + 1];
		for (int i = n; i >= 1; i--) {
			if (m[i][j] == m[i - 1][j]) {
				x[i] = 0;
			} else {
				x[i] = 1;
				j = j - goods[i - 1].weight / 10;
			}
		}
		return x;
	}

	/**
	 * 此方法用于计算0-1背包在分数下的情况
	 * 
	 * @param goods
	 *            物品
	 * @param bag
	 *            背包容量/10
	 * @param x
	 *            每个物品放进背包重量的百分数
	 */
	public static void fractionalknapsack(Goods[] goods, int bag, double[] x) {
		Arrays.sort(goods);
		int n = goods.length;
		for (int i = 0; i < n; ++i) {
			if (bag - goods[i].weight >= 0) {
				bag -= goods[i].weight;
				x[goods[i].num] = 1;
			} else {
				x[goods[i].num] = (double) bag / goods[i].weight;
				break;
			}
		}
	}

	public static void main(String[] args) {
		Knapsack kn = new Knapsack();
		Goods[] goods = { kn.new Goods(0, 20, 10), kn.new Goods(1, 30, 20), kn.new Goods(2, 65, 30),
				kn.new Goods(3, 40, 40), kn.new Goods(4, 60, 50) };
		int bag = 100;
		// ----------------------------0/1 knapsack---------------------
		int[][] m = Knapsack.oneZeroKnapsack(goods, bag / 10);
		// for (int i = 0; i <= goods.length; i++) {
		// for (int j = 0; j <= bag / 10; j++) {
		// System.out.print(m[i][j]+" ");
		// }
		// System.out.println();
		// }
		int[] x = kn.buildSolution(m, goods, bag / 10);
		System.out.println("0/1 knapsack:");
		for (int i = 1; i <= goods.length; i++) // 输出 选择的背包
			System.out.print(x[i] + " ");
		// ----------------------------fractional knapsack-----------------
		double[] x1 = new double[goods.length];
		Knapsack.fractionalknapsack(goods, bag, x1);
		System.out.println("\nfractional knapsack:");
		for (int i = 0; i < goods.length; ++i) {
			System.out.print(x1[i] + " ");
		}

	}

}
