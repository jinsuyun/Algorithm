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
		// 홈 방범 서비스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int test = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());// 맵의 크기
			m = Integer.parseInt(st.nextToken());// 집의 개수
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
					solve(j, i);// 집 위치에 상관없이 홈 서비스 위치를 정하기 때문에 map[i][j]가 1일 필요가 없다.
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}

	public static void solve(int x, int y) {
		Queue<House> q = new LinkedList<>();
		List<House> list = new LinkedList<>();
		int sum = 0;
		list.add(new House(x, y, 1));//cnt(1)는 거리 
		if (map[y][x] == 1)
			sum++;// 집 추가
		//가로 세로가 n이므로 대각선 거리까지 다 계산해 주어야하기때문에 2*n으로 하면 끝까지 갈수 있다.
		for (int i = 1; i <= 2 * n; i++) {//i는 거리가 점점 늘어나는 것을 의미
			for (House house : list)//큐에 리스트를 넣어준다.
				q.add(house);
			list.clear();//다음에 사용을위한 리스트 초기화
			visit[y][x] = 1;
			while (!q.isEmpty()) {
				House h = q.poll();
				int xx = h.x;
				int yy = h.y;
				//처음에 for문을 while안에 넣거나 continue처리를 해주지 않아 i와 거리와 따로 놀았음 따라서 거리와 i를 같게 만들어줌
				if (h.cnt == i) {//cnt(거리K)를 계속 i와 같아져야 계산할 수 있기 때문에 다시 처음부터 돌아가야함
					list.add(new House(xx, yy, h.cnt));
					continue;//거리가 늘어나는 것을 표시하기 위한 cnt이므로  거리와 i가 같다면 i를 올리기 위해 continue한다.
				}
				for (int dir = 0; dir < 4; dir++) {
					xx = h.x + dx[dir];
					yy = h.y + dy[dir];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (visit[yy][xx] == 0) {
							visit[yy][xx] = visit[h.y][h.x] + 1;//visit의 거리를 표시하기위해 숫자로 표시
							q.add(new House(xx, yy, h.cnt + 1));//아직 방문하지 않은 곳이므로 거리를 1증가시킴

							if (map[yy][xx] == 1) {
								sum++;//집 추가
							}
						}
					}
				}
			}
			cost = sum * m - (i * i + (i - 1) * (i - 1));
			if (cost < 0)//음수이면 계산할 필요가 없다.
				continue;
			else {
				result = Math.max(result, sum);//집의 최댓값 구하기
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
