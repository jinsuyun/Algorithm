package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class baek_4949 {

	public static void main(String[] args) throws IOException {
		// �������� ����
		String s = "";
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {//.�� ���ö����� �Է��� ��� �߰����ش�. ũ�Ⱑ �־����� �ʾұ� ������ ArrayList�� ���

			s = br.readLine();
			if (s.equals("."))//.�� ������ break;
				break;

			s = s.replace(" ", "");
			list.add(s);

		}
		for (int i = 0; i < list.size(); i++) {//ArrayList�� �ִ� ���ڿ��� ���� ��ȣ �˻縦 ���ش�.
			Stack<Character> stack = new Stack();//��ȣ �˻縦 ���� ����
			boolean check = true;//��ȣ �˻�
			for (int j = 0; j < list.get(i).length(); j++) {
				char ch = list.get(i).charAt(j);
				if (ch == '(' || ch == '[') {//(�� [�� ������ ���ÿ� �־��ش�.
					stack.add(ch);
				} else if (ch == ']' || ch == ')') {//)�� ]�� ������ 
					if (stack.isEmpty())//������ ��������� ���ʿ� (�� [�� ������� ���� ���̱� ������ false
						check = false;
					else {//������ ������� ������
						char pop = stack.pop();// ���ÿ��� �ϳ��� pop�Ѵ�.
						if ((pop == '(' && ch != ')') || (pop == '[' && ch != ']')) {//pop�� ���� (�̸� ���� ����)�̾�� ��ȣ�� ������ �ȴ�. �׷��� ������ false
							check = false;//����  ([])�� [()]�� ������ ������ ���� �ٸ��� ������ ([)] �̷����� ��ȣ�� false�� �ȴ�.
						}
					}
				} else {
					continue;
				}
			}

			if (check&&stack.isEmpty()) {//������ ���������� �ȵǱ⶧���� ���ñ��� ����ִ��� üũ���ش�.
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
