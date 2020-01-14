package java_basic;

public class practice_polymorphism3 {
	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * animal ani = new animal(); 
	 * dog d = null; 
	 * cat c = null; 
	 * d = (dog) ani;
	 * System.out.println(d.x); 
	 * // d=(dog)ani에서 컴파일은 성공하지만 에러가 발생 
	 * }
	 */

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * animal ani = null; 
	 * dog d = new dog(); 
	 * cat c = null; 
	 * ani = d; 
	 * c= (cat)ani;
	 * System.out.println(c.x); // cat과 dog은 독립된 객체로 에러가 발생 
	 * }
	 */

	
	  public static void main(String[] args) { // TODO Auto-generated method stub
	  animal ani = null;
	  dog d = new dog(); 
	  dog d1 = null;
	  ani = d;
	  ani = new cat();
	  d1= (cat)ani;
	  System.out.println(d1.x); //15
	  ani.method(); 
	  System.out.println(ani.x); // cat Method 10
	  System.out.println(d1.x);
	  d1.method(); // cat Method 
	  }
}

class animal {

	int x = 10;

	void method() {
		x = x + 10;
		System.out.println("Method");

	}

}

class dog extends animal {

	int x = 15;

	void method() {

		super.x = this.x + 10;
		System.out.println("dog Method");

	}

}

class cat extends dog {

	int x = 20;

	void method() {
		super.x = super.x + 10;
		System.out.println("cat Method");

	}

}
