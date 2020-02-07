package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class baek_4949 {

	public static void main(String[] args) throws IOException {
		// 균형잡힌 세상
		String s = "";
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {//.이 나올때까지 입력을 계속 추가해준다. 크기가 주어지지 않았기 때문에 ArrayList를 사용

			s = br.readLine();
			if (s.equals("."))//.이 나오면 break;
				break;

			s = s.replace(" ", "");
			list.add(s);

		}
		for (int i = 0; i < list.size(); i++) {//ArrayList에 있는 문자열을 통해 괄호 검사를 해준다.
			Stack<Character> stack = new Stack();//괄호 검사를 위한 스택
			boolean check = true;//괄호 검사
			for (int j = 0; j < list.get(i).length(); j++) {
				char ch = list.get(i).charAt(j);
				if (ch == '(' || ch == '[') {//(나 [가 들어오면 스택에 넣어준다.
					stack.add(ch);
				} else if (ch == ']' || ch == ')') {//)나 ]가 나오면 
					if (stack.isEmpty())//스택이 비어있으면 애초에 (나 [가 들어있지 않은 것이기 때문에 false
						check = false;
					else {//스택이 비어있지 않으면
						char pop = stack.pop();// 스택에서 하나를 pop한다.
						if ((pop == '(' && ch != ')') || (pop == '[' && ch != ']')) {//pop한 값이 (이면 현재 값이)이어야 괄호가 성립이 된다. 그렇지 않으면 false
							check = false;//따라서  ([])나 [()]는 되지만 스택의 값이 다르기 때문에 ([)] 이런식의 괄호는 false가 된다.
						}
					}
				} else {
					continue;
				}
			}

			if (check&&stack.isEmpty()) {//스택이 남아있으면 안되기때문에 스택까지 비어있는지 체크해준다.
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
