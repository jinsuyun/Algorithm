package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_11724_LinkedList {
	static int n,m,count=0;
	static boolean[] check;
	static ArrayList<Integer>[] map;
	public static void main(String[] args) throws IOException {
		//연결요소의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			map[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
		}
		for(int i=1;i<=n;i++) {
			Collections.sort(map[i]);
		}
		
		check=new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			if(!check[i]) {
				bfs(i);
				//dfs(i);
				count+=1;
			}
		}
		System.out.println(count);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		check[x]=true;
		while(!q.isEmpty()) {
			int y=q.poll();
			
			for(int i:map[y]) {
				if(!check[i]) {
					check[i]=true;
					q.add(i);
				}
			}
		}
	}
	/*public static void dfs(int x) {
		if(check[x]) return;
		check[x]=true;
		
		for(int i:map[x]) {
			if(!check[i]) {
				dfs(i);
			}
		}
	}*/

}
