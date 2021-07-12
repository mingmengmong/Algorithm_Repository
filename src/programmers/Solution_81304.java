package programmers;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Solution_81304 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/81304
	 * name : 미로 탈출
	 */
	
	int trapSize, fullTrapIdx;
	int[][][] G;
	int[] trapCheck;
	boolean[][] visit;
	
	class Node{
		public int u, idx;
		public int cost;
		public Node(int u, int idx, int cost) {
			this.u = u;
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	public int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = 0;
		
		G = new int[n+1][n+1][2];
		for(int[] iter : roads){
			int u = iter[0];
			int v = iter[1];
			int cost = iter[2];
			
			if(G[u][v][0] != 0 && G[u][v][0] < cost) continue;
			
			G[u][v][0] = cost;
			G[v][u][1] = cost;
		}
		
		trapSize = traps.length;
		fullTrapIdx = (1 << trapSize) - 1;
		visit = new boolean[n+1][fullTrapIdx + 1];
		trapCheck = new int[n+1];
		Arrays.fill(trapCheck, -1);
		for(int i=0; i<trapSize; ++i) trapCheck[traps[i]] = i;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2)->Long.compare(n1.cost,n2.cost));
		pq.add(new Node(start, 0, 0));
		while(!pq.isEmpty()){
			Node top = pq.poll();
			int u = top.u;
			int idx = top.idx;
			int cost = top.cost;
			
			if(u == end) return cost;
			if(visit[u][idx]) continue;
			visit[u][idx] = true;
			
			int[] nowTrapArr = new int[trapSize];
			int nowTrapIdx = 0;
			for(int i=0; i<trapSize; ++i){
				int trapIdx = 1 << (trapSize-1-i);
				nowTrapArr[i] = (trapIdx & idx) > 0 ? 1 : 0;
				if(traps[i] == u){
					nowTrapArr[i] ^= 1;
					nowTrapIdx = nowTrapArr[i];
				}
			}
			
			int nextIdx = 0;
			for(int i=0; i<trapSize; ++i){
				nextIdx <<= 1;
				nextIdx += nowTrapArr[i];
			}
			
			for(int v=1; v<=n; ++v){
				int check = nowTrapIdx;
				if(trapCheck[v] != -1) check ^= nowTrapArr[trapCheck[v]];
				if(G[u][v][check] == 0) continue;
				pq.add(new Node(v, nextIdx, cost+G[u][v][check]));
			}
		}
		
		return answer;
	}
}