
package java_basic;

public class practice_inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent p = new parent();
		p.age=30;
		System.out.println(p.age);
		child c=new child();
		System.out.println(c.age);
		c.age=20;
		grandchild g=new grandchild();
		System.out.println(g.age);
		System.out.println(c.sex+" "+p.sex);
		
		circle cir = new circle();
		cir.p.x=1;
		System.out.println(cir.p.x);
		
		System.out.println(c.sex);
		System.out.println(c.sex2);
		System.out.println(c.sex3);
		System.out.println(c.sex4);	
		
		point3d p3= new point3d(1,2,3);
	}

}

class parent{
	static int age=10;
	int sex=3;
}
class child extends parent{
	int sex=10;
	int sex2=sex;
	int sex3=super.sex;
	int sex4=this.sex;
	protected int sex5;
}
class grandchild extends child{
	
}
class point{
	int x,y;
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
	point(){
		
	}
	String getLocation() {
		return "x:"+x+",y:"+y;
	}
}
class point3d extends point{
	int z;
	point3d(int x,int y,int z){
		
		this.x=x;
		this.y=y;
		this.z=z;
	}
	String getLocation() {
		return "x:"+x+",y:"+y+"z:"+z;
	}
}
class circle{
	point p = new point();
	int r;
}


