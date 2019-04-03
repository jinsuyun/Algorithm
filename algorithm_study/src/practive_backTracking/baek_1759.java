package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1759 {
	static int l,c;
	static char[] password;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		// 암호 만들기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		password = new char[c];
		visit = new int[c];
		String[] s=br.readLine().split(" ");//띄어쓰기를 제외한 문자를 넣어줌
		for(int i=0;i<c;i++) {
			password[i]=s[i].charAt(0);//입력 받은 문자를 하나씩 넣어줌 String이므로 문자로 변환시켜넣어줌
		}
		Arrays.sort(password);//오름차순으로 정렬
		solve(0,0,0,0);
			
	}
	public static void solve(int start,int depth,int ja,int mo) {
		if(depth==l) {//요구하는 l의 개수와 같아지면(비밀번호 자리수)
			if(ja<2||mo<1) return;//반드시 자음은 2개이상 모음은 1개이상이어야함 
			for(int i=0;i<c;i++) {
				if(visit[i]==1) {//check한 곳만을 출력
					System.out.print((password[i]));
				}
			}
			System.out.println();
		}
		for(int i=start;i<c;i++) {//start부터 시작해서 계속 깊이 우선 탐색으로 끝까지 방문할 경우 하나씩 백트래킹 하며 조건에 맞는 모든 경우의 수를 따져야한다. 
			visit[i]=1;//c까지 방문을 하므로써 재귀함수를 통해 모든 경우의수를 구함
			if(password[i]=='a'||password[i]=='e'||password[i]=='i'||password[i]=='o'||password[i]=='u') {
				solve(i+1,depth+1,ja,mo+1);//모음이면 모음+1
			}else {
				solve(i+1,depth+1,ja+1,mo);//자음이면 자음+1
			}
			visit[i]=0;//재귀함수를 빠져나왔으므로 백트래킹하므로써 방문흔적을 지움
		}
		
	}

}
