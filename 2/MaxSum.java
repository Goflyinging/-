import java.util.Arrays;

public class MaxSum {
	/**
	 * 该算法用来求一个n个数中最大连续子段和
	 * @param a 待求数组
	 * @param index 存放最大连续字段和下标
	 * @return 最大连续子段和
	 */
	public static int DPMaxSum(int[] a, int[] index) {
		int max = 0;
		int d = 0;
		index[0] = index[1] = 0;
		for (int i = 0; i < a.length; i++) {
			if (d > 0)
				d += a[i];
			else {
				d = a[i];
				index[0] = i + 1;
			}
			if (d > max) {
				max = d;
				index[1] = i + 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {		
		int a[] = {-2,11,-4,13,-5,-2};
		int[] index = new int[2];
		System.out.println("待求数组："+Arrays.toString(a));
		System.out.println("最大连续子段和：" + DPMaxSum(a,index));
		System.out.println("从第"+index[0]+"个数到第"+index[1]+"个数");

	}

}
