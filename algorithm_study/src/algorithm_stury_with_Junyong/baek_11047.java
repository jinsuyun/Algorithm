package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_11047 {

	public static void main(String[] args) throws IOException {
		// ���� 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {//�׸��� �˰������ν� �ּ� ���� ������ ã�ƾ� �ϹǷ� �Ųٷ� for���� �����ش�.
			if(sum==k)break;//�ݾ��� ������ break;
			sum+=coin[i];//ó�� ������ �־��ش�.
			cnt++;
			if (k < sum) {//������ ���� ���� �� ũ�ٸ� ������ ������ ���� ���� ������ �� ���ݿ��� ���ش�.
				sum-=coin[i];
				cnt--;
			} else {//�׷��� �ʴٸ� �� ������ �ݾװ� ���� ���� ������ �Ѿ������ �����ش�. 
				while (k >= sum) {
					sum += coin[i];
					cnt++;
				}
				sum -=coin[i];//while���� �ѹ� �� ���⶧���� �ѹ� ���ش�.
				cnt--;
			}

		}
		System.out.println(cnt);
	}

}
