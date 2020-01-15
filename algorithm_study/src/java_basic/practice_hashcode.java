package java_basic;

public class practice_hashcode {

	public static void main(String[] args) {
		// 해시 코드 hash code
		// hashCode()는 해싱기법에 사용되는 해시함수를 구현
		// 해싱은 데이터 관리기법 중의 하나로 다량의 데이터를 저장하고 검색하는데 유용
		// 해시함수는 찾고자하는 값을 입력하면, 그 값이 저장된 위치를 알려주는 해시코드를 반환한다.
		// 해시코드가 같은 두 객체가 존재하는 것은 가능하지만 오브젝트 클래스에 정의된 hashCode 메서드는 객체의 주소값을 이용해서 해시코드를 만들어 반환하기 때문에 서로 다른 두 객체는 같은 해시코드를 가질 수 없다.
		// 따라서 hashCode를 오버라이딩 하지 않는다면 오브젝트 클래스에 정의된 대로 모든 객체가 서로 다른 해시코드 값을 가질 것이다.
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1.equals(s2));//String 클래스의 equals를 통해 내용을 비교하므로 true가 나온다.
		System.out.println(s1.hashCode());//String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환하도록 hashCode가 오버라이딩 되어있기 때문에 두 해시코드의 값은 동일하다.
		System.out.println(s2.hashCode());
		if(s1==s2) System.out.println("DD");//주소값이 서로 다르기 때문에 EE가 출력 된다.
		else System.out.println("EE");
		
		System.out.println(System.identityHashCode(s1));//오브젝트 클래스의 hashCode메서드처럼 객체 주소값으로 해시코드를 생성하기 때문에 두 해시코드의 값이 다르다.
		System.out.println(System.identityHashCode(s2));//따라서 s1과 s2는 해시코드는 같지만 서로 다른 객체이다.
	}

}
