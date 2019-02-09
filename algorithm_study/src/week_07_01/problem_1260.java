package week_07_01;

import java.util.Scanner;

public class problem_1260 {
	static boolean []visited;
	static int [][]adj;
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		int vertex_n=scan.nextInt();
		int edge_m=scan.nextInt();
		int detect_v=scan.nextInt();
		adj= new int[vertex_n+1][vertex_n+1];
		for(int i=0;i<vertex_n+1;i++) {
			for(int j=0;j<vertex_n;j++) {
				adj[i][j]=0;	
			}
		}
		visited=new boolean[adj.length];
		for(int i=0;i<adj.length;i++)
			visited[i]=false;
		
		for(int i=0;i<edge_m;i++) {
			int edge_x=scan.nextInt();
			int edge_y=scan.nextInt();
			adj[edge_x][edge_y]=1;
			adj[edge_y][edge_x]=1;
		}
		  for (int i = 0; i < vertex_n; i++) {
		         if (adj[detect_v][i]==1) {
		            dfs(detect_v, i);
		         }
		      }
		  for(int i=0;i<adj.length;i++) {
				if(visited[i])
					System.out.println(i);
			}

		
	}
	
	public static void dfs(int here,int v) {
		
		visited[here]=true;
		for(int i=0;i<adj.length;i++) {
			if(adj[v][i]==1&&!visited[i])
				dfs(i,v);
			
		}
		
		
	}

}
