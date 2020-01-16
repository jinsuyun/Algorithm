package java_basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class practice_linkedlist_arraylist {

	public static void main(String[] args) {
		// 링크드리스트 ArrayList 성능 비교
		// LinkedList는 중간 추가 및 삭제가 ArrayList보다 성능이 좋다.
		// ArrayList는 순차적으로 추가, 삭제 하는 경우 LinkedList보다 성능이 좋다.
		ArrayList al=new ArrayList<>();
		LinkedList ll=new LinkedList<>();

		System.out.println("순차적으로 추가 하기");//ArrayList가 LinkedList보다 빠르다
		System.out.println("ArrayList:"+add1(al));
		System.out.println("LinkedList:"+add1(ll));
		System.out.println();

		System.out.println("순차적으로 반환 하기");//ArrayList가 LinkedList보다 빠르다
		System.out.println("ArrayList:"+access(al));//LinkedList는 불연속적인 각 요소들이 서로 연결된 것이라 데이터 개수가 많아질수록 읽어오는 시간이 길어진다. 
		System.out.println("LinkedList:"+access(ll));
		System.out.println();
		
		System.out.println("중간에 추가 하기");//ArrayList가 LinkedList보다 느리다
		System.out.println("ArrayList:"+add2(al));
		System.out.println("LinkedList:"+add2(ll));
		System.out.println();		
		System.out.println("중간에 삭제 하기");//ArrayList가 LinkedList보다 느리다
		System.out.println("ArrayList:"+remove2(al));
		System.out.println("LinkedList:"+remove2(ll));
		System.out.println();		
		System.out.println("순차적으로 삭제 하기");//ArrayList가 LinkedList보다 빠르다
		System.out.println("ArrayList:"+remove1(al));
		System.out.println("LinkedList:"+remove1(ll));
		System.out.println();

	}
	public static long add1(List list) {
		long start=System.currentTimeMillis();
		for(int i=0;i<1000000;i++) {
			list.add(i+"");
		}
		long end=System.currentTimeMillis();
		return end-start;
	}
	
	public static long add2(List list) {
		long start=System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			list.add(500,"X");
		}
		long end=System.currentTimeMillis();
		return end-start;
	}
	public static long remove1(List list) {//역순으로 삭제
		long start=System.currentTimeMillis();
		for(int i=list.size()-1;i>=0;i--) {
			list.remove(i);
		}
		long end=System.currentTimeMillis();
		return end-start;
	}
	
	public static long remove2(List list) {
		long start=System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			list.remove(i);
		}
		long end=System.currentTimeMillis();
		return end-start;
	}
	
	public static long access(List list) {
		long start=System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			list.get(i);
		}
		long end=System.currentTimeMillis();
		return end-start;
	}
	
	

}
