import java.util.Arrays;

public class KthLargest {
	private int[] a;
	private int[] b;
	public int find(int aLeft, int aRight, int bLeft, int bRight, int k) {
		int aMid = (aLeft + aRight) / 2;
		int bMid = (bLeft + bRight) / 2;
		if (aLeft > aRight)
			return b[bLeft + k - 1];
		if (bLeft > bRight)
			return a[aLeft + k - 1];
		if (a[aMid] <= b[bMid]) {
			if (k <= (aMid - aLeft) + (bMid - bLeft) + 1)
				return find(aLeft, aRight, bLeft, bMid - 1, k);
			else
				return find(aMid + 1, aRight, bLeft, bRight, k - (aMid - aLeft + 1));
		} else {
			if (k <= (aMid - aLeft) + (bMid - bLeft) + 1)
				return find(aLeft, aMid - 1, bLeft, bRight, k);
			else
				return find(aLeft, aRight, bMid + 1, bRight, k - (bMid - bLeft + 1));
		}
	}

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest();
		kthLargest.a = new int[] { 1, 4, 6,7,10};
		kthLargest.b = new int[] { 5, 8, 9 };
		System.out.println("a数组："+Arrays.toString(kthLargest.a));
		System.out.println("b数组："+Arrays.toString(kthLargest.b));
		System.out.println("待查值：5");
		System.out.println("第5个数为："+kthLargest.find(0, 4, 0, 2, 5));
	}
}