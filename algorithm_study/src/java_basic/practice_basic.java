package java_basic;

import java.util.Arrays;

public class practice_basic {

	public static void main(String[] args) {
		// ����Ʈ ������
		//X<<n�� X * 2^n�� ����� ����.
		//X>>n�� X / 2^n�� ����� ����.
		//>>>�� <<<�� ��ȣ�� ������� �׻� 0���� ���ڸ��� ä���.
		
		System.out.println(-8>>1);
		System.out.println(-8>>>1);
		System.out.println(-8>>>1);
		System.out.println(1000>>35);
		System.out.println(1000>>33);
		System.out.println(1000>>32);
		System.out.println(1000>>31);
		System.out.println();
		//���� ������
		int x=10;
		x=(x>5)? 4:3;
		System.out.println(x);
		//�迭�� ����
		int[][] arr= {{1,2,3},{4,5,6}};
		int[][] xx=Arrays.copyOf(arr,arr.length);//arr�� �����ϴµ�, ���̰� 0���� arr�� length��ŭ �����Ѵ�
		System.out.println(Arrays.toString(xx[0]));
		System.out.println(Arrays.toString(xx[1]));
		System.out.println();
		
		//�̸� ���� �ݺ���
		Loop1: for(int i=0;i<5;i++) {//Loop1�̶�� �̸��� �ƹ����� �ָ�ȴ�.
			for(int j=5;j<10;j++) {
				if(j==7) break Loop1;
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		Loop1: for(int i=0;i<5;i++) {
			for(int j=5;j<10;j++) {
				if(j==7) break;
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}

}
