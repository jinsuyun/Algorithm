package java_basic;

import java.text.ParseException;

public class practice_exception {

	public static void main(String[] args) {
		// ���� ó��
		//������ ���α׷� �ڵ忡 ���ؼ� ������ �� ���� �ɰ��� ����
		//����(exception)�� ���α׷� �ڵ忡 ���ؼ� ������ �� �ִ� �ټ� �̾��� ����
		/*int num=100;
		int result=0;
		for(int i=0;i<10;i++) {
			try{
				result=num/(int)(Math.random()*10);//0���� ���� �� ���� ������ ������ �߻�
				System.out.println(result);
			}catch(ArithmeticException ar) {//������ �߻��ϸ� catch�� ���� ���� ó�� ����
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
				e.printStackTrace();//printStackTrace()�� ���� ȣ�⽺�ÿ� ���� ������ ���� �޽����� ���
				System.out.println("���� "+e.getMessage());//���� �޽��� 
			}
		}catch(NullPointerException|IndexOutOfBoundsException e) { // |��ȣ�� ���� 2���� ����ó���� �Ѳ����� �� �� �ִ�.
			System.out.println("Error");
		}catch(Exception e) {
			System.out.println(6);
		}/*catch(ArithmeticException e) { // �̹� Exception���� ArithmeticException�� �����ϱ⿡ ������ �߻�
			System.out.println(7);
		}*/
		System.out.println(7);
	}

}
