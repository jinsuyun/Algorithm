package week_12_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656 {
	static int w,h,n;
	static int[] dx= {1,0,-1,0}, dy= {0,-1,0,1};
	static int[][] map,visit,tmp;
	static Queue<XY> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// º®µ¹±ú±â
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map=new int[h][w];
			visit=new int[h][w];
			tmp=new int[h][w];
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
					}
				}
			}
			
			for(int i=0;i<w;i++) {
				for(int j=0;j<h;j++) {
					if(map[j][i]!=0)
						bfs(i,j);
				}
			}
			
			int cnt=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]!=0)
						cnt++;
				}
			}
			
			System.out.println(cnt);
		}

	}
	public static void dfs() {
		
	}
	public static void copyMap() {
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				tmp[i][j]=map[i][j];
			}
		}
	}
	public static void bfs(int hx,int hy) {
		q.add(new XY(hx,hy));
		while(!q.isEmpty()) {
			XY xy=q.poll();
			int x=xy.x;
			int y=xy.y;
			if(map[y][x]==1) {
				map[y][x]=0;
			}
			
			if(map[y][x]>1) {
				map[y][x]=0;
				for(int i=1;i<map[y][x];i++) {
					for(int k=0;k<4;k++) {
						int xx=xy.x+dx[k];
						int yy=xy.y+dy[k];
						if(xx>=0&&yy>=0&&xx<w&&yy<h) {
							if(map[yy][xx]!=1&&map[yy][xx]!=0) {
								map[yy][xx]=0;
								q.add(new XY(xx,yy));
							}
						}
					}	
				}
			}
		}
		changeMap();
	}
	
	public static void changeMap() {
		for(int i=w-1;i>=0;i--) {
			for(int j=h-1;j>=0;j--) {
				if(j+1<=h-1&&map[j+1][i]!=0&&map[j][i]==0) {
					int tmp=map[j+1][i];
					map[j+1][i]=map[j][i];
					map[j][i]=tmp;
				}
			}
		}
	}
}
class XY{
	int x;
	int y;
	XY(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}
