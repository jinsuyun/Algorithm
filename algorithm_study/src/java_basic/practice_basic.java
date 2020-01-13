package java_basic;

import java.util.Arrays;

public class practice_basic {

	public static void main(String[] args) {
		// 쉬프트 연산자
		//X<<n은 X * 2^n의 결과와 같다.
		//X>>n은 X / 2^n의 결과와 같다.
		//>>>나 <<<은 부호에 상관없이 항상 0으로 빈자리를 채운다.
		
		System.out.println(-8>>1);
		System.out.println(-8>>>1);
		System.out.println(-8>>>1);
		System.out.println(1000>>35);
		System.out.println(1000>>33);
		System.out.println(1000>>32);
		System.out.println(1000>>31);
		System.out.println();
		//삼항 연산자
		int x=10;
		x=(x>5)? 4:3;
		System.out.println(x);
		//배열의 복사
		int[][] arr= {{1,2,3},{4,5,6}};
		int[][] xx=Arrays.copyOf(arr,arr.length);//arr을 복사하는데, 길이가 0부터 arr의 length만큼 복사한다
		System.out.println(Arrays.toString(xx[0]));
		System.out.println(Arrays.toString(xx[1]));
		System.out.println();
		
		//이름 붙은 반복문
		Loop1: for(int i=0;i<5;i++) {//Loop1이라는 이름은 아무렇게 주면된다.
			for(int j=5;j<10;j++) {
				if(j==7) break Loop1;
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		Loop1: for(int i=0;i<5;i++) {
			for(int j=5;j<10;j++) {
				if(j==7) break;
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}

}
