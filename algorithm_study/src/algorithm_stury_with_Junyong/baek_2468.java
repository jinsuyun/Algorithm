package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2468 {
	static int map[][];
	static int visit[][];
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, rain;

	public static void main(String[] args) throws IOException {
		// ��������
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
		
		int result=Integer.MIN_VALUE;
		for (rain = 0; rain <= 100; rain++) {//�� ���� ���� ������ ��Ÿ�� �������� ���� ���� �ֱ� ������ 0���� ����
			visit = new int[n][n];//�� ���� �ʱ�ȭ�� ����
			int cnt = 0;//�� ���� �ʱ�ȭ�� ����
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 0 && map[i][j] > rain) {//�� ����� �ʰ� �湮���� �ʴ� ������ ��
						cnt++;//ī��Ʈ�� ���� 
						solve(i, j);//�� ��ġ���� �� ����� �ʾ� ����Ǿ� �ִ� ���� �̾�� 
						result=Math.max(result, cnt);//���� ���� ������ ���
					}
				}
			}
		}
		System.out.println(result);

	}

	public static void solve(int y, int x) {
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(x, y));
		visit[y][x] = 1;
		while (!q.isEmpty()) {
			Loc loc = q.poll();
			int xx = loc.x;
			int yy = loc.y;
			for (int k = 0; k < 4; k++) {
				int nx = xx + dx[k];//���� ��ġ
				int ny = yy + dy[k];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {//������ ����� �ʾƾ���
					if (visit[ny][nx] == 0 && map[ny][nx] > rain) {//�湮���� ������ �� ����� ���� ��
						visit[ny][nx] = 1;//�湮 üũ
						q.add(new Loc(nx, ny));//ť�� �־���
					}
				}
			}
		}
	}

}

class Loc {
	int x, y;

	Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
