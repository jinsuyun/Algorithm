package week_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_2048 {
	static int N,cnt,max;
	static int[][] map = new int [21][21];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
	
	public static void dfs(int[][] map, int step) {
		if(cnt==5) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					max=Math.max(max,map[i][j]);
				}
			}
			return;
		}
		for(int i=0;i<4;i++) {
			int[][] copyMap=new int [N][N];
			for(int j=0;j<N;j++) {
				copyMap[j]=Arrays.copyOf(map[j],N);
			}
			//dfs(copyMap,i)
		}
		
		
		//int[][] 
	}

}
