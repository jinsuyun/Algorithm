package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_7576 {
	static int n,m;
	static int[][] map,visit;
	static int[] dx= {1,0,-1,0}, dy= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// ≈‰∏∂≈‰
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
			}
		}
		
		bfs();
		
		int result=0;
		for(int i=0;i<n;i++) {
			if(result==-1) break;
			for(int j=0;j<m;j++) {
				if(visit[i][j]==-1&&map[i][j]==0) {
					result=-1;
					break; 
					} 
				else
					result=Math.max(result, visit[i][j]);
			}
		}
		System.out.println(result);
		
	}
	public static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visit[i][j]==-1&&map[i][j]==1) {
					q.add(new Point(j,i));
					visit[i][j]=0;
				}
			}
		}
		while(!q.isEmpty()) {
			Point xy=q.poll();
			int xx=xy.x;
			int yy=xy.y;
			for(int k=0;k<4;k++) {
				int nx=xx+dx[k];
				int ny=yy+dy[k];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(visit[ny][nx]==-1) {
						if(map[ny][nx]!=-1) {
							q.add(new Point(nx,ny));
							visit[ny][nx]=visit[yy][xx]+1;
						}
					}
				}
			}
		}
	}

}
class Point{
	int x;
	int y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
