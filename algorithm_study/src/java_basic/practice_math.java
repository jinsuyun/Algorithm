package java_basic;

public class practice_math {

	public static void main(String[] args) {
		// Math 반올림, 반내림, 올림, 내림, 제곱, 루트
		double a=10.25;
		System.out.println(Math.round(a));//round 소수점 첫째 자리에서 반올림 반환값이 int
		System.out.println(Math.rint(a));//rint 소수점 첫째 자리에서 반올림 반환값이 int -->rint()는 가장 가까운 정수값을 double로 반환
		System.out.println(Math.floor(a));//버림
		System.out.println(Math.ceil(a));//올림
		
		a=-1.5;
		System.out.println(Math.round(a));//음수일 때 결과가 다름 round는 -1.5에서 첫째자리에서 반올림해 -1이 됨
		System.out.println(Math.rint(a));//소수점 첫째자리가 5를 초과하는 값일 때만 반올림 따라서 내림
		
		System.out.println(Math.floor(a));//버림
		System.out.println(Math.ceil(a));//올림
		int b=4;
		
		System.out.println(Math.pow(b,2));//n제곱
		System.out.println(Math.sqrt(b));//루트
	}

}
