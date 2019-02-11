package week_19_02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_2117 {
	static int[][] map, visit;
	static int n, m, result, cost;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// Ȩ ��� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int test = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());// ���� ũ��
			m = Integer.parseInt(st.nextToken());// ���� ����
			map = new int[n][n];
			visit = new int[n][n];
			result = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visit = new int[n][n];
					solve(j, i);// �� ��ġ�� ������� Ȩ ���� ��ġ�� ���ϱ� ������ map[i][j]�� 1�� �ʿ䰡 ����.
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

	public static void solve(int x, int y) {
		Queue<House> q = new LinkedList<>();
		List<House> list = new LinkedList<>();
		int sum = 0;
		list.add(new House(x, y, 1));//cnt(1)�� �Ÿ� 
		if (map[y][x] == 1)
			sum++;// �� �߰�
		//���� ���ΰ� n�̹Ƿ� �밢�� �Ÿ����� �� ����� �־���ϱ⶧���� 2*n���� �ϸ� ������ ���� �ִ�.
		for (int i = 1; i <= 2 * n; i++) {//i�� �Ÿ��� ���� �þ�� ���� �ǹ�
			for (House house : list)//ť�� ����Ʈ�� �־��ش�.
				q.add(house);
			list.clear();//������ ��������� ����Ʈ �ʱ�ȭ
			visit[y][x] = 1;
			while (!q.isEmpty()) {
				House h = q.poll();
				int xx = h.x;
				int yy = h.y;
				//ó���� for���� while�ȿ� �ְų� continueó���� ������ �ʾ� i�� �Ÿ��� ���� ����� ���� �Ÿ��� i�� ���� �������
				if (h.cnt == i) {//cnt(�Ÿ�K)�� ��� i�� �������� ����� �� �ֱ� ������ �ٽ� ó������ ���ư�����
					list.add(new House(xx, yy, h.cnt));
					continue;//�Ÿ��� �þ�� ���� ǥ���ϱ� ���� cnt�̹Ƿ�  �Ÿ��� i�� ���ٸ� i�� �ø��� ���� continue�Ѵ�.
				}
				for (int dir = 0; dir < 4; dir++) {
					xx = h.x + dx[dir];
					yy = h.y + dy[dir];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (visit[yy][xx] == 0) {
							visit[yy][xx] = visit[h.y][h.x] + 1;//visit�� �Ÿ��� ǥ���ϱ����� ���ڷ� ǥ��
							q.add(new House(xx, yy, h.cnt + 1));//���� �湮���� ���� ���̹Ƿ� �Ÿ��� 1������Ŵ

							if (map[yy][xx] == 1) {
								sum++;//�� �߰�
							}
						}
					}
				}
			}
			cost = sum * m - (i * i + (i - 1) * (i - 1));
			if (cost < 0)//�����̸� ����� �ʿ䰡 ����.
				continue;
			else {
				result = Math.max(result, sum);//���� �ִ� ���ϱ�
			}

		}
	}
}

class House {
	int x, y, cnt;

	House(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
