package week_08_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem_9205 {

	static int t;
	static boolean success;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t=Integer.parseInt(br.readLine());//Å×½ºÆ®°¹¼ö
	
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());//ÆíÀÇÁ¡ °¹¼ö
			XY[] xy = new XY[n+2];
			String [] xy_split;
			success=false;
			for(int j=0;j<n+2;j++) {
				xy_split=br.readLine().split(" ");
				xy[j]= new XY(Integer.parseInt(xy_split[0]),Integer.parseInt(xy_split[1]));
				
			}
			bfs(xy,n);

		}

		
	}
	public static void bfs(XY[] xy,int n) {
		Queue<XY> q=new LinkedList<XY>();
		XY start = xy[0];
		XY end = xy[n+1];
		
		q.add(start);
		while(!q.isEmpty()) {
			XY position=q.poll();
			
			if(position.equals(end)) {
				success=true;
				break;
			}
			
			for(int i=1;i<n+2;i++) {
				if(Math.abs(position.x-xy[i].x)+Math.abs(position.y-xy[i].y)<=1000) {
					q.add(xy[i]);
				}
			}
			
			
		}
		
		if(success) {
			System.out.println("happy");
		}else {
			System.out.println("sad");
		}
	}

}

class XY{
	int x,y;
	XY(int x, int y){
		this.x=x;
		this.y=y;
	}
}
