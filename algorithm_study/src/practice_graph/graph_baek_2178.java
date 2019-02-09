package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_2178 {
	static int n,m;
	static int[] dx= {1,0,-1,0},dy= {0,-1,0,1};
	static int[][] map;
	static int[][] visit;
	public static void main(String[] args) throws IOException {
		// 미로찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map = new int [n][m];
		visit = new int [n][m];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j]==0&&map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		System.out.println(visit[n-1][m-1]);
	}
	
	public static void bfs(int y,int x) {
		Queue<DIST> q= new LinkedList<DIST>();
		q.add(new DIST(x,y));
		visit[y][x]+=1;
		while(!q.isEmpty()) {
			DIST xy=q.poll();
			int xx=xy.x;
			int yy=xy.y;
			for(int k=0;k<4;k++) {
				int nx=xx+dx[k];
				int ny=yy+dy[k];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(visit[ny][nx]==0&&map[ny][nx]==1) {
						q.add(new DIST(nx,ny));
						visit[ny][nx]=visit[yy][xx]+1;
					}
				}
			}
			
		}
	}

}
class DIST{
	int x,y;
	DIST(int x,int y){
		this.x=x;
		this.y=y;
	}
}
