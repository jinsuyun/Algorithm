package practice_dp;

import java.util.Scanner;

public class dp_baek_2133 {

	public static void main(String[] args) {
		// Ÿ��ä���
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[31];
		d[0]=1;
		d[1]=0;
		d[2]=3;
		for(int i=4;i<=n;i+=2) {
			d[i]=d[i-2]*3;//������ ����Ǽ��� 3���� (2x1 Ÿ��1���� 1x2Ÿ�� 1��,1x2Ÿ�� 1���� 2x1 Ÿ���� 1��, 1x2 Ÿ�� 3��) Ÿ���� 2ĭ�� �����ϹǷ� i-2
			for(int j=4;i-j>=0;j=j+2) {//4�϶� 6�϶� 8�϶� 10�϶�... ���� Ÿ���� �߰���(Ȧ���� X)
				d[i]+=2*d[i-j];//i-4 i-6 i-8 ...�� �߰��� *2�� Ÿ���� ��ġ�� ���϶� �Ʒ��϶� 2�������
			}
		}
		System.out.println(d[n]);

	}

}
