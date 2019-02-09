package practice_dp;

import java.util.Scanner;

public class dp_baek_9095 {
	static int[] d;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		

		for(int i=0;i<t;i++) {
			int n= sc.nextInt();
			d=new int [11];
			d[0]=1;
			for(int j=1;j<=n;j++) {
				if(j-1>=0)
					d[j]=d[j]+d[j-1];
				if(j-2>=0)
					d[j]=d[j]+d[j-2];
				if(j-3>=0)
					d[j]=d[j]+d[j-3];
			}
			System.out.println(d[n]);
		}

	}

}
