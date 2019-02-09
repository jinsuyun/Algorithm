package week_08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_4014 {
	static int map[][],N,T,X;
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());//지도 한 변의 크기
			X = Integer.parseInt(st.nextToken());//경사로 길이
			
			map = new int [N][N];
			Arrays.fill(visited, false);
			
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					map[j][k]=Integer.parseInt(st.nextToken());
				}		
			}	
		}
		
	}
	public static void x_dfs() {
		int n=map.length-1;
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<X;j++) {
				if(map[i][j]==map[i][j]&&!visited[i][j]) {
					x_dfs();
				}
			}
		}
		
	}
	
	public static void y_dfs() {
		int n=map.length-1;
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<X;j++) {
				if(map[i][j]==map[i][j]&&!visited[i][j]) {
					y_dfs();
				}
			}
		}
	}

}
