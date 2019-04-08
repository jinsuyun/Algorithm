package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_1941 {
	static char[][] map = new char[5][5];
	static boolean[] visit = new boolean[25];
	static boolean[][] mapVisit = new boolean[5][5];
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int result = 0, count = 0;

	public static void main(String[] args) throws IOException {
		// �ҹ��� ĥ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {// �� �б�
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = s.charAt(j);
			}
		}
//DFS�� ������ Ǯ�� ������ ���ڰ� ������ ���� �ľ��� �� ���� ������ �л� 25���� ��ȣ�� �����Ͽ� 25�� �� 7���� �����ϰ� �� ������ �ο��� ���� ����Ǿ����� �ľ��Ѵ�.
		for (int i = 0; i < 25; i++) {//25���� �л��� ������
			visit = new boolean[25];//���۸��� �л��� ����Ű�� visit�� �� �л��� ��ġ�� mapVisit�� �ʱ�ȭ���ش�
			mapVisit = new boolean[5][5];
			visit[i] = true;
			mapVisit[i / 5][i % 5] = true;//1���� �迭�� i�� 2�����迭�� ǥ���Ѱ�
			if (map[i / 5][i % 5] == 'S')//�л��� S���̸� s�� ������ 1���� ��Ų��.
				solve(1, i, 1);
			else//�л��� Y�̸� 0���� �����Ѵ�.
				solve(1, i, 0);
		}

		System.out.println(result);

	}

	public static void solve(int depth, int num, int sCnt) {//depth�� �л��� �ڸ���(7���� ä������),num�� �л��� ��ȣ��� ����, sCnt�� S�л��� ����
		if(depth>7) return;//7���� ���� �����ؾ��ϱ� ������ 7�� �Ѿ�� ���������� �ð��� �ٿ��ش�.
		if (depth == 7 && sCnt >= 4) {//�л� 7��� S�� 4���̻��̸�
			visited = new boolean[5][5];//visited�� �л��� �������ִ��� Ȯ���Ϸ��� visited
			count = 0;//ĥ���ָ� �����ֱ� ���� count�� ������ �ʱ�ȭ���ش�. 
			for (int i = 0; i < 5; i++) {//�л��� ��ġ �ľ��� ���� 2�� for�� 
				for (int j = 0; j < 5; j++) {
					if (!visited[i][j] && mapVisit[i][j]) {//mapVisit�� ���� ���� �л���ġ�� �������� ���̱� ������  true�� �Ǿ�� �� �ڸ��� �л��� �ִ� ���� check�� ���� �������� �� �� ����
						visited[i][j] = true;//�湮 ǥ��
						count = 1;//�Ѹ��� �������Ƿ� 1���� ��Ų�� count�� 7�� �Ǹ� ��
						check(i, j);
					}
				}
			}
			return;
		}
		for (int i = num + 1; i < 25; i++) {//25���� �л��� 7���� �����ϱ����� for�� start�� num+1�� �����ؼ� ��� �л� �� 7���� ����
			//��ȣ����� for���� ���� ��� �л��� Ž��
			if (!visit[i]) {//�л��� ��ȣ�� �湮���� �ʾҴٸ� �湮ǥ��
				visit[i] = true;
				mapVisit[i / 5][i % 5] = true;//i��� ��ȣ�� 1���� �迭�� 2���� �迭�� �ٲ� �� 
				if (map[i / 5][i % 5] == 'S')//S�̸� sCnt�� 1���� �ƴϸ� �״��
					solve(depth + 1, i, sCnt + 1);//�л� 1���� á���ϱ� depth�� +1�� �ϰ� �� �л��� ��ȣ�� i�� �Ѱ��ش�.
				else
					solve(depth + 1, i, sCnt);
			}
			visit[i] = false;//������������ false���ش�.
			mapVisit[i / 5][i % 5] = false;
		}
	}

	public static void check(int y, int x) {//�л� 7���� ���� ������ �ִ� �� Ȯ�� �ϱ� ���� 
		if (count == 7) {//�л� 7���� ������ �ִٸ� result�� ����������
			result++;
		} else {
			for (int k = 0; k < 4; k++) {//��ĭ�� �̵��ϸ� �����ߴ��� �ľ�
				int xx = x + dx[k];
				int yy = y + dy[k];
				if (xx >= 0 && yy >= 0 && xx < 5 && yy < 5) {//���� �ȿ� �ְ� 
					if (mapVisit[yy][xx] && !visited[yy][xx]) {//mapVisit�� �л��� ��ġ�� �ľ��ϴ� ���̹Ƿ� true�� ���� map���� �� �л��� ��ġ�� ���� visited�� ���� �����ߴ����� �ľ��ϱ� ����
						visited[yy][xx] = true;
						count += 1;//�������� �Ѿ�鼭 �л��� �Ѹ� �÷������� 7���� �ɶ����� check�Լ��� ������. 
						check(yy, xx);//����ĭ���� �Ѿ
					}
				}
			}
		}
	}
}
