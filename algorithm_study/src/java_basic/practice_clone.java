package java_basic;

import java.util.Arrays;

public class practice_clone {

	public static void main(String[] args) {
		// object class clone
		// clone()는 자신을 복제하여 새로운 인스턴스를 생성하는 일을 한다.
		// 이전 값을 보존하고 새로 인스턴스를 생성하여 작업하여 원래의 값을 보존한다. 
		// 오브젝트 클래스에 정의된 clone()는 단순 인스턴스 변수의 값만 복사하기 때문에 참조 변수 타입의 인스턴스 변수가 정의되어 있는 클래스는 완전한 인스턴스 복제가 이루어지지 않는다.
		// 배열의 경우, 인스턴스도 같은 배열의 주소를 갖기 때문에 원래 인스턴스에 영향을 미친다. 따라서 오버라이딩이 필요하다.
		//clone()을 사용하려면 먼저 복제할 클래스가 Cloneable인터페이스를 구현해야하고 clone()을 오버라이딩 하면서 접근제어자를 protected에서 public로 변경한다. 
		//그래야한 상속관계가 없는 다른 클래스에서 호출 가능하다.
		p original = new p(3,5);
		p copy = (p)original.clone();//다형성 개념
		p copy2 =original.clone();//clone() 오버라이딩을 Object가 아닌 p로 했기 때문에 캐스팅을 안해도된다.
		System.out.println(original);
		System.out.println(copy);//Cloneable을 구현하지 않는다면 복사가 이루어지지 않는다. 그 이유는 인스턴스 데이터를 보호하기 위함
		
		//배열의 복사 배열도 객체이기 때문에 clone()이 가능하다.
		//ArrayList, Vector,LinkedList,Hashset,TreeSet,HashMap,TreeMap,Calendar,Date와 같은 클래스도 clone()으로 복제가 가능하다.
		int[] arr= {1,2,3,4,5};
		int[] arrCopy=arr.clone();
		int[] arrCopy2 = new int[arr.length];
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrCopy));
		System.arraycopy(arr,0, arrCopy2,0, arr.length);//System.arraycopy를 사용하여 copy가 가능하다.
		System.out.println(Arrays.toString(arrCopy2));
		
		//얕은 복사 - 원본을 변경하면 복사본도 영향을 받는다.
		//깊은 복사 - 원본이 참조하고 있는 객체까지 복제한다. 원본과 복사본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복사본에 영향을 미치지 않는다.
		circle2 c1=new circle2(new p(1,1),2.4);
		circle2 c2=c1.clone();//완전한 복제가 아닌 클래스 내부에서 호출한 부분은 복제한 것도 똑같이 호출하는 것 --> 얕은 복사
		circle2 c3=c1.deepCopy();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		c1.p.x=9;
		c1.p.y=8;
		System.out.println("변경 후");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);//딥카피는 참조한 객체도 복사하기 때문에 바뀌지 않는다.
		
	}

}
class p{//Cloneable 인터페이스를 구현한 클래스에서만 clone()을 호출 할 수 있다. 그렇지 않으면 예외가 발생한다.
	int x,y;
	p(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return x+" "+y;
	}
	public p clone() {//Object를 p로 바꿈과 return의 형 변환을 자손클래스 p에 맞게 해줌으로써 클래스 호출시 번거로운 형변환을 줄일 수 있다.
		Object obj=null;
		try {
			obj=super.clone();
		}catch(CloneNotSupportedException e){
			
		}
		return (p)obj;
	}
}
class circle2 implements Cloneable{
	p p;
	double r;
	circle2(p p,double r){
		this.p=p;
		this.r=r;
	}
	public circle2 clone() {//얕은 복사
		Object o=null;
		try {
			o=super.clone();
		}catch(CloneNotSupportedException e) {
			
		}
		return (circle2)o;
	}
	public circle2 deepCopy() {
		Object o =null;
		try {
			o=super.clone();
		}catch(CloneNotSupportedException e) {}
		circle2 c = (circle2) o;//복제한 객체 o가 새로운 인스턴스 c를 참조하도록함으로써 원본이 참조하고 있는 객체까지 복사한것.
		c.p=new p(this.p.x,this.p.y);//참조한 것을 복사
		return c;
	}
	public String toString() {
		return p+" "+r;
	}
}
