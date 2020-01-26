package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class baek_10989 {

	public static void main(String[] args) throws IOException {
		// �� �����ϱ� 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//��¹��� ������ �� �ִ�.
		//BufferedWriter�� �⺻ ũ�⸦ ������ ��� ���۷� ���۸� �� ������ ��� ��Ʈ�� (character output stream) ��ü�� �����.
		int n = Integer.parseInt(br.readLine());//n�� ���� 1~10,000,000  ���� 1~10,000�� �ڿ���
		int[] arr = new int[10001];//���� 1���̱� ������ �迭�� 10001�� ũ��� ������ش�
		for(int i=0;i<n;i++) {
			int t=Integer.parseInt(br.readLine());
			arr[t]++;//�Է¹��� ��(1~10000)�� �迭 ��ġ�� �ִ´�.
		}
		
		for(int i=1;i<10001;i++) {//�迭�� ó������ ������ for��
			for(int j=0;j<arr[i];j++) {//���� ��������� arr[i]�� 0���� ū ���� ����ֱ� ������ �ߺ����� ����ִ��� ����� ���� �� �ִ�.
				bw.write(String.valueOf(i));//��¹��� �������� write 
				bw.newLine();//������ �ٲ��ִ�  ��.
			}
		}
		//flush()�� ������ ������ ���� ���ָ� �˴ϴ�. �翬�� xxx.close()�ϱ����� ����� �ϰ�����. 
		//flush�� ���� ���ؼ� stream�� ���� �ִ� �����͸� ������ �������� ������ �մϴ�.
		//���� ��� ȣ���� ����� ���������� Ʋ�� ���� ��׸� ȣ���ȿ� ���� ���� ���� �ְ� �˴ϴ�.
		//�� ���� �ִ� ���� ������ ���ؼ� ȣ���� ��� �÷��� ���� ��츦 ������ �̴ϴ�.
		//flush()�� ȣ���� ���� ���� ������ ������ �մϴ�.
		bw.flush();
		bw.close();//close()�� �ڵ����� flush()�� ȣ���մϴ�.
	}

}
