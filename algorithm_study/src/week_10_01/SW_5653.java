package week_10_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5653 {
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int map [][];
		int temp_map[][];
		int[][] activate;
		
		int test=Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++) {
			int result=0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			map=new int[n][m];
			temp_map=new int[n][m];
			activate=new int[n][m];
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				for(int l=0;l<m;l++) {
					map[j][l]=Integer.parseInt(st.nextToken());
					temp_map[j][l]=map[j][l];
					if(map[j][l]!=0)
						activate[j][l]=0;
				}
			}
			
			for(int time=1;time<=k;time++) {
				for(int j=0;j<n;j++) {
					for(int l=0;l<m;l++) {
						if(map[j][l]==time) {
							activate[j][l]=1;
						}
						else {
							if(activate[j][l]==1) {
								activate[j][l]=-1;
							}
							else
								activate[j][l]=0;
							
						}
						
						if(activate[j][l]==1) {
							for(int i=0;i<4;i++) {
								if((j+dy[i]>0&&l+dx[i]>0)&&j+dy[i]<n&&l+dx[i]<m)
									temp_map[j+dy[i]][l+dx[i]]=temp_map[j][l];
							}
						}
						
					}
				}
				
			}
			/*if(activate[j][l]==0)
				result=+1;
			if(activate[j][l]==1)
				result=+1;
			*/
			System.out.println("#"+(test+1)+" "+result);
		}
		
	}
	

}
