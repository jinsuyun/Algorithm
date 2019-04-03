package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1339 {
	static boolean[] visit = new boolean[10];
	static int size,n,max=0;
	static String[] s;
	static int[] values;
	static List<Integer> list = new LinkedList();
	public static void main(String[] args) throws IOException {
		// 단어수학
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n=Integer.parseInt(st.nextToken());
		
		s = new String[n];//문자를 배열로 개수만큼 받아옴
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			s[i]=st.nextToken();//문자열을 받아옴
			for(int j=0;j<s[i].length();j++) {//문자열의 크기만큼 for문으로 돌리면서 list에 문자를 넣는다
				if(!list.contains(s[i].charAt(j)-'A')){//같은 문자가 list에 들어있으면 추가하지 않는다 -'A'는 문자를 크기를 비교하기 위해 Integer로 바꾸기 위함
					list.add(s[i].charAt(j)-'A');
				}
			}
		}
		size=list.size();//문자의 개수가 저장되어있음 예를 들어 ABC면 3개 ABB면 2개 
		values=new int[size];//문자 개수만큼 값을 넣을 수 있는 values 생성
		solve(0,0);//백트래킹의 시작
		System.out.println(max);
	}
	
	public static void solve(int idx,int depth) {
		if(size==depth) {//문자의 개수만큼 모든 depth를 탐색했다면
			int sum=0;//값을 비교하기 위한 sum(value를 모두 더한것)
			for(int i=0;i<n;i++) {//
				int value=0;//숫자를 받기위한 value
				for(int j=0;j<s[i].length();j++) {//문자의 개수만큼 돌려준다 모든 문자를 받아오며 1,10,100의 자리를 계산하기 위함
					value*=10;//10의자리씩 자리수를 올려가며 모든 값을 더한다. 처음 1의자리는 value가 0이 초기화 값이기 때문 *10이 적용이 안됨 뒤로 10의자리, 100의자리... 가 적용됨
					value+=values[list.indexOf(s[i].charAt(j)-'A')];
					//list.indexOf는 속해있는 값이 values에서 몇번째 들어있느냐를 파악하기 위함 s[i].charAt(j)라는 문자에 -'A'를 하며 문자를 Integer로 나타낸 값이 몇번째에 들어있는지 파악
					//예를들어 values에 [9,8,7]이 들어있을 경우 ABC이란 문자에서 s[i].charAt(2)-'A'를 통해 C라는 문자가 Integer로 2이다. 즉, value[2]의 값 7을 불러오게되는 것
					//indexOf를 없애고 s[i].charAt(j)-'A'만 쓰면 런타임에러가난다. 주어진 list안에서 보는게 아닌 모든 것을 보기 때문인듯
				}
				sum+=value;//주어진 값을 sum에 다 더해준다. 
			}
			max=Math.max(max, sum);//가장 큰 값을 비교해준다.
			return;
			
		}
		for(int i=9;i>=0;i--) {//최대의 숫자를 구하는 것이고 0~9까지의 숫자로 표현하기 때문에 가장 큰수인 9부터 넣는다.
			//3개의 문자가 list에 들어있다고 가정할 경우, values에 [9,8,7]이 처음 들어가고 그다음 [9,8,6],[9,8,5]...값이 계속 들어감 
			if(!visit[i]) {//0~9까지 있는 배열에서 방문하지 않았다면, 즉 값을 아직 지정하지 않았다면 
				visit[i]=true;//방문한다. 중복을 제거하기 위함 9가 나왔는데 다시 9가 나오면 안되기 때문
				values[idx]=i;//values는 값이 들어가는 자리  
				solve(idx+1,depth+1);//값을 위에서 하나 넣고 다시 dfs를 통해 values를 증가시키는 idx와 list의 있는 모든 문자를 검색하기 위한 depth를 하나씩 증가시킨다. 
				visit[i]=false;//방문 배열을 빠져나옴
				values[idx]=0;//빠져나왔기 때문에 초기화시켜줌
			}
		}
		
	}

}
