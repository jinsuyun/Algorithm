package week_08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class problem_2589 {
	static int[] drow= {0,-1,0,1};
	static int[] dcol= {-1,0,1,0};
	
	static int col,row;
	static int[][] map = new int[51][51];
	static boolean[][] visit=new boolean[51][51];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<row;i++) {
			String line = br.readLine();
			for(int j=0;j<col;j++) {
				char c = line.charAt(j);
                map[i][j] = c == 'L' ? 0 : -1;
}
			
		}
		
		int maxDistance=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(map[i][j]==0) {
					maxDistance=Math.max(maxDistance, bfs(i,j));
				}
			}
			
		}
		System.out.println(maxDistance);
	
	}
	
	public static void initMap() {
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				visit[i][j]=false;
			}
		}
	}
	
	public static int bfs(int i, int j){
		initMap();
		
        Queue <Node> q = new LinkedList();
        q.add(new Node(i,j));
        visit[row][col]=true;
        
        int distance=-1;
        while(!q.isEmpty()){
        	distance++;
        	int size = q.size();
        	for(int m=0;m<size;m++) {
            Node node =q.poll();
            for(int k=0;k<4;k++) {
            	int nextRow = node.row+drow[k];
            	int nextCol = node.col+dcol[k];
            	
            	
            	 if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) continue;
                 if (visit[nextRow][nextCol]) continue;
                 if (map[nextRow][nextCol] == -1) continue;
            				q.add(new Node(nextRow,nextCol));
            				visit[nextRow][nextCol]=true;
	            			}
	            		}
	            	}

        return distance;
    }
	
}
class Node{
	int row,col;
	Node(int row,int col){
		this.row=row;
		this.col=col;
	}
}
