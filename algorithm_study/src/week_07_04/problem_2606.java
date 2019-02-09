package week_07_04;

import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem_2606 {
	static int count = 0;

    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // ��ǻ�� ���
		int pair = sc.nextInt(); // ��
		boolean[] check = new boolean[n + 1];
		
		ArrayList<Integer>[] com = (ArrayList<Integer>[]) new ArrayList[n + 1];

		for (int i = 1; i <= n; i++)

			com[i] = new ArrayList<Integer>();

		for (int i = 1; i <= pair; i++) {
			int node = sc.nextInt();
			int sub = sc.nextInt();

			com[node].add(sub);//������̱� ������
			com[sub].add(node);

		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);//���̷��� �ɸ� ��ǰ
		
		while (!q.isEmpty()) {
			int node = q.remove();
			for (int x : com[node]) {
				if (!check[x]) {
					check[x] = true;
					q.add(x);
				}
			}
		}
		int count = 0;
		for (int i = 2; i <= check.length - 1; i++) {
			if (check[i])
				count++;
		}
		System.out.println(count);
	}
}



