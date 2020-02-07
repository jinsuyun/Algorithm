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
		// 안전영역
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
		for (rain = 0; rain <= 100; rain++) {//비가 오는 것의 정도를 나타냄 전혀오지 않을 수도 있기 때문에 0부터 시작
			visit = new int[n][n];//비에 따라 초기화를 해줌
			int cnt = 0;//비에 따라 초기화를 해줌
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 0 && map[i][j] > rain) {//비에 잠기지 않고 방문하지 않는 곳으로 들어감
						cnt++;//카운트를 세줌 
						solve(i, j);//현 위치에서 비에 잠기지 않아 연결되어 있는 곳을 이어나감 
						result=Math.max(result, cnt);//가장 많은 지역을 출력
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
				int nx = xx + dx[k];//다음 위치
				int ny = yy + dy[k];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {//범위를 벗어나지 않아야함
					if (visit[ny][nx] == 0 && map[ny][nx] > rain) {//방문하지 않으며 비에 잠기지 않은 곳
						visit[ny][nx] = 1;//방문 체크
						q.add(new Loc(nx, ny));//큐에 넣어줌
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
