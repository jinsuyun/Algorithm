package practice_dp;

import java.util.Scanner;

public class dp_baek_1699 {

	public static void main(String[] args) {
		// 제곱수의 합
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			d[i]=i;
			for(int j=1;j*j<=i;j++) {
				if(d[i]>d[i-j*j]+1)//최소 값을 구함
					d[i]=d[i-j*j]+1;//1*1+2*2+...+j*j+i*i이므로 마지막은 i*i 그 전은 j*j   총 N= j*j+1(i*i를 1로봄)
					
			}
		}
		System.out.println(d[n]);

	}

}
