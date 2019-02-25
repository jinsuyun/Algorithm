package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1987 {
	static int r,c,result;
	static int[][] map;
	static boolean[] visit;
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// 알파벳
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());//세로
		c=Integer.parseInt(st.nextToken());//가로
		
		map=new int[r][c];
		visit=new boolean[26];//알파벳을 체크하기 위해 방문을 만듬
		for(int i=0;i<r;i++) {
			String s = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j]=s.charAt(j)-'A';//대문자 알파벳은 A~Z까지이며 int형으로 바꾸면 65~90까지이다.
			}
		}
		result=1;//다음으로 갈수 없다면 1이 결과 값이 되므로 최솟값을 1로 한다.
		solve(0,0,1);
		System.out.println(result);

	}
	
	public static void solve(int x,int y,int cnt) {
		int tmp=map[y][x];//map에 어떤 대문자가 들어있는지 파악하기위해 사용한 대문자는 visit[map[y][x]로 방문 표시를 한다.
		visit[tmp]=true;//방문 표시
		int xx,yy;
		for(int k=0;k<4;k++) {
			xx=x+dx[k];
			yy=y+dy[k];//다음 가야할 좌표
			if(xx>=0&&yy>=0&&xx<c&&yy<r) {
				int next=map[yy][xx];//다음 가야할곳의 대문자의 int형
				if(!visit[next]) {//그 대문자를 방문 하지 않았다면 통과
					result=Math.max(result,++cnt);//최댓값 구하기
					solve(xx,yy,cnt);
					--cnt;//재귀를 빠져나온 후(끝까지 깊이 우선 탐색한 후 전부 막혀있다면 그 전으로 이동하기 때문에 이동 횟수를 빼야함 
					visit[next]=false;//전으로 이동했기 때문에 방문또한 초기화
				}
			}
		}
		
	}

}
