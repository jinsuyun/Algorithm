package java_basic;

public class practice_interface2 {

	public static void main(String[] args) {
		// �������̽��� ���� ���߻�� �ޱ� ����
		tvcr t = new tvcr();
		t.channelDown();
		t.setCounter(4);
		t.getCounter();
		System.out.println();
		t=new tvcr(2);
		System.out.println(t.x);
		System.out.println(t.xx);
		//t.xx=30; // �������̽����� ������ ������ final�̱� ������ ��ĥ �� ����.
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
		System.out.println("���");
	}
	public void stop() {
		System.out.println("����");
	}
	public void reset() {
		System.out.println("����");
		counter=0;
	}
	public int getCounter() {
		System.out.println("ī����"+counter);
		return counter;
	}
	public void setCounter(int c) {
		counter=c;
		System.out.println("���� ī����"+counter);
	}
}
interface ivcr{ 
	void play();//�������̽��� ����κ����� public�� ������ �� �ִ�.
	public void stop();
	public void reset();
	public int getCounter();
	public void setCounter(int c);
	int xx=20; //public static final�� ������ ������� �����δ� public static final�� ����ȴ�.
}

class tvcr extends tv implements ivcr{//ivcr �������̽��� �����԰� �� �������̽��� �������뿡�� vcr�� ���� �޼ҵ带 ȣ�������ν� ���� ����� �����ϴ�. 
	vcr v=new vcr();
	int x=10;
	tvcr(int x){this.x=x;}
	tvcr(){}
	public void play() {//�������̽��� ���� �κ����� public ���� �Ұ����ϴ�.
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
