package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1012 {
	static int t,m,n,k;
	static int[] dx= {1,0,-1,0}, dy= {0,-1,0,1};
	static int[][] map,visit;
	public static void main(String[] args) throws IOException {
		// 유기농 배추
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t=Integer.parseInt(st.nextToken());
		for(int test=0;test<t;test++) {
			st= new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());//가로
			n=Integer.parseInt(st.nextToken());//세로
			k=Integer.parseInt(st.nextToken());//개수
			map = new int [n+1][m+1];
			visit = new int [n+1][m+1];
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}
			
			int cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(visit[i][j]==0&&map[i][j]==1) {
						cnt++;
						dfs(j,i);
					}
				}
			}
			System.out.println(cnt);
			
		}

	}
	public static void dfs(int x,int y) {
		visit[y][x]=1;
		for(int k=0;k<4;k++) {
			int xx=x+dx[k];
			int yy=y+dy[k];
			if(xx>=0&&yy>=0&&xx<=m&&yy<=n) {
				if(visit[yy][xx]==0&&map[yy][xx]==1) {
					visit[yy][xx]=1;
					dfs(xx,yy);
				}
			}
		}
	}

}
