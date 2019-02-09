package week_19_01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2383 {
	static int n,min;
	static int[][] map;
	static int[] dx= {1,0,-1,0}, dy= {0,-1,0,1},visit;
	static Stair[] stair;
	static Queue<Location> q = new LinkedList<Location>();
	static List<Location> people = new LinkedList<Location>();
	public static void main(String[] args) throws IOException {
		// ���� �Ļ�ð�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test=Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=test;t++) {
			st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			
			map=new int[n+1][n+1];
			
			stair=new Stair[2];
			people.clear();
			int idx=0;
			for(int i=1;i<=n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=1;j<=n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {//��� ��ġ
						idx+=1;
						people.add(new Location(j,i,idx,0,0,0,0));
					}else if(map[i][j]>1) {
						if(stair[0]==null) {//��� ��ġ 
							stair[0]=new Stair(j,i,map[i][j]);
						}else stair[1]=new Stair(j,i,map[i][j]);
					}
				}
			}
			visit=new int[people.size()];
			min=Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#"+t+" "+min);
			
		}
		
	}
	public static void dfs(int idx) {
		if(idx==people.size()) {
			solve();
			return;
		}
		visit[idx]=1;//��� 1�� ����
		dfs(idx+1);
		visit[idx]=2;//��� 2�� ����
		dfs(idx+1);
	}
	
	public static void solve() {
		int time=0;
		int stairX=stair[0].x;//��� 1 ��ġ x,y
		int stairY=stair[0].y;
		int stairX2=stair[1].x;//��� 2��ġ x,y
		int stairY2=stair[1].y;
		int[] sta = new int[2];
		for(int i=0;i<people.size();i++) {
			Location location;
			location = people.get(i);
			if(visit[i]==1) {
				int dist=Math.abs(stairX-location.x)+Math.abs(stairY-location.y);//���1�� ���� �Ÿ�
				q.add(new Location(location.x,location.y,location.idx,location.time,dist,1,location.wait));
			}else if(visit[i]==2) {
				int dist=Math.abs(stairX2-location.x)+Math.abs(stairY2-location.y);//���2�� ���� �Ÿ�
				q.add(new Location(location.x,location.y,location.idx,location.time,dist,2,location.wait));
			}
		}
		while(!q.isEmpty()) {
			Location loca = q.poll();
			int dist=loca.dist;
			time=loca.time;
			
			if(dist>=time) {//��ܿ� �����Ҷ����� �ð��� ���������ָ鼭 q�� �־��ش�.
				q.add(new Location(loca.x,loca.y,loca.idx,loca.time+1,loca.dist,loca.stair,loca.wait));
				continue;
			}
			
			if(loca.wait!=0) {//��� ���� �� ������
				if(loca.wait==stair[loca.stair-1].k) {
					sta[loca.stair-1]--;//����ο��� ���ش�.
					continue;
				}
				q.add(new Location(loca.x,loca.y,loca.idx,loca.time+1,loca.dist,loca.stair,loca.wait+1));
				continue;
			}
			
			 if(sta[loca.stair-1]==3) {//��ܿ��� ��� 1�а�� ����
				 q.add(new Location(loca.x, loca.y, loca.idx,loca.time+1,loca.dist,loca.stair,loca.wait));
	         }else {//��ܿ� �ִ� wait�÷��ش�. wait�� ��� �������� �� 
	        	 sta[loca.stair-1]++;
	        	 q.add(new Location(loca.x, loca.y,loca.idx,loca.time+1,loca.dist,loca.stair,loca.wait+1));
	         }
		}
		min=Math.min(min, time);
	}

}
class Location{
	int x,y,idx,time,dist,stair,wait;
	Location(int x,int y,int idx,int time,int dist,int stair,int wait){
		this.x=x;
		this.y=y;
		this.idx=idx;
		this.time=time;
		this.dist=dist;
		this.stair=stair;
		this.wait=wait;
	}
}
class Stair{
	int x,y,k;
	Stair(int x,int y,int k){
		this.x=x;
		this.y=y;
		this.k=k;
	}
}
