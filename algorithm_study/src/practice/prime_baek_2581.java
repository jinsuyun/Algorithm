package practice;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class prime_baek_2581 {

	public static void main(String[] args) throws IOException {
		// 소수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		List<Integer> list = new LinkedList<>();
		boolean check = false;
		for (int i = n; i <= m; i++) {//n부터 m까지 중 소수구하기
			if(i==1) continue;//1은 소수가 아니므로 제외 
			boolean isPrime = false;//소수인거 표시
			for (int j = 2; j < i; j++) {//소수는 자신과 2로 나눠져야함
				if (i % j == 0) {//i라는 숫자가 2부터j까지 나눴을때 나머지가 없이 나눠 떨어진다면 소수가 아님
					isPrime = true;//소수가 아닌것 
					break;//소수가 아니라면 더 for문을 돌릴 필요가 없으므로 break
				}
			}
			if (!isPrime) {//1과 자기 자신으로만 나눠지는 것이라면 소수의 첫번째 값을 출력하기 위해 리스트에 넣고 sum에 값을 더해준다
				list.add(i);
				sum += i;
				check=true;//소수가 하나라도 나왔다면 check에 true를 해준다.
			} 
		}
		
		if (check) {//소수가 하나라도 있다면 모든 소수를 더한 값과 소수의 첫번째 값을 출력 list.size()!=0이라고 써도 무방하다.
			System.out.println(sum);
			System.out.println(list.get(0));
		} else {//소수가 하나도 없다면 -1을 출력한다.
			System.out.println(-1);
		}
	}

}
