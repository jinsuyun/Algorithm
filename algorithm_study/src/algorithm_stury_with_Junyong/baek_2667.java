package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_2667 {
	static int n,cnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] map, visit;

	public static void main(String[] args) throws IOException {
		// DFS - 단지번호 붙이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.charAt(j)+"");
			}
		}
		ArrayList<Integer> list = new ArrayList();
		int dangiNum=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visit[i][j] == 0&&map[i][j]!=0) {//방문하지 않고 map이 1이면(단지이면) dfs 들어감
					cnt=1;//단지안에 몇개의 건물이 있는지
					dangiNum++;//단지 번호를 세어준다.
					visit[i][j] += 1;//방문표시
					solve(i, j);
					list.add(cnt);//건물을 list에 넣어줌
				}
			}
		}
		Collections.sort(list);
		System.out.println(dangiNum);
		for(int i:list) {
			System.out.println(i);
		}

	}

	public static void solve(int y,int x) {
		for(int k=0;k<4;k++) {//4방향으로 연결되어 있는 건물 세어준다
			int nx=x+dx[k];//다음 건물의 좌표
			int ny=y+dy[k];
			if(ny>=0&&nx>=0&&ny<n&&nx<n) {//map의 범위안에 있어야함
				if(visit[ny][nx]==0&&map[ny][nx]==1) {//방문하지 않았고 건물이라면
					cnt++;//건물 수를 ++
					visit[ny][nx]=1;//방문 표시
					solve(ny,nx);//재귀로 다시 다음 건물로 이동
				}
			}
		}
	}

}
