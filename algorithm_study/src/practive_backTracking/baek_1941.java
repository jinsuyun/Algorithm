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
		// 소문난 칠공주
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {// 맵 읽기
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = s.charAt(j);
			}
		}
//DFS로 문제를 풀려 했으나 십자가 형태의 맵을 파악할 수 없기 때문에 학생 25명을 번호로 지정하여 25명 중 7명을 선별하고 그 선별한 인원이 서로 연결되었는지 파악한다.
		for (int i = 0; i < 25; i++) {//25명의 학생을 돌려봄
			visit = new boolean[25];//시작마다 학생을 가리키는 visit과 그 학생의 위치인 mapVisit를 초기화해준다
			mapVisit = new boolean[5][5];
			visit[i] = true;
			mapVisit[i / 5][i % 5] = true;//1차원 배열의 i를 2차원배열로 표시한것
			if (map[i / 5][i % 5] == 'S')//학생이 S파이면 s의 개수를 1증가 시킨다.
				solve(1, i, 1);
			else//학생이 Y이면 0으로 시작한다.
				solve(1, i, 0);
		}

		System.out.println(result);

	}

	public static void solve(int depth, int num, int sCnt) {//depth는 학생의 자리수(7명을 채워야함),num은 학생의 번호라고 생각, sCnt는 S학생의 개수
		if(depth>7) return;//7명이 서로 인접해야하기 때문에 7이 넘어가면 종료함으로 시간을 줄여준다.
		if (depth == 7 && sCnt >= 4) {//학생 7명과 S가 4명이상이면
			visited = new boolean[5][5];//visited는 학생이 인접해있는지 확인하려는 visited
			count = 0;//칠공주를 세어주기 위한 count의 개수를 초기화해준다. 
			for (int i = 0; i < 5; i++) {//학생의 위치 파악을 위한 2중 for문 
				for (int j = 0; j < 5; j++) {
					if (!visited[i][j] && mapVisit[i][j]) {//mapVisit는 실제 앉은 학생위치를 설정해준 것이기 때문에  true가 되어야 그 자리에 학생이 있는 것임 check를 통해 인접한지 알 수 있음
						visited[i][j] = true;//방문 표시
						count = 1;//한명이 들어왔으므로 1증가 시킨다 count가 7이 되면 됨
						check(i, j);
					}
				}
			}
			return;
		}
		for (int i = num + 1; i < 25; i++) {//25명의 학생중 7명을 선발하기위한 for문 start를 num+1로 시작해서 모든 학생 중 7명을 선발
			//번호순대로 for문을 돌려 모든 학생을 탐색
			if (!visit[i]) {//학생의 번호를 방문하지 않았다면 방문표시
				visit[i] = true;
				mapVisit[i / 5][i % 5] = true;//i라는 번호의 1차원 배열을 2차원 배열로 바꾼 것 
				if (map[i / 5][i % 5] == 'S')//S이면 sCnt에 1증가 아니면 그대로
					solve(depth + 1, i, sCnt + 1);//학생 1명이 찼으니까 depth에 +1을 하고 그 학생의 번호인 i를 넘겨준다.
				else
					solve(depth + 1, i, sCnt);
			}
			visit[i] = false;//빠져나왔으면 false해준다.
			mapVisit[i / 5][i % 5] = false;
		}
	}

	public static void check(int y, int x) {//학생 7명이 서로 인접해 있는 지 확인 하기 위함 
		if (count == 7) {//학생 7명이 인접해 있다면 result를 증가시켜줌
			result++;
		} else {
			for (int k = 0; k < 4; k++) {//한칸씩 이동하며 인접했는지 파악
				int xx = x + dx[k];
				int yy = y + dy[k];
				if (xx >= 0 && yy >= 0 && xx < 5 && yy < 5) {//범위 안에 있고 
					if (mapVisit[yy][xx] && !visited[yy][xx]) {//mapVisit는 학생의 위치를 파악하는 것이므로 true인 곳이 map에서 그 학생의 위치를 뜻함 visited는 서로 인접했는지를 파악하기 위함
						visited[yy][xx] = true;
						count += 1;//다음으로 넘어가면서 학생을 한명씩 늘려줌으로 7명이 될때까지 check함수를 돌린다. 
						check(yy, xx);//다음칸으로 넘어감
					}
				}
			}
		}
	}
}
