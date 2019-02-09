package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_baek_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int test=0;test<t;test++) {
			int n=Integer.parseInt(br.readLine());
			int [][]map=new int[2][n+1];
			int [][]d=new int[3][n+1];
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
				for(int j=1;j<=n;j++) {
							d[0][j]=Math.max(d[0][j-1],Math.max(d[1][j-1],d[2][j-1]));
							d[1][j]=Math.max(d[0][j-1], d[2][j-1])+map[0][j];
							d[2][j]=Math.max(d[0][j-1],d[1][j-1])+map[1][j];
					
				}
			
			System.out.println(Math.max(d[0][n], Math.max(d[1][n], d[2][n])));
		}
	}

}
