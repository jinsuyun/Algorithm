package practice_stringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek_1032 {

	public static void main(String[] args) throws IOException {
		// ��� ������Ʈ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] list = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list[i] = st.nextToken();
		}
		char tmp=0;
		for (int i = 0; i < list[0].length(); i++) {//���η� ���ؼ� �����Ѵ�. �׷��� for�� 2���� �� �� �ִ�.
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
