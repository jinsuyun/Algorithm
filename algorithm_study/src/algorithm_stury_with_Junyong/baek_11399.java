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
		Arrays.sort(time);//최소 시간을 출력하기 위함이므로 그리디 알고리즘으로써 가장 최소한의 시간이 들수 있도록 정렬을 한다.
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
