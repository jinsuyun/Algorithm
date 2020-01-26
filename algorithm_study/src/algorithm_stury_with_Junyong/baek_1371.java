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
		// ���� ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] alpha = new int[26];
		ArrayList<String> list = new ArrayList<>();
		while (true) {
			String s = br.readLine();
			if (s==null)//null�̸� �Է��� ���� .equals�� �ȵ� �׷��� ������ null.equals()��°� ���� �ȵǱ� ����
				break;
			s = s.replace(" ", "");//���⸦ �� �ٿ���
			list.add(s);
		}
		for (String i : list) {
			for (int j = 0; j < i.length(); j++) {
				int num = i.charAt(j) - 'a';//'a'�� ���鼭 0~25���� ���ĺ� ���� ������ �� �ִ�.
				alpha[num]++;// �ش� ���� ���� �迭�� ũ�⸦ �÷��ش�.
			}
		}
		int max = -1;
		for (int i = 0; i < alpha.length; i++) {//���� ū ��(���� ���� �����)�� ã�� for�� 
			if (max < alpha[i]) {
				max = alpha[i];
				
			}
		}
		for (int i = 0; i < 26; i++) {//max(���� ���� �����)���� ���� ���� ������ ���� ������ ��� 
			if (max == alpha[i])
				bw.write((char)(i+'a'));

		}

		bw.flush();
		bw.close();

	}

}
