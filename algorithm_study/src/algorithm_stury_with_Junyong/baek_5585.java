package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_5585 {

	public static void main(String[] args) throws IOException {
		// °Å½º¸§ µ·
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result=1000-Integer.parseInt(st.nextToken());
		int[] coin= {500,100,50,10,5,1};
		int sum=0;
		int cnt=0;
		for(int i=0;i<coin.length;i++) {
			if(result==sum) break;
			sum+=coin[i];
			cnt++;
			if(sum>result) {
				sum-=coin[i];
				cnt--;
			}else {
				while(result>=sum) {
					sum+=coin[i];
					cnt++;
				}
				sum-=coin[i];
				cnt--;
			}
		}
		System.out.println(cnt);
	}

}
