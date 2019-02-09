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
			//drink[i-1] ���� �����ָ� ���� �ʾ��� ��� 
			//drink[i-2]+wine[i] ���粨�� ���ð� �������� �ȸ��ô� ���
			//wine[i]+wine[i-1]+drink[i-3] ���� ������ ���� ������ ���ǰ�� 
			drink[i]=Math.max(drink[i-1],Math.max(drink[i-2]+wine[i],drink[i-3]+wine[i-1]+wine[i]));
		}
		System.out.println(drink[n]);
		
	}

}
