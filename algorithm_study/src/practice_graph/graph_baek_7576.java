package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_7576 {
	static int n,m;
	static int[] dy= {0,-1,0,1},dx= {1,0,-1,0};
	static int[][] map,visit;
	public static void main(String[] args) throws IOException {
		// 토마토
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		visit=new int[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				visit[i][j]=-1;
				if(map[i][j]==1)
					visit[i][j]=0;//초기값에 이미 익은 토마토가 있는 곳이기 때문에 방문한것임
			}
		}
		
		bfs();
		
		int result=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result=Math.max(visit[i][j],result);
				}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j]==-1&&map[i][j]==0) {
					result=-1;
					}
				}
		}
	
		
		System.out.println(result);
	}
	
	public static void bfs() {
		Queue<Tomato> q = new LinkedList<Tomato>();
		for(int i=0;i<n;i++) {//맵에서 토마토가 동시에 익기 때문에 익은 모든 토마토를 큐에 담는다.
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					q.add(new Tomato(j,i));
					visit[i][j]=0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato tomato = q.poll();
			int xx=tomato.x;
			int yy=tomato.y;
			for(int k=0;k<4;k++) {
				int nx=xx+dx[k];
				int ny=yy+dy[k];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(visit[ny][nx]==-1&&map[ny][nx]==0) {
						q.add(new Tomato(nx,ny));
						visit[ny][nx]=visit[yy][xx]+1;
					}
				}
			}
		}
	}
}

class Tomato{
	int x,y;
	Tomato(int x,int y){
		this.x=x;
		this.y=y;
	}
}

