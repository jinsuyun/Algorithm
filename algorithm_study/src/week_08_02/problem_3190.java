package week_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_3190 {
	static int N,K,L,X;
	static int[] dRow = {0,-1,0,1};
	static int[] dCol = {1,0,-1,0};
	static int[][] map = new int [101][101];
	static int[][] direction = new int[101][101];
	static int apple=1, snake=2;
	static int headRow,headCol,tailRow,tailCol;
	static char C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());//¸ÊÀÇ Å©±â
		K=Integer.parseInt(br.readLine());//»ç°ú °¹¼ö
		
		for(int i=0;i<101;i++) {//¸Ê ÃÊ±âÈ­
			for(int j=0;j<101;j++) {
				map[i][j]=0;
			}
		}
		
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=apple;
		}
		
		L=Integer.parseInt(br.readLine());//¹ìÀÇ ¹æÇâ º¯È¯ È½¼ö
		
		Move[] move = new Move[L+1];//½Ã°£ ÃÊ¿Í ¹æÇâ
		
		for(int i=0;i<L;i++) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			move[i]=new Move(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0));
		}
		
		int count=0;
		for(int i=0;i<L;i++) {
			X=move[i].X;
			C=move[i].C;
			
			int time=X;
			while(time>0) {
				count++;
				headRow +=dRow[3];
				headCol +=dCol[0];
				
				if(headRow<1||headRow>N||headCol<1||headCol>N) {
					System.out.println(count);
					break;
				}
				
				if(map[headRow][headCol]==0) {
					map[headRow][headCol]=snake;
					
					tailRow +=dRow[snake];
					tailCol +=dCol[snake];
				}
				else if(map[headRow][headCol]==apple) {
					map[headRow][headCol]=snake;
					
				}
				else if(map[headRow][headCol]==snake) {
					System.out.println(count);
					break;
				}
				time--;
			}
			
		}
		
		
	}
}

class Move{
	int X;
	char C;
	Move(int X,char C){
		X=this.X;
		C=this.C;
		
	}
}