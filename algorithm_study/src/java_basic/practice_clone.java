package java_basic;

import java.util.Arrays;

public class practice_clone {

	public static void main(String[] args) {
		// object class clone
		// clone()�� �ڽ��� �����Ͽ� ���ο� �ν��Ͻ��� �����ϴ� ���� �Ѵ�.
		// ���� ���� �����ϰ� ���� �ν��Ͻ��� �����Ͽ� �۾��Ͽ� ������ ���� �����Ѵ�. 
		// ������Ʈ Ŭ������ ���ǵ� clone()�� �ܼ� �ν��Ͻ� ������ ���� �����ϱ� ������ ���� ���� Ÿ���� �ν��Ͻ� ������ ���ǵǾ� �ִ� Ŭ������ ������ �ν��Ͻ� ������ �̷������ �ʴ´�.
		// �迭�� ���, �ν��Ͻ��� ���� �迭�� �ּҸ� ���� ������ ���� �ν��Ͻ��� ������ ��ģ��. ���� �������̵��� �ʿ��ϴ�.
		//clone()�� ����Ϸ��� ���� ������ Ŭ������ Cloneable�������̽��� �����ؾ��ϰ� clone()�� �������̵� �ϸ鼭 ���������ڸ� protected���� public�� �����Ѵ�. 
		//�׷����� ��Ӱ��谡 ���� �ٸ� Ŭ�������� ȣ�� �����ϴ�.
		p original = new p(3,5);
		p copy = (p)original.clone();//������ ����
		p copy2 =original.clone();//clone() �������̵��� Object�� �ƴ� p�� �߱� ������ ĳ������ ���ص��ȴ�.
		System.out.println(original);
		System.out.println(copy);//Cloneable�� �������� �ʴ´ٸ� ���簡 �̷������ �ʴ´�. �� ������ �ν��Ͻ� �����͸� ��ȣ�ϱ� ����
		
		//�迭�� ���� �迭�� ��ü�̱� ������ clone()�� �����ϴ�.
		//ArrayList, Vector,LinkedList,Hashset,TreeSet,HashMap,TreeMap,Calendar,Date�� ���� Ŭ������ clone()���� ������ �����ϴ�.
		int[] arr= {1,2,3,4,5};
		int[] arrCopy=arr.clone();
		int[] arrCopy2 = new int[arr.length];
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arrCopy));
		System.arraycopy(arr,0, arrCopy2,0, arr.length);//System.arraycopy�� ����Ͽ� copy�� �����ϴ�.
		System.out.println(Arrays.toString(arrCopy2));
		
		//���� ���� - ������ �����ϸ� ���纻�� ������ �޴´�.
		//���� ���� - ������ �����ϰ� �ִ� ��ü���� �����Ѵ�. ������ ���纻�� ���� �ٸ� ��ü�� �����ϱ� ������ ������ ������ ���纻�� ������ ��ġ�� �ʴ´�.
		circle2 c1=new circle2(new p(1,1),2.4);
		circle2 c2=c1.clone();//������ ������ �ƴ� Ŭ���� ���ο��� ȣ���� �κ��� ������ �͵� �Ȱ��� ȣ���ϴ� �� --> ���� ����
		circle2 c3=c1.deepCopy();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		c1.p.x=9;
		c1.p.y=8;
		System.out.println("���� ��");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);//��ī�Ǵ� ������ ��ü�� �����ϱ� ������ �ٲ��� �ʴ´�.
		
	}

}
class p{//Cloneable �������̽��� ������ Ŭ���������� clone()�� ȣ�� �� �� �ִ�. �׷��� ������ ���ܰ� �߻��Ѵ�.
	int x,y;
	p(int x,int y){
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return x+" "+y;
	}
	public p clone() {//Object�� p�� �ٲް� return�� �� ��ȯ�� �ڼ�Ŭ���� p�� �°� �������ν� Ŭ���� ȣ��� ���ŷο� ����ȯ�� ���� �� �ִ�.
		Object obj=null;
		try {
			obj=super.clone();
		}catch(CloneNotSupportedException e){
			
		}
		return (p)obj;
	}
}
class circle2 implements Cloneable{
	p p;
	double r;
	circle2(p p,double r){
		this.p=p;
		this.r=r;
	}
	public circle2 clone() {//���� ����
		Object o=null;
		try {
			o=super.clone();
		}catch(CloneNotSupportedException e) {
			
		}
		return (circle2)o;
	}
	public circle2 deepCopy() {
		Object o =null;
		try {
			o=super.clone();
		}catch(CloneNotSupportedException e) {}
		circle2 c = (circle2) o;//������ ��ü o�� ���ο� �ν��Ͻ� c�� �����ϵ��������ν� ������ �����ϰ� �ִ� ��ü���� �����Ѱ�.
		c.p=new p(this.p.x,this.p.y);//������ ���� ����
		return c;
	}
	public String toString() {
		return p+" "+r;
	}
}
