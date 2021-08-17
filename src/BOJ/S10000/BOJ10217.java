package BOJ.S10000;
import java.io.*;
import java.util.*;

public class BOJ10217 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
		int u, cost, time;
		public Node(int u, int cost, int time) {
			this.u = u;
			this.cost = cost;
			this.time = time;
		}
		
		public boolean equals(Object obj){
			Node other = (Node) obj;
			return this.u == other.u && this.cost == other.cost && this.time == other.time;
		}
	}
	
	static final int MAXV = 100, MAXM = 10_000;
	static int TC;
	static int V,M,E;
	static List<Node>[] G;
	static int[][] dp;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2)-> {
//		if(n1.cost == n2.cost) return Integer.compare(n1.time, n2.time);
//		return Integer.compare(n1.cost, n2.cost);
		
		return Integer.compare(n1.time, n2.time);
	});
	
	static void init(){
		G = new List[V+1];
		for(int i=0; i<=V; ++i) G[i] = new ArrayList<>();
		dp = new int[MAXV+1][MAXM+1];
		for(int i=0; i<=MAXV; ++i) Arrays.fill(dp[i], Integer.MAX_VALUE);
		pq.clear();
	}
	
	public static void BOJ10217(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			init();
			
			for(int i=0; i<E; ++i){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				G[u].add(new Node(v,c,t));
			}
			
			
			int res = Integer.MAX_VALUE;
			pq.add(new Node(0, 0, 0));
			while(!pq.isEmpty()){
				Node top = pq.poll();
				int u = top.u;
				int cost = top.cost;
				int time = top.time;
				
				if(u == (V-1)){
					res = time;
					break;
				}
				if(dp[u][cost] < time) continue;
				if(cost > M) continue;
				
				for(Node iter : G[u]){
					int v = iter.u;
					int vc = iter.cost;
					int vt = iter.time;
					if(cost+vc > M) continue;
//					if(res <= time+vt) continue;
					if(dp[v][cost+vc] <= time+vt) continue;
					for(int c=cost+vc; c<=M; ++c){
						if(dp[v][c] <= time+vt) break;
						dp[v][c] = time+vt;
					}
					pq.add(new Node(v, cost+vc, time+vt));
				}
			}
			
			if(res == Integer.MAX_VALUE) bw.write("Poor KCM\n");
			else bw.write(res + "\n");
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}