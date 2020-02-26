package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_2573 {
	static int[][] map, visit, meetCnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, m;

	public static void main(String[] args) throws IOException {
		// 빙산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());//맵 입력
			}
		}

		int time = 0;//시간 표시
		Loop: while (true) {
			int cnt = 0;
			visit = new int[n][m];//방문 
			meetCnt = new int[n][m];//빙산이 맡닿아 있는 바다의 개수를 표현하기 위함
			for (int i = 1; i < n-1; i++) {//1첫째와 마지막 행과 열은 바다로 둘러 싸여있기에 1부터 n-1, m-1로 정해놓음
				for (int j = 1; j < m-1; j++) {
					if (map[i][j] != 0 ) {//빙산이면
						if(visit[i][j] == 0) {//방문하지 않았다면
							solve(i, j);//BFS
							cnt++;//연결요소의 개수를 구하기 위한 cnt
						}
						//완전 탐색이 끝난 후 빙하를 녹인다.
						if (map[i][j] < meetCnt[i][j])//빙산보다 바다로 둘러쌓여있는 것보다 크면 0으로 다 녹음
							map[i][j] = 0;//
						else
							map[i][j] -= meetCnt[i][j];//BFS를 다 검색한 후 meetCnt()를 빙산에서 빼줌
					}
				}
			}
			
			if (cnt==0) {//연결요소의 개수가 없으면 즉, 온 맵이 바다이면 time=0
				time=0; 
				break;
				}
			if(cnt>=2) {//연결 요소의 개수가 2이상이면 time 출력
				break;
			}
			time++;
		}
		System.out.println(time);
	}

	public static void solve(int y, int x) {
		Queue<Bingha> q = new LinkedList<>();
		q.add(new Bingha(x, y));
		while (!q.isEmpty()) {
			Bingha xy = q.poll();
			int xx = xy.x;
			int yy = xy.y;
			visit[yy][xx] = 1;//방문표시
			meetCnt[yy][xx] = meetSea(yy, xx);//바다로 둘러쌓 인 부분을 카운트한 것
			for (int k = 0; k < 4; k++) {
				int nx = dx[k] + xx;//다음 갈 곳
				int ny = dy[k] + yy;
				if (nx >= 0 && ny >= 0 && nx < m && ny < n) {//범위 안에 있으면
					if (visit[ny][nx] == 0 && map[ny][nx] > 0) {//빙산이고 방문하지 않았다면
						visit[ny][nx] = 1;//방문표시
						q.add(new Bingha(nx, ny));//BFS
						meetCnt[ny][nx] = meetSea(ny, nx);//바다로 둘러쌓 인 부분을 카운트한 것
					}
				}
			}
		}
	}

	public static int meetSea(int y, int x) {
		int cnt = 0;//if문으로 할 경우 메모리를 조금 더 줄일 수 있다.
		/*
		 * if (y + 1 < n) { if (map[y + 1][x] == 0) { cnt++; } } if (y - 1 >= 0) { if
		 * (map[y - 1][x] == 0) { cnt++; } } if (x + 1 < m) { if (map[y][x + 1] == 0) {
		 * cnt++; } } if (x + 1 >= 0) { if (map[y][x - 1] == 0) { cnt++; } }
		 */
		for(int i=0;i<4;i++) {//for문을 통해 바다인지 체크한 후 바다이면 cnt++;
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<m&&ny<n&&nx>=0&&ny>=0) {
				if(map[ny][nx]==0)
					cnt++;
			}
		}
		return cnt;
	}

}

class Bingha {
	int x, y;

	Bingha(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
