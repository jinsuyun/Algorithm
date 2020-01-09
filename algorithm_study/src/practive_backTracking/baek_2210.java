package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_2210 {
	static int[][] map=new int[5][5];
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	static List<Integer> list = new LinkedList();
	public static void main(String[] args) throws IOException {
		// 숫자판 점프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<5;i++) {//맵그리기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {//모든 맵을 다 탐색해야하기 때문에 전부 검사
			for(int j=0;j<5;j++) {
				solve("",0,i,j);
			}
		}
		
		System.out.println(list.size());

	}
	
	public static void solve(String s,int depth,int y,int x) {
		if(depth==6) {//만들어진 숫자가 6자리가 완료 되면 리스트에 넣고 종료
			if(!list.contains(Integer.parseInt(s)))//숫자가  리스트에 존재하지 않으면 추가해준다.
					list.add(Integer.parseInt(s));
			return;
		}
		for(int k=0;k<4;k++) {//4방향으로 움직여야 하므로 
			int xx=x+dx[k];//기존좌표에서 다음 칸으로 이동하기 위한 xx좌표
			int yy=y+dy[k];//기존좌표에서 다음 칸으로 이동하기 위한 yy좌표
			if(xx>=0&&yy>=0&&xx<5&&yy<5) {//맵을 벗어나면 안되므로 범위안에만 검사
				solve(s+map[yy][xx],depth+1,yy,xx);//범위안에 있다면 자리수depth를 1늘려주고 결과 값(6자리의 숫자)을 만들기위해 map[yy][xx]를 더해준다. yy,xx는 기존 좌표를 알기 위함
			}
		}
	}

}
