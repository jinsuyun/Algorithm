package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_2023 {
	static int n, m;
	static List<Integer> result = new LinkedList();

	public static void main(String[] args) throws IOException {
		// 신기한 소수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = (int) Math.pow(10, n);
		//solve(0);
		/*for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
		*/
		solve("",0);
		
	}

	public static void solve(int depth) {//이와 같은 방법은 값은 나오지만 시간초과가 나온다. 모든 것을 검사했기 때문에 8자리 숫자를 받기엔 효율적이지 못한 방법이다.
		if (n < depth) {
			return;
		}
		for (int i = m / 10; i < m; i++) {
			String value = Integer.toString(i);
			String prime = "";
			boolean all_check = false;
			if (check(i)) {
				for (int j = 0; j < n; j++) {
					prime += value.charAt(j);
					int check_prime = Integer.parseInt(prime);
					if (check(check_prime)) {
						all_check = true;

					} else
						all_check = false;

					if (!all_check)
						break;

				}
				if (!result.contains(i)&&all_check) {
					result.add(i);
				}
			}else continue;
		}
	}

	public static void solve(String s,int depth) {//숫자의 자리수만큼 dfs를 통해 신기한 소수를 구한다.
		if(depth==n) {//자리수가 같게 된다면 출력
			System.out.println(s); 
			return;
		}
		for(int i=1;i<=9;i++) {//1부터9까지 소수를 파악한다. 왼쪽부터 1자리,2자리,...n자리까지 소수이어야하기 때문에 s+i가 소수이어야 한다. 
			//예를 들어 2333이면 2도 소수 23도 소수 233도 소수 2333도 소수이어야한다.233에서 2를 더해준 2332는 소수가 아니므로 if문을 통과할 수 없다.
			//또한 첫번째 자리도 소수이어야 하기때문에 11,13,17 등 앞의 자리가 1이기 때문에 신기한 소수가 될 수 없다. 앞자리는 2,3,5,7이어야함
			if(check(Integer.parseInt(s+i))) {//check 메소드를 통해 소수인지 파악한다. s+i는 기존 값에 새로운 값을 더함으로써 소수인지 파악한다.
				solve(s+i,depth+1);//각 자리에 숫자를 더하고 자리수를 늘려주며 소수를 파악한다.
			}
		}
		
	}


	
	public static boolean check(int prime) {//소수를 파악하기 위한 메소드
		int count = 0;
		if(prime<2) return false;
		
		for (int j = 2; j < prime; j++) {
			if (prime % j == 0) {
				count++;
				break;
			}
		}
		if (count == 0) {
			return true;
		}

		return false;
	}

}
