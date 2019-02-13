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
		// 아기상어
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
			int eX = 100, eY = 100;// 먹이 위치를 저장할 곳
			int eat = 0, time = 0, size = 0;
			int Qsize = q.size();//같은 위치의 먹이를 비교하기위함 가장 위에있는 것과 가장 왼쪽에 있는 물고기를 고르기 위함

			for (int i = 0; i < Qsize; i++) {//같은 시간에서 물고기 위치를 확인하고 가장 먼저 먹어야할 물고기를 골라야함
				//같은 시간때에 큐에 들어있는 곳을 기점으로 사방을 확인할 수 있는 for문.

				Shark s = q.poll();
				int xx = s.x;
				int yy = s.y;
				for (int k = 0; k < 4; k++) {
					xx = s.x + dx[k];
					yy = s.y + dy[k];
					if (xx >= 0 && yy >= 0 && xx < n && yy < n) {
						if (visit[yy][xx] == 0) {
							visit[yy][xx] = visit[s.y][s.x] + 1;//위치의 이동과 거리가 얼만큼 되는지 파악하기 위해 Integer로 주었다.
							if (map[yy][xx] > s.size) {// 물고기가 아기상어 몸보다 크다면 못 지나감
								continue;
							} else {// 물고기 크기가 아기상어와 같거나 작다면 들어갈 수 있다.
								q.add(new Shark(xx, yy, s.size, s.time + 1, s.eat));//아기상어가 지나갈 수 있으므로 큐에 넣어줌
								if (map[yy][xx] != 0 && map[yy][xx] < s.size) {//같은 위치의 물고기를 먹기위함
									if (yy < eY) {//가장 위쪽과 가장 왼쪽을 우선으로 먹어야하기 때문에 미리 만들어놓은 곳에 넣어두고 비교
										eY = yy;//행이 적은 곳이 들어감 eY와 새롭게 이동한 yy와 행을 비교해서 이동한 곳의 yy가 행이 적으면 yy에 들어가있는 곳을 넣어줌
										eX = xx;
										size = s.size;
										time = s.time + 1;
										eat = s.eat;
									} else if (yy == eY) {//같은 행에 2개의 값이 있다면 가장 왼쪽것을 넣어주어야함 예를들어 (1,0) (3,0)이 들어있다면 왼쪽에있는 (1,0)을 넣어주어야함
										if (xx < eX) {//새로 이동한 곳(xx)이 더 적다면 더 적은곳(왼쪽에 있는 곳)으로 이동한다.  
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
			if (eX != 100) {//아기 상어가 다음 위치해야할 곳에 먹을게 있다면(미리 주어진 100과 다른 것은 이미 먹을 물고기가 있는 것임) 
				eat++;// 먹은 개수 추가
				if (size == eat) {// 몸집만큼 먹었으면 아기상어 사이즈 업
					size++;
					eat = 0;// 먹은 것 초기화해준다.

				}
				map[y][x] = 0;//아기상어위치를 먹은 물고기로 바꿔준다.
				map[eY][eX] = 9;// 아기상어의 이동

				result += time;//걸린 최소 시간을 넣어줌
				y = eY;//아기상어의 위치 변경
				x = eX;
				visit = new int[n][n];//물고기를 먹은 후 다른 물고기를 탐색하기 위해 다시 모든 방문 배열을 초기화 해준다 
				q.clear();//물고기를 먹었기때문에 다른 q를 갈 필요가 없음 
				visit[eY][eX] = 1;
				q.add(new Shark(x, y, size, 0, eat));//물고기를 먹은 위치부터 다시 탐색을 시작하기 위해 큐에 넣어줌
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
