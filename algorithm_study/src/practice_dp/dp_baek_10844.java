package practice_dp;

import java.util.Scanner;

public class dp_baek_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		long[][] d = new long[999][999];
		long result=0;
		d[0][0]=0;
		
		for(int i=1;i<=9;i++) {
			d[1][i]=1;
		}

		for(int i=2;i<=n;i++) {
			for(int l=0;l<=9;l++) {
				if(l-1>=0)
					d[i][l]+=d[i-1][l-1];
				if(l+1<=9)
					d[i][l]+=d[i-1][l+1];
				d[i][l]=d[i][l]%1000000000;
			}
		}
		
		for(int i=0;i<=9;i++) result=result+d[n][i];
		result=result%1000000000;
		System.out.println(result);
	}

}
