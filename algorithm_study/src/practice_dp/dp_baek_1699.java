package practice_dp;

import java.util.Scanner;

public class dp_baek_1699 {

	public static void main(String[] args) {
		// �������� ��
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			d[i]=i;
			for(int j=1;j*j<=i;j++) {
				if(d[i]>d[i-j*j]+1)//�ּ� ���� ����
					d[i]=d[i-j*j]+1;//1*1+2*2+...+j*j+i*i�̹Ƿ� �������� i*i �� ���� j*j   �� N= j*j+1(i*i�� 1�κ�)
					
			}
		}
		System.out.println(d[n]);

	}

}
