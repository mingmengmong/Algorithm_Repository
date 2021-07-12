package BOJ.S01000;
import java.io.*;
import java.util.*;

public class BOJ01916_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static int V, MAXV = 1_000, E, SI, EI;
	public static int[] dist = new int[MAXV+1];
	public static List<Node>[] G = new List[MAXV+1];
	static{
		for(int i=0; i<=MAXV; ++i) {
			G[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
	}
	
	public static void BOJ01916_2(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			G[u].add(new Node(v,w));
		}
		
		st = new StringTokenizer(br.readLine());
		SI = Integer.parseInt(st.nextToken());
		EI = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1,n2) -> Integer.compare(n1.w, n2.w));
		pq.add(new Node(SI, 0));
		while(!pq.isEmpty()){
			Node n = pq.poll();
			if(dist[n.v] != Integer.MAX_VALUE) continue;
			dist[n.v] = n.w;
			for(Node it : G[n.v]){
				if(dist[it.v] != Integer.MAX_VALUE) continue;
				pq.add(new Node(it.v, n.w + it.w));
			}
		}
		
		System.out.println(dist[EI]);
		
		sc.close();
		bw.close();
		br.close();
	}
}
