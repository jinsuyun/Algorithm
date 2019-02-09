package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_baek_2225 {

	public static void main(String[] args) throws IOException {
		// 합 분해
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] d =new long[k+1][n+1];
		d[0][0]=1;
		for(int i=1;i<=k;i++) {//점화식은 d[k][n]=d[k-1][n-1]+d[k][n] 
			//?+?+...+?=N에서 ?이 k개 있음 
			//?+?+...+?의 k-1개 + L(마지막 ?)=N
			//D[k-1][n-1]+D[k][n]=N
			for(int j=0;j<=n;j++) {
				for(int l=0;l<=j;l++) {
					d[i][j]=d[i][j]+d[i-1][j-l];
					d[i][j]%=1000000000;
				}
			}
			
		}
			System.out.println(d[k][n]);
	}

}
