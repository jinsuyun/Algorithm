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
		// �ֻ��� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());//�������� x�� y��ǥ�� �ݴ�� ���� (r,c)�κ��� �� �о���� ����!!!!
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
			if(move[i]==1) {// �� �� �� ��
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
			}else {//������ �Ѿ�� ���ø� ������� �̸� �����س��� nx,ny�� ����
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
	public static void change(int dir) {//�� �� �� ��
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
