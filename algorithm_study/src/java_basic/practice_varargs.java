package java_basic;

public class practice_varargs {

	public static void main(String[] args) {
		// �������ڿ� �����ε�
		String[] strArr= {"100","200","300"};
		System.out.println(concatenate("","100","200","300"));
		System.out.println(concatenate("",strArr));
		System.out.println(concatenate(",",new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",","1")+"]");
	}
	static String concatenate(String delim, String... args) {//String 1���� ...�� �ٿ� �������� String�� ������ ȿ���� ����
		String result="";
		for(String str:args) {
			result+=str+delim;
		}
		return result;
	}

}
