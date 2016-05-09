import java.util.Scanner;
import java.util.Random;
public class ExistTwo {
	public static void mergesort(int[] a, int p, int r) {
		if (p < r) {
			int mid = (r+p) / 2;
			mergesort(a, p, mid);
			mergesort(a, mid + 1, r);
			merge(a, p, mid, r);
		}

	}
	
	public static void merge(int[] a, int p, int q, int r) {

		int i = p;
		int j = q + 1;
		int k = p;
		
		int[] temp1 = new int[q - p + 1 +1];
		int[] temp2 = new int[r - q +1];
		int l1 = temp1.length;
		int l2 = temp2.length;
		for (int n = 0; n < l1-1; n++) {
			temp1[n] = a[i];
			i++;
		}
		for (int n = 0; n < l2-1; n++) {
			temp2[n] = a[j];
			j++;
		}
		temp1[l1-1] = 8888888;
		temp2[l2-1] = 8888888;
		i = 0;
		j = 0;

		for(; k<r+1;k++) {
			if (temp1[i] <= temp2[j]) {
				a[k] = temp1[i++];
				
			}
			else{
				a[k] = temp2[j++] ;
			}
		}//for
	}//meger
	public static int[] arrRandom(int n,int min , int max ){
		int arr[] = new int[n];
		Random  r = new Random();
		for(int i=0;i<n;i++){
			arr[i] =(r.nextInt(max-min + 1)+min);
			System.out.print(arr[i] + " ");
		}
		return arr;
		
	}//arrRandom
	public static boolean binarySearch(int arr[],int x, int min,int max){
		while(min<=max){
			int mid = (max + min)/2;
			if(arr[mid] > x)
			{
				max = mid-1;
			}
			else if(arr[mid] < x)
			{
				min = mid + 1;
			}
			else{
				return true;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		int[] a = arrRandom(10, 0, 30);
		mergesort(a, 0, 9);  //归并排序
		System.out.print("\n");
		for(int in:a){
			System.out.print(in+" ");
		}
		Scanner scanner = new Scanner(System.in);
		int i ;
		System.out.print("\n请输入你要查找的数：");
		int x = scanner.nextInt();
		for( i = 0 ;i<a.length;i++){
		 if(binarySearch(a, x -a[i], i+1, a.length -1)) //二分查找
		 {
			 System.out.print("存在: "+x+"="+a[i]+"+"+(x-a[i]));
			 break;
		 }
		}
		if(i == a.length){
			System.out.print("不存在");
		}
		
		
	}
	

}
