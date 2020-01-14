package java_basic;

public class practice_abstract {

	public static void main(String[] args) {
		// 추상화
		// 통일성을 위한 선언부의 필요성이 있다면 추상화 클래스를 생성한다.
		// 추상화가 아니더라도 오버라이딩 개념으로 코드를 짤 수 있지만 선언부가 애매해짐
		basicCal c = new basicCal(1, 2);
		System.out.println(c.add(c.x, c.y));//3
		System.out.println();
		basicCal2 b = new basicCal2(1, 2);
		System.out.println(b.add(b.x, b.y));//3

		Calculator2 c2 = new Calculator2(4, 2) {//자손클래스의 추상 메서드를 정의한 것이 아닌 abstract class자체를 불러올때는 따로 정의를 해주어야한다. 
			@Override
			int mul(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}

			@Override
			int minus(int x, int y) {
				// TODO Auto-generated method stub
				return x-y;
			}

			@Override
			int div(int x, int y) {
				// TODO Auto-generated method stub
				return x/y;
			}

			@Override
			int add(int x, int y) {
				// TODO Auto-generated method stub
				return x*y;
			}
		};
		System.out.println();
		System.out.println(c2.add());//일반 메서드를 불러온 것
		System.out.println(c2.add(2,3));//2,3이 추상 add메서드에 적용되지 않고 추상메서드에서 작성한 4,2가 적용된다. 
		System.out.println(c2.x+" "+c2.y);//4 2
	};

}

class Calculator {
	int x, y;

	Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class basicCal extends Calculator {
	basicCal(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

	int div(int x, int y) {
		return x / y;
	}

	int mul(int x, int y) {
		return x * y;
	}
}

abstract class Calculator2 {//추상 클래스이지만 일반 메서드도 가질 수 있다.
	int x, y;

	Calculator2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract int add(int x, int y);// 추상 메서드 선언

	abstract int minus(int x, int y);

	abstract int div(int x, int y);

	abstract int mul(int x, int y);

	int add() {
		return 10;
	};// 일반 메서드 --> 오버로딩의 개념으로 매개변수 타입을 바꾸고 같은 이름으로 생성

	int add(int x) {// 추상 메서드 구현
		return x;
	}
}

class basicCal2 extends Calculator2 {
	basicCal2(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {// 추상 메서드 구현
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

	int div(int x, int y) {
		return x / y;
	}

	int mul(int x, int y) {
		return x * y;
	}
}

abstract class basicCal3 extends Calculator2 {// 추상 클래스는 abstract로 선언된 메서드를 반드시 전부 선언해야한다. 그렇지 않다면 자손 클래스도 absract 클래스로
												// 생성해야한다.
	basicCal3(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

}
