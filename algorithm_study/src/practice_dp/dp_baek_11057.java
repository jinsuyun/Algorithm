package practice_dp;

import java.util.Scanner;

public class dp_baek_11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long d[][] = new long[n+1][10];
		long result=0;
		d[0][0]=1;
		for(int i=0;i<=9;i++) {
			d[1][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=0;k<=j;k++) {
					d[i][j]+=d[i-1][k];
					d[i][j]%=10007;
				}
			}
		}
		
		for(int i=0;i<=9;i++) {
			result+=d[n][i];
		}
		result%=10007;
		System.out.println(result);
	}

}
