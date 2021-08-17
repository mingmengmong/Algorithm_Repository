package BOJ.S11000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11657 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int V, E, MAXV = 500, S = 1, MAXW = 100_000_000;
	public static long[] dist = new long[MAXV+1];
	public static List<Node>[] G = new List[MAXV+1];
	static{
		for(int i=0; i<=MAXV; ++i) {
			G[i] = new ArrayList<Node>();
			dist[i] = MAXW;
		}
	}
	
	public static class Node{
		public int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	public static void BOJ11657(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<E; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			G[u].add(new Node(v, w));
		}
		
		dist[S] = 0;
		for(int i=0; i<V-1; ++i){
			for(int v=1; v<=V; ++v){
				if(dist[v] == MAXW) continue;
				for(Node n : G[v]){
					dist[n.v] = Math.min(dist[n.v], dist[v] + n.w);
				}
			}
		}
		
		boolean flag = true;
		for(int v=1; v<=V; ++v){
			if(!flag) break;
			if(dist[v] == MAXW) continue;
			for(Node n : G[v]){
				if(!flag) break;
				if(dist[n.v] > (dist[v] + n.w))
					flag = false;
			}
		}
		
		if(!flag) System.out.println(-1);
		else
			for(int i=2; i<=V; ++i)
				if(dist[i] == MAXW) System.out.println(-1);
				else System.out.println(dist[i]);
		
		sc.close();
		bw.close();
		br.close();
	}
}
