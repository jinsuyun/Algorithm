package week_19_01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5644 {
	static int[] moveX= {0,0,1,0,-1},moveY= {0,-1,0,1,0};//정지,상,우,하,좌
	static int[] userA,userB;
	static int[][] visit,visit2;
	static String[][] map;
	static int m,a;
	static List<User> user = new LinkedList<User>();
	static List<BC> bc = new LinkedList<BC>();
	public static void main(String[] args) throws IOException {
		// 무선 충전
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test=Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=test;t++) {
			st = new StringTokenizer(br.readLine());
			
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			map=new String[10][10];
			bc.clear();
			userA=new int[m];
			userB=new int[m];
			
				for(int j=0;j<10;j++) {
					Arrays.fill(map[j], "0");
				}
		
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) 
				userA[i]=Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) 	
				userB[i]=Integer.parseInt(st.nextToken());
			
			bc.add(new BC(0,0,0,0,0));
			for(int j=0;j<a;j++) {
				st = new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int p=Integer.parseInt(st.nextToken());
				bc.add(new BC(x-1,y-1,c,p,j+1));
				bfs(x-1,y-1,c,p,j+1);
			}
			
			int result=solve();//이동경로
			
			
			System.out.println("#"+t+" "+result);	
		}

	}
	
	public static void bfs(int x,int y,int c,int p,int cnt) {
		Queue<BC> q = new LinkedList<>();
		q.add(new BC(x,y,0,p,cnt));
		boolean[][] visited=new boolean[10][10];
		if(map[y][x]!="0")
			map[y][x]=map[y][x]+"0"+cnt;
		else
			map[y][x]=cnt+"";
		visited[y][x]=true;
		while(!q.isEmpty()) {
			BC bc = q.poll();
			if(bc.c==c) continue;
			for(int k=1;k<5;k++) {
				int xx=bc.x+moveX[k];
				int yy=bc.y+moveY[k];
				if(xx>=0&&yy>=0&&xx<=9&&yy<=9) {
					if(!visited[yy][xx]) {
						visited[yy][xx]=true;
						if(map[yy][xx]!="0") {
							map[yy][xx]=map[yy][xx]+"0"+cnt;
						}else
							map[yy][xx]=cnt+"";
						q.add(new BC(xx,yy,bc.c+1,bc.p,cnt));
					}
				}
			}
		}
	}
	
	public static int solve() {
		int result=0;
		Queue<User> q=new LinkedList<>();
		q.add(new User(0,0,0,0,0));
		q.add(new User(0,0,9,9,0));
		int i=0;
		while(!q.isEmpty()) {
			
			User user1=q.poll();
			User user2=q.poll();
			int xx=user1.x;
			int yy=user1.y;
			int xx2=user2.x2;
			int yy2=user2.y2;
			result+=calculate(xx,yy,xx2,yy2);
			if(user1.time==m) break;
			if(userA[i]==0) {
				xx=xx+moveX[0];
				yy=yy+moveY[0];	
			}else if(userA[i]==1) {
				xx=xx+moveX[1];
				yy=yy+moveY[1];
			}else if(userA[i]==2) {
				xx=xx+moveX[2];
				yy=yy+moveY[2];	
			}else if(userA[i]==3) {
				xx=xx+moveX[3];
				yy=yy+moveY[3];
			}else if(userA[i]==4) {
				xx=xx+moveX[4];
				yy=yy+moveY[4];
			}
			
			if(userB[i]==0) {
				xx2=xx2+moveX[0];
				yy2=yy2+moveY[0];
			}else if(userB[i]==1) {
				xx2=xx2+moveX[1];
				yy2=yy2+moveY[1];
			}else if(userB[i]==2) {
				xx2=xx2+moveX[2];
				yy2=yy2+moveY[2];
			}else if(userB[i]==3) {
				xx2=xx2+moveX[3];
				yy2=yy2+moveY[3];
			}else if(userB[i]==4) {
				xx2=xx2+moveX[4];
				yy2=yy2+moveY[4];
			}
			i++;
			q.add(new User(xx,yy,xx2,yy2,user1.time+1));
			q.add(new User(xx,yy,xx2,yy2,user2.time+1));
		}
		return result;
	}
	public static int calculate(int x,int y,int x2,int y2) {
		
		int[] arr1= {0},arr2= {0};
		
		if(map[y][x].length()>=3) {
			StringTokenizer st = new StringTokenizer(map[y][x],"0");
			int cnt=st.countTokens();
			arr1=new int[cnt];
			for(int i=0;i<cnt;i++) {
				arr1[i]=Integer.parseInt(st.nextToken());
			}
		}else if(!map[y][x].equals("0")) {
			arr1[0]=Integer.parseInt(map[y][x]);
		}
		
		if(map[y2][x2].length()>=3) {
			StringTokenizer st =new StringTokenizer(map[y2][x2],"0");
			int cnt=st.countTokens();
			arr2=new int [cnt];
			for(int i=0;i<cnt;i++) {
				arr2[i]=Integer.parseInt(st.nextToken());
			}
		}else if(!map[y2][x2].equals("0")) {
			arr2[0]=Integer.parseInt(map[y2][x2]);
		}
		int result=0;
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				result=Math.max(result, getMax(arr1[i],arr2[j]));
			}
		}
		
		return result;
	}
	
	 private static int getMax(int idx1,int idx2) {
	        // index가 같다면 같은 충전기에 있는 것이므로 *2 니깐 그대로
	        if(idx1==idx2) return bc.get(idx1).p;
	        else return bc.get(idx1).p+bc.get(idx2).p;
	    }
}
class BC{
	int x,y,c,p,idx;
	BC(int x,int y,int c,int p,int idx){
		this.x=x;
		this.y=y;
		this.c=c;
		this.p=p;
		this.idx=idx;
	}
}

class User{
	int x,y,x2,y2,time;
	User(int x,int y,int x2,int y2,int time){
		this.x=x;
		this.y=y;
		this.x2=x2;
		this.y2=y2;
		this.time=time;
	}
}
