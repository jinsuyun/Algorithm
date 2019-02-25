package practive_backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_9663 {
	static int result=0,n;
	static int[] map;
	public static void main(String[] args) throws IOException {
		// N-Queen
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());//���� ũ�� �� ���� ����
		map = new int[n];//�ϳ��� �ٿ��� �ϳ��� ���� ���� �� �ֱ� ������ 2���� �迭�� ���� �ʰ� 1���� �迭�� �����Ҽ� �ִ�.
		//map[i]�� ���� ���̰� i�� ������ �����ϸ� �ȴ�. ���� ��� map[2]=4�̸� 3��°(0���� �����ϹǷ�)�� 5��° ��(0���� ����)�� ���� ���� ���� ���Ѵ�.
		Arrays.fill(map, -1);
		solve(0);
		System.out.println(result);
		
	}
	public static void solve(int depth) {//depth�� ���� ���� ���Ѵ�.
		//int [][] map2=new int[n][n]; ���� ��ġ ����ϱ����� ����
		if(depth==n) {//���� ���� n�� ���ٸ� ���� ��ġ�� ��� ������ �����ߴٴ� ���̹Ƿ� ����� ���� �߰���
			result++;
			/*for(int i=0;i<n;i++) { //���� ��ġ ����غ�
				map2[i][map[i]]=1;
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(map2[i][j]);
				}System.out.println();
				
			}System.out.println();*/
		}else {
			for(int i=0;i<n;i++) {//���� n���� ���� �� ���� ������
				map[depth]=i;//���� depth�࿡ i��° ���� ���´�. �ϳ��� �࿡ �ϳ��� ���� ����
				if(check(depth)) {//���� ���� �� �ִ� �� Ȯ���ϴ� �Լ�
					solve(depth+1);//���� ���� �� �ִٸ� ���� ������ �̵��Ѵ�.
				}
			}
		}
		
	}
	public static boolean check(int depth) {
		for(int i=0;i<depth;i++) {//������ �����ִ� ���� ��ġ�� �񱳸� �ϴ� ���̱� ������ ���� ���� depth���� for���� ������.
			if(map[i]==map[depth]||Math.abs(depth-i)==Math.abs(map[depth]-map[i])) {
				return false;//i��° ��, map[i]��� ���� ���� �� depth, �� map[depth]���� map[i]=map[depth]�̸� ���� ���� �ִٰ� �Ǵ�
				//���� ��� (0,0) (0,3)�� ���, i=0, map[i]=0�� depth=3, map[depth]=0�̹Ƿ� map[depth]=map[i] ��, �������� �ִ� ��
				//���� �࿡���� ���� �ϳ��� �����ϱ� ������ ������ �񱳴� �� �ʿ䰡 ����.
				//���� �밢���� �ִ� ��츦 ���Ѵ�. 2���� �迭�� ������ �ΰ��� ������ x��� y���� ���̰� ���ٸ� �밢���� �ִ� ��
				//���� ��� (2,1)�� (7,6)�� ���� ��� 7-2=6-1�̹Ƿ� ���� �밢���� ���� ������ (2,1)�� (7,5)�� 7-2!=5-1�̹Ƿ� �ٸ� �밢���� ��ġ��
				//��ǥ�� �� ��� (x,y)�� ���, (map[i],i)��� ����ȴ�.
			}
		}
		return true;//���� ���� �� �ִ� �ڸ��� �´ٸ� true ���� ���� �� ���� ��ġ��� false
	}

}
