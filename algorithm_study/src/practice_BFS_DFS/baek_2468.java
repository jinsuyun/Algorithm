package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2468 {
	static int[][] map, visit;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int n;

	public static void main(String[] args) throws IOException {
		// ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int sum,result=0;
		for (int k = 0; k <=100; k++) {//k�� ���� �� n�� 100�����̱⶧���� ���� �絵 ������ �縸ŭ �־��� 
			sum = 0;//������ ������ ����� ǥ��
			visit = new int[n][n];//���� �翡 ���� visit�� �ʱ�ȭ ���ش�.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > k && visit[i][j] == 0) {//�湮���� �ʾҰ� ������ �����̸� �Լ��� ��
						solve(j, i, k);
						sum++;//������ ������ ������ ������
					}
				}
			}
			result=Math.max(sum,result);//���� �翡 ���� �ִ� ������ ������ ������ �־��ش�.
		}
		
		System.out.println(result);
	}

	public static void solve(int x, int y, int rain) {
		Queue<Safe> q = new LinkedList<>();
		q.add(new Safe(x, y));
		visit[y][x] = 1;
		while (!q.isEmpty()) {
			Safe s = q.poll();
			int xx = s.x;
			int yy = s.y;
			for (int k = 0; k < 4; k++) {
				xx = s.x + dx[k];
				yy = s.y + dy[k];
				if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
					if (visit[yy][xx] == 0 && map[yy][xx] > rain) {//�����ϰ� �湮���� ���� �� ã��
						q.add(new Safe(xx, yy));
						visit[yy][xx] = 1;
					}
				}
			}
		}
	}

}

class Safe {
	int x, y;

	Safe(int x, int y) {
		this.x = x;
		this.y = y;

	}
}
