package week_12_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SW_5658 {
	static int t,n,k;
	static char[] map;
	static String[] map2;
	static int[] result;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		// [모의 SW 역량테스트] 보물상자 비밀번호
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t=Integer.parseInt(st.nextToken());
		
		for(int test=1;test<=t;test++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			map=new char[n];
			result=new int[n];
			String s=br.readLine();
			for(int i=0;i<s.length();i++) {
				map[i]=s.charAt(i);
			}
			
			
			int x=n/4;//rotate의 개수
			boolean finish=true;
			list=new ArrayList<>();
			while(finish) {
				map2=new String[4];
				finish=false;
				int count=0;
				
				for(int i=0;i<4;i++) {
					map2[i]="";
					for(int j=0;j<x;j++) {
						map2[i]+=map[count];
						count++;
					}
				}
				
				for(int i=0;i<map2.length;i++) {
					int result=Integer.parseInt(map2[i],16);
					if(!list.contains(result)&&map2[i]!=null) {
						list.add(result);
						finish=true;
					}
				}
				
				rotate();
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			System.out.println("#"+test+" "+list.get(k-1));
		}
		
	}
	public static void rotate() {
		char tmp=map[n-1];
		for(int i=n-1;i>0;i--) {
				map[i]=map[i-1];	
			}
		map[0]=tmp;
	}

}
