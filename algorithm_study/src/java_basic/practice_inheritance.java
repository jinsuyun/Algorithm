
package java_basic;

import java.util.Arrays;

public class practice_inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent p = new parent();
		p.age = 30;
		System.out.println(p.age);
		child c = new child();
		System.out.println(c.age);
		c.age = 20;
		grandchild g = new grandchild();
		System.out.println(g.age);
		System.out.println(c.sex + " " + p.sex);

		circle cir = new circle();
		cir.p.x = 1;
		System.out.println(cir.p.x);

		System.out.println(c.sex);
		System.out.println(c.sex2);
		System.out.println(c.sex3);
		System.out.println(c.sex4);
		System.out.println();
		System.out.println();
		point3d ppp = new point3d(4,5,6);
		//System.out.println();
		//System.out.println("테스트 " + ppp.x);
		
		int[] arr= {1,2,3,4};
		//point pArr=new point(arr);//생성자에 배열도 넣을 수 있다.
		//System.out.println(Arrays.toString(pArr.arr));
	}

}

class parent {
	static int age = 10;
	int sex = 3;
}

class child extends parent {
	int sex = 10;
	int sex2 = sex;
	int sex3 = super.sex;
	int sex4 = this.sex;
	protected int sex5;
}

class grandchild extends child {

}

class point {
	int x, y;
	int[] arr;

	point(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("q");
	}

	point() {
		System.out.println("w");
	}
	
	point(int[] arr) {
		this.arr=arr;
		System.out.println("e");
	}


	String getLocation() {
		return "x:" + x + ",y:" + y;
	}
}

class point3d extends point {
	int z;

	point3d() {
		//super(); // super은 부모의 생성자를 호출하는 개념이다. 자손클래스에서 부모클래스를 상속 했을 경우 순서가 부모->자식 순이다 
		//만약 부모클래스에서 생성자가 없는 경우 default 생성자를 호출하지만 부모클래스에서 임의의 생성자를 생성한경우 자손클래스에서 부모 생성자를 호출할 super를 쓰지 않는다면 
		//부모 클래스의 default 생성자를 개발자가 만들어줘야 오류가 나지 않는다.(extends로 자식은 부모를 상속한다고 명시했기 때문) 
	}

	point3d(int x, int y, int z) {

		//super();
		this.z = z;
	}

	String getLocation() {
		return "x:" + x + ",y:" + y + "z:" + z;
	}
}

class circle {
	point p = new point();
	int r;
}
