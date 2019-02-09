package week_08_03;

import java.util.Scanner;

public class problem_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stair = sc.nextInt();
		int[] score = new int [stair+1];
		int[] total = new int[stair+1];
		for(int i=1;i<=stair;i++) {
			score[i]=sc.nextInt();
		}
		total[1]=score[1];
		total[2]=score[1]+score[2];
		
		for(int i=3;i<=stair;i++) {

			//total[i-2]+score[i] 마지막계단을 밟고 이전꺼를 안밟을 경우
			//score[i]+score[i-1]+total[i-3] 마지막과 이전 계단을 밟을 경우 
			total[i]=Math.max(total[i-2]+score[i],total[i-3]+score[i-1]+score[i]);
		}
		System.out.println(total[stair]);

	}

}
