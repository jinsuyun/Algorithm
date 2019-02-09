package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class graph_baek_11724 {
	static int[][] map;
	static boolean[] visit;
	static int n,m;
	static int count=0;
	public static void main(String[] args) throws IOException {
		// 연결 요소의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int l=0,k=0;
		map = new int[1001][1001];
		visit = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=0;
			}
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			l=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			map[k][l]=1;
			map[l][k]=1;
		}
		
		for(int i=1;i<=n;i++) {
				if(!visit[i]) {
					dfs(i);
					count++;
				}
			}
		System.out.println(count);
	
		
		
	}
	public static void dfs(int v) {
		visit[v]=true;
		for(int i=1;i<=n;i++) {
				if(map[v][i]==1&&!visit[i]) {
					dfs(i);
				}
			}
	}

}
