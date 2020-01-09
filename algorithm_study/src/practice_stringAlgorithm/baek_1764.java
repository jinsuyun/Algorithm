package practice_stringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1764 {

	public static void main(String[] args) throws IOException {
		// 듣보잡
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		ArrayList<String> listen=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			listen.add(st.nextToken());
		}
		Collections.sort(listen);//바이너리서치를 사용하기위해 정렬해둔다.
		String[] s=new String[listen.size()];
		s=listen.toArray(s);//바이너리 서치를 사용하기 위해 배열로 바꿔준다.
		
		ArrayList<String> result=new ArrayList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			String ss = st.nextToken();//보도 못한놈과 듣도보도 못한놈을 비교하기 위한 대상
			int idx=Arrays.binarySearch(s, ss);//s 배열에서 ss라는 값을 찾는다. 찾은 값을 idx에 넣는다.
			System.out.println(idx);
			if(idx>=0)//Arrays.binarySearch()를 사용하면 반환하는 값이 찾으면 0 혹은 양수, 찾지 못하면 음수를 반환한다. 
				result.add(ss);//값을 찾았다면 결과를 넣어준다.
			
		}
		
		//결과값 출력 부분
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
			
		}

	}

}
