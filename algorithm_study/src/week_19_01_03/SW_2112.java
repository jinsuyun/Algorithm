package week_19_01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2112 {
	static int d,k,w,min;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// ��ȣ �ʸ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test=Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=test;t++) {
			st = new StringTokenizer(br.readLine());
			
			d=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			
			map= new int[d][w];
			
			for(int i=0;i<d;i++) {//A�� 0 B�� 1
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			min=Integer.MAX_VALUE;
			change(0,0);
			System.out.println("#"+t+" "+min);
		}

	}
	public static void change(int y,int cnt) {
		if(cnt>=min) return;
		if(y>=d) {//DFS�� �Ųٷ� üũ�� ���ش�.
			if(check()) {
				min=Math.min(min, cnt);
			}
			return;
		}
		
		int[] copyMap = new int[w];
		
		change(y+1,cnt);
		
		for(int i=0;i<w;i++)
			copyMap[i]=map[y][i];
		
		for(int i=0;i<w;i++) {
			map[y][i]=1;
		}
		change(y+1,cnt+1);
		
		for(int i=0;i<w;i++) {
			map[y][i]=0;
		}
		change(y+1,cnt+1);
		
		for(int i=0;i<w;i++) {
			map[y][i]=copyMap[i];
		}
		
	}
	
	public static boolean check() {
		
		for(int i=0;i<w;i++) {
			boolean flag=false;
			int result=map[0][i];
			int cnt=0;
			for(int j=0;j<d;j++) {
				if(result==map[j][i]) {
					cnt++;
				}
				else {
					cnt=1;
					result=map[j][i];
				}
				if(cnt==k) {
					flag=true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true;
	}

}
