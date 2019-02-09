package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_2667 {
	static int[][] map;
	static int[][] visit;
	static int n;
	static int[] dx= {0,0,-1,1}, dy= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// 단지 번호 붙이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		map=new int[n+1][n+1];
		visit=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String s= br.readLine();
			for(int j=1;j<=n;j++) {
				map[i][j]=s.charAt(j-1)-'0';//Integer.parseInt(s.charAt(j-1)+""); 와 같이 문자를 숫자로 바꿔줌
			}
		}
		int count=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {
					bfs(i,j,++count);
				}
			}
		}
		int result[]=new int[count];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(visit[i][j]!=0) {
					result[visit[i][j]-1]+=1;
				}
			}
		}
		Arrays.sort(result);
		System.out.println(count);
		
		for(int i=0;i<count;i++)
			System.out.println(result[i]);
	}
	
	public static void bfs(int i,int j,int count) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(j,i));
		visit[i][j]=count;
		
		while(!q.isEmpty()) {
			XY xy=q.poll();
			int x=xy.x;
			int y=xy.y;
			for(int k=0;k<4;k++) {
				int nx,ny;
				nx=x+dx[k];
				ny=y+dy[k];
				if(nx>0&&ny>0&&nx<=n&&ny<=n) {
					if(map[ny][nx]==1&&visit[ny][nx]==0) {
						q.add(new XY(nx,ny));
						visit[ny][nx]=count;
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
