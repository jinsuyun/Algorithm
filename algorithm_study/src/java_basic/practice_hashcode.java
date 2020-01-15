package java_basic;

public class practice_hashcode {

	public static void main(String[] args) {
		// �ؽ� �ڵ� hash code
		// hashCode()�� �ؽ̱���� ���Ǵ� �ؽ��Լ��� ����
		// �ؽ��� ������ ������� ���� �ϳ��� �ٷ��� �����͸� �����ϰ� �˻��ϴµ� ����
		// �ؽ��Լ��� ã�����ϴ� ���� �Է��ϸ�, �� ���� ����� ��ġ�� �˷��ִ� �ؽ��ڵ带 ��ȯ�Ѵ�.
		// �ؽ��ڵ尡 ���� �� ��ü�� �����ϴ� ���� ���������� ������Ʈ Ŭ������ ���ǵ� hashCode �޼���� ��ü�� �ּҰ��� �̿��ؼ� �ؽ��ڵ带 ����� ��ȯ�ϱ� ������ ���� �ٸ� �� ��ü�� ���� �ؽ��ڵ带 ���� �� ����.
		// ���� hashCode�� �������̵� ���� �ʴ´ٸ� ������Ʈ Ŭ������ ���ǵ� ��� ��� ��ü�� ���� �ٸ� �ؽ��ڵ� ���� ���� ���̴�.
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1.equals(s2));//String Ŭ������ equals�� ���� ������ ���ϹǷ� true�� ���´�.
		System.out.println(s1.hashCode());//String Ŭ������ ���ڿ��� ������ ������ ������ �ؽ��ڵ带 ��ȯ�ϵ��� hashCode�� �������̵� �Ǿ��ֱ� ������ �� �ؽ��ڵ��� ���� �����ϴ�.
		System.out.println(s2.hashCode());
		if(s1==s2) System.out.println("DD");//�ּҰ��� ���� �ٸ��� ������ EE�� ��� �ȴ�.
		else System.out.println("EE");
		
		System.out.println(System.identityHashCode(s1));//������Ʈ Ŭ������ hashCode�޼���ó�� ��ü �ּҰ����� �ؽ��ڵ带 �����ϱ� ������ �� �ؽ��ڵ��� ���� �ٸ���.
		System.out.println(System.identityHashCode(s2));//���� s1�� s2�� �ؽ��ڵ�� ������ ���� �ٸ� ��ü�̴�.
	}

}
