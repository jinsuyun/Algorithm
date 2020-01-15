package java_basic;

public class practice_tostring {

	public static void main(String[] args) {
		// 오브젝트 클래스 toString()
		// 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의한 것이다.
		Card c1=new Card();
		Card c2=new Card();
		//오버라이딩이 되지 않는 toString을 사용할 경우 클래스이름에 16진수의 해시코드를 가진다.
		//만약 Card클래스에서 toString()을 오버라이딩 한다면 내용 값을 가질 수 있다.
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		//String 클래스의 toString()은 String인스턴스가 갖고 있는 문자열을 반환하도록 오버라이딩되어 있다.
		String s=new String("KOREA");
		System.out.println(s.toString());
	}

}
class Card{
	String kind;
	int number;
	Card(){
		this("SPADE",1);
	}
	Card(String kind,int number){
		this.kind=kind;
		this.number=number;
	}
	public String toString() {//오브젝트 클래스의 toString()메서드가 public이므로 오버라이딩의 접근제어자도 public로 해주어야한다.
		return kind+" "+number; 
	}
}

