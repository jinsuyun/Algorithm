package week_10_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5644 {
	static int[][] map = new int [11][11];
	static int[] dy= {0,1,0,-1,0};
	static int[] dx= {0,0,1,0,-1};
	static int[] dir= {0,1,2,3,4};
	static final int aptower=10;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 무선 충전
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int ap=Integer.parseInt(st.nextToken());
			
			User user1 = new User(0,0,0);
			User user2 = new User(10,10,0);
			
			st= new StringTokenizer(br.readLine());
			user1.location=new int[m+1];
		
			for(int i=1;i<=m;i++) {//A이동경로
				user1.location[i]=Integer.parseInt(st.nextToken());
				
			}
			
			st= new StringTokenizer(br.readLine());
			user2.location=new int[m+1];
			
			for(int i=1;i<=m;i++) {//B이동경로
				user2.location[i]=Integer.parseInt(st.nextToken());
			}
			
			Ap_point[] ap_point = new Ap_point[m];
			
			for(int i=1;i<=ap;i++) {//AP 설정
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int p=Integer.parseInt(st.nextToken());
				ap_point[i]= new Ap_point(x,y,c,p);
				map[ap_point[i].y][ap_point[i].x]=aptower;
			}
			
			for(int i=1;i<=ap;i++) {
				
			}
			
			for(int i=1;i<=m;i++) {//이동
				user1.x+=dx[user1.location[i]];
				user1.y+=dy[user1.location[i]];
				user2.x+=dx[user2.location[i]];
				user2.y+=dy[user2.location[i]];
				
				
			}
			
			System.out.println("#"+test+" ");
		}
		
	}

}
class User{
	int x,y,charge;
	int[] location;
	User(int x,int y,int charge){
		this.x=x;
		this.y=y;
		this.charge=charge;
		
	}
	
}
class Ap_point{
	int x,y,c,p;
	Ap_point(int x,int y,int c,int p){
		this.x=x;
		this.y=y;
		this.c=c;
		this.p=p;
	}
}
