package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2178 {
	static int n,m;
	static int[][] map,visit;
	static int[] dx= {1,0,-1,0},dy= {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		// 미로찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		visit=new int[n][m];
		for(int i=0;i<n;i++) {
			String s=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		bfs(0,0,1);
		System.out.println(visit[n-1][m-1]);
		
	}
	public static void bfs(int x,int y,int cnt) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(x,y));
		visit[y][x]=cnt;
		while(!q.isEmpty()) {
			XY xy=q.poll();
			int xx=xy.x;
			int yy=xy.y;
			for(int k=0;k<4;k++) {
				int nx=xx+dx[k];
				int ny=yy+dy[k];
				if(nx>=0&&ny>=0&&nx<m&&ny<n) {
					if(visit[ny][nx]==0&&map[ny][nx]==1) {
						q.add(new XY(nx,ny));
						visit[ny][nx]=visit[yy][xx]+1;
						
					}
				}
			}
			
		}
	}

}
class XY{
	int x,y;
	XY(int x,int y){
		this.x=x;
		this.y=y;
	}
}
