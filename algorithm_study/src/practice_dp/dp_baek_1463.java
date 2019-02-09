package practice_dp;

import java.util.Scanner;

public class dp_baek_1463 {
	static int[] d;
	public static void main(String[] args) {
		int n,count=0;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		d=new int[n+1];
		d[1]=0;
		
		for (int i=2; i<=n; i++) {
			d[i] = d[i-1] + 1;
			if (i%2 == 0 && d[i] > d[i/2] + 1) {
			d[i] = d[i/2] + 1;
			}
			if (i%3 == 0 && d[i] > d[i/3] + 1) {
			d[i] = d[i/3] + 1;
			}
			count=d[i];
			}
		
		System.out.println(count);
			
	}

}
