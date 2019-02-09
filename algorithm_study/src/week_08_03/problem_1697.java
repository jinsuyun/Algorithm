package week_08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem_1697 {
	static int N,K;
	static int[] visited = new int[100001];
	static int[] dx= {-1,1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());

		Arrays.fill(visited,-1);
	
		if(N>=K) {
			System.out.println(N-K);//N이 클 경우 -1로 가야함
			return;
		}
		
		int min=bfs(N);
		
		System.out.println(min);
		
	}
	
	public static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		int position=n;
		
		q.add(position);
		int count=0;
		visited[position]=1;
		while(!q.isEmpty()) {
			position= q.poll();
			
			if(position==K) {
				return count;
			}
			
			for(int i=0;i<3;i++) {
				int next;
				if(dx[i]!=0) {//-1이나 1일때
					next=position+dx[i];//1칸 증감한다
				}else {
					next=position*2;	
				}
				
				if(next>=K)
					continue;
				
				if(0<=next&&next<=100000&&visited[next]==-1) {
					
					q.add(next);
					visited[next]=1;
					count=count+1;	
				}
			}
			
		}
		return count;
	}

}

