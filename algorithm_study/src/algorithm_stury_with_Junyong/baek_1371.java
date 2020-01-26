package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class baek_1371 {

	public static void main(String[] args) throws IOException {
		// 가장 많은 글자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] alpha = new int[26];
		ArrayList<String> list = new ArrayList<>();
		while (true) {
			String s = br.readLine();
			if (s==null)//null이면 입력을 멈춤 .equals는 안됨 그러한 이유는 null.equals()라는게 말이 안되기 때문
				break;
			s = s.replace(" ", "");//띄어쓰기를 다 붙여줌
			list.add(s);
		}
		for (String i : list) {
			for (int j = 0; j < i.length(); j++) {
				int num = i.charAt(j) - 'a';//'a'를 빼면서 0~25까지 알파벳 값을 가져올 수 있다.
				alpha[num]++;// 해당 값에 대한 배열을 크기를 올려준다.
			}
		}
		int max = -1;
		for (int i = 0; i < alpha.length; i++) {//가장 큰 값(가장 많이 사용한)을 찾는 for문 
			if (max < alpha[i]) {
				max = alpha[i];
				
			}
		}
		for (int i = 0; i < 26; i++) {//max(가장 많이 사용한)값과 같은 값이 있으면 같이 여러개 출력 
			if (max == alpha[i])
				bw.write((char)(i+'a'));

		}

		bw.flush();
		bw.close();

	}

}
