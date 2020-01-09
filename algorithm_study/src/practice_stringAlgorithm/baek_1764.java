package practice_stringAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baek_1764 {

	public static void main(String[] args) throws IOException {
		// �躸��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		ArrayList<String> listen=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			listen.add(st.nextToken());
		}
		Collections.sort(listen);//���̳ʸ���ġ�� ����ϱ����� �����صд�.
		String[] s=new String[listen.size()];
		s=listen.toArray(s);//���̳ʸ� ��ġ�� ����ϱ� ���� �迭�� �ٲ��ش�.
		
		ArrayList<String> result=new ArrayList<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			String ss = st.nextToken();//���� ���ѳ�� �赵���� ���ѳ��� ���ϱ� ���� ���
			int idx=Arrays.binarySearch(s, ss);//s �迭���� ss��� ���� ã�´�. ã�� ���� idx�� �ִ´�.
			System.out.println(idx);
			if(idx>=0)//Arrays.binarySearch()�� ����ϸ� ��ȯ�ϴ� ���� ã���� 0 Ȥ�� ���, ã�� ���ϸ� ������ ��ȯ�Ѵ�. 
				result.add(ss);//���� ã�Ҵٸ� ����� �־��ش�.
			
		}
		
		//����� ��� �κ�
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
			
		}

	}

}
