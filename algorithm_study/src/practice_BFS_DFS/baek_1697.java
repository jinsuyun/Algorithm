package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1697 {
	static int n,k;
	static int[] map,visit,dx= {-1,1,2},visitX2;
	public static void main(String[] args) throws IOException {
		// ¼û¹Ù²ÀÁú
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		map=new int[100001];
		visit=new int[100001];
		bfs(n);
		System.out.println(visit[k]-1);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visit[x]=1;
		q.add(x);
		
		while(!q.isEmpty()) {
			int xx=q.poll();
			for(int k=0;k<3;k++) {
				if(k<2) {
					int nx=xx+dx[k];
					if(nx>=0&&nx<100001) {
						if(visit[nx]==0) {
							q.add(nx);
							visit[nx]=visit[xx]+1;
						}
					}
				}
				else if (k==2) {
					int nx=xx*dx[k];
					if(nx>=0&&nx<100001) {
						if(visit[nx]==0) {
							q.add(nx);
							visit[nx]=visit[xx]+1;
						}
					}
				}
			}
		}
	}
}
