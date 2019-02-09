package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_2146 {
	static int n,count=0;
	static int[][] map,visit,dist;
	static int[] dx= {1,0,-1,0},dy= {0,-1,0,1};
	static Queue<Bridge> q = new LinkedList<Bridge>();
	public static void main(String[] args) throws IOException {
		// 다리 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		map=new int[n][n];
		visit=new int[n][n];//방문
		dist=new int[n][n];//거리
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new Bridge(j,i));//육지를 큐에 넣어놓음 (동시 출발을 위함)		
				}
			}
		}
		for(int i=0;i<n;i++) {//육지에 대한 넘버링을 위한 dfs
			for(int j=0;j<n;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {//육지이고 방문하지 않으면
					visit[i][j]=1;//방문
					count++;//육지에 대한 번호를 매기기 위한 count
					dfs(j,i);
				}
			}
		}
		
		
		bfs();
		
		int result=9999999;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<4;k++) {
					int x=j+dx[k];
					int y=i+dy[k];
					if(x>=0&&y>=0&&x<n&&y<n) {//map에서 벗어나지않은 부분에서
						if(map[y][x]!=map[i][j]) {//간척사업을 한 부분에서 서로 만난다면 
							result=Math.min(result, dist[y][x]+dist[i][j]);
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void bfs() {//간척사업과 같은 섬 확장하기 위한 bfs
		while(!q.isEmpty()) {
			Bridge bridge=q.poll();
			int x=bridge.x;
			int y=bridge.y;
			for(int k=0;k<4;k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {//map이 벗어나지 않으면
					if(map[ny][nx]==0&&dist[ny][nx]==0) {//map이 바다인 곳에서
						q.add(new Bridge(nx,ny));
						dist[ny][nx]=dist[y][x]+1;//간척사업을 한 거리
						map[ny][nx]=map[y][x];//간척사업을 하기때문에 바다인 부분을 다시 육지로 만들어줌
					}
				}
			}
		}
	}
	
	public static void dfs(int x,int y) {
		if(map[y][x]==0) return;
		map[y][x]=count;//육지에 대한 넘버링
		
		for(int k=0;k<4;k++) {	
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(map[ny][nx]==1&&visit[ny][nx]==0) {//이동한 곳의 map에서 육지(1)이고 방문하지 않은 곳이면 
					visit[ny][nx]=1;//방문표시
					dfs(nx,ny);
				}
			}
		}
	}

}
class Bridge{
	int x,y;
	Bridge(int x,int y){
		this.x=x;
		this.y=y;
	}
}
