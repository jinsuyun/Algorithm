package java_basic;

public class practice_abstract2 {

	public static void main(String[] args) {
		// �߻�ȭ ���� �� ����
		Unit[] u=new Unit[4];
		u[0]=new Marine();//���������� ������ ������	unit�� �θ�Ŭ�����̱� ������ �����ϴ�.
		u[1]=new Tank();
		u[2]=new Dropship();
		u[3]=new Marine();
		for(int i=0;i<u.length;i++) {
			System.out.println(u[i].getName()+"\t\t��ǥ"+u[i].move(10, 20));
		}
	}

}

abstract class Unit{
	int x,y;
	abstract String move(int x,int y);
	abstract String getName();
	void stop() {return;};
	
}

class Marine extends Unit{
	int x;
	int y;
	String move(int x,int y) {
		this.x=x;
		this.y=y;
		return x+" "+y;
	}
	String getName() { return "Marine";}
	void stimpack() {
		
	}
}

class Tank extends Unit{
	int x;
	int y;
	String move(int x,int y) {
		this.x=x;
		this.y=y;
		return x+" "+y;
	}
	String getName() { return "Tank";}
	void changeMode() {
		
	}
}

class Dropship extends Unit{
	int x;
	int y;
	String move(int x,int y) {
		this.x=x;
		this.y=y;
		return x+" "+y;
	}
	String getName() { return "Dropship";}
	void unload() {
		
	}
}