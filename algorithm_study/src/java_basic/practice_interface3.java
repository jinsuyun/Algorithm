package java_basic;

public class practice_interface3 {

	public static void main(String[] args) {
		// �������̽� ����
		// Ŭ���� A�� B�� ���� ��, ������� Ŭ���� A���� B�� ȣ�� �ϴ� ��쿡�� B�� �̹� �ۼ��Ǿ� �־���ϸ� B �޼����� ����ΰ� ���ݸ�
		// �ٲ�� A�� ����Ǿ���Ѵ�.
		// �׷��� Ŭ����A�� B�� ���� ȣ������ �ʰ� �������̽��� �Ű�ü�� �Ͽ� Ŭ���� A�� �������̽��� ���� B�� �޼��忡 �����ϸ� Ŭ���� B��
		// ��������� ����ų�
		// Ŭ���� B�� ���� ����� �ٸ� Ŭ������ �ٸ� Ŭ������ ��ü �Ǿ Ŭ���� A�� ���� ���� ���� �ʵ��� �����ϴ�.
		// �� Ŭ���� ���踦 ���������� �����ϱ� ���ؼ� ���� �������̽��� �̿��ؼ� Ŭ���� B�� ����� ������ �и��ؾ��Ѵ�.
		
		A a = new A();//A�� B�� C�� ���� ���踦 ���� �ʰ� I��� �������̽��� ���� ���������� ������ ��ĥ �� �ִ�.
		a.methodA(new B());//A-I-B B�� ȣ���߱� ������ B�� �������̽� �����ο� ����.
		System.out.println();
		a.methodA(new C());//A-I-C C�� ȣ���߱� ������ C�� �������̽� �����ο� ����.
		System.out.println();
		a.methodInstance(new B());
	}

}
interface I{
	void method();
	default void method2() {}//default �޼ҵ�� �������̽��� �����ϴ��� ������ ������ Ŭ������ �������� �ʾƵ� �ȴ�. ��, ����Ŭ������ ���ο� �޼��带 �߰��� �Ͱ� ������ ���� ���̴�.
}

class A{
	public void methodA(I i) {
		i.method();
	}
	public void methodInstance(I i) {
		i=InstanceManager.getInstance();//�� 3�� Ŭ������  �޼��带 ���� �������̽� I�� ������ Ŭ������ �ν��Ͻ��� ���´�. 
		i.method();//���� B�� �ް� �ֱ� ������ B Ŭ������ method�� �� ���̴�.
	}
}
class B implements I{
	public void method() {
		System.out.println("method in B class");
	}
}
class C implements I{
	@Override
	public void method() {
		System.out.println("method in C class");
	}
}
class InstanceManager{//�ν��Ͻ��� ���� �������� �ʰ� getInstance()�� ���� �����޴´�. ���߿� �ٸ� Ŭ������ �ν��Ͻ��� ����Ǿ AŬ������ ������� getInstance�� �����ϸ� �ȴٴ� ������ �����.
	public static I getInstance() {
		return new B();//�ٸ� �ν��Ͻ��� �ٲٷ��� ���⸸ �����ϸ� �� ����� B�� �ް� ����
	}
}