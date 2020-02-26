package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2573 {
	static int[][] map, visit, meetCnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		// ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());//�� �Է�
			}
		}

		int time = 0;//�ð� ǥ��
		Loop: while (true) {
			int cnt = 0;
			visit = new int[n][m];//�湮 
			meetCnt = new int[n][m];//������ �ô�� �ִ� �ٴ��� ������ ǥ���ϱ� ����
			for (int i = 1; i < n-1; i++) {//1ù°�� ������ ��� ���� �ٴٷ� �ѷ� �ο��ֱ⿡ 1���� n-1, m-1�� ���س���
				for (int j = 1; j < m-1; j++) {
					if (map[i][j] != 0 ) {//�����̸�
						if(visit[i][j] == 0) {//�湮���� �ʾҴٸ�
							solve(i, j);//BFS
							cnt++;//�������� ������ ���ϱ� ���� cnt
						}
						//���� Ž���� ���� �� ���ϸ� ���δ�.
						if (map[i][j] < meetCnt[i][j])//���꺸�� �ٴٷ� �ѷ��׿��ִ� �ͺ��� ũ�� 0���� �� ����
							map[i][j] = 0;//
						else
							map[i][j] -= meetCnt[i][j];//BFS�� �� �˻��� �� meetCnt()�� ���꿡�� ����
					}
				}
			}
			
			if (cnt==0) {//�������� ������ ������ ��, �� ���� �ٴ��̸� time=0
				time=0; 
				break;
				}
			if(cnt>=2) {//���� ����� ������ 2�̻��̸� time ���
				break;
			}
			time++;
		}
		System.out.println(time);
	}

	public static void solve(int y, int x) {
		Queue<Bingha> q = new LinkedList<>();
		q.add(new Bingha(x, y));
		while (!q.isEmpty()) {
			Bingha xy = q.poll();
			int xx = xy.x;
			int yy = xy.y;
			visit[yy][xx] = 1;//�湮ǥ��
			meetCnt[yy][xx] = meetSea(yy, xx);//�ٴٷ� �ѷ��� �� �κ��� ī��Ʈ�� ��
			for (int k = 0; k < 4; k++) {
				int nx = dx[k] + xx;//���� �� ��
				int ny = dy[k] + yy;
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {//���� �ȿ� ������
					if (visit[ny][nx] == 0 && map[ny][nx] > 0) {//�����̰� �湮���� �ʾҴٸ�
						visit[ny][nx] = 1;//�湮ǥ��
						q.add(new Bingha(nx, ny));//BFS
						meetCnt[ny][nx] = meetSea(ny, nx);//�ٴٷ� �ѷ��� �� �κ��� ī��Ʈ�� ��
					}
				}
			}
		}
	}

	public static int meetSea(int y, int x) {
		int cnt = 0;//if������ �� ��� �޸𸮸� ���� �� ���� �� �ִ�.
		/*
		 * if (y + 1 < n) { if (map[y + 1][x] == 0) { cnt++; } } if (y - 1 >= 0) { if
		 * (map[y - 1][x] == 0) { cnt++; } } if (x + 1 < m) { if (map[y][x + 1] == 0) {
		 * cnt++; } } if (x + 1 >= 0) { if (map[y][x - 1] == 0) { cnt++; } }
		 */
		for(int i=0;i<4;i++) {//for���� ���� �ٴ����� üũ�� �� �ٴ��̸� cnt++;
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<m&&ny<n&&nx>=0&&ny>=0) {
				if(map[ny][nx]==0)
					cnt++;
			}
		}
		return cnt;
	}

}

class Bingha {
	int x, y;

	Bingha(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
