package java_basic;

public class practice_math {

	public static void main(String[] args) {
		// Math �ݿø�, �ݳ���, �ø�, ����, ����, ��Ʈ
		double a=10.25;
		System.out.println(Math.round(a));//round �Ҽ��� ù° �ڸ����� �ݿø� ��ȯ���� int
		System.out.println(Math.rint(a));//rint �Ҽ��� ù° �ڸ����� �ݿø� ��ȯ���� int -->rint()�� ���� ����� �������� double�� ��ȯ
		System.out.println(Math.floor(a));//����
		System.out.println(Math.ceil(a));//�ø�
		
		a=-1.5;
		System.out.println(Math.round(a));//������ �� ����� �ٸ� round�� -1.5���� ù°�ڸ����� �ݿø��� -1�� ��
		System.out.println(Math.rint(a));//�Ҽ��� ù°�ڸ��� 5�� �ʰ��ϴ� ���� ���� �ݿø� ���� ����
		
		System.out.println(Math.floor(a));//����
		System.out.println(Math.ceil(a));//�ø�
		int b=4;
		
		System.out.println(Math.pow(b,2));//n����
		System.out.println(Math.sqrt(b));//��Ʈ
	}

}
