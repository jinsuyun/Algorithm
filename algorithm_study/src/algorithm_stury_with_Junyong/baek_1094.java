package algorithm_stury_with_Junyong;

import java.util.Scanner;

public class baek_1094 {
	static int[] arr,visit;
	static int cnt;
	public static void main(String[] args) {
		// ����� - �ùķ��̼� ����
		//����⸦ �̸� �߶� ���� �ڸ� ����⸦ ��Ʈ��ŷ�� ���� ���������� ������� ������ ����
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int stick= 64;
		int sum=0;
		cnt=0;
		arr=new int[7];
		visit=new int[7];
		arr[0]=64;
		for(int i=1;i<arr.length;i++) {//�̸� ����⸦ �߶���´�.
			stick/=2;
			arr[i]=stick;
		}
		solve(0,x,0);//DFS ����
		System.out.println(cnt);

	}
	public static void solve(int start,int x,int sum) {//��Ʈ��ŷ ������� ���� ����
		if(sum==x) {//���ϴ� ����� ���̿� ������ ����� ���� count
			for(int i=0;i<arr.length;i++) {
				if(visit[i]==1)
					cnt++;
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {//start���� �����ϴ� ������ �̹� ������� �������ֱ� ������ ���������� �����Ѵٴ� �ǹ�
			if(visit[i]==0) {
				visit[i]=1;
				sum+=arr[i];//����� ������
				solve(i+1,x,sum);//i+1�̹Ƿ� start�� ��ĭ�� �þ�� �� ���� for���� ���ö� i+1���� �����ϱ� ����
				visit[i]=0;
				sum-=arr[i];//���� ���� �ٽ� ���������� ��, ���ߴ� ����� ����
			}
		}
	}

}
