package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_2012 {

	public static void main(String[] args) throws IOException {
		// 등수매기기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());//(1 ≤ N ≤ 500,000) int 범위 안에 들어가므로 int로 선언해줘도 된다.
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			list.add(Integer.parseInt(st.nextToken()));//자신의 예상 등수
		}
		//불만도 = 자신의 예상등수 - 실제등수의 절대값
		Collections.sort(list);//불만도를 최소로 구해야 하니까 정렬을 해준다.
		long sum=0;//sum은 값을 더해주므로 int의 범위를 벗어날 수 있다(범위가 50만이기 때문)
		for(int i=0;i<n;i++) {
			sum+=Math.abs(list.get(i)-(i+1));//불만의 최소 값을 구하기 위해 정렬한 리스트에서 한명씩 값을 빼주면 최소 값이 나온다.
		}
		System.out.println(sum);
		
	}

}
