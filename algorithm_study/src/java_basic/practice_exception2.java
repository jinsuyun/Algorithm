package java_basic;
import java.io.File;

public class practice_exception2 {

	public static void main(String[] args) throws Exception {
		// ����ó�� throw
		try {
			/*
			 * Exception e = new Exception("���Ƿ� �߻�"); throw e;//���Ƿ� �߻���Ŵ
			 */
			// throw new Exception("���� ����");//���� 2���� ���ٷ� ���� ����� ��

		} catch (Exception e) {
			System.out.println("���� :" + e.getMessage());// getMessage�� ���� ���� �޽����� ���� �� �ִ�.
			e.printStackTrace();
		}finally {
			System.out.println(10);//���ܿ� ������� ����ȴ�.
		}
		System.out.println("����");
		
		//method();
		// throw new RuntimeException();//������ ��Ÿ�� ���� ó��
		
		File f= createFile(args[0]);//args[0]�� ���ڸ� �ֱ� ���� run configuration�� �̿��Ѵ�.
		System.out.println(f.getName()+"������ ���������� �����Ǿ����ϴ�.");
	}

	public static void method() throws Exception {// thorws�� ���� �޼��忡 ����ó���� �� �� �ִ�.
		//throws�� ���ܸ� ����ϴ� ���� ���ܸ� ó���ϴ� ���� �ƴ϶� �ڽ��� ȣ���� �޼��忡�� ���ܸ� �����Ͽ� ȣ���� ���� ���޵Ǵ� ���� �������� �ִ� main���� ���� ó���� ���� ������ ���α׷��� ����ȴ�.
		//���� call stack�� �� �� �־� ��� ������������ ������� �� �� �ִ�.
		method2();
	}

	public static void method2() throws Exception {// thorws�� ���� �޼��忡 ����ó���� �� �� �ִ�.
		throw new Exception();
	}
	
	static File createFile(String fileName) {
		try {
			if(fileName==null||fileName.equals(""))
				throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
		}catch(Exception e) {
			System.out.println(e.getMessage()+" ������� ������ �����ϰڽ��ϴ�.");
			fileName="�������.txt";
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
