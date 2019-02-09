package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_baek_11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//가장 큰 증가 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] d= new int[n];
		int[] a= new int[n];
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			d[i]=a[i];
			for(int j=0;j<i;j++) {
				if(a[i]>a[j]&&d[i]<d[j]+a[i]) {
					d[i]=d[j]+a[i];
					
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			ans=Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
