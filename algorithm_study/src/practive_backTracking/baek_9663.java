package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_9663 {
	static int result=0,n;
	static int[] map;
	public static void main(String[] args) throws IOException {
		// N-Queen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());//맵의 크기 및 퀸의 개수
		map = new int[n];//하나의 줄에는 하나의 퀸만 놓을 수 있기 때문에 2차원 배열로 하지 않고 1차원 배열로 정리할수 있다.
		//map[i]의 값이 열이고 i가 행으로 생각하면 된다. 예를 들어 map[2]=4이면 3번째(0부터 시작하므로)행 5번째 열(0부터 시작)에 퀸을 놓는 것을 뜻한다.
		Arrays.fill(map, -1);
		solve(0);
		System.out.println(result);
		
	}
	public static void solve(int depth) {//depth는 현재 행을 뜻한다.
		//int [][] map2=new int[n][n]; 퀸의 위치 출력하기위한 선언
		if(depth==n) {//현재 행이 n과 같다면 퀸의 위치가 모든 조건을 만족했다는 것이므로 경우의 수를 추가함
			result++;
			/*for(int i=0;i<n;i++) { //퀸의 위치 출력해봄
				map2[i][map[i]]=1;
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map2[i][j]);
				}System.out.println();
				
			}System.out.println();*/
		}else {
			for(int i=0;i<n;i++) {//퀸을 n까지 놓는 것 전부 따져봄
				map[depth]=i;//퀸을 depth행에 i번째 열에 놓는다. 하나의 행에 하나의 퀸만 존재
				if(check(depth)) {//퀸이 놓을 수 있는 지 확인하는 함수
					solve(depth+1);//퀸을 놓을 수 있다면 다음 행으로 이동한다.
				}
			}
		}
		
	}
	public static boolean check(int depth) {
		for(int i=0;i<depth;i++) {//기존에 놓여있는 퀸의 위치와 비교를 하는 것이기 때문에 현재 행인 depth까지 for문을 돌린다.
			if(map[i]==map[depth]||Math.abs(depth-i)==Math.abs(map[depth]-map[i])) {
				return false;//i번째 행, map[i]라는 열과 현재 행 depth, 열 map[depth]에서 map[i]=map[depth]이면 같은 열에 있다고 판단
				//예를 들어 (0,0) (0,3)일 경우, i=0, map[i]=0과 depth=3, map[depth]=0이므로 map[depth]=map[i] 즉, 일직선상에 있는 것
				//같은 행에서는 퀸은 하나씩 존재하기 때문에 열끼리 비교는 할 필요가 없다.
				//같은 대각선상에 있는 경우를 비교한다. 2차원 배열로 따지면 두개의 점에서 x축과 y축의 차이가 같다면 대각선상에 있는 것
				//예를 들어 (2,1)과 (7,6)을 봤을 경우 7-2=6-1이므로 같은 대각선에 있음 하지만 (2,1)과 (7,5)는 7-2!=5-1이므로 다른 대각선에 위치함
				//좌표로 볼 경우 (x,y)일 경우, (map[i],i)라고 보면된다.
			}
		}
		return true;//퀸을 놓을 수 있는 자리가 맞다면 true 퀸을 놓을 수 없는 위치라면 false
	}

}
