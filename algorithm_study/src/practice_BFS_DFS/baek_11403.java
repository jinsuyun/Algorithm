package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class baek_11403 {
	static int n;
	static int[][] map,result;
	static int[] visit;
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		// 경로 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		map=new int[n+1][n+1];
		visit=new int[n+1];
		result=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=1;i<=n;i++) {
			dfs(i);
			for(int j=1;j<=n;j++) {
				result[i][j]=visit[j];
			}
			Arrays.fill(visit,0);
				
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int node) {
		int length=map.length-1;

		for(int i=1;i<=length;i++) {
			if(visit[i]==0&&map[node][i]==1) {
				visit[i]=1;
				dfs(i);
			}
		}
	}

}
