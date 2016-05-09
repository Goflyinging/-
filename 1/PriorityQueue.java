public class PriorityQueue {
	final static int BaseLen = 15;
	final static int IncreaseLen = 10;
	int size = BaseLen;
	int length = 0;
	int[] arr = new int[BaseLen];

	public PriorityQueue() {

	}

	public void insert(int key) {
		if (length + 1 > arr.length) {
			int[]  temp = new int[length];
			for(int i = 0; i < length; ++i )
				temp[i] = arr[i];
			arr = new int[size = length+IncreaseLen];
			for(int i = 0; i < length; ++i )
				arr[i] = temp[i];
		}
		arr[length] = Integer.MIN_VALUE;
		length = length + 1;
		increaseKey(length, key);

	}

	public void increaseKey(int i, int key) {
		i = i - 1;
		if (key < arr[i])
			System.out.println("插入的数小于原来的数");
		arr[i] = key;
		int p = (i + 1) / 2 - 1; // 父节点
		while (i > 0 && arr[p] < arr[i]) {
			int t = arr[i];
			arr[i] = arr[p];
			arr[p] = t;
			i = p;
			p = (i + 1) / 2 - 1;
		}
	}

	public int maximum() {
		if (length == 0) {
			System.out.println("队列中没有加入元素");
			return 0;
		}
		return arr[0];
	}

	public int extractMax() {

		if (length == 0) {
			System.out.println("队列中没有加入元素");
			return 0;
		}
		int max = arr[0];
		length--;
		arr[0] = Integer.MIN_VALUE;
		maxHeapIfy(1);
		return max;

	}

	public void maxHeapIfy(int i) {
		int l = 2 * i - 1; // left左节点
		int r = 2 * i;// 右节点
		i = i - 1;
		int largest = 0;
		if (l < arr.length && arr[l] > arr[i])
			largest = l;
		else
			largest = i;
		if (r < arr.length && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int t = arr[i];
			arr[i] = arr[largest];
			arr[largest] = t;
			maxHeapIfy(largest + 1);
		}

	}

	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue();
		System.out.println("插入队列的数字:12,3,4,8,13,20,16,15,22,17");
		q.insert(12);
		q.insert(3);
		q.insert(4);
		q.insert(8);
		q.insert(13);
		q.insert(20);
		q.insert(16);
		q.insert(15);
		q.insert(22);
		q.insert(17);
		System.out.println("最大值："+q.maximum());
		q.increaseKey(3, 30);
		System.out.println("在第3个位置插入30后的最大值："+q.maximum());
	    System.out.println("取出最大值："+q.extractMax());
	    System.out.println("取出后的最大值："+q.maximum());

	}

}
