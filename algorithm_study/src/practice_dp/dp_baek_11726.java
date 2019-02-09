package practice_dp;

import java.util.Scanner;

public class dp_baek_11726 {
	static int[] d;
	public static void main(String[] args) {
		//2XN ≈∏¿œ∏µ
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=0;
		d=new int[1001];
		d[0]=1;
		d[1]=1;
		for(int i=2;i<=n;i++) {
			
			d[i]=d[i-1]+d[i-2];
			d[i]=d[i]%10007;
		}
		
		System.out.println(d[n]);
	}

}
