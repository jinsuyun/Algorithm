package java_basic;

import java.util.LinkedList;
import java.util.Queue;

public class practice_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOC loc = new LOC();
		System.out.println(loc.x+""+loc.y);
		LOC loc2 = new LOC();
		System.out.println(loc2.x+""+loc2.y);
		loc.swap(loc.x,loc.y);
		System.out.println(loc.x+""+loc.y);
		Queue<LOC> q = new LinkedList<>();
		q.add(new LOC(1,2));
		q.add(new LOC(3,4));
		
	}

}
class LOC{
	int x,y;
	LOC(int x,int y){
		this.x=x;
		this.y=y;
	}
	LOC(){
		this.x=0;
		this.y=0;
	}
	
	void swap(int x,int y) {
		int tmp=x;
		this.x=y;
		this.y=tmp;
	}
}