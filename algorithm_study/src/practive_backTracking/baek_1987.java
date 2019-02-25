package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1987 {
	static int r,c,result;
	static int[][] map;
	static boolean[] visit;
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// ���ĺ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());//����
		c=Integer.parseInt(st.nextToken());//����
		
		map=new int[r][c];
		visit=new boolean[26];//���ĺ��� üũ�ϱ� ���� �湮�� ����
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j]=s.charAt(j)-'A';//�빮�� ���ĺ��� A~Z�����̸� int������ �ٲٸ� 65~90�����̴�.
			}
		}
		result=1;//�������� ���� ���ٸ� 1�� ��� ���� �ǹǷ� �ּڰ��� 1�� �Ѵ�.
		solve(0,0,1);
		System.out.println(result);

	}
	
	public static void solve(int x,int y,int cnt) {
		int tmp=map[y][x];//map�� � �빮�ڰ� ����ִ��� �ľ��ϱ����� ����� �빮�ڴ� visit[map[y][x]�� �湮 ǥ�ø� �Ѵ�.
		visit[tmp]=true;//�湮 ǥ��
		int xx,yy;
		for(int k=0;k<4;k++) {
			xx=x+dx[k];
			yy=y+dy[k];//���� ������ ��ǥ
			if(xx>=0&&yy>=0&&xx<c&&yy<r) {
				int next=map[yy][xx];//���� �����Ұ��� �빮���� int��
				if(!visit[next]) {//�� �빮�ڸ� �湮 ���� �ʾҴٸ� ���
					result=Math.max(result,++cnt);//�ִ� ���ϱ�
					solve(xx,yy,cnt);
					--cnt;//��͸� �������� ��(������ ���� �켱 Ž���� �� ���� �����ִٸ� �� ������ �̵��ϱ� ������ �̵� Ƚ���� ������ 
					visit[next]=false;//������ �̵��߱� ������ �湮���� �ʱ�ȭ
				}
			}
		}
		
	}

}
