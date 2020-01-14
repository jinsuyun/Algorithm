package java_basic;

public class practice_abstract2 {

	public static void main(String[] args) {
		// 추상화 개념 및 이해
		Unit[] u=new Unit[4];
		u[0]=new Marine();//다형성으로 구현한 것으로	unit이 부모클래스이기 때문에 가능하다.
		u[1]=new Tank();
		u[2]=new Dropship();
		u[3]=new Marine();
		for(int i=0;i<u.length;i++) {
			System.out.println(u[i].getName()+"\t\t좌표"+u[i].move(10, 20));
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