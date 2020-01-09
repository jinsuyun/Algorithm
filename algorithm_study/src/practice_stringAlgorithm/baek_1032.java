package practice_stringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_1032 {

	public static void main(String[] args) throws IOException {
		// 명령 프롬프트
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] list = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken();
		}
		char tmp=0;
		for (int i = 0; i < list[0].length(); i++) {//세로로 비교해서 구현한다. 그래야 for문 2개로 할 수 있다.
			for (int j = 0; j < n; j++) {
				if (list[0].charAt(i) == list[j].charAt(i)) {
					tmp=list[0].charAt(i);
				} else {
					tmp='?';
					break;
				}
			}
			System.out.print(tmp);

		}
	}

}
