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
		// 안전 영역
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
		for (int k = 0; k <=100; k++) {//k는 비의 양 n이 100이하이기때문에 비의 양도 육지의 양만큼 주어줌 
			sum = 0;//안전한 영역이 몇개인지 표시
			visit = new int[n][n];//비의 양에 따라 visit을 초기화 해준다.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > k && visit[i][j] == 0) {//방문하지 않았고 안전한 영역이면 함수로 들어감
						solve(j, i, k);
						sum++;//안전한 영역의 개수를 세어줌
					}
				}
			}
			result=Math.max(sum,result);//비의 양에 따라 최대 안전한 영역의 개수를 넣어준다.
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
					if (visit[yy][xx] == 0 && map[yy][xx] > rain) {//안전하고 방문하지 않은 곳 찾기
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
