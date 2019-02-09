package week_19_01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2382 {
	static int nn,m,k,result;
	static int[][] map,dirMap,cellMap;
	static int[][][] visit;
	static List<Cell> cell = new LinkedList<Cell>();
	static int[] dx= {0,0,-1,1}, dy= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		//�̻��� �ݸ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(br.readLine());
			nn=Integer.parseInt(st.nextToken());//�� ũ��
			m=Integer.parseInt(st.nextToken());//�ݸ� �ð�
			k=Integer.parseInt(st.nextToken());//�̻��� ����
			
			map=new int[nn][nn];
			dirMap=new int[nn][nn];
			cellMap=new int[nn][nn];
			visit=new int[nn][nn][1001];
			cell.clear();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int y=Integer.parseInt(st.nextToken());//����
				int x=Integer.parseInt(st.nextToken());//����
				int m=Integer.parseInt(st.nextToken());//�����ִ� �̻��� ��
				int dir=Integer.parseInt(st.nextToken());//���� 1 �� 2 �� 3 �� 4 ��
				cell.add(new Cell(x,y,m,dir,0));
				map[y][x]=m;
			}
			result=0;
			solve();
			System.out.println("#"+test+" "+result);
		
		}
	}
	private static void solve() {
		Queue<Cell> q = new LinkedList<Cell>();
		Cell c;
		for(int i=0;i<cell.size();i++) {
			c=cell.get(i);
			q.add(new Cell(c.x,c.y,c.n,c.dir,c.t));
			visit[c.y][c.x][0]++;
		}
		while(!q.isEmpty()) {
			c=q.poll();
			int nx=c.x;
			int ny=c.y;
			int dir=c.dir;
			int n=c.n;
			int t=c.t;
			
			if(visit[ny][nx][t]>1) {//2�� �̻� ��ĥ��
				if(map[ny][nx]>n) {//���� �������� �� ũ�ٸ�
					cellMap[ny][nx]+=n;//������
				}else {//ū������ ������ �ٲ��ְ� �̻����� ������ ������
					map[ny][nx]=n;
					cellMap[ny][nx]+=n;
					dirMap[ny][nx]=dir;
				}
				visit[ny][nx][t]--;
				continue;//���� �������°͵��� ��� ������ֱ� ������ continue�� ���ش�
			}else {//��ġ�� ����
				if(n<map[ny][nx]) {//�������� ���ϸ鼭 ������ �ٲٰ� ������ ������
					dir=dirMap[ny][nx];
					n+=cellMap[ny][nx];
				}else {
					n+=cellMap[ny][nx];
				}
				cellMap[ny][nx]=0;
				dirMap[ny][nx]=0;
				map[ny][nx]=0;//������ �ִ� �� �ʱ�ȭ
				visit[ny][nx][t]=0;//�̵� �� �湮 Ƚ�� ���ش�
			}
			if(t==m) {//����
				result+=n;
				continue;
			}
			if(dir==1) {//�̵�
			nx+=dx[0];
			ny+=dy[0];
			}else if(dir==2) {
				nx+=dx[1];
				ny+=dy[1];
			}else if(dir==3) {
				nx+=dx[2];
				ny+=dy[2];
			}else {
				nx+=dx[3];
				ny+=dy[3];
			}
			
			if(nx==0||ny==0||nx==nn-1||ny==nn-1) {//�๰�� ����������  ������ ���̰� ������ �ݴ�� 
				n=n/2;
				if(dir==1) {
					dir=2;
				}else if(dir==2) {
					dir=1;
				}else if(dir==3) {
					dir=4;
				}else if(dir==4){
					dir=3;
				}
				if(n==0) {
					visit[c.y][c.x][t]--;//�Ҹ� 
					continue;
				}
			}
			
			cellMap[c.y][c.x]=0;
			dirMap[c.y][c.x]=0;
			map[c.y][c.x]=0;
			visit[c.y][c.x][t]=0;
			visit[ny][nx][t+1]++;
			q.add(new Cell(nx,ny,n,dir,t+1));
		}
	}
}
class Cell{
	int x,y,n,dir,t;
	Cell(int x,int y,int n,int dir,int t){
		this.x=x;
		this.y=y;
		this.n=n;
		this.dir=dir;
		this.t=t;
	}
}
