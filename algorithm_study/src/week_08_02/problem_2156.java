package week_08_02;

import java.io.IOException;
import java.util.Scanner;

public class problem_2156 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int [10001];
		int[] drink = new int[10001];
		for(int i=1;i<=n;i++) {
			wine[i]=sc.nextInt();
		}
		drink[1]=wine[1];
		drink[2]=wine[1]+wine[2];
		
		for(int i=3;i<=n;i++) {
			//drink[i-1] 현재 포도주를 먹지 않았을 경우 
			//drink[i-2]+wine[i] 현재꺼를 마시고 이전꺼를 안마시는 경우
			//wine[i]+wine[i-1]+drink[i-3] 현재 포도주 이전 포도주 마실경우 
			drink[i]=Math.max(drink[i-1],Math.max(drink[i-2]+wine[i],drink[i-3]+wine[i-1]+wine[i]));
		}
		System.out.println(drink[n]);
		
	}

}
