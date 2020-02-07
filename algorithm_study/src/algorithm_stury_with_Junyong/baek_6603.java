package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_6603 {

	public static void main(String[] args) throws IOException{
		// DFS - �ζ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			if(n==0) break;
			int[] lotto=new int[n];
			int[] output=new int[n];
			boolean[] visit=new boolean[n];
			for(int i=0;i<n;i++) {
				lotto[i]=Integer.parseInt(st.nextToken());
			}
			solve(lotto,visit,0,0,n);
			System.out.println();
		}

	}
	public static void solve(int[] lotto,boolean[] visit,int start,int depth,int n) {
		if(depth==6) {//6���� ���ڰ� �������� ���� ����Ѵ�. ����, �������� Ŀ���� �ڿ� �ִ� ���ڰ� 6���� ���� �ʱ� ������ if���� ���� �ʴ´�.
			//�湮�� 6������ ����ϴ� ��. �ζǿ��� 6���� �̾ƾ��ϴ� ���̴ϱ� 6���� �̴� ��
			for(int i=0;i<lotto.length;i++) {
				if(visit[i])//�湮�Ѱ͸� ����ؾ���
					System.out.print(lotto[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<n;i++) {//start�� �����ִ� ������ �������� �־��ֱ� �����̴�(���ĵ� ���·� �̾ƾ��ϱ� ����)
			if(!visit[i]) {
				visit[i]=true;//�湮üũ
				solve(lotto,visit,i+1,depth+1,n);//start�� i+1�� 1�� �����ְ�(�������� �ٲ���), depth�� 1ĭ �ø���
				visit[i]=false;
			}
		}
	}

}
