package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_2455 {

	public static void main(String[] args) throws IOException {
		// ������ ���� -�ùķ��̼� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum=0;
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int off=Integer.parseInt(st.nextToken());//�������
			int in=Integer.parseInt(st.nextToken());//������ ź���
			int cnt=0;
			cnt+=in;
			cnt-=off;
			if(cnt>0) sum+=cnt;//����������� ź����� ������ ���ο����� ������
			sum=Math.max(sum, cnt);//������ ���� ���� ���� ��� ��
		}
		System.out.println(sum);
	}

}
