package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_6603 {
	static int k;
	static int[] lotto;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// 로또
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			lotto = new int[k];
			result = new int[k];
			
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());//오름차순으로 입력
			}
			solve(0,0);
			System.out.println();
		}
	}
	
	public static void solve(int start,int depth) {
		if(depth==6) {//숫자 6개가 된다면 출력 
			for(int i=0;i<k;i++) {
				if(result[i]==1) {//방문 했던 곳만을(숫자로 뽑은 곳)출력
					System.out.print(lotto[i]+" ");
				}
			}
			System.out.println();
		} 
		for(int i=start;i<k;i++) {
			result[i]=1;//방문을 했다는 표시(숫자를 뽑았다는 표시)
			solve(i+1,depth+1);//숫자 6개를 뽑을때까지 계속 재귀함수를 돌면서 늘려준다.
			result[i]=0;//재귀가 끝난 후 백트래킹 함으로써 마지막 방문했던 곳을 0으로 초기화해준다.
		}
	}

}
