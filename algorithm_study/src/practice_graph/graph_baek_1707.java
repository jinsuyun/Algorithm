package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_1707 {
	static int[] check;
	static ArrayList<Integer> map[];
	public static void main(String[] args) throws IOException {
		// 이분 그래프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		for(int test=1;test<=n;test++) {
			st= new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			map = new ArrayList[v+1];
			check = new int [v+1];
			
			for(int i=1;i<=v;i++) {
				map[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				map[x].add(y);
				map[y].add(x);
			}
			for(int i=1;i<=v;i++) {
				if(check[i]==0)
					//dfs(i,1);
					bfs(i,1);
					
			}
			
			boolean ck=true;
			
			for(int i=1;i<=v;i++) {
				for(int j:map[i]) {
					if(check[i]==check[j])
						ck=false;
				}
			}
			
			if(ck)
			System.out.println("YES");
			else
			System.out.println("NO");
		}
		
	}
	public static void dfs(int v,int visit) {
		if(check[v]!=0) return;

		check[v]=visit;
			
		for(int i:map[v]) {
			if(check[i]==0) {
				dfs(i,3-visit);
			}
		}
	}
	
	public static void bfs(int v,int visit) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v]=visit;
		while(!q.isEmpty()) {
			int y= q.poll();
			
			for(int i:map[y]) {
				if(check[i]==0) {
					check[i]=check[y]*-1;
					q.add(i);
				}
			}
		}
	}
}
