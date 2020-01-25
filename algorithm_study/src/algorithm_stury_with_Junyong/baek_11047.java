package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_11047 {

	public static void main(String[] args) throws IOException {
		// 동전 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {//그리디 알고리즘으로써 최소 동전 개수를 찾아야 하므로 거꾸로 for문을 돌려준다.
			if(sum==k)break;//금액이 맞으면 break;
			sum+=coin[i];//처음 동전을 넣어준다.
			cnt++;
			if (k < sum) {//가격의 더한 값이 더 크다면 위에서 더해준 동전 수와 가격을 총 가격에서 빼준다.
				sum-=coin[i];
				cnt--;
			} else {//그렇지 않다면 그 동전을 금액과 동전 수를 가격을 넘어갈때까지 더해준다. 
				while (k >= sum) {
					sum += coin[i];
					cnt++;
				}
				sum -=coin[i];//while문이 한번 더 돌기때문에 한번 빼준다.
				cnt--;
			}

		}
		System.out.println(cnt);
	}

}
