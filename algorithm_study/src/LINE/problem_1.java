package LINE;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem_1 {

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
				int money=20000;
				int n=1;
        final StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
						int total=0; 
						
            if(distance<=40){
							total=+720;
							money=money-total;
							
						}
						else if(distance>=41){
							total=total+720;
							int tmp=distance-40;
							int extra_money;
							if(tmp<=7||tmp%8!=0){
								extra_money=(tmp/8)*80+80;
							} else{
								extra_money = (tmp/8)*80;
							}
							total=total+extra_money;
							
							money=money-total;
						}
						else if(distance<4||distance>178){
							break;
						}
						if(money<0){
							break;
						}
					

					
    		}
			System.out.println(money);
	}
}