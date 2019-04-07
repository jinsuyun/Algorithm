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
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				solve("",0,i,j);
			}
		}
		
		System.out.println(list.size());

	}
	
	public static void solve(String s,int depth,int y,int x) {
		if(depth==6) {
			if(!list.contains(Integer.parseInt(s)))
					list.add(Integer.parseInt(s));
			return;
		}
		for(int k=0;k<4;k++) {
			int xx=x+dx[k];
			int yy=y+dy[k];
			if(xx>=0&&yy>=0&&xx<5&&yy<5) {
				solve(s+map[yy][xx],depth+1,yy,xx);
			}
		}
	}

}
