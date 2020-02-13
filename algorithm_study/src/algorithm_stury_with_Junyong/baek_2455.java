package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2455 {

	public static void main(String[] args) throws IOException {
		// 지능형 기차 -시뮬레이션 기초
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum=0;
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int off=Integer.parseInt(st.nextToken());//내린사람
			int in=Integer.parseInt(st.nextToken());//기차에 탄사람
			int cnt=0;
			cnt+=in;
			cnt-=off;
			if(cnt>0) sum+=cnt;//내린사람보다 탄사람이 많을때 총인원수에 더해줌
			sum=Math.max(sum, cnt);//기차에 가장 많을 때의 사람 수
		}
		System.out.println(sum);
	}

}
