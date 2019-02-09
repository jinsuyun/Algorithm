package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class stack_baek_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String letter= br.readLine();
		int order_count= Integer.parseInt(br.readLine());
		
		Stack<Character> left_stack = new Stack<Character>();
		Stack<Character> right_stack = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<letter.length();i++) {
			left_stack.push(letter.charAt(i));	
		}

		for(int i=0;i<order_count;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String order=st.nextToken();
			
			if(order.equals("L")){
				if(!left_stack.empty()) 
					right_stack.push(left_stack.pop());
			}
			else if(order.equals("D")) {
				if(!right_stack.empty())
					left_stack.push(right_stack.pop());
			}
			else if(order.equals("B")) {
				if(!left_stack.empty())
					left_stack.pop();
			}
			else if(order.contains("P")){
				char p=st.nextToken().charAt(0);
				left_stack.push(p);
			}
		}
		
		while(!left_stack.empty()) {
			right_stack.push(left_stack.pop());
		}
		
		while(!right_stack.empty()) {
			
			sb.append(right_stack.pop());
		}
		
		System.out.println(sb);
	}

}
