package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_2210 {
	static int[][] map=new int[5][5];
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	static List<Integer> list = new LinkedList();
	public static void main(String[] args) throws IOException {
		// ������ ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++) {//�ʱ׸���
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {//��� ���� �� Ž���ؾ��ϱ� ������ ���� �˻�
			for(int j=0;j<5;j++) {
				solve("",0,i,j);
			}
		}
		
		System.out.println(list.size());

	}
	
	public static void solve(String s,int depth,int y,int x) {
		if(depth==6) {//������� ���ڰ� 6�ڸ��� �Ϸ� �Ǹ� ����Ʈ�� �ְ� ����
			if(!list.contains(Integer.parseInt(s)))//���ڰ�  ����Ʈ�� �������� ������ �߰����ش�.
					list.add(Integer.parseInt(s));
			return;
		}
		for(int k=0;k<4;k++) {//4�������� �������� �ϹǷ� 
			int xx=x+dx[k];//������ǥ���� ���� ĭ���� �̵��ϱ� ���� xx��ǥ
			int yy=y+dy[k];//������ǥ���� ���� ĭ���� �̵��ϱ� ���� yy��ǥ
			if(xx>=0&&yy>=0&&xx<5&&yy<5) {//���� ����� �ȵǹǷ� �����ȿ��� �˻�
				solve(s+map[yy][xx],depth+1,yy,xx);//�����ȿ� �ִٸ� �ڸ���depth�� 1�÷��ְ� ��� ��(6�ڸ��� ����)�� ��������� map[yy][xx]�� �����ش�. yy,xx�� ���� ��ǥ�� �˱� ����
			}
		}
	}

}
