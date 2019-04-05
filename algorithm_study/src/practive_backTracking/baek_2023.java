package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_2023 {
	static int n, m;
	static List<Integer> result = new LinkedList();

	public static void main(String[] args) throws IOException {
		// �ű��� �Ҽ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = (int) Math.pow(10, n);
		//solve(0);
		/*for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
		*/
		solve("",0);
		
	}

	public static void solve(int depth) {//�̿� ���� ����� ���� �������� �ð��ʰ��� ���´�. ��� ���� �˻��߱� ������ 8�ڸ� ���ڸ� �ޱ⿣ ȿ�������� ���� ����̴�.
		if (n < depth) {
			return;
		}
		for (int i = m / 10; i < m; i++) {
			String value = Integer.toString(i);
			String prime = "";
			boolean all_check = false;
			if (check(i)) {
				for (int j = 0; j < n; j++) {
					prime += value.charAt(j);
					int check_prime = Integer.parseInt(prime);
					if (check(check_prime)) {
						all_check = true;

					} else
						all_check = false;

					if (!all_check)
						break;

				}
				if (!result.contains(i)&&all_check) {
					result.add(i);
				}
			}else continue;
		}
	}

	public static void solve(String s,int depth) {//������ �ڸ�����ŭ dfs�� ���� �ű��� �Ҽ��� ���Ѵ�.
		if(depth==n) {//�ڸ����� ���� �ȴٸ� ���
			System.out.println(s); 
			return;
		}
		for(int i=1;i<=9;i++) {//1����9���� �Ҽ��� �ľ��Ѵ�. ���ʺ��� 1�ڸ�,2�ڸ�,...n�ڸ����� �Ҽ��̾���ϱ� ������ s+i�� �Ҽ��̾�� �Ѵ�. 
			//���� ��� 2333�̸� 2�� �Ҽ� 23�� �Ҽ� 233�� �Ҽ� 2333�� �Ҽ��̾���Ѵ�.233���� 2�� ������ 2332�� �Ҽ��� �ƴϹǷ� if���� ����� �� ����.
			//���� ù��° �ڸ��� �Ҽ��̾�� �ϱ⶧���� 11,13,17 �� ���� �ڸ��� 1�̱� ������ �ű��� �Ҽ��� �� �� ����. ���ڸ��� 2,3,5,7�̾����
			if(check(Integer.parseInt(s+i))) {//check �޼ҵ带 ���� �Ҽ����� �ľ��Ѵ�. s+i�� ���� ���� ���ο� ���� �������ν� �Ҽ����� �ľ��Ѵ�.
				solve(s+i,depth+1);//�� �ڸ��� ���ڸ� ���ϰ� �ڸ����� �÷��ָ� �Ҽ��� �ľ��Ѵ�.
			}
		}
		
	}


	
	public static boolean check(int prime) {//�Ҽ��� �ľ��ϱ� ���� �޼ҵ�
		int count = 0;
		if(prime<2) return false;
		
		for (int j = 2; j < prime; j++) {
			if (prime % j == 0) {
				count++;
				break;
			}
		}
		if (count == 0) {
			return true;
		}

		return false;
	}

}
