package java_basic;

public class practice_tostring {

	public static void main(String[] args) {
		// ������Ʈ Ŭ���� toString()
		// �ν��Ͻ��� ���� ������ ���ڿ��� ������ �������� ������ ���̴�.
		Card c1=new Card();
		Card c2=new Card();
		//�������̵��� ���� �ʴ� toString�� ����� ��� Ŭ�����̸��� 16������ �ؽ��ڵ带 ������.
		//���� CardŬ�������� toString()�� �������̵� �Ѵٸ� ���� ���� ���� �� �ִ�.
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		//String Ŭ������ toString()�� String�ν��Ͻ��� ���� �ִ� ���ڿ��� ��ȯ�ϵ��� �������̵��Ǿ� �ִ�.
		String s=new String("KOREA");
		System.out.println(s.toString());
	}

}
class Card{
	String kind;
	int number;
	Card(){
		this("SPADE",1);
	}
	Card(String kind,int number){
		this.kind=kind;
		this.number=number;
	}
	public String toString() {//������Ʈ Ŭ������ toString()�޼��尡 public�̹Ƿ� �������̵��� ���������ڵ� public�� ���־���Ѵ�.
		return kind+" "+number; 
	}
}

