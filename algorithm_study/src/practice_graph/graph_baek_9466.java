package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_baek_9466 {
	static ArrayList<Integer>[] map;
	static int[] visit;
	static int[] start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Term Project
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st =new StringTokenizer(br.readLine());
			map=new ArrayList[n+1];
			visit=new int[n+1];
			start=new int[n+1];
			
			for(int i=1;i<=n;i++) {
				map[i]=new ArrayList();
			}
			
			for(int i=1;i<=n;i++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
			
			int count2=0;
			
			for(int i=1;i<=n;i++) {
				if(visit[i]==0) {
					count2+=dfs(i,1,i);
					
				}
			}
			
			System.out.println(n-count2);
		}
	}
	public static int dfs(int x,int count,int star) {
		/*이미 방문했던 정점이고
         * 시작정점이 star와 다르면 star 정점은 사이클 외에 있는 정점이므로 0을 리턴,
         * 아니면 (현재 cnt - star로부터 몇번째로 방문한 정점인지) 리턴
         */
		if(visit[x]!=0) {//이미 방문했다면
			if(star!=start[x])//시작정점과 star와 다르면 정점은 사이클 외에 있는 정점이므로 0 출력 사이클의 노드만 개수를 세는것임
				return 0;
			
			return count-visit[x];
	
		}
		
		visit[x]=count;
		start[x]=star;
		
		return dfs(map[x].get(0),count+1,star);
	}

}
