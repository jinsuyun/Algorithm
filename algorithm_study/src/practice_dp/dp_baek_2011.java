package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class dp_baek_2011 {

	public static void main(String[] args) throws IOException {
		// 암호코드
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String pw=br.readLine();
		int n=pw.length();
		pw=" "+pw;
		long[] d = new long[n+1];
		d[0]=1;
		for(int i=1;i<=n;i++) {
			int x=Integer.parseInt(pw.charAt(i)+"");//parseInt는 String을 int로 변환해주는것이기 때문에 charAt의 char형태에서 ""을 더하여 String로 만들어주었다.
			if(1<=x&&x<=9) {
				d[i]+=d[i-1];
				d[i]%=1000000;
			}
			if(i==1)continue;
			
			x=Integer.parseInt(pw.charAt(i-1)+"")*10+Integer.parseInt(pw.charAt(i)+"");
			if(9<x&&x<27) {
				d[i]+=d[i-2];
				d[i]%=1000000;
			}
		}
		System.out.println(d[n]);
		
	}

}
