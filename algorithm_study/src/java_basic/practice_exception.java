package java_basic;

import java.text.ParseException;

public class practice_exception {

	public static void main(String[] args) {
		// 예외 처리
		//에러는 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
		//예외(exception)는 프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
		/*int num=100;
		int result=0;
		for(int i=0;i<10;i++) {
			try{
				result=num/(int)(Math.random()*10);//0으로 나눌 수 없기 때문에 에러가 발생
				System.out.println(result);
			}catch(ArithmeticException ar) {//에러가 발생하면 catch로 인해 예외 처리 수행
				System.out.println("0");
			}
			
		}*/
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			
			System.out.println(4);
		}catch(ArithmeticException e) {
			if(e instanceof ArithmeticException) {
				System.out.println(5);
				e.printStackTrace();//printStackTrace()를 통해 호출스택에 대한 정보와 예외 메시지를 출력
				System.out.println("예외 "+e.getMessage());//예외 메시지 
			}
		}catch(NullPointerException|IndexOutOfBoundsException e) { // |기호를 통해 2가지 예외처리를 한꺼번에 할 수 있다.
			System.out.println("Error");
		}catch(Exception e) {
			System.out.println(6);
		}/*catch(ArithmeticException e) { // 이미 Exception에서 ArithmeticException을 포함하기에 에러가 발생
			System.out.println(7);
		}*/
		System.out.println(7);
	}

}
