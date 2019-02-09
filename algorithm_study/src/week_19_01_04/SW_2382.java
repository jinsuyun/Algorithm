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
		//미생물 격리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(br.readLine());
			nn=Integer.parseInt(st.nextToken());//맵 크기
			m=Integer.parseInt(st.nextToken());//격리 시간
			k=Integer.parseInt(st.nextToken());//미생물 개수
			
			map=new int[nn][nn];
			dirMap=new int[nn][nn];
			cellMap=new int[nn][nn];
			visit=new int[nn][nn][1001];
			cell.clear();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int y=Integer.parseInt(st.nextToken());//세로
				int x=Integer.parseInt(st.nextToken());//가로
				int m=Integer.parseInt(st.nextToken());//뭉쳐있는 미생물 수
				int dir=Integer.parseInt(st.nextToken());//방향 1 상 2 하 3 좌 4 우
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
			
			if(visit[ny][nx][t]>1) {//2개 이상 겹칠때
				if(map[ny][nx]>n) {//만약 다음것이 더 크다면
					cellMap[ny][nx]+=n;//합쳐줌
				}else {//큰쪽으로 방향을 바꿔주고 미생물의 개수를 합쳐줌
					map[ny][nx]=n;
					cellMap[ny][nx]+=n;
					dirMap[ny][nx]=dir;
				}
				visit[ny][nx][t]--;
				continue;//같이 겹쳐지는것들을 계속 계산해주기 때문에 continue를 해준다
			}else {//겹치지 않음
				if(n<map[ny][nx]) {//기존값과 비교하면서 방향을 바꾸고 갯수를 합쳐줌
					dir=dirMap[ny][nx];
					n+=cellMap[ny][nx];
				}else {
					n+=cellMap[ny][nx];
				}
				cellMap[ny][nx]=0;
				dirMap[ny][nx]=0;
				map[ny][nx]=0;//기존의 있는 값 초기화
				visit[ny][nx][t]=0;//이동 전 방문 횟수 빼준다
			}
			if(t==m) {//종료
				result+=n;
				continue;
			}
			if(dir==1) {//이동
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
			
			if(nx==0||ny==0||nx==nn-1||ny==nn-1) {//약물에 걸쳐있으면  반으로 줄이고 방향을 반대로 
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
					visit[c.y][c.x][t]--;//소멸 
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
