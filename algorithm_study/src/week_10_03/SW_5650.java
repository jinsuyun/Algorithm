package week_10_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5650 {
	static int[][] map;
	static int n,m;
	static int[] dx= {0,0,1,0,-1};
	static int[] dy= {0,1,0,-1,0};
	static int dir;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// «…∫º ∞‘¿”
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=t;test++) {
			n=Integer.parseInt(br.readLine());
			map= new int[n+1][n+1];
			
			for(int i=1;i<=n;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+test);
		}
	}

}
