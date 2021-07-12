package programmers;
import java.util.PriorityQueue;


public class Solution_67259 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/67259
	 * name : 경주로 건설
	 */
	
	class Node{
		public int r,c,d,cost;
		public Node(int r, int c, int d, int cost) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					", d=" + d +
					", cost=" + cost +
					'}';
		}
	}
	
	// U,D,R,L
	int[] RD = {1,-1,0,0}, CD = {0,0,1,-1};
	int[][] costArr = {
			{100,0,600,600},
			{0,100,600,600},
			{600,600,100,0},
			{600,600,0,100}
	};
	
	int SIZE;
	
	boolean isPossible(int r, int c){
		return 0<=r&&r<SIZE && 0<=c&&c<SIZE;
	}
	
	public int solution(int[][] board) {
		SIZE = board.length;
		
		boolean[][][] visit = new boolean[SIZE][SIZE][4];
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2) -> Integer.compare(n1.cost, n2.cost));
		pq.add(new Node(0,0,0,0));
		pq.add(new Node(0,0,2,0));
		
		while(!pq.isEmpty()){
			Node iter = pq.poll();
			int r = iter.r;
			int c = iter.c;
			int d = iter.d;
			int cost = iter.cost;
			
			if(r == SIZE-1 && c == SIZE-1)
				return cost;
			
			if(visit[r][c][d]) continue;
			visit[r][c][d] = true;
			
//			System.out.println(iter);
			
			for(int nd=0; nd<4; ++nd){
				int nr = r + RD[nd];
				int nc = c + CD[nd];
				
				if(!isPossible(nr,nc) || board[nr][nc] == 1) continue;
				if(costArr[d][nd] == 0) continue;
				if(visit[nr][nc][nd]) continue;
				
				pq.add(new Node(nr,nc,nd,cost+costArr[d][nd]));
			}
		}
		
		int answer = 0;
		return answer;
	}
}