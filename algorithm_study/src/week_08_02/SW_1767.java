package week_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1767 {
	static int [][] map;
	static int [][] visited;
	static int N,T,dir;
	static int core=1;
	static int line=2;
	static int compare=0;
	static int[] dRow= {0,1,0,-1};
	static int[] dCol= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(br.readLine());
			map=new int [N][N];
			visited=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=0;
					visited[i][j]=0;
				}
			}
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}

		}
		
	}
	public void dfs(int current, int connected, int step) {
		int col=0,row=0;
		Math.min(step,compare);
		if(row==0||row<N||col==0||col<N) {
			dfs(current+1,connected+1,step);
			return;
		}
		for(int i=0;i<4;i++) {
			while(true) {
				row +=dRow[dir]; 
				col +=dCol[dir];
			}
			
			
			}

		
	}

}
