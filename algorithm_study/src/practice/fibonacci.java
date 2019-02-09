package practice;

import java.util.Scanner;

public class fibonacci {
	static int[] memo = new int [100];
	static int[] d = new int [100];
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int input= sc.nextInt();
		
		for(int i=1;i<input;i++) {
			fibo(i);
			System.out.print (memo[i]+" ");
			
			
		}
		System.out.println();
		
		for(int i=1;i<input;i++) {
			fibo_bottomUp(i);
			System.out.print (d[i]+" ");
			
		}
		
	}
	
	public static int fibo(int n) {
		if(n<=1)
			return n;
		else
			if(memo[n]>0)
				return memo[n];
			memo[n]= fibo(n-1)+fibo(n-2);
			return memo[n];
	}
	
	public static int fibo_bottomUp(int n) {
		d[0]=0;
		d[1]=1;
		for(int i=2;i<=n;i++) {
			d[i]=d[i-1]+d[i-2];
		}
		return d[n];
	}

}
