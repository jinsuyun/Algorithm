package java_basic;

public class practice_interface4 {

	public static void main(String[] args) {
		// 인터페이스의 default와 static 메서드
		childInterface c= new childInterface();
		c.method1();//인터페이스에 있는 메서드를 전부 무시하고 childInterface 클래스에서 오버라이딩한 method1()을 가져온다.
		c.method2();//인터페이스에 있는 메서드를 전부 무시하고 부모 클래스에 있는 method2()를 가져온다.
		//myinterface.method1();//method1()은 static이 아니므로 가져와서 사용이 불가능하다.
		myinterface.staticmethod();//인터페이스에 있는 메서드를 직접 불러온다. 단, static으로 작성된 메서드만 가능하다.(static이나 default가 아니라면 method의 body가 없기 때문)
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
interface myinterface{//default나 static으로 작성한 interface의 메서드는 선언부만 작성하는 것이 아니라 일반 메서드처럼 사용 가능하다.
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
