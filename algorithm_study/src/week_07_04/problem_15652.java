package week_07_04;

import java.util.Scanner;

public class problem_15652 {
	static int n,m;
	static int[] all= new int[8];
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	n=sc.nextInt();
	m=sc.nextInt();
	dfs(0);
	

		
	}
	public static void dfs(int M) {
		
		if(m==M) {
		for(int i=0;i<m;i++) {
			System.out.print(all[i]+" ");
		}
		System.out.println();
		}
		else {
			for(int i=0;i<n;i++) {
				all[M]=i+1;
				dfs(M+1);
		}
		}
		
	}

}
