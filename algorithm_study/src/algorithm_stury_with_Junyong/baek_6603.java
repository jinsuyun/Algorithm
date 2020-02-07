package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_6603 {

	public static void main(String[] args) throws IOException{
		// DFS - 로또
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			if(n==0) break;
			int[] lotto=new int[n];
			int[] output=new int[n];
			boolean[] visit=new boolean[n];
			for(int i=0;i<n;i++) {
				lotto[i]=Integer.parseInt(st.nextToken());
			}
			solve(lotto,visit,0,0,n);
			System.out.println();
		}

	}
	public static void solve(int[] lotto,boolean[] visit,int start,int depth,int n) {
		if(depth==6) {//6개의 숫자가 충족했을 때만 출력한다. 따라서, 기준점이 커지면 뒤에 있는 숫자가 6개가 되지 않기 때문에 if문에 들어가지 않는다.
			//방문이 6개여야 출력하는 것. 로또에서 6개를 뽑아야하는 것이니까 6개를 뽑는 것
			for(int i=0;i<lotto.length;i++) {
				if(visit[i])//방문한것만 출력해야함
					System.out.print(lotto[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {//start를 정해주는 이유는 시작점을 넣어주기 위함이다(정렬된 상태로 뽑아야하기 때문)
			if(!visit[i]) {
				visit[i]=true;//방문체크
				solve(lotto,visit,i+1,depth+1,n);//start를 i+1로 1씩 더해주고(기준점을 바꿔줌), depth를 1칸 늘린다
				visit[i]=false;
			}
		}
	}

}
