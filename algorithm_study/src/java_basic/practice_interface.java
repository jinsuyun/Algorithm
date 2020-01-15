package java_basic;

public class practice_interface {

	public static void main(String[] args) {
		// �������̽�
		// ��� ��� ������ public static final �̾�� �ϸ�, �̸� ���� �� �� �ִ�.
		// ��� �޼���� public abstract �̾�� �ϸ�, �̸� ������ �� �ִ�. ��, static�޼���� ����Ʈ �޼���� ����
		
		// �������̽� ����
		// ���� �ð� ����, ǥ��ȭ ����, ���� ���� ���� Ŭ�������� ���踦 �ξ���, �������� ���α׷����� ����
		
		
		Fighter f = new Fighter();
		if(f instanceof Unit2)
			System.out.println("f�� Unit2 Ŭ������ �ڼ��Դϴ�.");
		if(f instanceof Fightable)
			System.out.println("f�� Fightable �������̽��� �����߽��ϴ�.");
		if(f instanceof Movable)
			System.out.println("f�� Movable �������̽��� �����߽��ϴ�.");
		if(f instanceof Attackable)
			System.out.println("f�� Attackable �������̽��� �����ߴϴ�.");
		if(f instanceof Object)
			System.out.println("f�� Object Ŭ������ �ڼ��Դϴ�.");
		
		System.out.println(f.move(2, 3));
		
		Fightable ff=new Fighter();//������ ����!!
		//�������̽� Fightable�� Fighter�� �������� �� Fighter �ν��Ͻ��� Fightable Ÿ���� ���������� �����ϴ� ���� �����ϴ�. 
		parsable p=printManager.method("���� Ÿ�� �Ľ�");
		p.parse("�Ľ�");
		p=printManager.method("���� Ÿ�� �Ľ�2");
		p.parse("�Ľ�2");
	}

}
class Fighter extends Unit2 implements Fightable{//�������̽��� ����̶�� �� ��� ����(implements)�̶�� �� ����Ѵ�.
	public String move(int x,int y) {return x+" "+y;}//�ݵ�� public�� ���� �����ڸ� �����ؾ��Ѵ�. 
	//�� ������ Movable�� �ִ� move�� public abstract�� ������ ���̹Ƿ� ���� �޼��庸�� ���� ������ ���� �����ڸ� �����ؾ� �ϱ� ����
	public void attack(Unit2 u) {}
	public void attack2(Fightable f) {};//�������̽��� �Ű������ε� ����� �����ϴ�.
	
}

class printManager{//���� Ÿ���� �������̽��� �Ľ��ϱ� ���� Ŭ����
	public static parsable method(String name) {
		if(name.equals("���� Ÿ�� �Ľ�"))
			return new print();//�������̽��� ����Ÿ������ �ִ°͵� �����ϴ�. ����Ÿ���� �������̽���� ���� �޼��尡 �ش� �������̽��� ������ Ŭ������ �ν��Ͻ��� ��ȯ�Ѵٴ� ���� �ǹ��Ѵ�.
		//Fighter Ŭ������ �ν��Ͻ��� ��ȯ�� �� ����
		else return new print2();
	}
	
}
class print implements parsable{//print�� print2�� ���� ��Ӱ� ���� ������� 2���� Ŭ������ �������̽��� ���� parasable�� �Ű��踦 ���� �� �ִ�. 
	public void parse(String name) {//������ ������
		System.out.println(name+"�� �������̽� ���� Ÿ������ ��ȯ�Ǿ����ϴ�");
	}
}

class print2 implements parsable{
	public void parse(String name) {//������ ������
		System.out.println(name+"�� print2 Ŭ������ ���� �������̽� ���� Ÿ������ ��ȯ�Ǿ����ϴ�.");
	}
}

class Unit2{
	int x,y,hp;
}

interface Movable{
	String move(int x,int y);//void �տ� public abstract�� ���� �Ȱ�
}

interface Attackable{
	void attack(Unit2 u);
	void attack2(Fightable f);
}

interface Fightable extends Movable,Attackable{
	
}
interface parsable {
	void parse(String name);//�������̽� Ÿ���� ���� �Ľ��� ���� ����
}

