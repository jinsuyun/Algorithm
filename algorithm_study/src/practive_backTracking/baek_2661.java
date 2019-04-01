package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2661 {
	static int n;
	static boolean finish;
	public static void main(String[] args) throws IOException {
		// 좋은 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		
		solve(1,"1");//가장 최소 숫자이기 때문에 첫자리수를 1로 주어줌 1보다 크면 최소의 숫자가 아니기 때문
	}
	
	public static void solve(int depth,String result) {
		if(finish) return;//최소의 숫자 1개만 나타내기 위한 finish
		if(depth==n) {//depth가 문자 길이와 같아진다면 출력하고 마침
			System.out.println(result);
			finish=true;//1개만 출력하기 위한 boolean
			return;
		}
		for(int i=1;i<=3;i++) {//1, 2, 3의 숫자만 사용하기 때문에 3까지 for문
			if(isOK(result+i))//인접한 수열을 비교하기 위한 함수 result에 i를 더해주고 그 수열이 좋은 수열인지 비교해준다.
				solve(depth+1,result+i);//좋은 수열이라면 다음 계산을 위한 depth를 늘려주고 실제 값인 result에 i값을 더해준다.
		}
	}
	
	public static boolean isOK(String result) {
		int length=result.length();//문자 길이
		int start=length-1;//문자길이 -1
		int end=length;//문자 끝
		for(int i=1;i<=length/2;i++) {//총 문자의 길이의 절반의 크기를 비교해준다 예를들어 n=7이면 length=3이므로 세자리 수까지 비교해주는 것
			String first = result.substring(start-i,end-i);//substring은 문자에서 추출값을 가져온다. start와 end는 [start,end)로 start<=추출 값<end이다
			String second = result.substring(start,end);//끝에서 비교해주면서 i값이 커지면서 가르키는 위치가 다른 first와 second값을 서로 비교해준다
			if(first.equals(second)) return false;//값이 같으면 빠져나옴 
			start--;//값이 다를 경우 start를 줄여주며 비교해야 할 값의 자릿수를 늘려준다.
		}
		return true;
		
	}

}
