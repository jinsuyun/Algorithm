package java_basic;

public class practice_polymorphism {

	public static void main(String[] args) {
		// ������
		parent2 p = null;
		child2 c= new child2();
		child2 c2;
		parent2 p3 = new parent2();
		//c2 = (child2)p3;//�� ������ �ᱹ c2=new parent2()�� ���� ���̱� ������ �������� ���༺�������� ������ ������ �߻��Ѵ�.
		
		parent2 p4 = new child2();//������ �߻����� �ʴ´�. �θ�Ŭ������ parent2�� child2�� ������ �� �� �ֱ� ����
		System.out.println(p4.x);
		
		c2=(child2)p4;//�θ�Ŭ������ �����ϱ� ���ؼ��� �ڽ�Ŭ�������� ����ȯ�� �ٿ�ĳ������ �ݵ�� �ؾ��Ѵ�.
		
		//child2 c3=(child2) new parent2();//������ �ȶߴµ� ������ ���� ���� �׷��� ������ parent2�� child2�� �θ�Ŭ�����̱� ������ ������ �� �� ����!! ĳ������ �ϴ��� �Ұ���
		//System.out.println(c3.x);
		
		//child3 c33=new child2(); // ���� ���� �θ�Ŭ������ �������� �ٸ� Ŭ�����̱� ������ ������ �߻�
		p=c;//��ĳ������ ������ �����ϴ�.
		c2=(child2)p;//�ٿ�ĳ������ �ݵ�� �ؾ��Ѵ�.
		
		System.out.println(p.x);//�������� �Ͽ�� parent2�� ������ �״�� �����´�.
		p.method();
		System.out.println(p.x);//method�� �ڼ�Ŭ�������� �������̵��� �����߱� ������ p.x���� ������ �ʴ´�. ���� �ڼ�Ŭ������ method���� super.x�̸� 10 ���� ���Ѵ�.
		
		System.out.println(c2.x);//100�� �ƴ϶� 200�� ������ ������ �̹� �ڼ� Ŭ������ �������̵��� ���Ʊ� ������ ���� �̹� �������� 
		c2.method();
		System.out.println(c2.x);
	}

}
class parent2{
	int x=10;
	void method() {
		x=20;
		System.out.println("Parent");
	}
	
}
class child2 extends parent2{
	int x=100;
	void method() {
		x=200;//x�� ����Ű�� ���� this.x�̱� ������ child2�� x���� ���ϴ� ��
		System.out.println("Child");
		
	}
}
class child3 extends parent2{
	int x=300;
}
