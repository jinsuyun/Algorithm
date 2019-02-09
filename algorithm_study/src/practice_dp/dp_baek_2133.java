package practice_dp;

import java.util.Scanner;

public class dp_baek_2133 {

	public static void main(String[] args) {
		// 타일채우기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[31];
		d[0]=1;
		d[1]=0;
		d[2]=3;
		for(int i=4;i<=n;i+=2) {
			d[i]=d[i-2]*3;//마지막 경우의수가 3개임 (2x1 타일1개와 1x2타일 1개,1x2타일 1개와 2x1 타일이 1개, 1x2 타일 3개) 타일이 2칸을 차지하므로 i-2
			for(int j=4;i-j>=0;j=j+2) {//4일때 6일때 8일때 10일때... 각각 타일이 추가됨(홀수는 X)
				d[i]+=2*d[i-j];//i-4 i-6 i-8 ...씩 추가됨 *2는 타일의 위치가 위일때 아래일때 2가지경우
			}
		}
		System.out.println(d[n]);

	}

}
