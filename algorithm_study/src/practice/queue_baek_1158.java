package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class queue_baek_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i=0;i<m-1;i++) {
				int poll=queue.poll();
				queue.add(poll);
			}
			sb.append(queue.poll());
			
			if (queue.isEmpty()) {
				break;
			}
			sb.append(", ");
	
		}
		
		System.out.print("<");
		System.out.print(sb);
		System.out.print(">");
	}

}
