package practice_dp;

import java.util.Scanner;

public class dp_baek_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[] d=new long[n+1];//�Ǻ���ġ ������ �ǹǷ� int������ �ʰ���
		d[0]=0;
		d[1]=1;
		for(int i=2;i<=n;i++) {
				d[i]=d[i-1]+d[i-2];
		}
		System.out.println(d[n]);
	}

}
