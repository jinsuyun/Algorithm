package practice;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class prime_baek_2581 {

	public static void main(String[] args) throws IOException {
		// �Ҽ�
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		List<Integer> list = new LinkedList<>();
		boolean check = false;
		for (int i = n; i <= m; i++) {//n���� m���� �� �Ҽ����ϱ�
			if(i==1) continue;//1�� �Ҽ��� �ƴϹǷ� ���� 
			boolean isPrime = false;//�Ҽ��ΰ� ǥ��
			for (int j = 2; j < i; j++) {//�Ҽ��� �ڽŰ� 2�� ����������
				if (i % j == 0) {//i��� ���ڰ� 2����j���� �������� �������� ���� ���� �������ٸ� �Ҽ��� �ƴ�
					isPrime = true;//�Ҽ��� �ƴѰ� 
					break;//�Ҽ��� �ƴ϶�� �� for���� ���� �ʿ䰡 �����Ƿ� break
				}
			}
			if (!isPrime) {//1�� �ڱ� �ڽ����θ� �������� ���̶�� �Ҽ��� ù��° ���� ����ϱ� ���� ����Ʈ�� �ְ� sum�� ���� �����ش�
				list.add(i);
				sum += i;
				check=true;//�Ҽ��� �ϳ��� ���Դٸ� check�� true�� ���ش�.
			} 
		}
		
		if (check) {//�Ҽ��� �ϳ��� �ִٸ� ��� �Ҽ��� ���� ���� �Ҽ��� ù��° ���� ��� list.size()!=0�̶�� �ᵵ �����ϴ�.
			System.out.println(sum);
			System.out.println(list.get(0));
		} else {//�Ҽ��� �ϳ��� ���ٸ� -1�� ����Ѵ�.
			System.out.println(-1);
		}
	}

}
