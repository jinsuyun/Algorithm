package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class graph_baek_2146 {
	static int n,count=0;
	static int[][] map,visit,dist;
	static int[] dx= {1,0,-1,0},dy= {0,-1,0,1};
	static Queue<Bridge> q = new LinkedList<Bridge>();
	public static void main(String[] args) throws IOException {
		// �ٸ� �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		map=new int[n][n];
		visit=new int[n][n];//�湮
		dist=new int[n][n];//�Ÿ�
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new Bridge(j,i));//������ ť�� �־���� (���� ����� ����)		
				}
			}
		}
		for(int i=0;i<n;i++) {//������ ���� �ѹ����� ���� dfs
			for(int j=0;j<n;j++) {
				if(map[i][j]==1&&visit[i][j]==0) {//�����̰� �湮���� ������
					visit[i][j]=1;//�湮
					count++;//������ ���� ��ȣ�� �ű�� ���� count
					dfs(j,i);
				}
			}
		}
		
		
		bfs();
		
		int result=9999999;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<4;k++) {
					int x=j+dx[k];
					int y=i+dy[k];
					if(x>=0&&y>=0&&x<n&&y<n) {//map���� ��������� �κп���
						if(map[y][x]!=map[i][j]) {//��ô����� �� �κп��� ���� �����ٸ� 
							result=Math.min(result, dist[y][x]+dist[i][j]);
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void bfs() {//��ô����� ���� �� Ȯ���ϱ� ���� bfs
		while(!q.isEmpty()) {
			Bridge bridge=q.poll();
			int x=bridge.x;
			int y=bridge.y;
			for(int k=0;k<4;k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {//map�� ����� ������
					if(map[ny][nx]==0&&dist[ny][nx]==0) {//map�� �ٴ��� ������
						q.add(new Bridge(nx,ny));
						dist[ny][nx]=dist[y][x]+1;//��ô����� �� �Ÿ�
						map[ny][nx]=map[y][x];//��ô����� �ϱ⶧���� �ٴ��� �κ��� �ٽ� ������ �������
					}
				}
			}
		}
	}
	
	public static void dfs(int x,int y) {
		if(map[y][x]==0) return;
		map[y][x]=count;//������ ���� �ѹ���
		
		for(int k=0;k<4;k++) {	
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(map[ny][nx]==1&&visit[ny][nx]==0) {//�̵��� ���� map���� ����(1)�̰� �湮���� ���� ���̸� 
					visit[ny][nx]=1;//�湮ǥ��
					dfs(nx,ny);
				}
			}
		}
	}

}
class Bridge{
	int x,y;
	Bridge(int x,int y){
		this.x=x;
		this.y=y;
	}
}
