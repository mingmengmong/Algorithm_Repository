import java.io.*;
import java.util.*;

public class BOJ01219 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
		int u;
		long w;
		public Node(int u, long w) {
			this.u = u;
			this.w = w;
		}
	}
	
	static int N, S, E, M, MAXN = 100;
	static long MAX = 1_000_000_000_000L;
	static int[][] input = new int[MAXN +1][3];
	static List<Node>[] G = new List[MAXN +1];
	static int[] cost = new int[MAXN+1];
	static long[] res = new long[MAXN+1];
	static boolean[] visit = new boolean[MAXN+1];
	static{
		Arrays.fill(res, MAX);
		for(int i=0; i<=MAXN; ++i) G[i] = new ArrayList<Node>();
//		for(int i=0; i<=MAXN; ++i){
//			Arrays.fill(G[i], MAX);
//			G[i][i] = 0;
//		}
	}
	
	static void dfs(int u){
		if(visit[u]) return;
		visit[u] = true;
		res[u] = -MAX;
		for(Node iter : G[u]){
			int v = iter.u;
			if(visit[v]) continue;
			dfs(v);
		}
	}
	
	public static void BOJ01219(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("input"));
		sc = new Scanner(new File("input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			input[i][0] = u;
			input[i][1] = v;
			input[i][2] = w;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; ++i){
			int u = input[i][0];
			int v = input[i][1];
			int w = input[i][2];
			G[u].add(new Node(v, w-cost[v]));
		}
		
		res[S] = -cost[S];
//		res[S] = 0;
		for(int i=0; i<N-1; ++i){
			for(int u=0; u<N; ++u){
				if(res[u] == MAX) continue;
				long uw = res[u];
				for(Node next : G[u]){
					int v = next.u;
					long vw = next.w;
					res[v] = Math.min(res[v], uw + vw);
				}
			}
		}
		
		if(res[E] == MAX){
			System.out.println("gg");
			return;
		}
		
		// 음수 cycle 검사
		List<Integer> negativeCycle = new LinkedList<Integer>();
		for(int u=0; u<N; ++u){
			if(res[u] == MAX) continue;
			long uw = res[u];
			for(Node next : G[u]){
				int v = next.u;
				long vw = next.w;
				if(res[v] == -MAX) continue;
				if(res[v] > uw + vw){
					res[v] = -MAX;
					negativeCycle.add(v);
				}
			}
		}
		
		for(int u : negativeCycle){
			if(!visit[u]){
				dfs(u);
			}
		}
		
		
		if(res[E] != -MAX) System.out.println(-res[E]);
		else System.out.println("Gee");
		
		br.close();
		bw.close();
		sc.close();
	}
}