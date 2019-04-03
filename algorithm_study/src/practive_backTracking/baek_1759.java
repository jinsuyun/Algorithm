package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1759 {
	static int l,c;
	static char[] password;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		// ��ȣ �����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		password = new char[c];
		visit = new int[c];
		String[] s=br.readLine().split(" ");//���⸦ ������ ���ڸ� �־���
		for(int i=0;i<c;i++) {
			password[i]=s[i].charAt(0);//�Է� ���� ���ڸ� �ϳ��� �־��� String�̹Ƿ� ���ڷ� ��ȯ���ѳ־���
		}
		Arrays.sort(password);//������������ ����
		solve(0,0,0,0);
			
	}
	public static void solve(int start,int depth,int ja,int mo) {
		if(depth==l) {//�䱸�ϴ� l�� ������ ��������(��й�ȣ �ڸ���)
			if(ja<2||mo<1) return;//�ݵ�� ������ 2���̻� ������ 1���̻��̾���� 
			for(int i=0;i<c;i++) {
				if(visit[i]==1) {//check�� ������ ���
					System.out.print((password[i]));
				}
			}
			System.out.println();
		}
		for(int i=start;i<c;i++) {//start���� �����ؼ� ��� ���� �켱 Ž������ ������ �湮�� ��� �ϳ��� ��Ʈ��ŷ �ϸ� ���ǿ� �´� ��� ����� ���� �������Ѵ�. 
			visit[i]=1;//c���� �湮�� �ϹǷν� ����Լ��� ���� ��� ����Ǽ��� ����
			if(password[i]=='a'||password[i]=='e'||password[i]=='i'||password[i]=='o'||password[i]=='u') {
				solve(i+1,depth+1,ja,mo+1);//�����̸� ����+1
			}else {
				solve(i+1,depth+1,ja+1,mo);//�����̸� ����+1
			}
			visit[i]=0;//����Լ��� �����������Ƿ� ��Ʈ��ŷ�ϹǷν� �湮������ ����
		}
		
	}

}
