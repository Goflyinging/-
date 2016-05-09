import java.util.Arrays;

public class MaxSum {
	/**
	 * ���㷨������һ��n��������������Ӷκ�
	 * @param a ��������
	 * @param index �����������ֶκ��±�
	 * @return ��������Ӷκ�
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
		System.out.println("�������飺"+Arrays.toString(a));
		System.out.println("��������Ӷκͣ�" + DPMaxSum(a,index));
		System.out.println("�ӵ�"+index[0]+"��������"+index[1]+"����");

	}

}
