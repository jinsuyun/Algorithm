 package practice_dp;

import java.util.Scanner;

public class dp_baek_2156 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] wine = new int [n+1];
		int[][] d = new int [3][n+1];
		
		for(int i=1;i<=n;i++) {
			wine[i]=sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			d[0][i]=Math.max(d[0][i-1],Math.max(d[1][i-1],d[2][i-1]));//i번째가 0번연속은 i-1번째가 안마신경우 1번연속마신경우 2번연속 마신경우 전부 가능
			d[1][i]=d[0][i-1]+wine[i];//i번째가 1번연속은 i-1이 0번이어야함 i번에서 1번이 충족되었기때문
			d[2][i]=d[1][i-1]+wine[i];//i번째가 2번연속은 i-1이 1번연속으로 와야함 
		}
		System.out.println(Math.max(d[0][n],Math.max(d[1][n],d[2][n])));
		
		dp(wine,n);
	}
	
	public static void dp(int[] wine,int n) {
		int [] drink = new int[n+1];
		drink[0]=0;
		drink[1]=wine[1];
		drink[2]=wine[1]+wine[2];
		for(int i=3;i<=n;i++) {
			drink[i]=Math.max(drink[i-1],Math.max(drink[i-2]+wine[i],drink[i-3]+wine[i-1]+wine[i]));
			//0번 연속 마신 경우 d[n-1] 1번 연속 마신경우 n-1은 0이고 n-2번째는 마셔도되고 안마셔도 되므로 d[n-2]+wine[n]
			//2번 연속 마신 경우 i번째와 i-1번째는 마시고 i-2번째는 마시면 안되므로 drink[i-3]+wine[i-1]+wine[i]
		}
		System.out.println(drink[n]);
		
	}

}
