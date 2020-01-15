package java_basic;

public class practice_interface2 {

	public static void main(String[] args) {
		// 인터페이스를 통한 다중상속 받기 연습
		tvcr t = new tvcr();
		t.channelDown();
		t.setCounter(4);
		t.getCounter();
		System.out.println();
		t=new tvcr(2);
		System.out.println(t.x);
		System.out.println(t.xx);
		//t.xx=30; // 인터페이스에서 선언한 변수는 final이기 때문에 고칠 수 없다.
		System.out.println(t.xx);
	}

}

class tv{
	protected boolean power;
	protected int channel;
	protected int volume;
	
	public void power() {power =!power;}
	public void channelUp() {channel++;}
	public void channelDown() {channel--;}
	public void volumeUp() {volume++;}
	public void volumeDown() {volume--;}
}

class vcr{
	protected int counter;
	public void play() {
		System.out.println("재생");
	}
	public void stop() {
		System.out.println("스톱");
	}
	public void reset() {
		System.out.println("리셋");
		counter=0;
	}
	public int getCounter() {
		System.out.println("카운터"+counter);
		return counter;
	}
	public void setCounter(int c) {
		counter=c;
		System.out.println("변경 카운터"+counter);
	}
}
interface ivcr{ 
	void play();//인터페이스의 선언부분으로 public을 생략할 수 있다.
	public void stop();
	public void reset();
	public int getCounter();
	public void setCounter(int c);
	int xx=20; //public static final이 생략된 모습으로 실제로는 public static final이 적용된다.
}

class tvcr extends tv implements ivcr{//ivcr 인터페이스를 생성함과 그 인터페이스의 구현내용에서 vcr에 대한 메소드를 호출함으로써 다중 상속이 가능하다. 
	vcr v=new vcr();
	int x=10;
	tvcr(int x){this.x=x;}
	tvcr(){}
	public void play() {//인터페이스의 구현 부분으로 public 생략 불가능하다.
		v.play();
	}
	public void stop() {
		v.stop();
	}
	public void reset() {
		v.reset();
	}
	public int getCounter() {
		return v.getCounter();
	}
	public void setCounter(int c) {
		v.setCounter(c);
	}
}
