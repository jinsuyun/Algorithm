package java_basic;

public class practice_exception3 {

	public static void main(String[] args) {
		// ���� ó�� ����, ���� ���� ó�� �����
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
			startInstall();//���α׷� ��ġ�� �ʿ��� �غ�
			copyFiles();//���� ����
		}catch(SpaceException e) {
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(e);
			throw ie;
		}catch(MemoryException e) {
			InstallException ie = new InstallException("��ġ �� ���� �߻�");
			ie.initCause(e);
			throw ie;
		}finally {
			deleteTempFiles();//���� �ӽ����� ����
		}
	}
	static void startInstall() throws SpaceException, MemoryException{
		if(!enoughSpace()) {
			throw new SpaceException("��ġ�� ������ �����մϴ�");
		}
		if(!enoughMemory()) {
			throw new MemoryException("�޸𸮰� �����մϴ�.");
		}
	}
	
	static void copyFiles() {
		//���� ���� �ڵ�
	}
	static void deleteTempFiles() {
		//�ӽ����ϵ� ���� �ڵ�
	}
	static boolean enoughSpace() {
		//��ġ ���� Ȯ�� �ڵ�
		return false;
	}
	static boolean enoughMemory() {
		//��ġ �޸� ���� Ȯ�� �ڵ�
		return true;
	}
}

class InstallException extends Exception{//extends�� ���� ���� ó�� �޽����� �޾ƿ� �� �ִ�.
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

