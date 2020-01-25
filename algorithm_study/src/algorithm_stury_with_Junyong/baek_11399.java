package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11399 {
	public static void main(String[] args) throws IOException {
		// ATM
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int[] time = new int[n];
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			time[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);//�ּ� �ð��� ����ϱ� �����̹Ƿ� �׸��� �˰������ν� ���� �ּ����� �ð��� ��� �ֵ��� ������ �Ѵ�.
		int sum=0;
		for(int i=0;i<n;i++) {
			int sum2=0;
			for(int j=0;j<=i;j++) {
				sum2+=time[j];
			}
			sum+=sum2;
		}
		
		System.out.println(sum);

	}

}
