package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1339 {
	static boolean[] visit = new boolean[10];
	static int size,n,max=0;
	static String[] s;
	static int[] values;
	static List<Integer> list = new LinkedList();
	public static void main(String[] args) throws IOException {
		// �ܾ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		n=Integer.parseInt(st.nextToken());
		
		s = new String[n];//���ڸ� �迭�� ������ŭ �޾ƿ�
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			s[i]=st.nextToken();//���ڿ��� �޾ƿ�
			for(int j=0;j<s[i].length();j++) {//���ڿ��� ũ�⸸ŭ for������ �����鼭 list�� ���ڸ� �ִ´�
				if(!list.contains(s[i].charAt(j)-'A')){//���� ���ڰ� list�� ��������� �߰����� �ʴ´� -'A'�� ���ڸ� ũ�⸦ ���ϱ� ���� Integer�� �ٲٱ� ����
					list.add(s[i].charAt(j)-'A');
				}
			}
		}
		size=list.size();//������ ������ ����Ǿ����� ���� ��� ABC�� 3�� ABB�� 2�� 
		values=new int[size];//���� ������ŭ ���� ���� �� �ִ� values ����
		solve(0,0);//��Ʈ��ŷ�� ����
		System.out.println(max);
	}
	
	public static void solve(int idx,int depth) {
		if(size==depth) {//������ ������ŭ ��� depth�� Ž���ߴٸ�
			int sum=0;//���� ���ϱ� ���� sum(value�� ��� ���Ѱ�)
			for(int i=0;i<n;i++) {//
				int value=0;//���ڸ� �ޱ����� value
				for(int j=0;j<s[i].length();j++) {//������ ������ŭ �����ش� ��� ���ڸ� �޾ƿ��� 1,10,100�� �ڸ��� ����ϱ� ����
					value*=10;//10���ڸ��� �ڸ����� �÷����� ��� ���� ���Ѵ�. ó�� 1���ڸ��� value�� 0�� �ʱ�ȭ ���̱� ���� *10�� ������ �ȵ� �ڷ� 10���ڸ�, 100���ڸ�... �� �����
					value+=values[list.indexOf(s[i].charAt(j)-'A')];
					//list.indexOf�� �����ִ� ���� values���� ���° ����ִ��ĸ� �ľ��ϱ� ���� s[i].charAt(j)��� ���ڿ� -'A'�� �ϸ� ���ڸ� Integer�� ��Ÿ�� ���� ���°�� ����ִ��� �ľ�
					//������� values�� [9,8,7]�� ������� ��� ABC�̶� ���ڿ��� s[i].charAt(2)-'A'�� ���� C��� ���ڰ� Integer�� 2�̴�. ��, value[2]�� �� 7�� �ҷ����ԵǴ� ��
					//indexOf�� ���ְ� s[i].charAt(j)-'A'�� ���� ��Ÿ�ӿ���������. �־��� list�ȿ��� ���°� �ƴ� ��� ���� ���� �����ε�
				}
				sum+=value;//�־��� ���� sum�� �� �����ش�. 
			}
			max=Math.max(max, sum);//���� ū ���� �����ش�.
			return;
			
		}
		for(int i=9;i>=0;i--) {//�ִ��� ���ڸ� ���ϴ� ���̰� 0~9������ ���ڷ� ǥ���ϱ� ������ ���� ū���� 9���� �ִ´�.
			//3���� ���ڰ� list�� ����ִٰ� ������ ���, values�� [9,8,7]�� ó�� ���� �״��� [9,8,6],[9,8,5]...���� ��� �� 
			if(!visit[i]) {//0~9���� �ִ� �迭���� �湮���� �ʾҴٸ�, �� ���� ���� �������� �ʾҴٸ� 
				visit[i]=true;//�湮�Ѵ�. �ߺ��� �����ϱ� ���� 9�� ���Դµ� �ٽ� 9�� ������ �ȵǱ� ����
				values[idx]=i;//values�� ���� ���� �ڸ�  
				solve(idx+1,depth+1);//���� ������ �ϳ� �ְ� �ٽ� dfs�� ���� values�� ������Ű�� idx�� list�� �ִ� ��� ���ڸ� �˻��ϱ� ���� depth�� �ϳ��� ������Ų��. 
				visit[i]=false;//�湮 �迭�� ��������
				values[idx]=0;//�������Ա� ������ �ʱ�ȭ������
			}
		}
		
	}

}
