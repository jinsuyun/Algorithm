package java_basic;

public class practice_interface4 {

	public static void main(String[] args) {
		// �������̽��� default�� static �޼���
		childInterface c= new childInterface();
		c.method1();//�������̽��� �ִ� �޼��带 ���� �����ϰ� childInterface Ŭ�������� �������̵��� method1()�� �����´�.
		c.method2();//�������̽��� �ִ� �޼��带 ���� �����ϰ� �θ� Ŭ������ �ִ� method2()�� �����´�.
		//myinterface.method1();//method1()�� static�� �ƴϹǷ� �����ͼ� ����� �Ұ����ϴ�.
		myinterface.staticmethod();//�������̽��� �ִ� �޼��带 ���� �ҷ��´�. ��, static���� �ۼ��� �޼��常 �����ϴ�.(static�̳� default�� �ƴ϶�� method�� body�� ���� ����)
		myinterface2.staticmethod();
	}
}
class childInterface extends parentInterface implements myinterface,myinterface2{
	public void method1() {
		System.out.println("method1() in child");
	}
}
class parentInterface{
	public void method2() {
		System.out.println("method2() in parent");
	}
}
interface myinterface{//default�� static���� �ۼ��� interface�� �޼���� ����θ� �ۼ��ϴ� ���� �ƴ϶� �Ϲ� �޼���ó�� ��� �����ϴ�.
	default void method1() {
		System.out.println("method1() in myinterface");
	}
	default void method2() {
		System.out.println("method2() in myinterface");
	}
	static void staticmethod() {
		System.out.println("staticmethod() in myinterface");
	}
}

interface myinterface2{
	default void method1() {
		System.out.println("method1() in myinterface2");
	}
	default void method2() {
		System.out.println("method2() in myinterface2");
	}
	static void staticmethod() {
		System.out.println("staticmethod() in myinterface2");
	}
}
