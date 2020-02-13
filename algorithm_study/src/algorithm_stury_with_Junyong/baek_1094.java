package algorithm_stury_with_Junyong;

import java.util.Scanner;

public class baek_1094 {
	static int[] arr,visit;
	static int cnt;
	public static void main(String[] args) {
		// 막대기 - 시뮬레이션 기초
		//막대기를 미리 잘라 놓고 자른 막대기를 백트래킹을 통해 더해줌으로 막대기의 개수를 센다
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int stick= 64;
		int sum=0;
		cnt=0;
		arr=new int[7];
		visit=new int[7];
		arr[0]=64;
		for(int i=1;i<arr.length;i++) {//미리 막대기를 잘라놓는다.
			stick/=2;
			arr[i]=stick;
		}
		solve(0,x,0);//DFS 시작
		System.out.println(cnt);

	}
	public static void solve(int start,int x,int sum) {//백트래킹 방식으로 문제 접근
		if(sum==x) {//원하는 막대기 길이와 같으면 막대기 개수 count
			for(int i=0;i<arr.length;i++) {
				if(visit[i]==1)
					cnt++;
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {//start부터 시작하는 이유가 이미 순서대로 정해져있기 때문에 순차적으로 진행한다는 의미
			if(visit[i]==0) {
				visit[i]=1;
				sum+=arr[i];//막대기 더해줌
				solve(i+1,x,sum);//i+1이므로 start가 한칸씩 늘어나는 것 다음 for문을 들어올때 i+1부터 시작하기 위함
				visit[i]=0;
				sum-=arr[i];//들어온 곳을 다시 빠져나왔을 때, 더했던 막대기 빼줌
			}
		}
	}

}
