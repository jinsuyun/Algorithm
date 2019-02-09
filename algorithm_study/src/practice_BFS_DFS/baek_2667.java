package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baek_2667 {
	static int[][] map,visit;
	static int n,house;
	static int[] dx= {1,0,-1,0}, dy= {0,-1,0,1};
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		// 단지 번호 붙이기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		map=new int[n][n];
		visit=new int[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]==0&&map[i][j]==1) {
					count+=1;
					house=0;
					dfs(j,i,count);
					list.add(house);
				}
			}
		}
		
		System.out.println(count);
		
		for(int i=0;i<list.size();i++)
			Collections.sort(list);
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));

	}
	public static void dfs(int x,int y,int cnt) {
		house+=1;
		visit[y][x]=cnt;
		for(int k=0;k<4;k++) {
			int xx=x+dx[k];
			int yy=y+dy[k];
			if(xx>=0&&yy>=0&&xx<n&&yy<n) {
				if(visit[yy][xx]==0&&map[yy][xx]==1) {
					visit[yy][xx]=cnt;
					dfs(xx,yy,cnt);
				}
			}
		}
	}

}
