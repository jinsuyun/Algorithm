package java_basic;
import java.io.File;

public class practice_exception2 {

	public static void main(String[] args) throws Exception {
		// 예외처리 throw
		try {
			/*
			 * Exception e = new Exception("고의로 발생"); throw e;//고의로 발생시킴
			 */
			// throw new Exception("고의 에러");//위의 2줄을 한줄로 만들어서 사용한 것

		} catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());// getMessage에 내가 넣은 메시지를 넣을 수 있다.
			e.printStackTrace();
		}finally {
			System.out.println(10);//예외와 상관없이 실행된다.
		}
		System.out.println("종료");
		
		//method();
		// throw new RuntimeException();//강제로 런타임 예외 처리
		
		File f= createFile(args[0]);//args[0]에 문자를 넣기 위해 run configuration을 이용한다.
		System.out.println(f.getName()+"파일이 성공적으로 생성되었습니다.");
	}

	public static void method() throws Exception {// thorws를 통해 메서드에 예외처리를 할 수 있다.
		//throws에 예외를 명시하는 것은 예외를 처리하는 것이 아니라 자신을 호출한 메서드에게 예외를 전달하여 호출을 따라 전달되다 제일 마지막에 있는 main에서 예외 처리가 되지 않으면 프로그램이 종료된다.
		//또한 call stack을 알 수 있어 어디서 비정상적으로 종료된지 알 수 있다.
		method2();
	}

	public static void method2() throws Exception {// thorws를 통해 메서드에 예외처리를 할 수 있다.
		throw new Exception();
	}
	
	static File createFile(String fileName) {
		try {
			if(fileName==null||fileName.equals(""))
				throw new Exception("파일이름이 유효하지 않습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage()+" 제목없음 파일을 생성하겠습니다.");
			fileName="제목없음.txt";
		}finally {
			File f = new File(fileName);
			createNewFile(f);
			return f;
		}
	}
	static void createNewFile(File f) {
		try {
			f.createNewFile();
		}catch(Exception e){
			
		}
	}
}
