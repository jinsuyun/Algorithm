package week_19_01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5650 {
	static int[][] map;
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	static int result,n;
	static List<Holl> holl;
	public static void main(String[] args) throws IOException {
		// �ɺ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		
		for(int test=1;test<=t;test++) {
			st= new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			
			map=new int[n][n];
			holl = new LinkedList<Holl>();
			for(int i=1;i<=5;i++)
				holl.add(new Holl(-1,-1,-1,-1));//�ʱ�ȭ
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>=6) {//��Ȧ�ϰ�� ��Ȧ����
						if(holl.get(map[i][j]-6).x==-1) {//��Ȧ�� ����Ʈ�� ���������ʾ�����
							holl.get(map[i][j]-6).x=j;
							holl.get(map[i][j]-6).y=i;
						}
						else {//���� ��Ȧ����
							holl.get(map[i][j]-6).x2=j;
							holl.get(map[i][j]-6).y2=i;
						}
					}
				}
			}
			
			result=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==0) {
						solve(j,i);
					}
				}
			}
			
			System.out.println("#"+test+" "+result);
		}
		
	}
	public static void solve(int x,int y){
		Queue<XY> q = new LinkedList<>();
		int cnt=0;
		for(int k=0;k<4;k++)//4���� ������ �� �˻��ؾ���
			q.add(new XY(x,y,cnt,k));
		
		while(!q.isEmpty()) {

			XY xy=q.poll();
			int xx=xy.x;
			int yy=xy.y;
			int dir=xy.dir;
			cnt++;
			
			if(xx==x&&yy==y&&cnt>4) {//cnt�� 4���� ������ ���������ν� 4�� ���Ҵ� �� �� ���� ū �� result�� ����
				result=Math.max(result, xy.cnt);
				continue;
			}
			
			if(dir==0) {
				xx+=dx[0];
				yy+=dy[0];
			}
			else if(dir==1) {
				xx+=dx[1];
				yy+=dy[1];
			}
			else if(dir==2) {
				xx+=dx[2];
				yy+=dy[2];		
			}
			else if(dir==3) {
				xx+=dx[3];
				yy+=dy[3];
			}
			
			if(xx<0||yy<0||xx>=n||yy>=n) {//���� ���, ������ �ݴ�� Ƚ���� 1�߰�
				if(dir==0)
					dir=2;
				else if(dir==1)
					dir=3;
				else if(dir==2)
					dir=0;
				else if(dir==3)
					dir=1;
				
				xy.cnt++;//���� ����� 1�߰�
				
				if(map[xy.y][xy.x]!=0) {//�̵��� ���� �ƴ� �̵� ���� ���� ��Ȧ�� üũ����
					if(map[xy.y][xy.x]>=6) {//��Ȧ
						int nx=holl.get(map[xy.y][xy.x]-6).x;
						int ny=holl.get(map[xy.y][xy.x]-6).y;
						int nx2=holl.get(map[xy.y][xy.x]-6).x2;
						int ny2=holl.get(map[xy.y][xy.x]-6).y2;
						
						if(xy.x==nx&&xy.y==ny) {
							q.add(new XY(nx2,ny2,xy.cnt,dir));
						}
						else {
							q.add(new XY(nx,ny,xy.cnt,dir));
						}
					}
					else {//���
						xy.dir=change(map[xy.y][xy.x],dir);
						q.add(new XY(xy.x,xy.y,xy.cnt+1,xy.dir));
					}
				}
				else
					q.add(new XY(xy.x,xy.y,xy.cnt,dir));
				continue;
			}
			
			else {//���� ����� �ʾҴٸ�
				if(map[yy][xx]==-1)//��Ȧ
					result=Math.max(result, xy.cnt);
				else if(map[yy][xx]==0)//�Ϲ� ��
					q.add(new XY(xx,yy,xy.cnt,dir));
				else if(map[yy][xx]<6&&map[yy][xx]>0) {//���
					dir=change(map[yy][xx],dir);
					q.add(new XY(xx,yy,xy.cnt+1,dir));
				}
				else if(map[yy][xx]>=6){//��Ȧ
					int nx=holl.get(map[yy][xx]-6).x;
					int ny=holl.get(map[yy][xx]-6).y;
					int nx2=holl.get(map[yy][xx]-6).x2;
					int ny2=holl.get(map[yy][xx]-6).y2;
					
					if(xx==nx&&yy==ny) {
						q.add(new XY(nx2,ny2,xy.cnt,dir));
					}
					else {
						q.add(new XY(nx,ny,xy.cnt,dir));
					}
				}
			}
			
		}
		
	}
	public static int change(int wall,int dir) {
		if(wall==1) {
			if(dir==0)
				dir=2;
			else if(dir==1)
				dir=0;
			else if(dir==2)
				dir=3;
			else if(dir==3)
				dir=1;
		}
		else if(wall==2) {
			if(dir==0)
				dir=2;
			else if(dir==1)
				dir=3;
			else if(dir==2)
				dir=1;
			else if(dir==3)
				dir=0;
				}
		else if(wall==3) {
			if(dir==0)
				dir=1;
			else if(dir==1)
				dir=3;
			else if(dir==2)
				dir=0;
			else if(dir==3)
				dir=2;
		}
		else if(wall==4) {

			if(dir==0)
				dir=3;
			else if(dir==1)
				dir=2;
			else if(dir==2)
				dir=0;
			else if(dir==3)
				dir=1;
		}
		else if(wall==5) {

			if(dir==0)
				dir=2;
			else if(dir==1)
				dir=3;
			else if(dir==2)
				dir=0;
			else if(dir==3)
				dir=1;
		}
		
		return dir;
	}
	

}
class XY{
	int x,y,cnt,dir;
	XY(int x,int y,int cnt,int dir){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
		this.dir=dir;
	}
}
class Holl{
	int x,y,x2,y2;
	Holl(int x,int y,int x2,int y2){
		this.x=x;
		this.y=y;
		this.x2=x2;
		this.y2=y2;
	}
}
