package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2661 {
	static int n;
	static boolean finish;
	public static void main(String[] args) throws IOException {
		// ���� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		
		solve(1,"1");//���� �ּ� �����̱� ������ ù�ڸ����� 1�� �־��� 1���� ũ�� �ּ��� ���ڰ� �ƴϱ� ����
	}
	
	public static void solve(int depth,String result) {
		if(finish) return;//�ּ��� ���� 1���� ��Ÿ���� ���� finish
		if(depth==n) {//depth�� ���� ���̿� �������ٸ� ����ϰ� ��ħ
			System.out.println(result);
			finish=true;//1���� ����ϱ� ���� boolean
			return;
		}
		for(int i=1;i<=3;i++) {//1, 2, 3�� ���ڸ� ����ϱ� ������ 3���� for��
			if(isOK(result+i))//������ ������ ���ϱ� ���� �Լ� result�� i�� �����ְ� �� ������ ���� �������� �����ش�.
				solve(depth+1,result+i);//���� �����̶�� ���� ����� ���� depth�� �÷��ְ� ���� ���� result�� i���� �����ش�.
		}
	}
	
	public static boolean isOK(String result) {
		int length=result.length();//���� ����
		int start=length-1;//���ڱ��� -1
		int end=length;//���� ��
		for(int i=1;i<=length/2;i++) {//�� ������ ������ ������ ũ�⸦ �����ش� ������� n=7�̸� length=3�̹Ƿ� ���ڸ� ������ �����ִ� ��
			String first = result.substring(start-i,end-i);//substring�� ���ڿ��� ���Ⱚ�� �����´�. start�� end�� [start,end)�� start<=���� ��<end�̴�
			String second = result.substring(start,end);//������ �����ָ鼭 i���� Ŀ���鼭 ����Ű�� ��ġ�� �ٸ� first�� second���� ���� �����ش�
			if(first.equals(second)) return false;//���� ������ �������� 
			start--;//���� �ٸ� ��� start�� �ٿ��ָ� ���ؾ� �� ���� �ڸ����� �÷��ش�.
		}
		return true;
		
	}

}
