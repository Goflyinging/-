public class Knapsack {

	class Goods {
		int num;
		double values;
		double weight;
		public Goods(int num, double values, double weight) {
			this.values = values;
			this.weight = weight;
			this.num = num;
		}
	}
	/**
	 * ���㷨���ڻ��ݷ���� 0-1��������
	 * @param bag   ������
	 * @param goods ��Ʒ
	 * @param fw    ���յ�����
	 * @param fp    ���յļ۸�
	 * @param X     ����ѡ������
	 */
	public static void backTracking(double bag, Goods[] goods, double fw, double fp, boolean[] X) {
		int n = goods.length;
		double cw, cp;  //��ǰ�������ͼ�ֵ
		int k; //���ݽǱ�
		boolean[] Y = new boolean[n]; //��¼
		cw = cp = 0;
		k = 0;
		fp = -1;
		while (true) {
			if (k < n && cw + goods[k].weight > bag)
				printnode(k, Y[goods[k].num]);
			while (k < n && cw + goods[k].weight <= bag) // һֱ�����֧
			{
				cw = cw + goods[k].weight;
				cp = cp + goods[k].values;
				Y[goods[k].num] = true;
				printnode(k, Y[goods[k].num]);
				k++;
			}
			if (k >= n) {
				fp = cp;
				fw = cw;
				k = n - 1;
				for (int i = 0; i < n; ++i)
					X[i] = Y[i];
			} else
				Y[goods[k].num] = false;
			if (BOUND(cp, cw, k, bag, goods) > fp)
				printnode(k, Y[goods[k].num]);
			while (BOUND(cp, cw, k, bag, goods) <= fp) {
				while (k != -1 && Y[goods[k].num] == false)
					k--; // �����һ��û���ѹ��к��ӵĽڵ�
				if (k == -1)
					return;
				Y[goods[k].num] = false;
				cw = cw - goods[k].weight;
				cp = cp - goods[k].values;
				printnode(k, Y[goods[k].num]);
			}
			k++;
		}//while
	}

	private static double BOUND(double p, double w, int k, double bag, Goods[] goods) {
		int n = goods.length;
		for (int i = k + 1; i < n; ++i) {
			w += goods[i].weight;
			if (w < bag)
				p += goods[i].values;
			else {
				return (p + (1 - (w - bag) / goods[i].weight) * goods[i].values);
			}

		}
		return p;

	}

	private static void printnode(int k, boolean x) {
		for (int i = 0; i < k; ++i)
			System.out.print(" ");
		System.out.println(k + 1 + ":" + x);
	}

	private static void print(Goods[] goods, boolean[] W) {
		System.out.println("solution:");
		for (int i = 0; i < W.length; ++i) {
			System.out.println("goods" + (i + 1) + ":" + W[i]);
		}
	}

	public static void main(String[] args) {
		double bag = 100;
		Knapsack ks = new Knapsack();
		Goods[] goods = { ks.new Goods(0, 20, 10), ks.new Goods(1, 30, 20), ks.new Goods(2, 65, 30),
				ks.new Goods(3, 40, 40), ks.new Goods(4, 60, 50) };
		double fw = 0, fp = 0;
		boolean[] X = new boolean[goods.length];
		backTracking(bag, goods, fw, fp, X);
		print(goods, X);
	}

}
