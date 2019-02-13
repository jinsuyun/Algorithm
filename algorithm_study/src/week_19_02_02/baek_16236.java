package week_19_02_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_16236 {
	static int n, result, x, y;
	static int[][] map, visit;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		// �Ʊ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = j;
					y = i;
				}
			}
		}

		result = 0;
		solve();

		System.out.println(result);
	}

	public static void solve() {
		Queue<Shark> q = new LinkedList<Shark>();

		q.add(new Shark(x, y, 2, 0, 0));
		visit[y][x] = 1;
		while (!q.isEmpty()) {
			int eX = 100, eY = 100;// ���� ��ġ�� ������ ��
			int eat = 0, time = 0, size = 0;
			int Qsize = q.size();//���� ��ġ�� ���̸� ���ϱ����� ���� �����ִ� �Ͱ� ���� ���ʿ� �ִ� ����⸦ ���� ����

			for (int i = 0; i < Qsize; i++) {//���� �ð����� ����� ��ġ�� Ȯ���ϰ� ���� ���� �Ծ���� ����⸦ ������
				//���� �ð����� ť�� ����ִ� ���� �������� ����� Ȯ���� �� �ִ� for��.

				Shark s = q.poll();
				int xx = s.x;
				int yy = s.y;
				for (int k = 0; k < 4; k++) {
					xx = s.x + dx[k];
					yy = s.y + dy[k];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (visit[yy][xx] == 0) {
							visit[yy][xx] = visit[s.y][s.x] + 1;//��ġ�� �̵��� �Ÿ��� ��ŭ �Ǵ��� �ľ��ϱ� ���� Integer�� �־���.
							if (map[yy][xx] > s.size) {// ����Ⱑ �Ʊ��� ������ ũ�ٸ� �� ������
								continue;
							} else {// ����� ũ�Ⱑ �Ʊ���� ���ų� �۴ٸ� �� �� �ִ�.
								q.add(new Shark(xx, yy, s.size, s.time + 1, s.eat));//�Ʊ�� ������ �� �����Ƿ� ť�� �־���
								if (map[yy][xx] != 0 && map[yy][xx] < s.size) {//���� ��ġ�� ����⸦ �Ա�����
									if (yy < eY) {//���� ���ʰ� ���� ������ �켱���� �Ծ���ϱ� ������ �̸� �������� ���� �־�ΰ� ��
										eY = yy;//���� ���� ���� �� eY�� ���Ӱ� �̵��� yy�� ���� ���ؼ� �̵��� ���� yy�� ���� ������ yy�� ���ִ� ���� �־���
										eX = xx;
										size = s.size;
										time = s.time + 1;
										eat = s.eat;
									} else if (yy == eY) {//���� �࿡ 2���� ���� �ִٸ� ���� ���ʰ��� �־��־���� ������� (1,0) (3,0)�� ����ִٸ� ���ʿ��ִ� (1,0)�� �־��־����
										if (xx < eX) {//���� �̵��� ��(xx)�� �� ���ٸ� �� ������(���ʿ� �ִ� ��)���� �̵��Ѵ�.  
											eY = yy;
											eX = xx;
											size = s.size;
											time = s.time + 1;
											eat = s.eat;
										}
									}
								}
							}
						}
					}
				}
			}
			if (eX != 100) {//�Ʊ� �� ���� ��ġ�ؾ��� ���� ������ �ִٸ�(�̸� �־��� 100�� �ٸ� ���� �̹� ���� ����Ⱑ �ִ� ����) 
				eat++;// ���� ���� �߰�
				if (size == eat) {// ������ŭ �Ծ����� �Ʊ��� ������ ��
					size++;
					eat = 0;// ���� �� �ʱ�ȭ���ش�.

				}
				map[y][x] = 0;//�Ʊ�����ġ�� ���� ������ �ٲ��ش�.
				map[eY][eX] = 9;// �Ʊ����� �̵�

				result += time;//�ɸ� �ּ� �ð��� �־���
				y = eY;//�Ʊ����� ��ġ ����
				x = eX;
				visit = new int[n][n];//����⸦ ���� �� �ٸ� ����⸦ Ž���ϱ� ���� �ٽ� ��� �湮 �迭�� �ʱ�ȭ ���ش� 
				q.clear();//����⸦ �Ծ��⶧���� �ٸ� q�� �� �ʿ䰡 ���� 
				visit[eY][eX] = 1;
				q.add(new Shark(x, y, size, 0, eat));//����⸦ ���� ��ġ���� �ٽ� Ž���� �����ϱ� ���� ť�� �־���
			}

		}

	}

}

class Shark {
	int x, y, size, time, eat;

	Shark(int x, int y, int size, int time, int eat) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.time = time;
		this.eat = eat;
	}
}
