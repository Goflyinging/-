import java.util.Arrays;

public class Scheduling {
	/**
	 * �����ҵ���ȿ���ʹƽ�����ʱ����С
	 * @param jobs ����
	 */
	public static void scheduling(int[] jobs){
		Arrays.sort(jobs);
		int a=0;
		int sum = 0;
		for(int i = 0;i<jobs.length;i++){
			a +=jobs[i];
			sum +=a;	
		}
		System.out.println("the best way of scheduling��"+Arrays.toString(jobs));
		System.out.println("the min average completion time:"+sum/jobs.length);
	}
	

	public static void main(String[] args) {
		int[] jobs = {15, 8, 3, 10};
		Scheduling.scheduling(jobs);
	}

}
