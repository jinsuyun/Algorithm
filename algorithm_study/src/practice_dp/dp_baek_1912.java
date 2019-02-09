package practice_dp;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class dp_baek_1912 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// ¿¬¼ÓÇÕ
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			d[i]=a[i];
			if(i==0) continue;
            if(a[i]+d[i-1]>d[i]) {
				d[i]=a[i]+d[i-1];
			}
		}
		
		int ans=d[0];
		for(int i=0;i<n;i++) {
			ans=Math.max(ans, d[i]);
		}
		System.out.println(ans);
	}

}
