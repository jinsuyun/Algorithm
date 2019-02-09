package week_12_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_16234 {
	static int n,l,r,count=0,sum=0;
	static int[][] people,visit,tmp; 
	static int[] dy= {0,-1,0,1},dx= {1,0,-1,0};
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static ArrayList<Point> point=new ArrayList<Point>();
	static boolean finish;
	public static void main(String[] args) throws IOException {
		// 인구이동
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		l=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		people=new int[n][n];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				people[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		finish =true;
		
		while(true) {
			sum=0;
			visit=new int[n][n];
			tmp=new int[n][n];
			finish=true;
			int result=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(visit[i][j]==0) {
						
						list=new ArrayList<Integer>();
						point=new ArrayList<Point>();
						list.add(people[i][j]);
						point.add(new Point(j,i));
						dfs(j,i);
						if(list.size()>1) {//1개만있음 안됨
							sum=0;
							result=average();
							change(result,point);
							finish=false;
						}
					}
				}
			}
			
			if(!finish) 
				count++;
			else break;
			
		}
	
		
		System.out.println(count);
	}
	
	public static int average() {//모든 인구수 평균 구하기
		for(int k=0;k<list.size();k++)
			sum+=list.get(k);
		sum=sum/list.size();
		return sum;
	}
	public static void change(int result,ArrayList<Point> point) {
		for(int i=0;i<point.size();i++) {
			int x=point.get(i).x;
			int y=point.get(i).y;
			people[y][x]=result;
		}
	}
	public static void dfs(int x,int y) {
		//if(visit[y][x]==1) return;
		visit[y][x]=1;
		for(int k=0;k<4;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(Math.abs(people[y][x]-people[ny][nx])>=l&&Math.abs(people[y][x]-people[ny][nx])<=r) {
					if(visit[ny][nx]==0) {
						//finish=false;
						list.add(people[ny][nx]);
						point.add(new Point(nx,ny));
						visit[ny][nx]=1;
						dfs(nx,ny);
						
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
