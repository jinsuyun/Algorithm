package practice_SW_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5658 {
	static int n, k;
	static char[] map;
	static String[] edge;
	static int c = 0;
	static char[] a = new char[4];
	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// �������� ��й�ȣ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());//test ����
		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map=new char[n];// ���ڸ� �ϳ��� �迭�� �޾ƿ��� ����.
			String s = br.readLine();
			for(int i=0;i<s.length();i++) {
				map[i]=s.charAt(i);//n���� ��й�ȣ�� char �迭�� �ϳ��� �ִ´�.
			}
			
			boolean finish = true;//��� ȸ���� �ľ��ϱ� ���� 
			int x=n/4;//edge�� 4���� �����Ƿ� 4�� ���������ν� �� edge�� ��� ���ڰ� ���� �ľ��ϱ� ����
			list = new LinkedList<>();//���� ������ ���� list �ʱ�ȭ
			while(finish) {
				edge=new String[4];//edge�� ũ���4���̰� �ϳ��� edge�� map�� �ִ� ���ڸ� �޾ƿ�
				finish=false;//�ʱ�ȭ
				int count=0;//map�� �Էµ��ִ� ���� �޾ƿ��� ���� count
				for(int i=0;i<4;i++) {//4���� edge�ϱ� 4���� ����ȴ�.
					edge[i]="";//null�̶�� ���� �����ϰ� ��ĭ�� �ִ´�
					for(int j=0;j<x;j++) {//x�� ��� ���ڰ� �ϳ��� edge�� ���� ���ϴ� ���̹Ƿ� �� edge�� x��ŭ�� ���ڰ� �� 
						edge[i]+=map[count];//char�� �ϳ��� �����ָ鼭 String���� �� edge�� �� ���� �ǹ�
						count++;//ó������ j�� �־����� �̴� map�� ���� ��ġ�� �����ϴ� ���� �����Ͽ� count�� �÷��ָ� ��� n���� ���ڸ� ǥ���ϱ� ����
					}
				}
				
				for(int i=0;i<edge.length;i++) {//edge�� ���ִ� �����̹Ƿ� edge�� ������ŭ�� �����ش�. 4��
					int result=Integer.parseInt(edge[i],16);//String���� ������ 16������ �ٲ���
					if(!list.contains(result)) {//list�� ���ԵǾ����� �ʾҴٸ� list�� �߰��Ѵ�.
						list.add(result);
						finish=true;//list�� �߰��� �԰� finish�� true�� �ϸ� while���� ������ �ʾҴٴ� ���� ǥ�� 
						//if���� ���� �ʾҴٸ� edge�� �ִ� ��� ���� �̹� list�� ����ִ� ���̹Ƿ� �� �̻� rotate�� ���� �ʾƵ� �ȴٴ� ��
					}
				}
				rotate();//�ѹ� ȸ�������ش�
			}
			
			//Collections.sort(list);//������ ���� ��������
			Collections.reverse(list);//��������
			System.out.println("#"+test+" "+list.get(k-1));
		}

	}
	public static void rotate() {//���ڸ� ȸ����Ű�� ���� �� ���ھ� �о���
		char tmp=map[n-1];
		for(int i=n-1;i>0;i--) {
			map[i]=map[i-1];
		}
		map[0]=tmp;
	}
}
