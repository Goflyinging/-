public class QuickSort{

	public static void main(String[] args) {

		int[] a = { 0, 1, 7, 3, 8, 4, 5,2,2,4 };
		System.out.println("原数组：");
		for(int i:a){
			System.out.print(i+" ");
		}
		System.out.println("\n用快排排序后的数组：");
		quickSort(a,0,9);
		for(int i:a){
			System.out.print(i+" ");
		}
		
		

	}

	public static void quickSort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);

		}

	}

	public static int partition(int[] a, int p, int r) {
		int x = a[r];
		int t = 0;
		int i = p -1 ;
		for (int j = p; j <= r; j++) {
			if(a[j] <= x){
				t = a[j];
				a[j] = a[i+1];
				a[i+1] = t;
				i++;	
			}
		}

		return i ;

	}

}
