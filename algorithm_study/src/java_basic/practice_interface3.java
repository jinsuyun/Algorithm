package java_basic;

public class practice_interface3 {

	public static void main(String[] args) {
		// 인터페이스 이해
		// 클래스 A와 B가 있을 때, 예를들어 클래스 A에서 B를 호출 하는 경우에는 B가 이미 작성되어 있어야하며 B 메서드의 선언부가 조금만
		// 바뀌면 A도 변경되어야한다.
		// 그러나 클래스A가 B를 직접 호출하지 않고 인터페이스를 매개체로 하여 클래스 A가 인터페이스를 통해 B의 메서드에 접근하면 클래스 B에
		// 변경사항이 생기거나
		// 클래스 B와 같은 기능의 다른 클래스로 다른 클래스로 대체 되어도 클래스 A는 전혀 영향 받지 않도록 가능하다.
		// 두 클래스 관계를 간접적으로 변경하기 위해서 먼저 인터페이스를 이용해서 클래스 B의 선언과 구현을 분리해야한다.
		
		A a = new A();//A와 B와 C는 직접 관계를 맺지 않고 I라는 인터페이스를 통해 간접적으로 영향을 끼칠 수 있다.
		a.methodA(new B());//A-I-B B를 호출했기 때문에 B의 인터페이스 구현부에 들어간다.
		System.out.println();
		a.methodA(new C());//A-I-C C를 호출했기 때문에 C의 인터페이스 구현부에 들어간다.
		System.out.println();
		a.methodInstance(new B());
	}

}
interface I{
	void method();
	default void method2() {}//default 메소드는 인터페이스를 수정하더라도 기존의 구현한 클래스를 변경하지 않아도 된다. 즉, 조상클래스에 새로운 메서드를 추가한 것과 동일해 지는 것이다.
}

class A{
	public void methodA(I i) {
		i.method();
	}
	public void methodInstance(I i) {
		i=InstanceManager.getInstance();//제 3의 클래스의  메서드를 통해 인터페이스 I를 구현한 클래스의 인스턴스를 얻어온다. 
		i.method();//현재 B를 받고 있기 때문에 B 클래스의 method로 들어갈 것이다.
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
class InstanceManager{//인스턴스를 직접 생성하지 않고 getInstance()를 통해 제공받는다. 나중에 다른 클래스의 인스턴스로 변경되어도 A클래스의 변경없이 getInstance만 변경하면 된다는 장점이 생긴다.
	public static I getInstance() {
		return new B();//다른 인스턴스로 바꾸려면 여기만 변경하면 됨 현재는 B를 받고 있음
	}
}