package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2583 {
	static int n,m,k;
	static int[][] map,visit;
	static int[] dx= {1,0,-1,0},dy= {0,1,0,-1};
	static List<Integer> result = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// ���� ���ϱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		map=new int[101][101];
		visit=new int[101][101];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int lX = Integer.parseInt(st.nextToken());
			int lY = Integer.parseInt(st.nextToken());
			int rX = Integer.parseInt(st.nextToken());
			int rY = Integer.parseInt(st.nextToken());
			
			for(int j=lY;j<rY;j++) {//���簢�� ũ�� ��ŭ ���� �� ǥ��
				for(int k=lX;k<rX;k++) {
					map[j][k]=1;
				}
			}
		}
		int cnt=0;//���� ���� ���ִ� cnt
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0&&visit[i][j]==0) {
					cnt++;//���� ������ ������
					solve(j,i);
				}
			}
		}
		
		Collections.sort(result);//��������
		System.out.println(cnt);//���� ����
		for(int i=0;i<result.size();i++) 
			System.out.print(result.get(i)+" ");
		
		
	}
	public static void solve(int x,int y) {
		Queue<Square> q = new LinkedList();
		visit[y][x]=1;
		int cnt=1;
		q.add(new Square(x,y));
		while(!q.isEmpty()) {
			Square xy=q.poll();
			for(int k=0;k<4;k++) {
				int xx=xy.x+dx[k];
				int yy=xy.y+dy[k];
				if(xx>=0&&yy>=0&&xx<n&&yy<m) {//n,m �������ǻ������ ���鼭 ������ ������ 
					if(visit[yy][xx]==0) {
						visit[yy][xx]=visit[xy.y][xy.x]+1;
						if(map[yy][xx]==0) {
							q.add(new Square(xx,yy));
							cnt++;//���� ���� 0�� ������ ������
						}
					}
				}
			}
		}
		result.add(cnt);//������ ���̸� ����Ʈ�� �־��ش�
		
	
		
	}

}
class Square{
	int x,y;
	Square(int x,int y){
		this.x=x;
		this.y=y;
	}
}
