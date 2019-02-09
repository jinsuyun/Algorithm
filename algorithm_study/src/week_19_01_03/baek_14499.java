package week_19_01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_14499 {
	static int n,m,x,y,k;
	static int[][] map;
	static int[] dx= {1,-1,0,0},dy= {0,0,-1,1},move,dice;
	public static void main(String[] args) throws IOException {
		// 주사위 굴리기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());//문제에서 x와 y좌표가 반대로 나옴 (r,c)부분을 잘 읽어보도록 주의!!!!
		x=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		dice=new int[7];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		move = new int[k];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<k;i++) {
			move[i]=Integer.parseInt(st.nextToken());
		}
		int nx=0,ny=0;
		for(int i=0;i<k;i++) {
			nx=x;
			ny=y;
			if(move[i]==1) {// 동 서 북 남
				x+=dx[0];
				y+=dy[0];
			}else if(move[i]==2) {
				x+=dx[1];
				y+=dy[1];
			}else if(move[i]==3) {
				x+=dx[2];
				y+=dy[2];
			}else if(move[i]==4) {
				x+=dx[3];
				y+=dy[3];
			}
			
			if(0<=x&&x<m&&0<=y&&y<n) {
				change(move[i]);
				swap(x,y);
				System.out.println(dice[1]);
			}else {//범위가 넘어가면 무시를 해줘야함 미리 저장해놓은 nx,ny를 대입
				x=nx;
				y=ny;
			}
		}
	}
	
	public static void swap(int x,int y) {
		if(map[y][x]==0) {
			map[y][x]=dice[6];
		}else {
			dice[6]=map[y][x];
			map[y][x]=0;
		}
	}
	public static void change(int dir) {//동 서 북 남
		int tmp;
		if(dir==1) {
			tmp=dice[1];
			dice[1]=dice[4];
			dice[4]=dice[6];
			dice[6]=dice[3];
			dice[3]=tmp;
		}else if(dir==2) {
			tmp=dice[4];
			dice[4]=dice[1];
			dice[1]=dice[3];
			dice[3]=dice[6];
			dice[6]=tmp;
		}else if(dir==3) {
			tmp=dice[2];
			dice[2]=dice[1];
			dice[1]=dice[5];
			dice[5]=dice[6];
			dice[6]=tmp;
		}else if(dir==4) {
			tmp=dice[1];
			dice[1]=dice[2];
			dice[2]=dice[6];
			dice[6]=dice[5];
			dice[5]=tmp;
		}
	}

}
