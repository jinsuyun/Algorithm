package practice_SW_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_8016 {

	public static void main(String[] args) throws IOException {
		// 홀수 피라미드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long test=Integer.parseInt(st.nextToken());
		for(long t=1;t<=test;t++) {
			st = new StringTokenizer(br.readLine());
			long level=Long.parseLong(st.nextToken());//범위가 크기 때문에 long으로 선언
			

			long left=(long)(2*(level-1)*(level-1)+1);
			long right=(long)(2*level*level-1);
			
			System.out.println("#"+t+" "+left+" "+right);
		}

	}

}
