package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_4963 {
	static int[][] map;
	static int[][] visit;
	static int w,h;
	static int[] dx= {1,1,0,-1,-1,-1,0,1},dy= {0,-1,-1,-1,0,1,1,1};
	public static void main(String[] args) throws IOException {
		// ¼¶ÀÇ °³¼ö
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean finish=true;
		while(finish) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			map=new int[h][w];
			visit=new int[h][w];
			if(w==0&&h==0) {
				break;
			}
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int count=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]==1&&visit[i][j]==0) {
						bfs(j,i,++count);
						
					}
				}
			}
			
			System.out.println(count);
			
			
			
		}

	}
	public static void bfs(int x,int y,int count) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		visit[y][x]=count;
		while(!q.isEmpty()) {
			Point xy=q.poll();
			int j=xy.x;
			int i=xy.y;
			for(int k=0;k<8;k++) {
				int nx,ny;
				nx=j+dx[k];
				ny=i+dy[k];
				if(nx>=0&&ny>=0&&nx<w&&ny<h) {
					if(visit[ny][nx]==0&&map[ny][nx]!=0) {
						q.add(new Point(nx,ny));
						visit[ny][nx]=count;
					}
				}
			}
		}
	}

}

class Point{
	int x,y;
	Point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
