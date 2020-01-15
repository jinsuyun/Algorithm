package java_basic;

public class practice_innerclass {

	public static void main(String[] args) {
		// ���� Ŭ����
	}

}

class Inner {
	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv = outerIv;// �ܺ� Ŭ������ private ����� ���� �����ϴ�.
		int iiv2 = outerCv;
	}

	static class StaticInner {
		// int siv=outerIv; //����ƽ Ŭ������ �ܺ�Ŭ������ �ν��Ͻ� ����� ������ �� ����.
		static int scv = outerCv;
	}

	InstanceInner iv = new InstanceInner();// �ν��Ͻ� ����� ���� ���� ���� ����
	static StaticInner cv = new StaticInner();// ����ƽ ����� ���� ���� ���� ����

	static void staticMethod() {
		// InstanceInner obj1 = new InstanceInner(); //����ƽ ����� �ν��Ͻ������ ���� ������ �� ����.
		StaticInner obj2 = new StaticInner();

		// ���� �����Ϸ��� �Ʒ��� ���� ��ü�������� �����Ѵ�. �ν��Ͻ� Ŭ������ �ܺ� Ŭ������ ���� �����ؾ��� ������ �� �ִ�.
		Inner outer = new Inner();
		InstanceInner obj1 = outer.new InstanceInner();

		class LocalInner {
			int iv = 300;
			// static int cv=200;// static������ ���� �� �� ����. static ������ �����Ϸ��� static Ŭ������
			// �����ؾ��Ѵ�.
			final static int con = 400;// final static�� ����̹Ƿ� �����ϴ�.
		}
		LocalInner lv = new LocalInner();// ���� �޼��� �ȿ��� ���� Ŭ���� ������ �� �� �ִ�.
	}

	void instanceMethod() {
		// �ν��Ͻ� �޼��忡�� �ν��Ͻ� ����� ����ƽ ��� ��� ���� ����
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		// LocalInner lv = new LocalInner();// �޼��� ���� ���������� ����� ���� Ŭ������ �ܺο��� ������ �� ����.
	}

	void myMethod() {
		int lv = 0;
		final int LV = 0;
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;// JDK1.8���� final�� ���� �ʾƵ� ���ǻ� ������ ���̴�.
			int liv4 = LV;
		}
	}

}
