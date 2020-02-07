package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_11724 {
	static int n, m;
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		// �������� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();//ArrayList�� �迭�� �����߱� ������ �迭�� ArrayList���� �ʱ�ȭ�� ������Ѵ�.
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int curNode = Integer.parseInt(st.nextToken());
			int nextNode = Integer.parseInt(st.nextToken());
			list[curNode].add(nextNode);//������ �����Ƿ� �������� �־��ش�.
			list[nextNode].add(curNode);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {//ó�� ���� �湮���� ���� ���� ��
			if (!visit[i]) {
				solve(list, i);
				cnt++;//���� ǥ���ϴ� ī��Ʈ
			}
		}

		System.out.println(cnt);
	}

	public static void solve(ArrayList<Integer>[] list, int i) {//Integer�� ���׸��� �����ؾ� Object�� �ƴ� Integer�� �޾Ƶ���
		visit[i] = true;//��� �湮 ǥ��
		if (list[i] != null) {//��忡 � ���� ����ִٸ�
			for (int k = 0; k < list[i].size(); k++) {//�������� ���� ��� ���� �� �ֱ� ������ list�� size��ŭ for���� ������.
				int n = list[i].get(k);//���� ���(���� ��忡 ��� �ִ� ��)�� ������ �湮���� �ʾҴٸ� �� ���� �湮�Ѵ�.
				if (!visit[n])
					solve(list, n);
			}
		}
	}
}
