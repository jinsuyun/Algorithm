package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_10451 {
	static ArrayList<Integer> map[];
	static boolean check[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// º¯ø≠ ΩŒ¿Ã≈¨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			map=new ArrayList[n+1];
			
			for(int i=1;i<=n;i++) {
				map[i]=new ArrayList<Integer>();
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i=1;i<=n;i++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
			
			check=new boolean[n+1];
			int count=0;
			for(int i=1;i<=n;i++) {
				if(!check[i]) {
					//bfs(i);
					dfs(i);
				count+=1;
				}
			}
			System.out.println(count);
		}
	}
	public static void dfs(int v) {
		if(check[v]) return;
		check[v]=true;
		for(int i:map[v]) {
			if(!check[i])
				dfs(i);
		}
	}
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		check[v]=true;
		while(!q.isEmpty()) {
			int y=q.poll();
			for(int i:map[y]) {
				if(!check[i]) {
					q.add(i);
					check[i]=true;
				}
			}
		}
	}

}
