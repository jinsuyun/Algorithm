package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_baek_9466 {
	static ArrayList<Integer>[] map;
	static int[] visit;
	static int[] start;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Term Project
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine());
			StringTokenizer st =new StringTokenizer(br.readLine());
			map=new ArrayList[n+1];
			visit=new int[n+1];
			start=new int[n+1];
			
			for(int i=1;i<=n;i++) {
				map[i]=new ArrayList();
			}
			
			for(int i=1;i<=n;i++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
			
			int count2=0;
			
			for(int i=1;i<=n;i++) {
				if(visit[i]==0) {
					count2+=dfs(i,1,i);
					
				}
			}
			
			System.out.println(n-count2);
		}
	}
	public static int dfs(int x,int count,int star) {
		/*�̹� �湮�ߴ� �����̰�
         * ���������� star�� �ٸ��� star ������ ����Ŭ �ܿ� �ִ� �����̹Ƿ� 0�� ����,
         * �ƴϸ� (���� cnt - star�κ��� ���°�� �湮�� ��������) ����
         */
		if(visit[x]!=0) {//�̹� �湮�ߴٸ�
			if(star!=start[x])//���������� star�� �ٸ��� ������ ����Ŭ �ܿ� �ִ� �����̹Ƿ� 0 ��� ����Ŭ�� ��常 ������ ���°���
				return 0;
			
			return count-visit[x];
	
		}
		
		visit[x]=count;
		start[x]=star;
		
		return dfs(map[x].get(0),count+1,star);
	}

}
