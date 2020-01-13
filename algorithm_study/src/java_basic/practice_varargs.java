package java_basic;

public class practice_varargs {

	public static void main(String[] args) {
		// 가변인자와 오버로딩
		String[] strArr= {"100","200","300"};
		System.out.println(concatenate("","100","200","300"));
		System.out.println(concatenate("",strArr));
		System.out.println(concatenate(",",new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",","1")+"]");
	}
	static String concatenate(String delim, String... args) {//String 1개로 ...을 붙여 여러개의 String을 선언한 효과와 같다
		String result="";
		for(String str:args) {
			result+=str+delim;
		}
		return result;
	}

}
