package java_basic;

public class practice_polymorphism {

	public static void main(String[] args) {
		// 다형성
		parent2 p = null;
		child2 c= new child2();
		child2 c2;
		parent2 p3 = new parent2();
		//c2 = (child2)p3;//이 개념은 결국 c2=new parent2()와 같은 말이기 때문에 컴파일은 실행성공일지라도 런에서 오류가 발생한다.
		
		parent2 p4 = new child2();//오류가 발생하지 않는다. 부모클래스인 parent2가 child2를 참조를 할 수 있기 때문
		System.out.println(p4.x);
		
		c2=(child2)p4;//부모클래스를 참조하기 위해서는 자식클래스에서 형변환인 다운캐스팅을 반드시 해야한다.
		
		//child2 c3=(child2) new parent2();//오류는 안뜨는데 실행은 되지 않음 그러한 이유는 parent2는 child2의 부모클래스이기 때문에 참조를 할 수 없다!! 캐스팅을 하더라도 불가능
		//System.out.println(c3.x);
		
		//child3 c33=new child2(); // 서로 같은 부모클래스를 가지더라도 다른 클래스이기 때문에 오류가 발생
		p=c;//업캐스팅은 생략이 가능하다.
		c2=(child2)p;//다운캐스팅을 반드시 해야한다.
		
		System.out.println(p.x);//다형성을 하였어도 parent2의 변수를 그대로 가져온다.
		p.method();
		System.out.println(p.x);//method는 자손클래스에서 오버라이딩을 진행했기 때문에 p.x값은 변하지 않는다. 만약 자손클래스의 method에서 super.x이면 10 값이 변한다.
		
		System.out.println(c2.x);//100이 아니라 200이 나오는 이유는 이미 자손 클래스의 오버라이딩을 거쳤기 때문에 값이 이미 변해있음 
		c2.method();
		System.out.println(c2.x);
	}

}
class parent2{
	int x=10;
	void method() {
		x=20;
		System.out.println("Parent");
	}
	
}
class child2 extends parent2{
	int x=100;
	void method() {
		x=200;//x가 가리키는 것은 this.x이기 때문에 child2의 x값만 변하는 것
		System.out.println("Child");
		
	}
}
class child3 extends parent2{
	int x=300;
}
