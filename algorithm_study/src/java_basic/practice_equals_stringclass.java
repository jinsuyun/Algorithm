package java_basic;

import java.util.Arrays;
import java.util.StringTokenizer;

public class practice_equals_stringclass {

	public static void main(String[] args) {
		// object class�� equals�� String, StringBuffer, compareTo, split�� stringtokenizer�� ����
		val v1 = new val(10);
		val v2 = new val(10);

		if (v1.value == v2.value)
			System.out.println("���� ���� ����");
		else
			System.out.println("���� ���� ������ �ƴ�");

		if (v1 == v2)
			System.out.println("�ּ� ���� ���� ����");
		else
			System.out.println("������ ���� ���� ������ �ƴ�");

		// equals�� ������ ���� ��
		if (v1.equals(v2))
			System.out.println("������ �� ��");
		else
			System.out.println("�ּ� �� �� �ƴ�");

		v2 = v1;// ������ ���ٴ� ���� ���, v2�� v1�� �����ϰ� �ִ� �ν��Ͻ� �ּҸ� ����
		if (v1.equals(v2))
			System.out.println("������ �� ��");
		else
			System.out.println("�ּ� �� �� �ƴ�");
		//String Ŭ������ String�� �����Ҷ����� ���ο� �ν��Ͻ��� �����ϴ� ����
		//��, �̹� �����ϰ� �ִ� ���� ���� ���ͷ� ���ڸ� String ������ �ִ� ���� �̹� �����ϴ� �ν��Ͻ��� ���
		String s = new String("1");
		String s2 = "1";
		String s3 = new String("1");
		if (s == s2)//==�� �ּҰ��� ���ϴ� ��
			System.out.println("@");// ==���� ���� ��� �ٸ� ���������� ����Ű�� ���̹Ƿ� �ٸ��ٰ� ���´�.
		else
			System.out.println("#");

		if (s.equals(s2))
			System.out.println("3");// String�� equals�� ������ ���� ���� ���� ���ϴ� ���̹Ƿ� ���ٰ� ���´�.
		else
			System.out.println("4");

		if (s == s3)
			System.out.println("D");// ���� StringŬ������ ����Ѵٰ� �ص� �ΰ��� String�� �ٸ� �ν��Ͻ��� �����Ǳ� ������ ==(�ּҰ� ��)���� ���� ��� �ٸ��ٰ� ���´�.
		else
			System.out.println("E");

		// String Ŭ���� ���� ������Ʈ Ŭ������ equals�޼��带 �״�� ����ϴ� ���� �ƴ϶� �������̵��� ���ؼ� String �ν��Ͻ��� ����
		// ���ڿ� ���� ���ϵ��� �Ǿ� �ִ�.
		if (s.equals(s3))
			System.out.println("F");// ���� s�� s3�� ���� �����Ƿ� F�� ��µȴ�.
		else
			System.out.println("G");
		// ��, StringBufferŬ������ �������̵� �Ǿ� ���� �ʴ�.

		// String
		// ���ڿ� ���� �����̳� ���� �� ���ڿ��� �ٷ�� �۾��� ���� �ʿ��� ���� String��� StringBufferŬ������ ����ϴ� ���� ����.
		// StringBuffer�ν��Ͻ��� ����� ���ڿ��� ������ �����ϹǷ� �ϳ��� StringBuffer�ν��Ͻ������� ���ڿ��� �ٷ�� ���� �����ϴ�.
		String s4 = "abc";// ���ڿ� ���ͷ� abc�� �ּҰ� s1�� �����
		String s5 = new String("abc");// ���ο� String�ν��Ͻ��� ����, ���� String Ŭ������ �����ڸ� �̿��� ��쿡�� new�����ڿ� ���� �޸� �Ҵ��� �̷������ ������
		// �׻� ���ο� String �ν��Ͻ��� �����ȴ�. �׷��� ���ڿ� ���ͷ��� �̹� �����ϴ� ���� �����ϴ� ���̴�.
		
		char[] carr=new char[0];//char[] carr={};�� ����.
		//char c ='';//����� �Ұ��� char�� �ݵ�� �ϳ��� ���ڸ� �����ؾ��Ѵ�.
		String s6=new String(carr);//String s6=new String("");�� ����.
		System.out.println(carr);//�ƹ��� ���� ������ ����
		System.out.println(carr.length);//0�� ����
		System.out.println(s6.length());//0�� ����
		//comapreTo�� ���� ������ ��
		s="1";
		s2="2";
		System.out.println(s.compareTo(s2));//���� ��ũ�� 1 �ڰ� ��ũ�� -1 ������ 0�� ��ȯ�Ѵ�.
		System.out.println(s.concat("3"));//concat�� �ڿ� �����δ�.
		//indexOf - �־��� ���ڰ� ���ڿ��� �����ϴ��� Ȯ���Ͽ� ������ ��ġ���� Ȯ���Ͽ� ��ġ�� �˷��ش�.
		s="Hello";
		System.out.println(s.indexOf("h"));//ã�� ���ϸ� -1�� ��ȯ
		System.out.println(s.indexOf("H",0));//������ ��ġ���� Ȯ���Ͽ� ��ġ�� �˷��ش�.
		System.out.println(Arrays.toString(s.split("l")));//������ �и��ڷ� ������ ���ڿ� �迭�� ��� ��ȯ
		System.out.println(s.startsWith("H"));//������ ���ڿ��� �����ϴ��� �˻�
		System.out.println(s.substring(0));//������ ������ġ���� ����ġ ���Ե� ���ڿ��� ��´�.
		System.out.println(s.substring(0,3));//������ ������ġ���� ������ ����ġ���� ���Ե� ���ڿ��� ��´�. ������  0<=���ڿ�<3
		System.out.println(s.trim());//���ڿ��� ���� ���� ������ ���� �ִ� ������ ���� ����� ��ȯ, ���ڿ� �߰��� ������ ������ ����.
		s="dog,cat,bear";
		String[] ar=s.split(",");
		System.out.println(Arrays.toString(ar));
		s=String.join("-", ar);//split�� �ݴ� �������� �����ڸ� �־ ���ڿ��� ��ġ�� �� ��ġ�� ��
		System.out.println(s);
		
		//StringBuffer
		StringBuffer sb=new StringBuffer("123");
		sb.append("456").append("789");//�̷������� ����
		System.out.println(sb);
		System.out.println(sb.reverse());//�������� ��ȯ
		
		sb=new StringBuffer("123");
		StringBuffer sb2=new StringBuffer("123");
		System.out.println(sb==sb2);//false
		System.out.println(sb.equals(sb2));//false�� ���� equals�� StringBufferŬ������ �������̵��� �Ǿ����� �����Ƿ�
		System.out.println(sb.toString().equals(sb2.toString()));//�̷������� toString()�� ����Ͽ� ���ؾ���
		System.out.println();
		
		sb=new StringBuffer("123");
		sb2=sb.append(45);//���� sb�� �����ϱ� ������ 123�� �̾� 45�� ���ΰ�
		sb.append(6);
		StringBuffer sb3=sb.append(78);//sb3�� sb�� ���� �ּҸ� ������ ������ 12345678�̵�
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3);
		//StringBuilder - StringBuffer�� �Ȱ��� ������� �ۼ��Ǿ����� ��, ����ȭ�� StringBuffer ������ ����߷� �������� ����ȭ�� �� ���� StringBuilder�̴�. 
		
		//StringTokenizer�� Split ��
		s="A,,B,C,,D";
		StringTokenizer st = new StringTokenizer(s,",");
		String[] sarr=s.split(",");
		for(int i=0;i<sarr.length;i++)
			System.out.print(sarr[i]+"|");
		System.out.println("split ���� "+sarr.length);
		
		int i=0;
		for(;st.hasMoreTokens();i++)
			System.out.print(st.nextToken()+"|");
		System.out.println("stringtokenize ���� "+i);
	}

}

class val {
	int value;

	val(int val) {
		this.value = val;
	}
}
