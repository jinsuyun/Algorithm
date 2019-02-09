package week_19_01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_4013 {
	static int k;
	static int[][] map;
	static int[] point= {1,2,4,8};
	public static void main(String[] args) throws IOException {
		// 특이한 자석
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t=Integer.parseInt(st.nextToken());
		for(int test=1;test<=t;test++) {
			st = new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken());
			map=new int[4][8];
			
			for(int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<8;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			Queue<infoK> q = new LinkedList<infoK>();
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int tire = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				q.add(new infoK(tire-1,dir));
				solve(q);//큐에 하나 삽입 할때마다 삽인한 톱니바퀴와 또다른 톱니바퀴가 같이 돌아가는지 확인해준다.
			}
			
			int sum=0;
			for(int i=0;i<4;i++){
				if(map[i][0]==1) {
					sum+=point[i];
				}
			}
			System.out.println("#"+test+" "+sum);
			
		}
	}
	public static void solve(Queue<infoK> q) {//톱니바퀴0~4중 톱니갯수 0~7중 마주보는곳 0:2, 1:2 1:6, 2:2 2:6, 3:6
		boolean[] visited = new boolean[4];
		while(!q.isEmpty()) {
			infoK infoK=q.poll();
			int idx=infoK.idx;//0~3까지
			int rotate=infoK.rotate;
			visited[idx]=true;//방문체크를 하므로써 중복을 없애준다.
			if(idx-1>=0) {//왼쪽 체크 
				if(map[idx-1][2]!=map[idx][6]&&!visited[idx-1]) {
					q.add(new infoK(idx-1,rotate*-1));
					visited[idx-1]=true;
				}
			}
			if(idx+1<4) {//오른쪽 체크
				if(map[idx][2]!=map[idx+1][6]&&!visited[idx+1]) {
					q.add(new infoK(idx+1,rotate*-1));
					visited[idx+1]=true;
				}
			}
			if(rotate==1)
				rotate(idx);
			else rotateR(idx);
		}
	}
	public static void rotate(int idx) {
		int tmp;
		tmp=map[idx][7];
		for(int i=7;i>=1;i--) {
			map[idx][i]=map[idx][i-1];
		}
		map[idx][0]=tmp;
		
	}
	
	public static void rotateR(int idx) {
		int tmp;
		tmp=map[idx][0];
		for(int i=1;i<=7;i++) {
			map[idx][i-1]=map[idx][i];
		}
		map[idx][7]=tmp;
	}

}
class infoK{
	int idx,rotate;
	infoK(int idx,int rotate){
		this.idx=idx;
		this.rotate=rotate;
	}
}
