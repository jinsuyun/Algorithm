package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_1260_adjacentList {
	static boolean[] visit,visit_bfs;
	static int n,m,v;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		//DFS¿Í BFS
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visit = new boolean[n+1];
		visit_bfs = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			visit[i]=false;
			for(int j=1;j<=n;j++) {
				map[i][j]=0;	
			}
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			map[l][k]=1;
			map[k][l]=1;
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
		
		
		
	}
	public static void bfs(int vertex) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		visit_bfs[vertex]=true;
		q.add(vertex);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x+" ");
			for(int i=1;i<=n;i++) {
				if(map[x][i]==1&&!visit_bfs[i]) {
					visit_bfs[i]=true;
					q.add(i);
				}
			}
		}
	}

	public static void dfs(int vertex) {
		visit[vertex]=true;
		System.out.print(vertex+" ");
		for(int i=1;i<=n;i++) {
			if(map[vertex][i]==1&&!visit[i]) {
				dfs(i);
			}
		}
		
	}

}
