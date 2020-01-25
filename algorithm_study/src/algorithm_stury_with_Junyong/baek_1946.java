package algorithm_stury_with_Junyong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_1946 {

	public static void main(String[] args) throws IOException {
		// ���Ի��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test=Integer.parseInt(st.nextToken());
		for(int t=0;t<test;t++) {
			ArrayList<rank> list = new ArrayList<>();
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				int document=Integer.parseInt(st.nextToken());
				int munjup=Integer.parseInt(st.nextToken());
				list.add(new rank(document,munjup));//���� ������ ���� ������ ����Ʈ�� �ִ´�.
			}
			Collections.sort(list,new Comparator<rank>(){//���������� ������� �������� ������ �����ش�.
				//compare �޼��带 �������̵��� ����ؼ� ����ϴ� �� �� �˾Ƶ���!
				public int compare(rank o1,rank o2) {
					if(o1.document>o2.document)
						return 1;
					else if(o1.document<o2.document)
						return -1;
					return 0;
				}
			});
			int cnt=0;
			int mun2=Integer.MAX_VALUE;//�ʱⰪ�� �ֱ� ���� �ִ밪�� ���� ��.
			for(int i=0;i<list.size();i++) {//���������� �̹� ������ �Ǿ��ֱ� ������ ���������� �����ָ�ȴ�.
				int mun=list.get(i).munjup;
				if(mun<mun2) {//for���� �����鼭 ���� ������ ������ �ִ� ������� ���� ��� �� ���Ի���� �̴� ��
					mun2=mun;
					cnt++;//���� �־� �־����� �� ������ �̴´ٴ� ��
				}
			}
			System.out.println(cnt);
		}
	}

}
class rank{
	int document,munjup;
	rank(int document,int munjup){
		this.document=document;
		this.munjup=munjup;
	}
}
