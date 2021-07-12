package BOJ.S01000;
import java.io.*;
import java.util.*;

public class BOJ01238_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int v,w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static int N, MAXN = 1_000, M, X;
	public static List<Node>[] G = new List[MAXN+1];
	public static long[] dist, res = new long[MAXN+1];
	static{
		for(int i=0; i<=MAXN; ++i)
			G[i] = new ArrayList<>();
	}
	
	public static void BOJ01238_2(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			G[u].add(new Node(v,w));
		}
		
		for(int i=1; i<=N; ++i){
			dijkstra(i);
			if(i == X){
				for(int j=1; j<=N; ++j){
					res[j] += dist[j];
				}
			}else{
				res[i] += dist[X];
			}
		}
		
		System.out.println(Arrays.stream(res).max().getAsLong());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int S){
		dist = new long[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.w, n2.w));
		pq.add(new Node(S, 0));
		while(!pq.isEmpty()){
			Node node = pq.poll();
			int v = node.v;
			int w = node.w;
			
			if(dist[v] != Integer.MAX_VALUE) continue;
			dist[v] = w;
			
			for(Node iter : G[v]){
				if(dist[iter.v] != Integer.MAX_VALUE) continue;
				pq.add(new Node(iter.v, iter.w + w));
			}
		}
	}
}
