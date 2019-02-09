package practice;

import java.util.Scanner;
import java.util.Stack;

public class stack_baek_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bracket=sc.nextLine();
		Stack<Character> stack= new Stack<Character>();
		int count=0;
		for(int i=0;i<bracket.length();i++) {
			if(bracket.charAt(i)=='(') {
				stack.push('(');
				
			} else {
				stack.pop();
				if(bracket.charAt(i-1)=='(') {
					count+=stack.size();
				}else {
					count+=1;
				}
			}
			
		}
		System.out.println(count);
	}

}
