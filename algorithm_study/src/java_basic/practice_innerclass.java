package java_basic;

public class practice_innerclass {

	public static void main(String[] args) {
		// 내부 클래스
	}

}

class Inner {
	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv = outerIv;// 외부 클래스의 private 멤버도 접근 가능하다.
		int iiv2 = outerCv;
	}

	static class StaticInner {
		// int siv=outerIv; //스태틱 클래스는 외부클래스의 인스턴스 멤버에 접근할 수 없다.
		static int scv = outerCv;
	}

	InstanceInner iv = new InstanceInner();// 인스턴스 멤버간 서로 직접 접근 가능
	static StaticInner cv = new StaticInner();// 스테틱 멤버간 서로 직접 접근 가능

	static void staticMethod() {
		// InstanceInner obj1 = new InstanceInner(); //스테틱 멤버는 인스턴스멤버에 직접 접근할 수 없다.
		StaticInner obj2 = new StaticInner();

		// 굳이 접근하려면 아래와 같이 객체생성으로 접근한다. 인스턴스 클래스는 외부 클래스를 먼저 생성해야한 생성할 수 있다.
		Inner outer = new Inner();
		InstanceInner obj1 = outer.new InstanceInner();

		class LocalInner {
			int iv = 300;
			// static int cv=200;// static변수를 선언 할 수 없다. static 변수를 선언하려면 static 클래스로
			// 선언해야한다.
			final static int con = 400;// final static은 상수이므로 가능하다.
		}
		LocalInner lv = new LocalInner();// 같은 메서드 안에서 내부 클래스 선언을 할 수 있다.
	}

	void instanceMethod() {
		// 인스턴스 메서드에서 인스턴스 멤버과 스테틱 멤버 모두 접근 가능
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		// LocalInner lv = new LocalInner();// 메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근할 수 없다.
	}

	void myMethod() {
		int lv = 0;
		final int LV = 0;
		class LocalInner {
			int liv = outerIv;
			int liv2 = outerCv;
			int liv3 = lv;// JDK1.8부터 final이 붙지 않아도 편의상 생략된 것이다.
			int liv4 = LV;
		}
	}

}
