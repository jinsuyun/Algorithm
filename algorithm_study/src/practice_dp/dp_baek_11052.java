package practice_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_baek_11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[n+1];
		int[] d = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			card[i]=Integer.parseInt(st.nextToken());
			for(int j=1;j<=i;j++) {
				d[i]=Math.max(d[i], card[j]+d[i-j]);
			}
		}
		System.out.println(d[n]);
	}

}
