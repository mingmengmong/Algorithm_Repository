package programmers;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_76503 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/76503
	 * name : 모두 0으로 만들기
	 */
	
	int size;
	List<Integer>[] G;
	long[] W;
	boolean[] visit;
	int[] cntG;
	long[] resCnt;
	
	public long solution(int[] ww, int[][] edges) {
		long sum = 0;
		for(long a : ww) sum += a;
		if(sum != 0) return -1;
		
		size = ww.length;
		cntG = new int[size];
		resCnt = new long[size];
		visit = new boolean[size];
		W = new long[size];
		for(int i=0; i<size; ++i) W[i] = ww[i];
		G = new List[size];
		for(int i=0; i<size; ++i) G[i] = new ArrayList<Integer>();
		for(int[] iter : edges){
			G[iter[0]].add(iter[1]);
			G[iter[1]].add(iter[0]);
			++cntG[iter[0]];
			++cntG[iter[1]];
		}
		
//		System.out.println(Arrays.toString(cntG));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> {
			long nn1 = resCnt[n1] + (long) Math.abs(W[n1]);
			long nn2 = resCnt[n2] + (long) Math.abs(W[n2]);
			return Long.compare(nn1, nn2);
		});
		for(int i=0; i<size; ++i){
			if(cntG[i] == 1){
				--cntG[i];
				visit[i] = true;
				pq.add(i);
			}
		}
		
//		System.out.println(Arrays.toString(cntG));
		
		
		long res = 0;
		while(!pq.isEmpty()){
			int idx = pq.poll();
			
			System.out.println();
			System.out.printf("%d : [%d, %d]\n", idx, W[idx], resCnt[idx]);
			
			visit[idx] = true;
			
			resCnt[idx] += (long) Math.abs(W[idx]);
			res = resCnt[idx];
			
			for(int v : G[idx]){
				if(visit[v]) continue;
				
				W[v] += W[idx];
				resCnt[v] += resCnt[idx];
				
				if(--cntG[v] == 1){
					pq.add(v);
					System.out.printf("next -> %d : [%d, %d]\n", v, W[v], resCnt[v]);
				}
			}
		}
		
		return res;
	}
}