package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_1260 {
	static int n,m,v;
	static ArrayList<Integer>[] map;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		//DFS와 BFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		v=Integer.parseInt(st.nextToken());
		map = (ArrayList<Integer>[]) new ArrayList[n+1];
		check = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			map[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			map[x].add(y);
			map[y].add(x);
		}
		  for (int i=1; i<=n; i++) {//이유는 아직 잘 모르겠지만 정렬을 해주어야 함
	            Collections.sort(map[i]);
	        }
		  
		dfs(v);
		System.out.println();
		check = new boolean[n+1];
		bfs(v);
		System.out.println();
		
	}
	public static void dfs(int x) {//재귀함수로 dfs
		if(check[x]) return;//방문했다면 종료
		check[x]=true;//방문 표시
		System.out.print(x+" ");//방문 순서 출력
		
		for(int i:map[x]) {//인접리스트에 있는 값을 하나씩 넣어간다. 
			if(!check[i])
				dfs(i);
			
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(x);
		check[x]=true;
		
		while(!q.isEmpty()) {
			int y=q.remove();
			System.out.print(y+" ");
			for(int i:map[y]) {
				if(!check[i]) {
					check[i]=true;
					q.add(i);
				}
				
			}
			
		}
		
	}
}