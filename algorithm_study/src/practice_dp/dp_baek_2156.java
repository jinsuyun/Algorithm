 package practice_dp;

import java.util.Scanner;

public class dp_baek_2156 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int[] wine = new int [n+1];
		int[][] d = new int [3][n+1];
		
		for(int i=1;i<=n;i++) {
			wine[i]=sc.nextInt();
		}
		
		for(int i=1;i<=n;i++) {
			d[0][i]=Math.max(d[0][i-1],Math.max(d[1][i-1],d[2][i-1]));//i��°�� 0�������� i-1��°�� �ȸ��Ű�� 1�����Ӹ��Ű�� 2������ ���Ű�� ���� ����
			d[1][i]=d[0][i-1]+wine[i];//i��°�� 1�������� i-1�� 0���̾���� i������ 1���� �����Ǿ��⶧��
			d[2][i]=d[1][i-1]+wine[i];//i��°�� 2�������� i-1�� 1���������� �;��� 
		}
		System.out.println(Math.max(d[0][n],Math.max(d[1][n],d[2][n])));
		
		dp(wine,n);
	}
	
	public static void dp(int[] wine,int n) {
		int [] drink = new int[n+1];
		drink[0]=0;
		drink[1]=wine[1];
		drink[2]=wine[1]+wine[2];
		for(int i=3;i<=n;i++) {
			drink[i]=Math.max(drink[i-1],Math.max(drink[i-2]+wine[i],drink[i-3]+wine[i-1]+wine[i]));
			//0�� ���� ���� ��� d[n-1] 1�� ���� ���Ű�� n-1�� 0�̰� n-2��°�� ���ŵ��ǰ� �ȸ��ŵ� �ǹǷ� d[n-2]+wine[n]
			//2�� ���� ���� ��� i��°�� i-1��°�� ���ð� i-2��°�� ���ø� �ȵǹǷ� drink[i-3]+wine[i-1]+wine[i]
		}
		System.out.println(drink[n]);
		
	}

}
