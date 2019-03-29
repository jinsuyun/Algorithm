package practice_SW_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5658 {
	static int n, k;
	static char[] map;
	static String[] edge;
	static int c = 0;
	static char[] a = new char[4];
	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// 보물상자 비밀번호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());//test 개수
		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map=new char[n];// 문자를 하나씩 배열에 받아오기 위함.
			String s = br.readLine();
			for(int i=0;i<s.length();i++) {
				map[i]=s.charAt(i);//n개의 비밀번호를 char 배열에 하나씩 넣는다.
			}
			
			boolean finish = true;//모든 회전을 파악하기 위함 
			int x=n/4;//edge가 4개가 있으므로 4로 나눠줌으로써 한 edge에 몇개의 문자가 들어갈지 파악하기 위함
			list = new LinkedList<>();//다음 문제를 위한 list 초기화
			while(finish) {
				edge=new String[4];//edge는 크기는4개이고 하나의 edge에 map에 있는 문자를 받아옴
				finish=false;//초기화
				int count=0;//map에 입력되있는 것을 받아오기 위한 count
				for(int i=0;i<4;i++) {//4개의 edge니까 4번만 돌면된다.
					edge[i]="";//null이라는 것을 제외하고 빈칸을 넣는다
					for(int j=0;j<x;j++) {//x는 몇개의 문자가 하나의 edge에 들어갈지 정하는 것이므로 한 edge의 x만큼의 문자가 들어감 
						edge[i]+=map[count];//char를 하나씩 더해주면서 String으로 한 edge에 들어간 것을 의미
						count++;//처음에는 j를 주었으나 이는 map의 같은 위치만 지정하는 것을 인지하여 count를 올려주며 모든 n개의 문자를 표현하기 위함
					}
				}
				
				for(int i=0;i<edge.length;i++) {//edge에 들어가있는 상태이므로 edge의 개수만큼만 돌려준다. 4번
					int result=Integer.parseInt(edge[i],16);//String으로 들어간것을 16진수로 바꿔줌
					if(!list.contains(result)) {//list에 포함되어있지 않았다면 list에 추가한다.
						list.add(result);
						finish=true;//list에 추가를 함과 finish를 true로 하며 while문이 끝나지 않았다는 것을 표시 
						//if문을 들어가지 않았다면 edge에 있는 모든 수가 이미 list에 들어있는 것이므로 더 이상 rotate를 돌지 않아도 된다는 것
					}
				}
				rotate();//한번 회전시켜준다
			}
			
			//Collections.sort(list);//역순을 위한 오름차순
			Collections.reverse(list);//내림차순
			System.out.println("#"+test+" "+list.get(k-1));
		}

	}
	public static void rotate() {//문자를 회전시키기 위함 한 문자씩 밀어줌
		char tmp=map[n-1];
		for(int i=n-1;i>0;i--) {
			map[i]=map[i-1];
		}
		map[0]=tmp;
	}
}
