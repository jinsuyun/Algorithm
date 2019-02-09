package week_12_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_5373 {
	static int n,t;
	static int[] dy= {},dx= {};
	static char[][] U,D,F,B,L,R;
	//1. U: 윗 면, 2. D: 아랫 면, 3. F: 앞 면, 4. B: 뒷 면, 5. L: 왼쪽 면, 6. R: 오른쪽 면
	//윗 면은 흰색, 아랫 면은 노란색, 앞 면은 빨간색, 뒷 면은 오렌지색, 왼쪽 면은 초록색, 오른쪽 면은 파란색
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 큐빙
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		t=Integer.parseInt(br.readLine());
		for(int test=0;test<t;test++) {
			n=Integer.parseInt(br.readLine());//큐브 돌린 횟수

			U=new char[3][3];
			D=new char[3][3];
			F=new char[3][3];
			B=new char[3][3];
			L=new char[3][3];
			R=new char[3][3];
			
			for(int i=2;i>=0;i--) {
				for(int j=0;j<3;j++) {
					U[i][j]='w';
					D[i][j]='y';
					F[i][j]='r';
					B[i][j]='o';
					L[i][j]='g';
					R[i][j]='b';
				}
			}
			
			String[] rote = new String[n];
			st=new StringTokenizer(br.readLine());//회전 입력
			for(int i=0;i<n;i++) {//큐브를 돌린횟수 n을 따라 입력 방법이 다르게끔
				rote[i]=st.nextToken();
			}
			for(int i=0;i<n;i++) {
				if(rote[i].equals("L-")) {
					
					rotateL(L);LL();
				}else if(rote[i].equals("L+")) {
					
					rotateR(L);LR();
				}else if(rote[i].equals("R+")) {
					
					rotateR(R);RR();
				}else if(rote[i].equals("R-")) {
					
					rotateL(R);RL();
				}else if(rote[i].equals("U+")) {

					rotateR(U);UR();
				}else if(rote[i].equals("U-")) {
					
					rotateL(U);UL();
				}else if(rote[i].equals("D+")) {
					
					rotateR(D);DR();
				}else if(rote[i].equals("D-")) {
					
					rotateL(D);DL();
				}else if(rote[i].equals("F+")) {
					
					rotateR(F);FR();
				}else if(rote[i].equals("F-")) {
					
					rotateL(F);FL();
				}else if(rote[i].equals("B+")) {
					
					rotateR(B);BR();
				}else if(rote[i].equals("B-")) {
					
					rotateL(B);BL();
				}
			}
			
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(U[i][j]);
				}
				System.out.println();
			}
			
		}

	}
	
	public static void LL() {
		char a,b,c;
		a=U[2][0];
		b=U[1][0];
		c=U[0][0];
		U[0][0]=F[0][0];
		U[1][0]=F[1][0];
		U[2][0]=F[2][0];
		
		F[2][0]=D[0][2];
		F[1][0]=D[1][2];
		F[0][0]=D[2][2];
		
		D[2][2]=B[0][0];
		D[1][2]=B[1][0];
		D[0][2]=B[2][0];
		
		B[2][0]=a;
		B[1][0]=b;
		B[0][0]=c;
		
	}
	
	public static void LR() {
		char a,b,c;
		a=U[0][0];
		b=U[1][0];
		c=U[2][0];
		
		U[0][0]=B[0][0];
		U[1][0]=B[1][0];
		U[2][0]=B[2][0];
		
		B[2][0]=D[0][2];
		B[1][0]=D[1][2];
		B[0][0]=D[2][2];
		
		D[0][2]=F[2][0];
		D[1][2]=F[1][0];
		D[2][2]=F[0][0];
		
		F[0][0]=a;
		F[1][0]=b;
		F[2][0]=c;
		
	}
	public static void RL() {
		char a,b,c;
		a=U[0][2];
		b=U[1][2];
		c=U[2][2];
		
		U[0][2]=B[0][2];
		U[1][2]=B[1][2];
		U[2][2]=B[2][2];

		B[2][2]=D[0][0];
		B[1][2]=D[1][0];
		B[0][2]=D[2][0];
		
		D[2][0]=F[0][2];
		D[1][0]=F[1][2];
		D[0][0]=F[2][2];
		
		F[0][2]=a;
		F[1][2]=b;
		F[2][2]=c;
		
	}
	
	public static void RR() {
		char a,b,c;
		a=U[0][2];
		b=U[1][2];
		c=U[2][2];
		U[0][2]=F[0][2];
		U[1][2]=F[1][2];
		U[2][2]=F[2][2];
		
		F[2][2]=D[0][0];
		F[1][2]=D[1][0];
		F[0][2]=D[2][0];
		
		D[2][0]=B[0][2];
		D[1][0]=B[1][2];
		D[0][0]=B[2][2];
		
		B[0][2]=a;
		B[1][2]=b;
		B[2][2]=c;
		
	}
	public static void FL() {
		char a,b,c;
		a=U[2][2];
		b=U[2][1];
		c=U[2][0];
		
		U[2][2]=R[2][2];
		U[2][1]=R[2][1];
		U[2][0]=R[2][0];
		
		R[2][2]=D[2][2];
		R[2][1]=D[2][1];
		R[2][0]=D[2][0];
		
		D[2][2]=L[2][2];
		D[2][1]=L[2][1];
		D[2][0]=L[2][0];
		
		L[2][2]=a;
		L[2][1]=b;
		L[2][0]=c;
		
	}
	public static void FR() {
		char a,b,c;
		a=U[2][0];
		b=U[2][1];
		c=U[2][2];
		
		U[2][0]=L[2][0];
		U[2][1]=L[2][1];
		U[2][2]=L[2][2];
		
		L[2][0]=D[2][0];
		L[2][1]=D[2][1];
		L[2][2]=D[2][2];
		
		D[2][0]=R[2][0];
		D[2][1]=R[2][1];
		D[2][2]=R[2][2];
		
		R[2][0]=a;
		R[2][1]=b;
		R[2][2]=c;
		
	}
	public static void BL() {
		char a,b,c;
		a=U[0][0];
		b=U[0][1];
		c=U[0][2];
		U[0][0]=L[0][0];
		U[0][1]=L[0][1];
		U[0][2]=L[0][2];
		
		L[0][0]=D[0][0];
		L[0][1]=D[0][1];
		L[0][2]=D[0][2];
		
		D[0][0]=R[0][0];
		D[0][1]=R[0][1];
		D[0][2]=R[0][2];
		
		R[0][0]=a;
		R[0][1]=b;
		R[0][2]=c;
		
	}
	public static void BR() {
		char a,b,c;
		a=U[0][0];
		b=U[0][1];
		c=U[0][2];
		U[0][0]=R[0][0];
		U[0][1]=R[0][1];
		U[0][2]=R[0][2];
		
		R[0][0]=D[0][0];
		R[0][1]=D[0][1];
		R[0][2]=D[0][2];
		
		D[0][0]=L[0][0];
		D[0][1]=L[0][1];
		D[0][2]=L[0][2];
		
		L[0][0]=a;
		L[0][1]=b;
		L[0][2]=c;
		
	}
	public static void UL() {
		char a,b,c;
		a=L[0][2];
		b=L[1][2];
		c=L[2][2];
		L[0][2]=B[2][2];
		L[1][2]=B[2][1];
		L[2][2]=B[2][0];
		
		B[2][2]=R[2][0];
		B[2][1]=R[1][0];
		B[2][0]=R[0][0];
		
		R[2][0]=F[0][0];
		R[1][0]=F[0][1];
		R[0][0]=F[0][2];
		
		F[0][0]=a;
		F[0][1]=b;
		F[0][2]=c;
		
	}
	public static void UR() {
		char a,b,c;
		a=L[2][2];
		b=L[1][2];
		c=L[0][2];
		
		L[2][2]=F[0][2];
		L[1][2]=F[0][1];
		L[0][2]=F[0][0];
		
		F[0][2]=R[0][0];
		F[0][1]=R[1][0];
		F[0][0]=R[2][0];
		
		R[0][0]=B[2][0];
		R[1][0]=B[2][1];
		R[2][0]=B[2][2];
		
		B[2][0]=a;
		B[2][1]=b;
		B[2][2]=c;
		
	}
	public static void DL() {
		char a,b,c;
		a=B[0][0];
		b=B[0][1];
		c=B[0][2];
		
		B[0][0]=L[2][0];
		B[0][1]=L[1][0];
		B[0][2]=L[0][0];
		
		L[2][0]=F[2][2];
		L[1][0]=F[2][1];
		L[0][0]=F[2][0];
		
		F[2][2]=R[0][2];
		F[2][1]=R[1][2];
		F[2][0]=R[2][2];
		
		R[0][2]=a;
		R[1][2]=b;
		R[2][2]=c;
		
	}
	public static void DR() {
		char a,b,c;
		a=B[0][0];
		b=B[0][1];
		c=B[0][2];
		
		B[0][0]=R[0][2];
		B[0][1]=R[1][2];
		B[0][2]=R[2][2];
		
		R[0][2]=F[2][2];
		R[1][2]=F[2][1];
		R[2][2]=F[2][0];
		
		F[2][2]=L[2][0];
		F[2][1]=L[1][0];
		F[2][0]=L[0][0];
		
		L[2][0]=a;
		L[1][0]=b;
		L[0][0]=c;
		
	}
	public static void rotateL(char[][] cube) {
		char a,b,c;
		a=cube[0][0];
		b=cube[0][1];
		c=cube[0][2];
		
		cube[0][0]=cube[0][2];
		cube[0][1]=cube[1][2];
		cube[0][2]=cube[2][2];
		
		cube[0][2]=cube[2][2];
		cube[1][2]=cube[2][1];
		cube[2][2]=cube[2][0];
		
		cube[2][2]=cube[2][0];
		cube[2][1]=cube[1][0];
		cube[2][0]=cube[0][0];
		
		cube[2][0]=a;
		cube[1][0]=b;
		cube[0][0]=c;
		
	}
	public static void rotateR(char[][] cube) {
		char a,b,c;
		a=cube[0][0];
		b=cube[0][1];
		c=cube[0][2];
		
		cube[0][2]=cube[0][0];
		cube[0][1]=cube[1][0];
		cube[0][0]=cube[2][0];
		
		cube[0][0]=cube[2][0];
		cube[1][0]=cube[2][1];
		cube[2][0]=cube[2][2];
		
		cube[2][0]=cube[2][2];
		cube[2][1]=cube[1][2];
		cube[2][2]=cube[0][2];

		cube[0][2]=a;
		cube[1][2]=b;
		cube[2][2]=c;
	}

}
