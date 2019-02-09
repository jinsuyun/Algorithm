package week_07_04;

import java.util.Scanner;

public class problem_15649 {
	static int n;
	static int m;
	static boolean [] visit = new boolean [8];
	static int [] all = new int[8];
	public static void main(String args[]){
		 Scanner sc= new Scanner(System.in);
		 
		 n=sc.nextInt();
		 m=sc.nextInt();
		 dfs(0);
		 
	 }
	
	 public static void dfs(int M) {
		/* for(int i=0;i<8;i++)
			 visit[i]=0;*/
		 
		 if (M==m) {
			 for(int i=0;i<m;i++) {
				// if(n!=m) {
					 System.out.print(all[i]+" ");
			 }
					 System.out.println();
					 return;
				// }
			 }
			 
			 for(int i=0;i<n;i++) {
				 if(!visit[i]) {
					 visit[i]=true;
					 all[M]=i+1;
					 dfs(M+1);
					 visit[i]=false;
				 }
			 }
	 }
}
