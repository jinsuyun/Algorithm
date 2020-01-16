package java_basic;

import java.util.Arrays;
import java.util.StringTokenizer;

public class practice_equals_stringclass {

	public static void main(String[] args) {
		// object class의 equals와 String, StringBuffer, compareTo, split과 stringtokenizer의 차이
		val v1 = new val(10);
		val v2 = new val(10);

		if (v1.value == v2.value)
			System.out.println("값에 의한 참조");
		else
			System.out.println("값에 의한 참조가 아님");

		if (v1 == v2)
			System.out.println("주소 값에 의한 참조");
		else
			System.out.println("데이터 값에 의한 참조가 아님");

		// equals는 데이터 값을 비교
		if (v1.equals(v2))
			System.out.println("데이터 값 비교");
		else
			System.out.println("주소 값 비교 아님");

		v2 = v1;// 참조가 같다는 것을 명시, v2는 v1이 참조하고 있는 인스턴스 주소를 저장
		if (v1.equals(v2))
			System.out.println("데이터 값 비교");
		else
			System.out.println("주소 값 비교 아님");
		//String 클래스는 String을 선언할때마다 새로운 인스턴스를 생성하는 개념
		//단, 이미 존재하고 있는 같은 값의 리터럴 문자를 String 변수에 넣는 경우는 이미 존재하는 인스턴스를 사용
		String s = new String("1");
		String s2 = "1";
		String s3 = new String("1");
		if (s == s2)//==은 주소값을 비교하는 것
			System.out.println("@");// ==으로 비교할 경우 다른 참조변수를 가리키는 것이므로 다르다고 나온다.
		else
			System.out.println("#");

		if (s.equals(s2))
			System.out.println("3");// String의 equals는 참조에 의한 내용 값을 비교하는 것이므로 같다고 나온다.
		else
			System.out.println("4");

		if (s == s3)
			System.out.println("D");// 같은 String클래스를 사용한다고 해도 두개의 String은 다른 인스턴스로 생성되기 때문에 ==(주소값 비교)으로 비교할 경우 다르다고 나온다.
		else
			System.out.println("E");

		// String 클래스 역시 오브젝트 클래스의 equals메서드를 그대로 사용하는 것이 아니라 오버라이딩을 통해서 String 인스턴스가 갖는
		// 문자열 값을 비교하도록 되어 있다.
		if (s.equals(s3))
			System.out.println("F");// 따라서 s와 s3의 값이 같으므로 F가 출력된다.
		else
			System.out.println("G");
		// 단, StringBuffer클래스는 오버라이딩 되어 있지 않다.

		// String
		// 문자열 간의 결합이나 추출 등 문자열을 다루는 작업이 많이 필요한 경우는 String대신 StringBuffer클래스를 사용하는 것이 좋다.
		// StringBuffer인스턴스에 저장된 문자열은 변경이 가능하므로 하나의 StringBuffer인스턴스만으로 문자열을 다루는 것이 가능하다.
		String s4 = "abc";// 문자열 리터럴 abc의 주소가 s1에 저장됨
		String s5 = new String("abc");// 새로운 String인스턴스를 생성, 따라서 String 클래스의 생성자를 이용한 경우에는 new연산자에 의해 메모리 할당이 이루어지기 때문에
		// 항상 새로운 String 인스턴스가 생성된다. 그러나 문자열 리터럴은 이미 존재하는 것을 재사용하는 것이다.
		
		char[] carr=new char[0];//char[] carr={};와 같다.
		//char c ='';//사용이 불가능 char은 반드시 하나의 문자를 지정해야한다.
		String s6=new String(carr);//String s6=new String("");와 가다.
		System.out.println(carr);//아무런 값이 나오지 않음
		System.out.println(carr.length);//0이 나옴
		System.out.println(s6.length());//0이 나옴
		//comapreTo는 사전 순으로 비교
		s="1";
		s2="2";
		System.out.println(s.compareTo(s2));//앞이 더크면 1 뒤가 더크면 -1 같으면 0을 반환한다.
		System.out.println(s.concat("3"));//concat은 뒤에 덧붙인다.
		//indexOf - 주어진 문자가 문자열에 존재하는지 확인하여 지정된 위치부터 확인하여 위치를 알려준다.
		s="Hello";
		System.out.println(s.indexOf("h"));//찾지 못하면 -1을 반환
		System.out.println(s.indexOf("H",0));//지정된 위치부터 확인하여 위치를 알려준다.
		System.out.println(Arrays.toString(s.split("l")));//지정된 분리자로 나누어 문자열 배열에 담아 반환
		System.out.println(s.startsWith("H"));//지정한 문자열로 시작하는지 검사
		System.out.println(s.substring(0));//지정한 시작위치부터 끝위치 포함된 문자열을 얻는다.
		System.out.println(s.substring(0,3));//지정한 시작위치부터 지정한 끝위치까지 포함된 문자열을 얻는다. 범위는  0<=문자열<3
		System.out.println(s.trim());//문자열의 왼쪽 끝과 오른쪽 끝에 있는 공백을 없앤 결과를 반환, 문자열 중간의 공백은 없애지 못함.
		s="dog,cat,bear";
		String[] ar=s.split(",");
		System.out.println(Arrays.toString(ar));
		s=String.join("-", ar);//split과 반대 개념으로 구분자를 넣어서 문자열을 합치는 것 합치는 것
		System.out.println(s);
		
		//StringBuffer
		StringBuffer sb=new StringBuffer("123");
		sb.append("456").append("789");//이런식으로 가능
		System.out.println(sb);
		System.out.println(sb.reverse());//역순으로 반환
		
		sb=new StringBuffer("123");
		StringBuffer sb2=new StringBuffer("123");
		System.out.println(sb==sb2);//false
		System.out.println(sb.equals(sb2));//false가 나옴 equals가 StringBuffer클래스에 오버라이딩이 되어있지 않으므로
		System.out.println(sb.toString().equals(sb2.toString()));//이런식으로 toString()을 사용하여 비교해야함
		System.out.println();
		
		sb=new StringBuffer("123");
		sb2=sb.append(45);//같은 sb를 참조하기 때문에 123에 이어 45를 붙인것
		sb.append(6);
		StringBuffer sb3=sb.append(78);//sb3는 sb와 같은 주소를 가지기 때문에 12345678이됨
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		//StringBuilder - StringBuffer과 똑같은 기능으로 작성되어있음 단, 동기화가 StringBuffer 성능을 떨어뜨려 쓰레드의 동기화만 뺀 것이 StringBuilder이다. 
		
		//StringTokenizer와 Split 비교
		s="A,,B,C,,D";
		StringTokenizer st = new StringTokenizer(s,",");
		String[] sarr=s.split(",");
		for(int i=0;i<sarr.length;i++)
			System.out.print(sarr[i]+"|");
		System.out.println("split 개수 "+sarr.length);
		
		int i=0;
		for(;st.hasMoreTokens();i++)
			System.out.print(st.nextToken()+"|");
		System.out.println("stringtokenize 개수 "+i);
	}

}

class val {
	int value;

	val(int val) {
		this.value = val;
	}
}
