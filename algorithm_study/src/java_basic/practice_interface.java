package java_basic;

public class practice_interface {

	public static void main(String[] args) {
		// 인터페이스
		// 모든 멤버 변수는 public static final 이어야 하며, 이를 생략 할 수 있다.
		// 모든 메서드는 public abstract 이어야 하며, 이를 생략할 수 있다. 단, static메서드와 디폴트 메서드는 예외
		
		// 인터페이스 장점
		// 개발 시간 단축, 표준화 가능, 서로 관계 없는 클래스에게 관계를 맺어줌, 독립적인 프로그래밍이 가능
		
		
		Fighter f = new Fighter();
		if(f instanceof Unit2)
			System.out.println("f는 Unit2 클래스의 자손입니다.");
		if(f instanceof Fightable)
			System.out.println("f는 Fightable 인터페이스를 구현했습니다.");
		if(f instanceof Movable)
			System.out.println("f는 Movable 인터페이스를 구현했습니다.");
		if(f instanceof Attackable)
			System.out.println("f는 Attackable 인터페이스를 구현했니다.");
		if(f instanceof Object)
			System.out.println("f는 Object 클래스의 자손입니다.");
		
		System.out.println(f.move(2, 3));
		
		Fightable ff=new Fighter();//다형성 가능!!
		//인터페이스 Fightable을 Fighter가 구현했을 때 Fighter 인스턴스를 Fightable 타입의 참조변수로 참조하는 것이 가능하다. 
		parsable p=printManager.method("리턴 타입 파싱");
		p.parse("파싱");
		p=printManager.method("리턴 타입 파싱2");
		p.parse("파싱2");
	}

}
class Fighter extends Unit2 implements Fightable{//인터페이스는 상속이라는 말 대신 구현(implements)이라는 용어를 사용한다.
	public String move(int x,int y) {return x+" "+y;}//반드시 public로 접근 제어자를 설정해야한다. 
	//그 이유는 Movable에 있는 move는 public abstract가 생략된 것이므로 조상 메서드보다 넓은 범위의 접근 제어자를 지정해야 하기 때문
	public void attack(Unit2 u) {}
	public void attack2(Fightable f) {};//인터페이스는 매개변수로도 사용이 가능하다.
	
}

class printManager{//리턴 타입을 인터페이스로 파싱하기 위한 클래스
	public static parsable method(String name) {
		if(name.equals("리턴 타입 파싱"))
			return new print();//인터페이스를 리턴타입으로 넣는것도 가능하다. 리턴타입이 인터페이스라는 것은 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다.
		//Fighter 클래스의 인스턴스를 반환할 수 있음
		else return new print2();
	}
	
}
class print implements parsable{//print와 print2와 같이 상속과 같은 관계없는 2개의 클래스를 인터페이스를 통해 parasable와 ㅕ관계를 맺을 수 있다. 
	public void parse(String name) {//선언의 구현부
		System.out.println(name+"이 인터페이스 리턴 타입으로 반환되었습니다");
	}
}

class print2 implements parsable{
	public void parse(String name) {//선언의 구현부
		System.out.println(name+"이 print2 클래스를 통해 인터페이스 리턴 타입으로 반환되었습니다.");
	}
}

class Unit2{
	int x,y,hp;
}

interface Movable{
	String move(int x,int y);//void 앞에 public abstract가 생략 된것
}

interface Attackable{
	void attack(Unit2 u);
	void attack2(Fightable f);
}

interface Fightable extends Movable,Attackable{
	
}
interface parsable {
	void parse(String name);//인터페이스 타입의 리턴 파싱을 위한 선언
}

