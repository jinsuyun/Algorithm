package java_basic;

public class practice_exception3 {

	public static void main(String[] args) {
		// 예외 처리 연습, 직접 예외 처리 만들기
		try {
			install();
		}catch(InstallException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void install() throws InstallException{
		try {
			startInstall();//프로그램 설치에 필요한 준비
			copyFiles();//파일 복사
		}catch(SpaceException e) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
			throw ie;
		}catch(MemoryException e) {
			InstallException ie = new InstallException("설치 중 예외 발생");
			ie.initCause(e);
			throw ie;
		}finally {
			deleteTempFiles();//사용된 임시파일 삭제
		}
	}
	static void startInstall() throws SpaceException, MemoryException{
		if(!enoughSpace()) {
			throw new SpaceException("설치할 공간이 부족합니다");
		}
		if(!enoughMemory()) {
			throw new MemoryException("메모리가 부족합니다.");
		}
	}
	
	static void copyFiles() {
		//파일 복사 코드
	}
	static void deleteTempFiles() {
		//임시파일들 삭제 코드
	}
	static boolean enoughSpace() {
		//설치 공간 확인 코드
		return false;
	}
	static boolean enoughMemory() {
		//설치 메모리 공간 확인 코드
		return true;
	}
}

class InstallException extends Exception{//extends를 통해 예외 처리 메시지를 받아올 수 있다.
	InstallException(String msg) {
		super(msg);
	}
}
class SpaceException extends Exception{
	 SpaceException(String msg) {
		 super(msg);
	 }
}
class MemoryException extends Exception{
	 MemoryException(String msg) {
		 super(msg);
	 }
}

