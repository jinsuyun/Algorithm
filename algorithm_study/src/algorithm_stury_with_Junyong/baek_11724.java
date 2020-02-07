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
		// 연결요소의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();//ArrayList를 배열로 선언했기 때문에 배열의 ArrayList마다 초기화를 해줘야한다.
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int curNode = Integer.parseInt(st.nextToken());
			int nextNode = Integer.parseInt(st.nextToken());
			list[curNode].add(nextNode);//방향이 없으므로 양쪽으로 넣어준다.
			list[nextNode].add(curNode);
		}

		int cnt = 0;
		for (int i = 1; i <= n; i++) {//처음 부터 방문하지 않은 노드로 들어감
			if (!visit[i]) {
				solve(list, i);
				cnt++;//연결 표시하는 카운트
			}
		}

		System.out.println(cnt);
	}

	public static void solve(ArrayList<Integer>[] list, int i) {//Integer로 제네릭을 선언해야 Object가 아닌 Integer로 받아들임
		visit[i] = true;//노드 방문 표시
		if (list[i] != null) {//노드에 어떤 값이 들어있다면
			for (int k = 0; k < list[i].size(); k++) {//여러개의 값이 들어 있을 수 있기 때문에 list의 size만큼 for문을 돌린다.
				int n = list[i].get(k);//다음 노드(현재 노드에 들어 있는 값)를 꺼내고 방문하지 않았다면 그 노드로 방문한다.
				if (!visit[n])
					solve(list, n);
			}
		}
	}
}
