package week_10_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5648 {
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	static boolean success;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		
		for(int t=0;t<test;t++) {
			int result=0;
			int n = Integer.parseInt(br.readLine());
			Point[] pt=new Point[n+2];
			for(int i=0;i<n;i++) {
				st= new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());//방향
				int k=Integer.parseInt(st.nextToken());//에너지

				for(int j=0;j<n;j++) {
					pt[j]=new Point(x,y,dir,k);
					
				}
				result=bfs(pt,n);
			}
			
			System.out.println("#"+(t+1)+" "+result);
		
		}
	}
	public static int bfs(Point[] point,int n) {
		Queue<Point> q=new LinkedList<Point>();
		int result=0;
		Point start = point[0];
		
		q.add(start);
		while(!q.isEmpty()) {
			Point position=q.poll();
			
			
			
			if(position.x==start.x&&position.y==start.y) {
				result=result+position.k+start.k;
				continue;
			}
			else {
				q.add(position);
			}
			
			for(int i=0;i<n;i++) {
				if(i==position.dir) {
					position.x+=dx[i];
					position.y+=dy[i];
				}
			}
			
			if(position.x<-3000||position.y<-3000||position.x>3000||position.y>3000)
				continue;
			
			
		}
		
		return result;
	}
	
}

class Point{
	int x,y,dir,k;
	Point(int x,int y,int dir,int k){
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.k=k;
	}
}

