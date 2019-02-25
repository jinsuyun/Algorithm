package practice_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_6603 {
	static int k;
	static int[] lotto;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// �ζ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			lotto = new int[k];
			result = new int[k];
			
			for (int i = 0; i < k; i++) {
				lotto[i] = Integer.parseInt(st.nextToken());//������������ �Է�
			}
			solve(0,0);
			System.out.println();
		}
	}
	
	public static void solve(int start,int depth) {
		if(depth==6) {//���� 6���� �ȴٸ� ��� 
			for(int i=0;i<k;i++) {
				if(result[i]==1) {//�湮 �ߴ� ������(���ڷ� ���� ��)���
					System.out.print(lotto[i]+" ");
				}
			}
			System.out.println();
		} 
		for(int i=start;i<k;i++) {
			result[i]=1;//�湮�� �ߴٴ� ǥ��(���ڸ� �̾Ҵٴ� ǥ��)
			solve(i+1,depth+1);//���� 6���� ���������� ��� ����Լ��� ���鼭 �÷��ش�.
			result[i]=0;//��Ͱ� ���� �� ��Ʈ��ŷ �����ν� ������ �湮�ߴ� ���� 0���� �ʱ�ȭ���ش�.
		}
	}

}
