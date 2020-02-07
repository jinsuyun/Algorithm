package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_2667 {
	static int n,cnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map, visit;

	public static void main(String[] args) throws IOException {
		// DFS - ������ȣ ���̱�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		ArrayList<Integer> list = new ArrayList();
		int dangiNum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0&&map[i][j]!=0) {//�湮���� �ʰ� map�� 1�̸�(�����̸�) dfs ��
					cnt=1;//�����ȿ� ��� �ǹ��� �ִ���
					dangiNum++;//���� ��ȣ�� �����ش�.
					visit[i][j] += 1;//�湮ǥ��
					solve(i, j);
					list.add(cnt);//�ǹ��� list�� �־���
				}
			}
		}
		Collections.sort(list);
		System.out.println(dangiNum);
		for(int i:list) {
			System.out.println(i);
		}

	}

	public static void solve(int y,int x) {
		for(int k=0;k<4;k++) {//4�������� ����Ǿ� �ִ� �ǹ� �����ش�
			int nx=x+dx[k];//���� �ǹ��� ��ǥ
			int ny=y+dy[k];
			if(ny>=0&&nx>=0&&ny<n&&nx<n) {//map�� �����ȿ� �־����
				if(visit[ny][nx]==0&&map[ny][nx]==1) {//�湮���� �ʾҰ� �ǹ��̶��
					cnt++;//�ǹ� ���� ++
					visit[ny][nx]=1;//�湮 ǥ��
					solve(ny,nx);//��ͷ� �ٽ� ���� �ǹ��� �̵�
				}
			}
		}
	}

}
