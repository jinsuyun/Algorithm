package practice_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class graph_baek_2331 {
	static int check[],a,p;
	public static void main(String[] args) throws IOException {
		// 반복 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		p=Integer.parseInt(st.nextToken());
		
		check = new int[1000000];
		
		int value=dfs(a,1);
		System.out.println(value);
	}
	
	public static int dfs(int v,int count) {
		if(check[v]!=0) return check[v]-1;
		
		check[v]=count;
		
		String s=v+"";
		int result=0;
		for(int i=0;i<s.length();i++) {
			int x=Integer.parseInt(s.charAt(i)+"");
			result+=(int) Math.pow(x,p);
		}
		
		return dfs(result,count+1);
	}

}
