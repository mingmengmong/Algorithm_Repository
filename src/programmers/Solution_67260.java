package programmers;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution_67260 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/67260
	 * name : 동굴 탐험
	 */
	
	List<Integer>[] G;
	boolean[] visit;
	int[] beforeVisit;
	int[] afterVisit;
	
	void dfs(int u){
		if(visit[u]) return;
		
		// 기존 지점 탐색 x
		if(beforeVisit[u] != 0 && !visit[beforeVisit[u]]) {
			// 탐색 순서에 따라 기존 지점을 탐색 안한 경우
			// 해당 지점에서 다시 재검색을 하게끔 해야한다.
			afterVisit[beforeVisit[u]] = u;
			return;
		}
		
		visit[u] = true;
		// afterVisit 이 없을 경우(있더라도 dfs 에서 탐색을 안한경우는 패스)
		if(afterVisit[u] != 0)
			dfs(afterVisit[u]);
		for(int v : G[u]) if(!visit[v]) dfs(v);
	}
	
	public boolean solution(int n, int[][] paths, int[][] orders) {
		G = new List[n];
		visit = new boolean[n];
		beforeVisit = new int[n];
		afterVisit = new int[n];
		for(int i=0; i<n; ++i) G[i] = new ArrayList<>();
		
		for(int[] path : paths){
			int u = path[0];
			int v = path[1];
			G[u].add(v);
			G[v].add(u);
		}
		
		for(int[] order : orders){
			int u = order[0];
			int v = order[1];
			beforeVisit[v] = u;
			// 여기서 after 를 정해줄 시 dfs 에서 도착 여부 파악이 안댐.
			// dfs 내에서 도착여부를 확인해야한다.
//			afterVisit[u] = v;
		}
		
		if(beforeVisit[0] != 0) return false;
		
		// StackOverFlowError
//		dfs(0);
//		visit[0] = true;
//		for(int v : G[0]) dfs(v);
		
		
		// StackOverFlowError 해결
		Stack<Integer> st = new Stack<>();
		st.add(0);
		while(!st.isEmpty()){
			int u = st.pop();
			if(visit[u]) continue;
			
			// 기존 지점 탐색 x
			if(beforeVisit[u] != 0 && !visit[beforeVisit[u]]) {
				// 탐색 순서에 따라 기존 지점을 탐색 안한 경우
				// 해당 지점에서 다시 재검색을 하게끔 해야한다.
				afterVisit[beforeVisit[u]] = u;
				continue;
			}
			
			visit[u] = true;
			// afterVisit 이 없을 경우(있더라도 dfs 에서 탐색을 안한경우는 패스)
			if(afterVisit[u] != 0)
				st.add(afterVisit[u]);
			for(int v : G[u]) if(!visit[v]) st.add(v);
		}
		
		for(boolean b : visit) if(!b) return false;
		return true;
	}
}