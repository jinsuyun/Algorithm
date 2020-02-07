package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_2012 {

	public static void main(String[] args) throws IOException {
		// ����ű��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());//(1 �� N �� 500,000) int ���� �ȿ� ���Ƿ� int�� �������൵ �ȴ�.
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			list.add(Integer.parseInt(st.nextToken()));//�ڽ��� ���� ���
		}
		//�Ҹ��� = �ڽ��� ������ - ��������� ���밪
		Collections.sort(list);//�Ҹ����� �ּҷ� ���ؾ� �ϴϱ� ������ ���ش�.
		long sum=0;//sum�� ���� �����ֹǷ� int�� ������ ��� �� �ִ�(������ 50���̱� ����)
		for(int i=0;i<n;i++) {
			sum+=Math.abs(list.get(i)-(i+1));//�Ҹ��� �ּ� ���� ���ϱ� ���� ������ ����Ʈ���� �Ѹ� ���� ���ָ� �ּ� ���� ���´�.
		}
		System.out.println(sum);
		
	}

}
