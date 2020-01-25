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
		// 신입사원
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
				list.add(new rank(document,munjup));//서류 점수와 면접 점수를 리스트에 넣는다.
			}
			Collections.sort(list,new Comparator<rank>(){//서류점수를 기반으로 오름차순 정렬을 시켜준다.
				//compare 메서드를 오버라이딩을 사용해서 사용하는 것 꼭 알아두자!
				public int compare(rank o1,rank o2) {
					if(o1.document>o2.document)
						return 1;
					else if(o1.document<o2.document)
						return -1;
					return 0;
				}
			});
			int cnt=0;
			int mun2=Integer.MAX_VALUE;//초기값을 넣기 위해 최대값을 넣은 것.
			for(int i=0;i<list.size();i++) {//서류점수는 이미 정렬이 되어있기 때문에 면접점수만 비교해주면된다.
				int mun=list.get(i).munjup;
				if(mun<mun2) {//for문을 지나면서 면접 점수가 기존에 있는 사람보다 좋을 경우 그 신입사원을 뽑는 것
					mun2=mun;
					cnt++;//값을 넣어 주었으면 그 신입을 뽑는다는 것
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
