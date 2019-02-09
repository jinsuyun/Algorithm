package week_08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_1759 {
	static int l,c;
	static char[] arr;
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		String[] line = br.readLine().split(" ");
		check = new int[c];
		arr = new char[c];
		for(int i=0;i<c;i++) {
			arr[i]=line[i].charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0,0,0);



	}
	public static void dfs(int start, int depth, int aeiou, int etc) {
		for(int i=start;i<c;i++) {
			check[i]=1;//선택된 문자 확인
			
			dfs(i+1,depth+1,aeiou+(!checked(arr[i])? 1:0),etc+(!checked(arr[i])? 0:1));
			
			check[i]=0;
		}
		if(depth==l&&aeiou>1&&etc>0) {
			for(int i=0;i<c;i++) {
				if(check[i]==1)
					System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
	
	 public static boolean checked(char a) {
	        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
	            return true;
	        else
	            return false;
	    }

}
