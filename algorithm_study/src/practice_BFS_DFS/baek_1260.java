package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1260 {
	static int n,m,v;
	static int[][] map;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		// BFS¿Í DFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		
		map=new int[n+1][n+1];
		visit=new int[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int here=Integer.parseInt(st.nextToken());
			int next=Integer.parseInt(st.nextToken());
			map[here][next]=1;
			map[next][here]=1;	
		}
		
		dfs(v);
		System.out.println();
		visit=new int[n+1];
		bfs(v);
		
		
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visit[x]=1;
		
		while(!q.isEmpty()) {
			int y=q.poll();
			System.out.print(y+" ");
			for(int i=1;i<=n;i++) {
				if(visit[i]==0&&map[y][i]==1) {
					q.add(i);
					visit[i]=1;
				}
			}
		}	
	}
	
	public static void dfs(int x) {
	
		visit[x]=1;
		System.out.print(x+" ");
		for(int i=1;i<=n;i++) {
			if(visit[i]==0&&map[x][i]==1) {
				dfs(i);
			}
		}
	}

}
