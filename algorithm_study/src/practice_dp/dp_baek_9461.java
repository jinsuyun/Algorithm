package practice_dp;

import java.util.Scanner;

public class dp_baek_9461 {

	public static void main(String[] args) {
		//파도반 수열
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=1;t<=test;t++) {
			int n= sc.nextInt();
			long[] d = new long[101];
			d[1]=1;
			d[2]=1;
			d[3]=1;
			for(int i=4;i<=n;i++) {
				d[i]=d[i-2]+d[i-3];
			}
			System.out.println(d[n]);
			
		}
		
		
	}

}
