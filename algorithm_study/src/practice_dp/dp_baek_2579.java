package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_baek_2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// °è´Ü¿À¸£±â
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] a= new int[n+1];
		int[][] d= new int[3][n+1];

		
		for(int i=1;i<=n;i++) {
			a[i]=Integer.parseInt(br.readLine());	
		}
		
		d[1][1]=a[1];
		for(int i=2;i<=n;i++) {
			d[1][i]=Math.max(d[1][i-2], d[2][i-2])+a[i];//1¹ø ¿¬¼ÓÀÌ¹Ç·Î i-1À» ¹âÀ¸¸é ¾ÈµÊ 
			d[2][i]=d[1][i-1]+a[i];//Â÷°îÂ÷°î ¹â¾Æ¼­ ¿Ã¶ó¿È
			
		}
		System.out.println(Math.max(d[1][n],d[2][n]));

	}

}
