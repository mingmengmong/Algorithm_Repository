package programmers;
import java.util.PriorityQueue;


public class Solution_12978 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/12978
	 * name : 배달
	 */
	
	int MAX_NUM = 50;
	int[][] G = new int[MAX_NUM+1][MAX_NUM+1];
	boolean[] visit = new boolean[MAX_NUM+1];
	
	public int solution(int N, int[][] road, int K) {
		for(int[] iter : road){
			int u = iter[0];
			int v = iter[1];
			int cost = iter[2];
			if(G[u][v] == 0) G[u][v] = G[v][u] = cost;
			else G[u][v] = G[v][u] = Math.min(cost, G[u][v]);
		}
		
		int res = 0;
		// int[] : [v, cost]
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1, n2)->Integer.compare(n1[1], n2[1]));
		pq.add(new int[]{1,0});
		while(!pq.isEmpty()){
			int[] iter = pq.poll();
			int u = iter[0];
			int cost = iter[1];
			
			if(cost > K) break;
			if(visit[u]) continue;
			visit[u] = true;
			++res;
			
			for(int v=1; v<=N; ++v){
				if(G[u][v] == 0) continue;
				if(visit[v]) continue;
				pq.add(new int[]{v, cost+G[u][v]});
			}
		}
		
		return res;
	}
}